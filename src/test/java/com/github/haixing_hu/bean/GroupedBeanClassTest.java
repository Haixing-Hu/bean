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
