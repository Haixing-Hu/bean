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

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import static com.github.haixing_hu.lang.Argument.requireNonNull;

/**
 * A default implementation of {@link Bean} interface.
 *
 * @author Haixing Hu
 */
public class DefaultBean implements Bean {

  private final BeanClass beanClass;
  private final Map<String, Property> properties;

  /**
   * Constructs a {@link DefaultBean}.
   *
   * @param beanClass
   *          the class of the bean.
   */
  public DefaultBean(final BeanClass beanClass) {
    this.beanClass = requireNonNull("beanClass", beanClass);
    properties = new HashMap<>();
    for (final PropertyDescriptor pd : beanClass.getPropertyDescriptors()) {
      final Property property = new DefaultProperty(pd);
      properties.put(property.getName(), property);
    }
  }

  @Override
  public final BeanClass getBeanClass() {
    return beanClass;
  }

  @Override
  public final Property getProperty(final String name) {
    return properties.get(name);
  }

  @Override
  public final Object get(final String name) {
    final Property property = properties.get(name);
    if (property == null) {
      throw new PropertyNotExistException(name);
    }
    return property.getSimpleValue();
  }

  @Override
  public final void set(final String name, final Object value) {
    final Property property = properties.get(name);
    if (property == null) {
      throw new PropertyNotExistException(name);
    }
    property.setSimpleValue(value);
  }

  @Override
  public final int getSize(final String name) {
    final Property property = properties.get(name);
    if (property == null) {
      throw new PropertyNotExistException(name);
    }
    return property.getSize();
  }

  @Override
  public final Object get(final String name, final int index) {
    final Property property = properties.get(name);
    if (property == null) {
      throw new PropertyNotExistException(name);
    }
    return property.getIndexedValue(index);
  }

  @Override
  public final void set(final String name, final int index,
      @Nullable final Object value) {
    final Property property = properties.get(name);
    if (property == null) {
      throw new PropertyNotExistException(name);
    }
    property.setIndexedValue(index, value);
  }

  @Override
  public final void add(final String name, final int index,
      @Nullable final Object value) {
    final Property property = properties.get(name);
    if (property == null) {
      throw new PropertyNotExistException(name);
    }
    property.addIndexedValue(index, value);
  }

  @Override
  public final void add(final String name, @Nullable final Object value) {
    final Property property = properties.get(name);
    if (property == null) {
      throw new PropertyNotExistException(name);
    }
    property.addIndexedValue(value);
  }

  @Override
  public final Object remove(final String name, final int index) {
    final Property property = properties.get(name);
    if (property == null) {
      throw new PropertyNotExistException(name);
    }
    return property.removeIndexedValue(index);
  }

  @Override
  public final Set<String> getKeySet(final String name) {
    final Property property = properties.get(name);
    if (property == null) {
      throw new PropertyNotExistException(name);
    }
    return property.getKeySet();
  }

  @Override
  public final boolean containsKey(final String name, final String key) {
    final Property property = properties.get(name);
    if (property == null) {
      throw new PropertyNotExistException(name);
    }
    return property.containsKey(key);
  }

  @Override
  public final Object get(final String name, final String key) {
    final Property property = properties.get(name);
    if (property == null) {
      throw new PropertyNotExistException(name);
    }
    return property.getMappedValue(key);
  }

  @Override
  public final void set(final String name, final String key,
      @Nullable final Object value) {
    final Property property = properties.get(name);
    if (property == null) {
      throw new PropertyNotExistException(name);
    }
    property.setMappedValue(key, value);
  }

  @Override
  public final Object remove(final String name, final String key) {
    final Property property = properties.get(name);
    if (property == null) {
      throw new PropertyNotExistException(name);
    }
    return property.removeMappedValue(key);
  }

  @Override
  public final void clear(final String name) {
    final Property property = properties.get(name);
    if (property == null) {
      throw new PropertyNotExistException(name);
    }
    property.clear();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(11, 7)
        .append(beanClass)
        .append(properties)
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
    final DefaultBean rhs = (DefaultBean) obj;
    return new EqualsBuilder()
        .append(beanClass, rhs.beanClass)
        .append(properties, rhs.properties)
        .build();
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("beanClass", beanClass)
        .append("properties", properties)
        .build();
  }
}
