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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

/**
 * Unit test of the {@link GroupedBeanClass}.
 *
 * @author Haixing Hu
 */
public class GroupedBeanClassTest extends BeanClassTestBase {

  @Test
  public void testConstructor() {

    final GroupedBeanClass cls0 = getGroupedBeanClass0();
    testBeanClass0Constructor(cls0);
    assertArrayEquals(new PropertyDescriptorGroup[0],
        cls0.getPropertyDescriptorGroups());

    final GroupedBeanClass cls1 = getGroupedBeanClass1();
    testBeanClass1Constructor(cls1);
    assertArrayEquals(new PropertyDescriptorGroup[] {
        getPropertyDescriptorGroup0(),
    }, cls1.getPropertyDescriptorGroups());

    final GroupedBeanClass cls2 = getGroupedBeanClass2();
    testBeanClass2Constructor(cls2);
    assertArrayEquals(new PropertyDescriptorGroup[] {
        getPropertyDescriptorGroup0(),
        getPropertyDescriptorGroup1(),
    }, cls2.getPropertyDescriptorGroups());

    final GroupedBeanClass cls3 = getGroupedBeanClass3();
    testBeanClass3Constructor(cls3);
    assertArrayEquals(new PropertyDescriptorGroup[] {
        getPropertyDescriptorGroup0(),
        getPropertyDescriptorGroup1(),
        getPropertyDescriptorGroup2(),
    }, cls3.getPropertyDescriptorGroups());

    final GroupedBeanClass cls4 = getGroupedBeanClass4();
    testBeanClass4Constructor(cls4);
    assertArrayEquals(new PropertyDescriptorGroup[] {
        getPropertyDescriptorGroup0(),
        getPropertyDescriptorGroup1(),
        getPropertyDescriptorGroup2(),
        getPropertyDescriptorGroup3(),
    }, cls4.getPropertyDescriptorGroups());


    try {
      new GroupedBeanClass(null, new PropertyDescriptorGroup[0]);
      fail("should throw");
    } catch (final NullPointerException e) {
      //  pass
    }

    try {
      new GroupedBeanClass("bean1", null);
      fail("should throw");
    } catch (final NullPointerException e) {
      //  pass
    }

    try {
      new GroupedBeanClass("bean1", new PropertyDescriptorGroup[]{ null });
      fail("should throw");
    } catch (final NullPointerException e) {
      //  pass
    }


    try {
      new GroupedBeanClass(null, new PropertyDescriptorGroup[0], MyBean.class);
      fail("should throw");
    } catch (final NullPointerException e) {
      //  pass
    }

    try {
      new GroupedBeanClass("bean1", null);
      fail("should throw");
    } catch (final NullPointerException e) {
      //  pass
    }

    try {
      new GroupedBeanClass("bean1", new PropertyDescriptorGroup[]{ null },
          MyBean.class);
      fail("should throw");
    } catch (final NullPointerException e) {
      //  pass
    }

    try {
      new GroupedBeanClass("bean1", new PropertyDescriptorGroup[0],
          Bean.class);
      fail("should throw");
    } catch (final IllegalArgumentException e) {
      //  pass
    }

    try {
      new GroupedBeanClass("bean1", new PropertyDescriptorGroup[0],
          EmptyBean.class);
      fail("should throw");
    } catch (final IllegalArgumentException e) {
      //  pass
    }
  }


  @Test
  public void testNewInstance() {
    final GroupedBeanClass cls0 = getGroupedBeanClass0();
    testBeanClass0NewInstance(cls0);

    final GroupedBeanClass cls1 = getGroupedBeanClass1();
    testBeanClass1NewInstance(cls1);

    final GroupedBeanClass cls2 = getGroupedBeanClass2();
    testBeanClass2NewInstance(cls2);

    final GroupedBeanClass cls3 = getGroupedBeanClass3();
    testBeanClass3NewInstance(cls3);

    final GroupedBeanClass cls4 = getGroupedBeanClass4();
    testBeanClass4NewInstance(cls4);

    final GroupedBeanClass cls = new GroupedBeanClass();
    testEmptyBeanClassNewInstance(cls);

    final GroupedBeanClass clsb = new GroupedBeanClass("bad-bean",
        new PropertyDescriptorGroup[0], BadBean.class);
    testBadBeanClassNewInstance(clsb);
  }

