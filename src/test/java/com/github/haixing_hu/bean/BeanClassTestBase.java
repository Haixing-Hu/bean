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

import com.github.haixing_hu.reflect.ReflectionException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

/**
 * Provides common functions for unit testing the implementations of
 * {@link BeanClass}.
 *
 * @author Haixing Hu
 */
public class BeanClassTestBase extends PropertyDescriptorTestBase {

  protected DefaultBeanClass getDefaultBeanClass0() {
    return new DefaultBeanClass("bean0", new PropertyDescriptor[0]);
  }

  protected String getDefaultBeanClass0Xml() {
    return "<bean-class>" + "<name>bean0</name>" + "<bean>default-bean</bean>"
        + "<properties/>" + "</bean-class>";
  }

  protected DefaultBeanClass getDefaultBeanClass1() {
    return new DefaultBeanClass("bean1", new PropertyDescriptor[] {

    });
  }

  protected String getDefaultBeanClass1Xml() {
    return "<bean-class>" + "<name>bean1</name>" + "<bean>default-bean</bean>"
        + "<properties/>" + "</bean-class>";
  }

  protected DefaultBeanClass getDefaultBeanClass2() {
    TypeAliasRegistry.register("my-bean", MyBean.class);
    return new DefaultBeanClass("bean2",
        new PropertyDescriptor[] { getPropertyDescriptor1(), }, MyBean.class);
  }

  protected String getDefaultBeanClass2Xml() {
    return "<bean-class>" + "<name>bean2</name>" + "<bean>my-bean</bean>"
        + "<properties>" + getPropertyDescriptor1Xml() + "</properties>"
        + "</bean-class>";
  }

  protected DefaultBeanClass getDefaultBeanClass3() {
    return new DefaultBeanClass("bean3", new PropertyDescriptor[] {
        getPropertyDescriptor1(), getPropertyDescriptor2(),
        getPropertyDescriptor3(), }, null);
  }

  protected String getDefaultBeanClass3Xml() {
    return "<bean-class>" + "<name>bean3</name>" + "<bean>default-bean</bean>"
        + "<properties>" + getPropertyDescriptor1Xml()
        + getPropertyDescriptor2Xml() + getPropertyDescriptor3Xml()
        + "</properties>" + "</bean-class>";
  }

  protected DefaultBeanClass getDefaultBeanClass4() {
    TypeAliasRegistry.register("my-bean", MyBean.class);
    return new DefaultBeanClass("bean4", new PropertyDescriptor[] {
        getPropertyDescriptor1(), getPropertyDescriptor2(),
        getPropertyDescriptor3(), getPropertyDescriptor4(),
        getPropertyDescriptor5(), getPropertyDescriptor6(), }, MyBean.class);
  }

  protected String getDefaultBeanClass4Xml() {
    return "<bean-class>" + "<name>bean4</name>" + "<bean>my-bean</bean>"
        + "<properties>" + getPropertyDescriptor1Xml()
        + getPropertyDescriptor2Xml() + getPropertyDescriptor3Xml()
        + getPropertyDescriptor4Xml() + getPropertyDescriptor5Xml()
        + getPropertyDescriptor6Xml() + "</properties>" + "</bean-class>";
  }

  protected GroupedBeanClass getGroupedBeanClass0() {
    return new GroupedBeanClass("bean0", new PropertyDescriptorGroup[0]);
  }

  protected String getGroupedBeanClass0Xml() {
    return "<bean-class>" + "<name>bean0</name>" + "<bean>default-bean</bean>"
        + "<property-groups/>" + "</bean-class>";
  }

  protected GroupedBeanClass getGroupedBeanClass1() {
    return new GroupedBeanClass("bean1",
        new PropertyDescriptorGroup[] { getPropertyDescriptorGroup0(), });
  }

  protected String getGroupedBeanClass1Xml() {
    return "<bean-class>" + "<name>bean1</name>" + "<bean>default-bean</bean>"
        + "<property-groups>" + getPropertyDescriptorGroup0Xml()
        + "</property-groups>" + "</bean-class>";
  }

  protected GroupedBeanClass getGroupedBeanClass2() {
    TypeAliasRegistry.register("my-bean", MyBean.class);
    return new GroupedBeanClass("bean2", new PropertyDescriptorGroup[] {
        getPropertyDescriptorGroup0(), getPropertyDescriptorGroup1(), },
        MyBean.class);
  }

