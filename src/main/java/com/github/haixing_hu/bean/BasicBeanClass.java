/*
 * Copyright (c) 2014  Haixing Hu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.github.haixing_hu.bean;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.github.haixing_hu.reflect.ReflectionException;

import static com.github.haixing_hu.lang.Argument.requireNonNull;

/**
 * A default implementation of {@link BeanClass} interface.
 *
 * @author Haixing Hu
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "bean")
public class BasicBeanClass implements BeanClass {

  /**
   * The name of this bean class.
   */
  @XmlElement(name = "name", required = true)
  protected final String name;

  /**
   * The {@link Bean} implementation class used for creating new instances.
   */
  @XmlJavaTypeAdapter(TypeAliasXmlAdapter.class)
  @XmlElement(name = "type", required = false)
  protected Class<? extends Bean> beanType = BasicBean.class;

  /**
   * The property descriptors of the beans created by this bean class.
   */
  @XmlElementWrapper(name = "properties", required = true)
  @XmlElement(name = "property")
  protected PropertyDescriptor[] descriptors = {};

  /**
   * A map from the property name to its descriptor.
   */
  protected transient Map<String, PropertyDescriptor> descriptorMap = null;

  /**
   * The constructor of the {@code beanType} used for creating new instances.
   */
  protected transient Constructor<? extends Bean> constructor = null;

  /**
   * The method signature of the constructor used to new {@code beanType}
   * instances.
   */
  protected transient Class<?>[] constructorSignature = { BeanClass.class };

  /**
   * The arguments values to be passed to the constructor used to create new
   * {@code beanType} instances.
   */
  protected transient Object[] constructorArguments = { this };

  /**
   * A default constructor used by the JAXB.
   */
  BasicBeanClass() {
    name = StringUtils.EMPTY;
  }

  /**
   * Constructs a {@link BasicBeanClass}.
   * <p>
   * The constructor will use {@link BasicBean.class} to create new bean
   * instances.
   *
   * @param name
   *          the name of the new bean class.
   * @param descriptors
   *          the property descriptors for the properties of the beans created
   *          by the new bean class.
   */
  public BasicBeanClass(final String name,
      final PropertyDescriptor[] descriptors) {
    this(name, descriptors, null);
  }

  /**
   * Constructs a {@link BasicBeanClass}.
   *
   * @param name
   *          the name of the new bean class.
   * @param descriptors
   *          the property descriptors for the properties of the beans created
   *          by the new bean class.
   * @param beanType
   *          {@link Bean} implementation class used for creating new bean
   *          instances. If this argument is {@code null}, the constructor will
   *          use {@link BasicBean.class} to create new bean instances.
   */
  public BasicBeanClass(final String name,
      final PropertyDescriptor[] descriptors,
      @Nullable final Class<? extends Bean> beanType) {
    this.name = requireNonNull("name", name);
    setDescriptors(descriptors);
    setBeanType(beanType);
  }

  /**
   * Sets the property descriptors of the beans created by this bean class.
   *
   * @param descriptors
   *          the property descriptors of the beans created by this bean class.
   */
  protected void setDescriptors(final PropertyDescriptor[] descriptors) {
    this.descriptors = requireNonNull("descriptors", descriptors);
    if (descriptorMap == null) {
      descriptorMap = new HashMap<>();
    } else {
      descriptorMap.clear();
    }
    for (final PropertyDescriptor descriptor : descriptors) {
      descriptorMap.put(descriptor.getName(), descriptor);
    }
  }

  /**
   * Sets the type of the beans created by this bean class.
   *
   * @param beanType
   *          the class object of the type of the beans created by this bean
   *          class.
   */
  protected void setBeanType(@Nullable final Class<? extends Bean> beanType) {
    if (beanType == null) {
      this.beanType = BasicBean.class;
    } else if (beanType.isInterface()) {
      throw new IllegalArgumentException("Class " + beanType.getName()
          + " is an interface, not a class");
    } else {
      this.beanType = beanType;
    }
    // Identify the Constructor we will use in newInstance()
    try {
      constructor = this.beanType.getConstructor(constructorSignature);
    } catch (final NoSuchMethodException e) {
      throw new IllegalArgumentException("Class " + this.beanType.getName()
          + " does not have an appropriate constructor");
    }
  }

  @Override
  public final String getName() {
    return name;
  }

  @Override
  public final Class<? extends Bean> getBeanType() {
    return beanType;
  }

  @Override
  public final PropertyDescriptor[] getPropertyDescriptors() {
    return descriptors;
  }

  @Override
  public boolean hasProperty(final String name) {
    if (descriptorMap == null) {
      //  we need to set the map since it may be not set by JAXB
      setDescriptors(descriptors);
    }
    return descriptorMap.containsKey(name);
  }

  @Override
  public PropertyDescriptor getPropertyDescriptor(final String name) {
    if (descriptorMap == null) {
      //  we need to set the map since it may be not set by JAXB
      setDescriptors(descriptors);
    }
    return descriptorMap.get(name);
  }

  @Override
  public Bean newInstance() {
    if (constructor == null) {
      setBeanType(beanType);
    }
    try {
      return constructor.newInstance(constructorArguments);
    } catch (final Exception e) {
      throw new ReflectionException(e);
    }
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(11, 7)
        .append(name)
        .append(beanType)
        .append(descriptors)
        .build();
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (obj == this) {
      return true;
    }
    if (obj.getClass() != getClass()) {
      return false;
    }
    final BasicBeanClass rhs = (BasicBeanClass) obj;
    return new EqualsBuilder()
        .append(name, rhs.name)
        .append(beanType, rhs.beanType)
        .append(descriptors, rhs.descriptors)
        .build();
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("name", name)
        .append("beanType", beanType)
        .append("descriptors", descriptors)
        .build();
  }

}
