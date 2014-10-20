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