  protected String getGroupedBeanClass2Xml() {
    return "<bean-class>" + "<name>bean2</name>" + "<bean>my-bean</bean>"
        + "<property-groups>" + getPropertyDescriptorGroup0Xml()
        + getPropertyDescriptorGroup1Xml() + "</property-groups>"
        + "</bean-class>";
  }

  protected GroupedBeanClass getGroupedBeanClass3() {
    return new GroupedBeanClass("bean3", new PropertyDescriptorGroup[] {
        getPropertyDescriptorGroup0(), getPropertyDescriptorGroup1(),
        getPropertyDescriptorGroup2(), }, null);
  }

  protected String getGroupedBeanClass3Xml() {
    return "<bean-class>" + "<name>bean3</name>" + "<bean>default-bean</bean>"
        + "<property-groups>" + getPropertyDescriptorGroup0Xml()
        + getPropertyDescriptorGroup1Xml() + getPropertyDescriptorGroup2Xml()
        + "</property-groups>" + "</bean-class>";
  }

  protected GroupedBeanClass getGroupedBeanClass4() {
    TypeAliasRegistry.register("my-bean", MyBean.class);
    return new GroupedBeanClass("bean4", new PropertyDescriptorGroup[] {
        getPropertyDescriptorGroup0(), getPropertyDescriptorGroup1(),
        getPropertyDescriptorGroup2(), getPropertyDescriptorGroup3(), },
        MyBean.class);
  }

  protected String getGroupedBeanClass4Xml() {
    return "<bean-class>" + "<name>bean4</name>" + "<bean>my-bean</bean>"
        + "<property-groups>" + getPropertyDescriptorGroup0Xml()
        + getPropertyDescriptorGroup1Xml() + getPropertyDescriptorGroup2Xml()
        + getPropertyDescriptorGroup3Xml() + "</property-groups>"
        + "</bean-class>";
  }

  protected void testBeanClass0Constructor(final BeanClass cls0) {
    assertEquals("bean0", cls0.getName());
    assertArrayEquals(new PropertyDescriptor[0], cls0.getPropertyDescriptors());
    assertEquals(DefaultBean.class, cls0.getBeanType());
    assertEquals(false, cls0.hasProperty("prop1"));
    assertEquals(false, cls0.hasProperty("_prop2"));
    assertEquals(false, cls0.hasProperty("prop-3"));
    assertEquals(false, cls0.hasProperty("prop_4"));
    assertEquals(false, cls0.hasProperty("prop5"));
    assertEquals(false, cls0.hasProperty("prop6"));
  }

  protected void testBeanClass1Constructor(final BeanClass cls1) {
    assertEquals("bean1", cls1.getName());
    assertArrayEquals(new PropertyDescriptor[0], cls1.getPropertyDescriptors());
    assertEquals(DefaultBean.class, cls1.getBeanType());
    assertEquals(false, cls1.hasProperty("prop1"));
    assertEquals(false, cls1.hasProperty("_prop2"));
    assertEquals(false, cls1.hasProperty("prop-3"));
    assertEquals(false, cls1.hasProperty("prop_4"));
    assertEquals(false, cls1.hasProperty("prop5"));
    assertEquals(false, cls1.hasProperty("prop6"));
  }

  protected void testBeanClass2Constructor(final BeanClass cls2) {
    assertEquals("bean2", cls2.getName());
    assertArrayEquals(new PropertyDescriptor[] { getPropertyDescriptor1(), },
        cls2.getPropertyDescriptors());
    assertEquals(MyBean.class, cls2.getBeanType());
    assertEquals(true, cls2.hasProperty("prop1"));
    assertEquals(false, cls2.hasProperty("_prop2"));
    assertEquals(false, cls2.hasProperty("prop-3"));
    assertEquals(false, cls2.hasProperty("prop_4"));
    assertEquals(false, cls2.hasProperty("prop5"));
    assertEquals(false, cls2.hasProperty("prop6"));
  }

  protected void testBeanClass3Constructor(final BeanClass cls3) {
    assertEquals("bean3", cls3.getName());
    assertArrayEquals(new PropertyDescriptor[] { getPropertyDescriptor1(),
        getPropertyDescriptor2(), getPropertyDescriptor3(), },
        cls3.getPropertyDescriptors());
    assertEquals(DefaultBean.class, cls3.getBeanType());
    assertEquals(true, cls3.hasProperty("prop1"));
    assertEquals(true, cls3.hasProperty("_prop2"));
    assertEquals(true, cls3.hasProperty("prop-3"));
    assertEquals(false, cls3.hasProperty("prop_4"));
    assertEquals(false, cls3.hasProperty("prop5"));
    assertEquals(false, cls3.hasProperty("prop6"));
  }