  @Test
  public void testHasProperty() {
    final GroupedBeanClass cls0 = getGroupedBeanClass0();
    testBeanClass0HasProperty(cls0);

    final GroupedBeanClass cls1 = getGroupedBeanClass1();
    testBeanClass1HasProperty(cls1);

    final GroupedBeanClass cls2 = getGroupedBeanClass2();
    testBeanClass2HasProperty(cls2);

    final GroupedBeanClass cls3 = getGroupedBeanClass3();
    testBeanClass3HasProperty(cls3);

    final GroupedBeanClass cls4 = getGroupedBeanClass4();
    testBeanClass4HasProperty(cls4);

    final GroupedBeanClass cls = new GroupedBeanClass();
    testEmptyBeanClassHasProperty(cls);
  }

  @Test
  public void testGetPropertyDescriptor() {
    final GroupedBeanClass cls0 = getGroupedBeanClass0();
    testBeanClass0GetPropertyDescriptor(cls0);

    final GroupedBeanClass cls1 = getGroupedBeanClass1();
    testBeanClass1GetPropertyDescriptor(cls1);

    final GroupedBeanClass cls2 = getGroupedBeanClass2();
    testBeanClass2GetPropertyDescriptor(cls2);

    final GroupedBeanClass cls3 = getGroupedBeanClass3();
    testBeanClass3GetPropertyDescriptor(cls3);

    final GroupedBeanClass cls4 = getGroupedBeanClass4();
    testBeanClass4GetPropertyDescriptor(cls4);

    final GroupedBeanClass cls = new GroupedBeanClass();
    testEmptyBeanClassGetPropertyDescriptor(cls);
  }


