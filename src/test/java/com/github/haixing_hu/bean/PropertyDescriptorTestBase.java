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

/**
 * Base class for the unit tests of {@link PropertyDescriptor}.
 *
 * @author Haixing Hu
 */
public class PropertyDescriptorTestBase extends XmlSerializationTestBase {


  protected PropertyDescriptor getPropertyDescriptor1() {
    return new PropertyDescriptor("prop1", String.class);
  }

  protected String getPropertyDescriptor1Xml() {
    return "<property>"
         + "<name>prop1</name>"
         + "<type>string</type>"
         + "<kind>simple</kind>"
         + "</property>";
  }

  protected PropertyDescriptor getPropertyDescriptor2() {
    return new PropertyDescriptor("_prop2", Integer.class, PropertyKind.INDEXED);
  }

  protected String getPropertyDescriptor2Xml() {
    return "<property>"
         + "<name>_prop2</name>"
         + "<type>int</type>"
         + "<kind>indexed</kind>"
         + "</property>";
  }

  protected PropertyDescriptor getPropertyDescriptor3() {
    return new PropertyDescriptor("prop-3", Boolean.class, PropertyKind.MAPPED);
  }

  protected String getPropertyDescriptor3Xml() {
    return "<property>"
         + "<name>prop-3</name>"
         + "<type>boolean</type>"
         + "<kind>mapped</kind>"
         + "</property>";
  }

  protected PropertyDescriptor getPropertyDescriptor4() {
    TypeAliasRegistry.register("my-bean", MyBean.class);
    return new PropertyDescriptor("prop_4", MyBean.class, PropertyKind.SIMPLE);
  }

  protected String getPropertyDescriptor4Xml() {
    return "<property>"
         + "<name>prop_4</name>"
         + "<type>my-bean</type>"
         + "<kind>simple</kind>"
         + "</property>";
  }

  protected PropertyDescriptor getPropertyDescriptor5() {
    return new PropertyDescriptor("prop5", Float.class, PropertyKind.INDEXED);
  }

  protected String getPropertyDescriptor5Xml() {
    return "<property>"
         + "<name>prop5</name>"
         + "<type>float</type>"
         + "<kind>indexed</kind>"
         + "</property>";
  }

  protected PropertyDescriptor getPropertyDescriptor6() {
    return new PropertyDescriptor("prop6", DefaultProperty.class,
        PropertyKind.MAPPED);
  }

  protected String getPropertyDescriptor6Xml() {
    return "<property>"
         + "<name>prop6</name>"
         + "<type>" + DefaultProperty.class.getName() + "</type>"
         + "<kind>mapped</kind>"
         + "</property>";
  }


  protected PropertyDescriptorGroup getPropertyDescriptorGroup0() {
    return new PropertyDescriptorGroup("group0",
        new PropertyDescriptor[0]);
  }

  protected String getPropertyDescriptorGroup0Xml() {
    return "<property-group>"
         + "<name>group0</name>"
        +  "<properties/>"
         + "</property-group>";
  }

  protected PropertyDescriptorGroup getPropertyDescriptorGroup1() {
    return new PropertyDescriptorGroup("group1",
        new PropertyDescriptor[] {
          getPropertyDescriptor1(),
        });
  }

  protected String getPropertyDescriptorGroup1Xml() {
    return "<property-group>"
         + "<name>group1</name>"
         + "<properties>"
         + getPropertyDescriptor1Xml()
         + "</properties>"
         + "</property-group>";
  }

  protected PropertyDescriptorGroup getPropertyDescriptorGroup2() {
    return new PropertyDescriptorGroup("group2",
        new PropertyDescriptor[] {
          getPropertyDescriptor2(),
          getPropertyDescriptor3(),
        });
  }

  protected String getPropertyDescriptorGroup2Xml() {
    return "<property-group>"
         + "<name>group2</name>"
         + "<properties>"
         + getPropertyDescriptor2Xml()
         + getPropertyDescriptor3Xml()
         + "</properties>"
         + "</property-group>";
  }

  protected PropertyDescriptorGroup getPropertyDescriptorGroup3() {
    return new PropertyDescriptorGroup("group3",
        new PropertyDescriptor[] {
          getPropertyDescriptor4(),
          getPropertyDescriptor5(),
          getPropertyDescriptor6(),
        });
  }

  protected String getPropertyDescriptorGroup3Xml() {
    return "<property-group>"
         + "<name>group3</name>"
         + "<properties>"
         + getPropertyDescriptor4Xml()
         + getPropertyDescriptor5Xml()
         + getPropertyDescriptor6Xml()
         + "</properties>"
         + "</property-group>";
  }

}
