/*
 * Copyright (C) 2014 Haixing Hu
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.github.haixing_hu.bean;

import javax.annotation.Nullable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.StringUtils;

/**
 * A class used to test the inheritance of {@link DefaultBeanClass}.
 *
 * @author Haixing Hu
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "inherited-bean-class")
public class InheritedBeanClass extends DefaultBeanClass {

  @XmlElement(name="type", required=true)
  private final String type;

  InheritedBeanClass() {
    super();
    type = StringUtils.EMPTY;
  }

  /**
   * Constructs a {@link InheritedBeanClass}.
   * <p>
   * The constructor will use {@link BasicBean.class} to create new bean
   * instances.
   *
   * @param name
   *          the name of the new bean class.
   * @param descriptors
   *          the property descriptors for the properties of the beans created
   *          by the new bean class.
   * @param type
   *          the type of this bean class.
   */
  public InheritedBeanClass(final String name,
      final PropertyDescriptor[] descriptors, final String type) {
    this(name, descriptors, null, type);
  }

  /**
   * Constructs a {@link DefaultBeanClass}.
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
   * @param type
   *          the type of this bean class.
   */
  public InheritedBeanClass(final String name,
      final PropertyDescriptor[] descriptors,
      @Nullable final Class<? extends Bean> beanType,
      final String type) {
    super(name, descriptors, beanType);
    this.type = type;
  }

  /**
   * Gets the type.
   *
   * @return the type.
   */
  public String getType() {
    return type;
  }


}