  @Test
  public void testEqualHashCode() {
    final GroupedBeanClass cls0 = getGroupedBeanClass0();
    final GroupedBeanClass cls0c = getGroupedBeanClass0();

    final GroupedBeanClass cls1 = getGroupedBeanClass1();
    final GroupedBeanClass cls1c = getGroupedBeanClass1();

    final GroupedBeanClass cls2 = getGroupedBeanClass2();
    final GroupedBeanClass cls2c = getGroupedBeanClass2();

    final GroupedBeanClass cls3 = getGroupedBeanClass3();
    final GroupedBeanClass cls3c = getGroupedBeanClass3();

    final GroupedBeanClass cls4 = getGroupedBeanClass4();
    final GroupedBeanClass cls4c = getGroupedBeanClass4();

    assertEquals(true, cls0.equals(cls0));
    assertEquals(true, cls0.equals(cls0c));
    assertEquals(false, cls0.equals(cls1));
    assertEquals(false, cls0.equals(cls2));
    assertEquals(false, cls0.equals(cls3));
    assertEquals(false, cls0.equals(cls4));
    assertEquals(false, cls0.equals(null));
    assertEquals(false, cls0.equals("str"));

    assertEquals(cls0.hashCode(), cls0.hashCode());
    assertEquals(cls0.hashCode(), cls0c.hashCode());
    assertNotEquals(cls0.hashCode(), cls1.hashCode());
    assertNotEquals(cls0.hashCode(), cls2.hashCode());
    assertNotEquals(cls0.hashCode(), cls3.hashCode());
    assertNotEquals(cls0.hashCode(), cls4.hashCode());

    assertEquals(true, cls1.equals(cls1));
    assertEquals(true, cls1.equals(cls1c));
    assertEquals(false, cls1.equals(cls0));
    assertEquals(false, cls1.equals(cls2));
    assertEquals(false, cls1.equals(cls3));
    assertEquals(false, cls1.equals(cls4));
    assertEquals(false, cls1.equals(null));
    assertEquals(false, cls1.equals("str"));

    assertEquals(cls1.hashCode(), cls1.hashCode());
    assertEquals(cls1.hashCode(), cls1c.hashCode());
    assertNotEquals(cls1.hashCode(), cls0.hashCode());
    assertNotEquals(cls1.hashCode(), cls2.hashCode());
    assertNotEquals(cls1.hashCode(), cls3.hashCode());
    assertNotEquals(cls1.hashCode(), cls4.hashCode());

    assertEquals(true, cls2.equals(cls2));
    assertEquals(true, cls2.equals(cls2c));
    assertEquals(false, cls2.equals(cls0));
    assertEquals(false, cls2.equals(cls1));
    assertEquals(false, cls2.equals(cls3));
    assertEquals(false, cls2.equals(cls4));
    assertEquals(false, cls2.equals(null));
    assertEquals(false, cls2.equals("str"));

    assertEquals(cls2.hashCode(), cls2.hashCode());
    assertEquals(cls2.hashCode(), cls2c.hashCode());
    assertNotEquals(cls2.hashCode(), cls0.hashCode());
    assertNotEquals(cls2.hashCode(), cls1.hashCode());
    assertNotEquals(cls2.hashCode(), cls3.hashCode());
    assertNotEquals(cls2.hashCode(), cls4.hashCode());

    assertEquals(true, cls3.equals(cls3));
    assertEquals(true, cls3.equals(cls3c));
    assertEquals(false, cls3.equals(cls0));
    assertEquals(false, cls3.equals(cls1));
    assertEquals(false, cls3.equals(cls2));
    assertEquals(false, cls3.equals(cls4));
    assertEquals(false, cls3.equals(null));
    assertEquals(false, cls3.equals("str"));

    assertEquals(cls3.hashCode(), cls3.hashCode());
    assertEquals(cls3.hashCode(), cls3c.hashCode());
    assertNotEquals(cls3.hashCode(), cls0.hashCode());
    assertNotEquals(cls3.hashCode(), cls1.hashCode());
    assertNotEquals(cls3.hashCode(), cls2.hashCode());
    assertNotEquals(cls3.hashCode(), cls4.hashCode());

    assertEquals(true, cls4.equals(cls4));
    assertEquals(true, cls4.equals(cls4c));
    assertEquals(false, cls4.equals(cls0));
    assertEquals(false, cls4.equals(cls1));
    assertEquals(false, cls4.equals(cls2));
    assertEquals(false, cls4.equals(cls3));
    assertEquals(false, cls4.equals(null));
    assertEquals(false, cls4.equals("str"));

    assertEquals(cls4.hashCode(), cls4.hashCode());
    assertEquals(cls4.hashCode(), cls4c.hashCode());
    assertNotEquals(cls4.hashCode(), cls0.hashCode());
    assertNotEquals(cls4.hashCode(), cls1.hashCode());
    assertNotEquals(cls4.hashCode(), cls2.hashCode());
    assertNotEquals(cls4.hashCode(), cls3.hashCode());
  }