  protected void testBeanClass4Constructor(final BeanClass cls4) {
    assertEquals("bean4", cls4.getName());
    assertArrayEquals(new PropertyDescriptor[] { getPropertyDescriptor1(),
        getPropertyDescriptor2(), getPropertyDescriptor3(),
        getPropertyDescriptor4(), getPropertyDescriptor5(),
        getPropertyDescriptor6(), }, cls4.getPropertyDescriptors());
    assertEquals(MyBean.class, cls4.getBeanType());
    assertEquals(true, cls4.hasProperty("prop1"));
    assertEquals(true, cls4.hasProperty("_prop2"));
    assertEquals(true, cls4.hasProperty("prop-3"));
    assertEquals(true, cls4.hasProperty("prop_4"));
    assertEquals(true, cls4.hasProperty("prop5"));
    assertEquals(true, cls4.hasProperty("prop6"));
  }

  protected void testBeanClass0NewInstance(final BeanClass cls0) {
    final Bean bean0 = cls0.newInstance();
    assertEquals(DefaultBean.class, bean0.getClass());
    assertSame(cls0, bean0.getBeanClass());
  }

  protected void testBeanClass1NewInstance(final BeanClass cls1) {
    final Bean bean1 = cls1.newInstance();
    assertEquals(DefaultBean.class, bean1.getClass());
    assertSame(cls1, bean1.getBeanClass());
  }

  protected void testBeanClass2NewInstance(final BeanClass cls2) {
    final Bean bean2 = cls2.newInstance();
    assertEquals(MyBean.class, bean2.getClass());
    assertSame(cls2, bean2.getBeanClass());
  }

  protected void testBeanClass3NewInstance(final BeanClass cls3) {
    final Bean bean3 = cls3.newInstance();
    assertEquals(DefaultBean.class, bean3.getClass());
    assertSame(cls3, bean3.getBeanClass());
  }

  protected void testBeanClass4NewInstance(final BeanClass cls4) {
    final Bean bean4 = cls4.newInstance();
    assertEquals(MyBean.class, bean4.getClass());
    assertSame(cls4, bean4.getBeanClass());
  }

  protected void testEmptyBeanClassNewInstance(final BeanClass cls) {
    final Bean bean4 = cls.newInstance();
    assertEquals(DefaultBean.class, bean4.getClass());
    assertSame(cls, bean4.getBeanClass());
  }

  protected void testBadBeanClassNewInstance(final BeanClass cls) {
    try {
      cls.newInstance();
      fail("should throw");
    } catch (final ReflectionException e) {
      //  pass
    }
  }

  protected void testBeanClass0HasProperty(final BeanClass cls0) {
    assertEquals(false, cls0.hasProperty("prop1"));
    assertEquals(false, cls0.hasProperty("_prop2"));
    assertEquals(false, cls0.hasProperty("prop-3"));
    assertEquals(false, cls0.hasProperty("prop_4"));
    assertEquals(false, cls0.hasProperty("prop5"));
    assertEquals(false, cls0.hasProperty("prop6"));
  }

  protected void testBeanClass1HasProperty(final BeanClass cls1) {
    assertEquals(false, cls1.hasProperty("prop1"));
    assertEquals(false, cls1.hasProperty("_prop2"));
    assertEquals(false, cls1.hasProperty("prop-3"));
    assertEquals(false, cls1.hasProperty("prop_4"));
    assertEquals(false, cls1.hasProperty("prop5"));
    assertEquals(false, cls1.hasProperty("prop6"));
  }

  protected void testBeanClass2HasProperty(final BeanClass cls2) {
    assertEquals(true, cls2.hasProperty("prop1"));
    assertEquals(false, cls2.hasProperty("_prop2"));
    assertEquals(false, cls2.hasProperty("prop-3"));
    assertEquals(false, cls2.hasProperty("prop_4"));
    assertEquals(false, cls2.hasProperty("prop5"));
    assertEquals(false, cls2.hasProperty("prop6"));
  }

  protected void testBeanClass3HasProperty(final BeanClass cls3) {
    assertEquals(true, cls3.hasProperty("prop1"));
    assertEquals(true, cls3.hasProperty("_prop2"));
    assertEquals(true, cls3.hasProperty("prop-3"));
    assertEquals(false, cls3.hasProperty("prop_4"));
    assertEquals(false, cls3.hasProperty("prop5"));
    assertEquals(false, cls3.hasProperty("prop6"));
  }

