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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

/**
 * Unit test of the {@link PropertyDescriptor} class.
 *
 * @author Haixing Hu
 */
public class PropertyDescriptorTest extends BeanClassTestBase {

  @Test
  public void testIsValidName() {
    assertEquals(false, PropertyDescriptor.isValidName(null));
    assertEquals(false, PropertyDescriptor.isValidName(""));
    assertEquals(false, PropertyDescriptor.isValidName("a.b"));
    assertEquals(false, PropertyDescriptor.isValidName("-ab"));
    assertEquals(false, PropertyDescriptor.isValidName("12ab"));
    assertEquals(true, PropertyDescriptor.isValidName("a"));
    assertEquals(true, PropertyDescriptor.isValidName("ab"));
    assertEquals(true, PropertyDescriptor.isValidName("_ab"));
    assertEquals(true, PropertyDescriptor.isValidName("a123"));
    assertEquals(true, PropertyDescriptor.isValidName("ab123-1"));
    assertEquals(true, PropertyDescriptor.isValidName("_a12-3"));
  }

  @Test
  public void testConstructorStringClass() {
    final PropertyDescriptor desp1 = getPropertyDescriptor1();
    assertEquals("prop1", desp1.getName());
    assertEquals(String.class, desp1.getType());
    assertEquals(PropertyKind.SIMPLE, desp1.getKind());
    assertEquals(true, desp1.isSimple());
    assertEquals(false, desp1.isIndexed());
    assertEquals(false, desp1.isMapped());

    final PropertyDescriptor desp2 = getPropertyDescriptor2();
    assertEquals("_prop2", desp2.getName());
    assertEquals(Integer.class, desp2.getType());
    assertEquals(PropertyKind.INDEXED, desp2.getKind());
    assertEquals(false, desp2.isSimple());
    assertEquals(true, desp2.isIndexed());
    assertEquals(false, desp2.isMapped());

    final PropertyDescriptor desp3 = getPropertyDescriptor3();
    assertEquals("prop-3", desp3.getName());
    assertEquals(Boolean.class, desp3.getType());
    assertEquals(PropertyKind.MAPPED, desp3.getKind());
    assertEquals(false, desp3.isSimple());
    assertEquals(false, desp3.isIndexed());
    assertEquals(true, desp3.isMapped());

    final PropertyDescriptor desp4 = getPropertyDescriptor4();
    assertEquals("prop_4", desp4.getName());
    assertEquals(MyBean.class, desp4.getType());
    assertEquals(PropertyKind.SIMPLE, desp4.getKind());
    assertEquals(true, desp4.isSimple());
    assertEquals(false, desp4.isIndexed());
    assertEquals(false, desp4.isMapped());

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
  public void testEqualsHashCode() {
    final PropertyDescriptor desp1 = getPropertyDescriptor1();
    final PropertyDescriptor desp1c = getPropertyDescriptor1();
    final PropertyDescriptor desp2 = getPropertyDescriptor2();

    assertEquals(true, desp1.equals(desp1));
    assertEquals(true, desp1.equals(desp1c));
    assertEquals(false, desp1.equals(desp2));
    assertEquals(false, desp1.equals(null));
    assertEquals(false, desp1.equals("str"));

    assertEquals(desp1.hashCode(), desp1.hashCode());
    assertEquals(desp1.hashCode(), desp1c.hashCode());
    assertNotEquals(desp1.hashCode(), desp2.hashCode());
  }

  @Test
  public void testToString() {
    final PropertyDescriptor desp1 = getPropertyDescriptor1();
    final PropertyDescriptor desp1c = getPropertyDescriptor1();
    final PropertyDescriptor desp2 = getPropertyDescriptor2();

    assertEquals(desp1.toString(), desp1.toString());
    assertNotEquals(desp1.toString(), desp1c.toString());
    assertNotEquals(desp1.toString(), desp2.toString());
  }

  @Test
  public void testXmlSerialize() throws Exception {
    final PropertyDescriptor desp1 = getPropertyDescriptor1();
    final String xml1 = getPropertyDescriptor1Xml();
    testXmlMarshal(PropertyDescriptor.class, desp1, xml1);

    final PropertyDescriptor desp2 = getPropertyDescriptor2();
    final String xml2 = getPropertyDescriptor2Xml();
    testXmlMarshal(PropertyDescriptor.class, desp2, xml2);

    final PropertyDescriptor desp3 = getPropertyDescriptor3();
    final String xml3 = getPropertyDescriptor3Xml();
    testXmlMarshal(PropertyDescriptor.class, desp3, xml3);

    final PropertyDescriptor desp4 = getPropertyDescriptor4();
    final String xml4 = getPropertyDescriptor4Xml();
    testXmlMarshal(PropertyDescriptor.class, desp4, xml4);

    final PropertyDescriptor desp5 = getPropertyDescriptor5();
    final String xml5 = getPropertyDescriptor5Xml();
    testXmlMarshal(PropertyDescriptor.class, desp5, xml5);

    final PropertyDescriptor desp6 = getPropertyDescriptor6();
    final String xml6 = getPropertyDescriptor6Xml();
    testXmlMarshal(PropertyDescriptor.class, desp6, xml6);
  }

  @Test
  public void testXmlDeserialize() throws Exception {
    final PropertyDescriptor desp1 = getPropertyDescriptor1();
    final String xml1 = getPropertyDescriptor1Xml();
    testXmlUnmarshal(PropertyDescriptor.class, xml1, desp1);

    final PropertyDescriptor desp2 = getPropertyDescriptor2();
    final String xml2 = getPropertyDescriptor2Xml();
    testXmlUnmarshal(PropertyDescriptor.class, xml2, desp2);

    final PropertyDescriptor desp3 = getPropertyDescriptor3();
    final String xml3 = getPropertyDescriptor3Xml();
    testXmlUnmarshal(PropertyDescriptor.class, xml3, desp3);

    final PropertyDescriptor desp4 = getPropertyDescriptor4();
    final String xml4 = getPropertyDescriptor4Xml();
    testXmlUnmarshal(PropertyDescriptor.class, xml4, desp4);

    final PropertyDescriptor desp5 = getPropertyDescriptor5();
    final String xml5 = getPropertyDescriptor5Xml();
    testXmlUnmarshal(PropertyDescriptor.class, xml5, desp5);

    final PropertyDescriptor desp6 = getPropertyDescriptor6();
    final String xml6 = getPropertyDescriptor6Xml();
    testXmlUnmarshal(PropertyDescriptor.class, xml6, desp6);
  }
}