  @Test
  public void testToString() {
    final GroupedBeanClass cls0 = getGroupedBeanClass0();
    final GroupedBeanClass cls0c = getGroupedBeanClass0();

    final GroupedBeanClass cls1 = getGroupedBeanClass1();
    final GroupedBeanClass cls1c = getGroupedBeanClass1();

    final GroupedBeanClass cls2 = getGroupedBeanClass2();
    final GroupedBeanClass cls2c = getGroupedBeanClass2();

    final GroupedBeanClass cls3 = getGroupedBeanClass3();
    final GroupedBeanClass cls3c = getGroupedBeanClass3();

    final GroupedBeanClass cls4 = getGroupedBeanClass4();
    final GroupedBeanClass cls4c = getGroupedBeanClass4();

    assertEquals(cls0.toString(), cls0.toString());
    assertNotEquals(cls0.toString(), cls0c.toString());
    assertNotEquals(cls0.toString(), cls1.toString());
    assertNotEquals(cls0.toString(), cls2.toString());
    assertNotEquals(cls0.toString(), cls3.toString());
    assertNotEquals(cls0.toString(), cls4.toString());

    assertEquals(cls1.toString(), cls1.toString());
    assertNotEquals(cls1.toString(), cls1c.toString());
    assertNotEquals(cls1.toString(), cls0.toString());
    assertNotEquals(cls1.toString(), cls2.toString());
    assertNotEquals(cls1.toString(), cls3.toString());
    assertNotEquals(cls1.toString(), cls4.toString());

    assertEquals(cls2.toString(), cls2.toString());
    assertNotEquals(cls2.toString(), cls2c.toString());
    assertNotEquals(cls2.toString(), cls0.toString());
    assertNotEquals(cls2.toString(), cls1.toString());
    assertNotEquals(cls2.toString(), cls3.toString());
    assertNotEquals(cls2.toString(), cls4.toString());

    assertEquals(cls3.toString(), cls3.toString());
    assertNotEquals(cls3.toString(), cls3c.toString());
    assertNotEquals(cls3.toString(), cls0.toString());
    assertNotEquals(cls3.toString(), cls1.toString());
    assertNotEquals(cls3.toString(), cls2.toString());
    assertNotEquals(cls3.toString(), cls4.toString());

    assertEquals(cls4.toString(), cls4.toString());
    assertNotEquals(cls4.toString(), cls4c.toString());
    assertNotEquals(cls4.toString(), cls0.toString());
    assertNotEquals(cls4.toString(), cls1.toString());
    assertNotEquals(cls4.toString(), cls2.toString());
    assertNotEquals(cls4.toString(), cls3.toString());
  }

  @Test
  public void testXmlSerialize() throws Exception {
    final GroupedBeanClass cls0 = getGroupedBeanClass0();
    final String xml0 = getGroupedBeanClass0Xml();
    testXmlMarshal(GroupedBeanClass.class, cls0, xml0);

    final GroupedBeanClass cls1 = getGroupedBeanClass1();
    final String xml1 = getGroupedBeanClass1Xml();
    testXmlMarshal(GroupedBeanClass.class, cls1, xml1);

    final GroupedBeanClass cls2 = getGroupedBeanClass2();
    final String xml2 = getGroupedBeanClass2Xml();
    testXmlMarshal(GroupedBeanClass.class, cls2, xml2);

    final GroupedBeanClass cls3 = getGroupedBeanClass3();
    final String xml3 = getGroupedBeanClass3Xml();
    testXmlMarshal(GroupedBeanClass.class, cls3, xml3);

    final GroupedBeanClass cls4 = getGroupedBeanClass4();
    final String xml4 = getGroupedBeanClass4Xml();
    testXmlMarshal(GroupedBeanClass.class, cls4, xml4);
  }

  @Test
  public void testXmlDeserialize() throws Exception {
    final GroupedBeanClass cls0 = getGroupedBeanClass0();
    final String xml0 = getGroupedBeanClass0Xml();
    testXmlUnmarshal(GroupedBeanClass.class, xml0, cls0);

    final GroupedBeanClass cls1 = getGroupedBeanClass1();
    final String xml1 = getGroupedBeanClass1Xml();
    testXmlUnmarshal(GroupedBeanClass.class, xml1, cls1);

    final GroupedBeanClass cls2 = getGroupedBeanClass2();
    final String xml2 = getGroupedBeanClass2Xml();
    testXmlUnmarshal(GroupedBeanClass.class, xml2, cls2);

    final GroupedBeanClass cls3 = getGroupedBeanClass3();
    final String xml3 = getGroupedBeanClass3Xml();
    testXmlUnmarshal(GroupedBeanClass.class, xml3, cls3);

    final GroupedBeanClass cls4 = getGroupedBeanClass4();
    final String xml4 = getGroupedBeanClass4Xml();
    testXmlUnmarshal(GroupedBeanClass.class, xml4, cls4);
  }
}