  protected void testBeanClass4HasProperty(final BeanClass cls4) {
    assertEquals(true, cls4.hasProperty("prop1"));
    assertEquals(true, cls4.hasProperty("_prop2"));
    assertEquals(true, cls4.hasProperty("prop-3"));
    assertEquals(true, cls4.hasProperty("prop_4"));
    assertEquals(true, cls4.hasProperty("prop5"));
    assertEquals(true, cls4.hasProperty("prop6"));
  }

  protected void testEmptyBeanClassHasProperty(final BeanClass cls) {
    assertEquals(false, cls.hasProperty("prop1"));
    assertEquals(false, cls.hasProperty("_prop2"));
    assertEquals(false, cls.hasProperty("prop-3"));
    assertEquals(false, cls.hasProperty("prop_4"));
    assertEquals(false, cls.hasProperty("prop5"));
    assertEquals(false, cls.hasProperty("prop6"));
  }

  protected void testBeanClass0GetPropertyDescriptor(final BeanClass cls0) {
    assertEquals(null, cls0.getPropertyDescriptor("prop1"));
    assertEquals(null, cls0.getPropertyDescriptor("_prop2"));
    assertEquals(null, cls0.getPropertyDescriptor("prop-3"));
    assertEquals(null, cls0.getPropertyDescriptor("prop_4"));
    assertEquals(null, cls0.getPropertyDescriptor("prop5"));
    assertEquals(null, cls0.getPropertyDescriptor("prop6"));
  }

  protected void testBeanClass1GetPropertyDescriptor(final BeanClass cls1) {
    assertEquals(null, cls1.getPropertyDescriptor("prop1"));
    assertEquals(null, cls1.getPropertyDescriptor("_prop2"));
    assertEquals(null, cls1.getPropertyDescriptor("prop-3"));
    assertEquals(null, cls1.getPropertyDescriptor("prop_4"));
    assertEquals(null, cls1.getPropertyDescriptor("prop5"));
    assertEquals(null, cls1.getPropertyDescriptor("prop6"));
  }

  protected void testBeanClass2GetPropertyDescriptor(final BeanClass cls2) {
    assertEquals(getPropertyDescriptor1(), cls2.getPropertyDescriptor("prop1"));
    assertEquals(null, cls2.getPropertyDescriptor("_prop2"));
    assertEquals(null, cls2.getPropertyDescriptor("prop-3"));
    assertEquals(null, cls2.getPropertyDescriptor("prop_4"));
    assertEquals(null, cls2.getPropertyDescriptor("prop5"));
    assertEquals(null, cls2.getPropertyDescriptor("prop6"));
  }

  protected void testBeanClass3GetPropertyDescriptor(final BeanClass cls3) {
    assertEquals(getPropertyDescriptor1(), cls3.getPropertyDescriptor("prop1"));
    assertEquals(getPropertyDescriptor2(), cls3.getPropertyDescriptor("_prop2"));
    assertEquals(getPropertyDescriptor3(), cls3.getPropertyDescriptor("prop-3"));
    assertEquals(null, cls3.getPropertyDescriptor("prop_4"));
    assertEquals(null, cls3.getPropertyDescriptor("prop5"));
    assertEquals(null, cls3.getPropertyDescriptor("prop6"));
  }

  protected void testBeanClass4GetPropertyDescriptor(final BeanClass cls4) {
    assertEquals(getPropertyDescriptor1(),
        cls4.getPropertyDescriptor("prop1"));
    assertEquals(getPropertyDescriptor2(),
        cls4.getPropertyDescriptor("_prop2"));
    assertEquals(getPropertyDescriptor3(),
        cls4.getPropertyDescriptor("prop-3"));
    assertEquals(getPropertyDescriptor4(),
        cls4.getPropertyDescriptor("prop_4"));
    assertEquals(getPropertyDescriptor5(),
        cls4.getPropertyDescriptor("prop5"));
    assertEquals(getPropertyDescriptor6(),
        cls4.getPropertyDescriptor("prop6"));
  }

  protected void testEmptyBeanClassGetPropertyDescriptor(final BeanClass cls) {
    assertEquals(null, cls.getPropertyDescriptor("prop1"));
    assertEquals(null, cls.getPropertyDescriptor("_prop2"));
    assertEquals(null, cls.getPropertyDescriptor("prop-3"));
    assertEquals(null, cls.getPropertyDescriptor("prop_4"));
    assertEquals(null, cls.getPropertyDescriptor("prop5"));
    assertEquals(null, cls.getPropertyDescriptor("prop6"));
    assertArrayEquals(new PropertyDescriptor[0], cls.getPropertyDescriptors());
  }
}
