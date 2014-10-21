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
 * Unit test of the {@link DefaultBeanClass}.
 *
 * @author Haixing Hu
 */
public class DefaultBeanClassTest extends BeanClassTestBase {

  @Test
  public void testConstructor() {
    final DefaultBeanClass cls0 = getDefaultBeanClass0();
    testBeanClass0Constructor(cls0);

    final DefaultBeanClass cls1 = getDefaultBeanClass1();
    testBeanClass1Constructor(cls1);

    final DefaultBeanClass cls2 = getDefaultBeanClass2();
    testBeanClass2Constructor(cls2);

    final DefaultBeanClass cls3 = getDefaultBeanClass3();
    testBeanClass3Constructor(cls3);

    final DefaultBeanClass cls4 = getDefaultBeanClass4();
    testBeanClass4Constructor(cls4);

    try {
      new DefaultBeanClass(null, new PropertyDescriptor[0]);
      fail("should throw");
    } catch (final NullPointerException e) {
      //  pass
    }

    try {
      new DefaultBeanClass("bean1", null);
      fail("should throw");
    } catch (final NullPointerException e) {
      //  pass
    }

    try {
      new DefaultBeanClass("bean1", new PropertyDescriptor[]{ null });
      fail("should throw");
    } catch (final NullPointerException e) {
      //  pass
    }

    try {
      new DefaultBeanClass(null, new PropertyDescriptor[0], MyBean.class);
      fail("should throw");
    } catch (final NullPointerException e) {
      //  pass
    }

    try {
      new DefaultBeanClass("bean1", null, MyBean.class);
      fail("should throw");
    } catch (final NullPointerException e) {
      //  pass
    }

    try {
      new DefaultBeanClass("bean1", new PropertyDescriptor[]{ null },
          MyBean.class);
      fail("should throw");
    } catch (final NullPointerException e) {
      //  pass
    }

    try {
      new DefaultBeanClass("bean1", new PropertyDescriptor[0],
          Bean.class);
      fail("should throw");
    } catch (final IllegalArgumentException e) {
      //  pass
    }

    try {
      new DefaultBeanClass("bean1", new PropertyDescriptor[0],
          EmptyBean.class);
      fail("should throw");
    } catch (final IllegalArgumentException e) {
      //  pass
    }
  }

  @Test
  public void testNewInstance() {
    final DefaultBeanClass cls0 = getDefaultBeanClass0();
    testBeanClass0NewInstance(cls0);

    final DefaultBeanClass cls1 = getDefaultBeanClass1();
    testBeanClass1NewInstance(cls1);

    final DefaultBeanClass cls2 = getDefaultBeanClass2();
    testBeanClass2NewInstance(cls2);

    final DefaultBeanClass cls3 = getDefaultBeanClass3();
    testBeanClass3NewInstance(cls3);

    final DefaultBeanClass cls4 = getDefaultBeanClass4();
    testBeanClass4NewInstance(cls4);

    final DefaultBeanClass cls = new DefaultBeanClass();
    testEmptyBeanClassNewInstance(cls);

    final DefaultBeanClass clsb = new DefaultBeanClass("bad-bean",
          new PropertyDescriptor[0], BadBean.class);
    testBadBeanClassNewInstance(clsb);
  }

  @Test
  public void testHasProperty() {
    final DefaultBeanClass cls0 = getDefaultBeanClass0();
    testBeanClass0HasProperty(cls0);

    final DefaultBeanClass cls1 = getDefaultBeanClass1();
    testBeanClass1HasProperty(cls1);

    final DefaultBeanClass cls2 = getDefaultBeanClass2();
    testBeanClass2HasProperty(cls2);

    final DefaultBeanClass cls3 = getDefaultBeanClass3();
    testBeanClass3HasProperty(cls3);

    final DefaultBeanClass cls4 = getDefaultBeanClass4();
    testBeanClass4HasProperty(cls4);

    final DefaultBeanClass cls = new DefaultBeanClass();
    testEmptyBeanClassHasProperty(cls);
  }

