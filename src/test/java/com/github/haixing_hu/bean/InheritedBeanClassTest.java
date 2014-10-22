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

import org.junit.Test;

/**
 * Unit test of the {@link InheritedBeanClass}.
 *
 * @author Haixing Hu
 */
public class InheritedBeanClassTest extends BeanClassTestBase {

  @Test
  public void testXmlSerialization() throws Exception {
    final InheritedBeanClass cls = new InheritedBeanClass("class1",
        new PropertyDescriptor[] {
          getPropertyDescriptor1(),
          getPropertyDescriptor2(),
          getPropertyDescriptor3(),
    }, "type1");
    final String xml = "<inherited-bean-class>"
                     + "<name>class1</name>"
                     + "<bean>default-bean</bean>"
                     + "<type>type1</type>"
                     + "<properties>"
                     + getPropertyDescriptor1Xml()
                     + getPropertyDescriptor2Xml()
                     + getPropertyDescriptor3Xml()
                     + "</properties>"
                     + "</inherited-bean-class>";
    testXmlMarshal(InheritedBeanClass.class, cls, xml);
    testXmlUnmarshal(InheritedBeanClass.class, xml, cls);
  }
}
