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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import static com.github.haixing_hu.lang.Argument.requireNonNull;

/**
 * A {@link PropertyDescriptorGroup} represents a group of property descriptors.
 *
 * @author Haixing Hu
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "property-group")
public final class PropertyDescriptorGroup {

  @XmlElement(name="name", required = true)
  private final String name;

  @XmlElementWrapper(name = "properties", required = true)
  @XmlElement(name = "property")
  private final PropertyDescriptor[] descriptors;

  /**
   * Default constructor used by the JAXB.
   */
  PropertyDescriptorGroup() {
    name = StringUtils.EMPTY;
    descriptors = new PropertyDescriptor[0];
  }

  /**
   * Constructs a {@link PropertyDescriptorGroup}.
   *
   * @param name
   *          the name of the group, which cannot be {@code null}.
   * @param descriptors
   *          the array of property descriptors in the group, which cannot be
   *          {@code null}.
   */
  public PropertyDescriptorGroup(final String name,
      final PropertyDescriptor[] descriptors) {
    this.name = requireNonNull("name", name);
    this.descriptors = requireNonNull("descriptors", descriptors);
  }

  /**
   * Gets the name of this group.
   *
   * @return the name of this group, which will never be {@code null}.
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the list of property descriptors in this group.
   *
   * @return the array of property descriptors in this group, which will never be
   *         {@code null}.
   */
  public PropertyDescriptor[] getDescriptors() {
    return descriptors;
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(11, 13)
        .append(name)
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
    final PropertyDescriptorGroup rhs = (PropertyDescriptorGroup) obj;
    return new EqualsBuilder()
        .append(name, rhs.name)
        .append(descriptors, rhs.descriptors)
        .build();
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("name", name)
        .append("descriptors", descriptors)
        .build();
  }

}