  @Test
  public void testGetPropertyDescriptor() {
    final DefaultBeanClass cls0 = getDefaultBeanClass0();
    testBeanClass0GetPropertyDescriptor(cls0);

    final DefaultBeanClass cls1 = getDefaultBeanClass1();
    testBeanClass1GetPropertyDescriptor(cls1);

    final DefaultBeanClass cls2 = getDefaultBeanClass2();
    testBeanClass2GetPropertyDescriptor(cls2);

    final DefaultBeanClass cls3 = getDefaultBeanClass3();
    testBeanClass3GetPropertyDescriptor(cls3);

    final DefaultBeanClass cls4 = getDefaultBeanClass4();
    testBeanClass4GetPropertyDescriptor(cls4);

    final DefaultBeanClass cls = new DefaultBeanClass();
    testEmptyBeanClassGetPropertyDescriptor(cls);
  }

  @Test
  public void testEqualHashCode() {
    final DefaultBeanClass cls0 = getDefaultBeanClass0();
    final DefaultBeanClass cls0c = getDefaultBeanClass0();

    final DefaultBeanClass cls1 = getDefaultBeanClass1();
    final DefaultBeanClass cls1c = getDefaultBeanClass1();

    final DefaultBeanClass cls2 = getDefaultBeanClass2();
    final DefaultBeanClass cls2c = getDefaultBeanClass2();

    final DefaultBeanClass cls3 = getDefaultBeanClass3();
    final DefaultBeanClass cls3c = getDefaultBeanClass3();

    final DefaultBeanClass cls4 = getDefaultBeanClass4();
    final DefaultBeanClass cls4c = getDefaultBeanClass4();

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
    final DefaultBeanClass cls0 = getDefaultBeanClass0();
    final DefaultBeanClass cls0c = getDefaultBeanClass0();

    final DefaultBeanClass cls1 = getDefaultBeanClass1();
    final DefaultBeanClass cls1c = getDefaultBeanClass1();

    final DefaultBeanClass cls2 = getDefaultBeanClass2();
    final DefaultBeanClass cls2c = getDefaultBeanClass2();

    final DefaultBeanClass cls3 = getDefaultBeanClass3();
    final DefaultBeanClass cls3c = getDefaultBeanClass3();

    final DefaultBeanClass cls4 = getDefaultBeanClass4();
    final DefaultBeanClass cls4c = getDefaultBeanClass4();

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
    final DefaultBeanClass cls0 = getDefaultBeanClass0();
    final String xml0 = getDefaultBeanClass0Xml();
    testXmlMarshal(DefaultBeanClass.class, cls0, xml0);

    final DefaultBeanClass cls1 = getDefaultBeanClass1();
    final String xml1 = getDefaultBeanClass1Xml();
    testXmlMarshal(DefaultBeanClass.class, cls1, xml1);

    final DefaultBeanClass cls2 = getDefaultBeanClass2();
    final String xml2 = getDefaultBeanClass2Xml();
    testXmlMarshal(DefaultBeanClass.class, cls2, xml2);

    final DefaultBeanClass cls3 = getDefaultBeanClass3();
    final String xml3 = getDefaultBeanClass3Xml();
    testXmlMarshal(DefaultBeanClass.class, cls3, xml3);

    final DefaultBeanClass cls4 = getDefaultBeanClass4();
    final String xml4 = getDefaultBeanClass4Xml();
    testXmlMarshal(DefaultBeanClass.class, cls4, xml4);
  }

  @Test
  public void testXmlDeserialize() throws Exception {
    final DefaultBeanClass cls0 = getDefaultBeanClass0();
    final String xml0 = getDefaultBeanClass0Xml();
    testXmlUnmarshal(DefaultBeanClass.class, xml0, cls0);

    final DefaultBeanClass cls1 = getDefaultBeanClass1();
    final String xml1 = getDefaultBeanClass1Xml();
    testXmlUnmarshal(DefaultBeanClass.class, xml1, cls1);

    final DefaultBeanClass cls2 = getDefaultBeanClass2();
    final String xml2 = getDefaultBeanClass2Xml();
    testXmlUnmarshal(DefaultBeanClass.class, xml2, cls2);

    final DefaultBeanClass cls3 = getDefaultBeanClass3();
    final String xml3 = getDefaultBeanClass3Xml();
    testXmlUnmarshal(DefaultBeanClass.class, xml3, cls3);

    final DefaultBeanClass cls4 = getDefaultBeanClass4();
    final String xml4 = getDefaultBeanClass4Xml();
    testXmlUnmarshal(DefaultBeanClass.class, xml4, cls4);
  }
}
