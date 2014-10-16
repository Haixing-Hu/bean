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

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Unit test of the {@link PropertyDescriptor} class.
 *
 * @author Haixing Hu
 */
public class PropertyDescriptorTest extends XmlSerializationTest {

  @Test
  public void testConstructorStringClass() {
    final PropertyDescriptor desp1 = new PropertyDescriptor("prop1",
        String.class);
    assertEquals("prop1", desp1.getName());
    assertEquals(String.class, desp1.getType());
    assertEquals(PropertyKind.SIMPLE, desp1.getKind());

    final PropertyDescriptor desp2 = new PropertyDescriptor("prop-prop",
        Boolean.class);
    assertEquals("prop-prop", desp2.getName());
    assertEquals(Boolean.class, desp2.getType());
    assertEquals(PropertyKind.SIMPLE, desp2.getKind());

    final PropertyDescriptor desp3 = new PropertyDescriptor("_prop",
        Integer.class);
    assertEquals("_prop", desp3.getName());
    assertEquals(Integer.class, desp3.getType());
    assertEquals(PropertyKind.SIMPLE, desp3.getKind());

    final PropertyDescriptor desp4 = new PropertyDescriptor("Prop123-prop4_",
        Long.class);
    assertEquals("Prop123-prop4_", desp4.getName());
    assertEquals(Long.class, desp4.getType());
    assertEquals(PropertyKind.SIMPLE, desp4.getKind());

    try {
      new PropertyDescriptor(null, String.class);
      fail("should throw");
    } catch (final NullPointerException e) {
      //  pass
    }

    try {
      new PropertyDescriptor("prop1", null);
      fail("should throw");
    } catch (final NullPointerException e) {
      //  pass
    }

    try {
      new PropertyDescriptor("prop1.prop2", String.class);
      fail("should throw");
    } catch (final IllegalArgumentException e) {
      //  pass
    }

    try {
      new PropertyDescriptor("prop1 prop2", String.class);
      fail("should throw");
    } catch (final IllegalArgumentException e) {
      //  pass
    }

    try {
      new PropertyDescriptor("1prop", String.class);
      fail("should throw");
    } catch (final IllegalArgumentException e) {
      //  pass
    }

    try {
      new PropertyDescriptor("prop1AB%", String.class);
      fail("should throw");
    } catch (final IllegalArgumentException e) {
      //  pass
    }
  }

  @Test
  public void testConstructorStringClassKind() {
    final PropertyDescriptor desp1 = new PropertyDescriptor("prop1",
        String.class, PropertyKind.MAPPED);
    assertEquals("prop1", desp1.getName());
    assertEquals(String.class, desp1.getType());
    assertEquals(PropertyKind.MAPPED, desp1.getKind());

    final PropertyDescriptor desp2 = new PropertyDescriptor("prop-prop",
        Boolean.class, PropertyKind.INDEXED);
    assertEquals("prop-prop", desp2.getName());
    assertEquals(Boolean.class, desp2.getType());
    assertEquals(PropertyKind.INDEXED, desp2.getKind());

    final PropertyDescriptor desp3 = new PropertyDescriptor("_prop",
        Float.class, PropertyKind.MAPPED);
    assertEquals("_prop", desp3.getName());
    assertEquals(Float.class, desp3.getType());
    assertEquals(PropertyKind.MAPPED, desp3.getKind());

    final PropertyDescriptor desp4 = new PropertyDescriptor("Prop123-prop4_",
        Integer.class, PropertyKind.SIMPLE);
    assertEquals("Prop123-prop4_", desp4.getName());
    assertEquals(Integer.class, desp4.getType());
    assertEquals(PropertyKind.SIMPLE, desp4.getKind());

    try {
      new PropertyDescriptor(null, String.class, PropertyKind.MAPPED);
      fail("should throw");
    } catch (final NullPointerException e) {
      //  pass
    }

    try {
      new PropertyDescriptor("prop1", null, PropertyKind.MAPPED);
      fail("should throw");
    } catch (final NullPointerException e) {
      //  pass
    }

    try {
      new PropertyDescriptor("prop1", String.class, null);
      fail("should throw");
    } catch (final NullPointerException e) {
      //  pass
    }
  }


  @Test
  public void testXmlSerialize() throws Exception {
    final PropertyDescriptor desp1 = new PropertyDescriptor("prop1",
        Integer.class);
    final String xml1 = "<property>"
                + "<name>prop1</name>"
                + "<type>int</type>"
                + "<kind>simple</kind>"
                + "</property>";
    testXmlMarshal(PropertyDescriptor.class, desp1, xml1);

    final PropertyDescriptor desp2 = new PropertyDescriptor("prop2",
        String.class, PropertyKind.INDEXED);
    final String xml2 = "<property>"
                + "<name>prop2</name>"
                + "<type>string</type>"
                + "<kind>indexed</kind>"
                + "</property>";
    testXmlMarshal(PropertyDescriptor.class, desp2, xml2);

    final PropertyDescriptor desp3 = new PropertyDescriptor("prop3",
        Class.class, PropertyKind.MAPPED);
    final String xml3 = "<property>"
                + "<name>prop3</name>"
                + "<type>class</type>"
                + "<kind>mapped</kind>"
                + "</property>";
    testXmlMarshal(PropertyDescriptor.class, desp3, xml3);

    final PropertyDescriptor desp4 = new PropertyDescriptor("prop4",
        PropertyDescriptor.class, PropertyKind.MAPPED);
    final String xml4 = "<property>"
                + "<name>prop4</name>"
                + "<type>com.github.haixing_hu.bean.PropertyDescriptor</type>"
                + "<kind>mapped</kind>"
                + "</property>";
    testXmlMarshal(PropertyDescriptor.class, desp4, xml4);
  }

  @Test
  public void testXmlDeserialize() throws Exception {
    final PropertyDescriptor desp1 = new PropertyDescriptor("prop1",
        Integer.class);
    final String xml1 = "<property>"
                + "<name>prop1</name>"
                + "<type>int</type>"
                + "<kind>simple</kind>"
                + "</property>";
    testXmlUnmarshal(PropertyDescriptor.class, xml1, desp1);

    final PropertyDescriptor desp2 = new PropertyDescriptor("prop2",
        String.class, PropertyKind.INDEXED);
    final String xml2 = "<property>"
                + "<name>prop2</name>"
                + "<type>string</type>"
                + "<kind>indexed</kind>"
                + "</property>";
    testXmlUnmarshal(PropertyDescriptor.class, xml2, desp2);

    final PropertyDescriptor desp3 = new PropertyDescriptor("prop3",
        Class.class, PropertyKind.MAPPED);
    final String xml3 = "<property>"
                + "<name>prop3</name>"
                + "<type>class</type>"
                + "<kind>mapped</kind>"
                + "</property>";
    testXmlUnmarshal(PropertyDescriptor.class, xml3, desp3);

    final PropertyDescriptor desp4 = new PropertyDescriptor("prop4",
        PropertyDescriptor.class);
    final String xml4 = "<property>"
                + "<name>prop4</name>"
                + "<type>com.github.haixing_hu.bean.PropertyDescriptor</type>"
                + "</property>";
    testXmlUnmarshal(PropertyDescriptor.class, xml4, desp4);
  }
}
