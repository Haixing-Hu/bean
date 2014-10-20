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

/**
 * Unit test for the {@link DefaultBean} class.
 *
 * @author Haixing Hu
 */
public class DefaultBeanTest extends BeanTestBase {

  @Override
  protected Property newProperty(final PropertyDescriptor descriptor) {
    if (descriptor == null) {
      return null;
    } else {
      return new DefaultProperty(descriptor);
    }
  }

  @Test
  public void testConstructor() {
    final BeanClass cls0 = getDefaultBeanClass0();
    final DefaultBean bean0 = new DefaultBean(cls0);
    testBeanConstructor(cls0, bean0);

    final BeanClass cls1 = getDefaultBeanClass1();
    final DefaultBean bean1 = new DefaultBean(cls1);
    testBeanConstructor(cls1, bean1);

    final BeanClass cls2 = getDefaultBeanClass2();
    final DefaultBean bean2 = new DefaultBean(cls2);
    testBeanConstructor(cls2, bean2);

    final BeanClass cls3 = getDefaultBeanClass3();
    final DefaultBean bean3 = new DefaultBean(cls3);
    testBeanConstructor(cls3, bean3);

    final BeanClass cls4 = getDefaultBeanClass4();
    final DefaultBean bean4 = new DefaultBean(cls4);
    testBeanConstructor(cls4, bean4);
  }

  @Test
  public void testGetPoroperty() {
    final BeanClass cls0 = getDefaultBeanClass0();
    final DefaultBean bean0 = new DefaultBean(cls0);
    testBeanGetProperty(cls0, bean0);

    final BeanClass cls1 = getDefaultBeanClass1();
    final DefaultBean bean1 = new DefaultBean(cls1);
    testBeanGetProperty(cls1, bean1);

    final BeanClass cls2 = getDefaultBeanClass2();
    final DefaultBean bean2 = new DefaultBean(cls2);
    testBeanGetProperty(cls2, bean2);

    final BeanClass cls3 = getDefaultBeanClass3();
    final DefaultBean bean3 = new DefaultBean(cls3);
    testBeanGetProperty(cls3, bean3);

    final BeanClass cls4 = getDefaultBeanClass4();
    final DefaultBean bean4 = new DefaultBean(cls4);
    testBeanGetProperty(cls4, bean4);
  }

  @Test
  public void testGetSetSimpleValue() {
    final BeanClass cls0 = getDefaultBeanClass0();
    final DefaultBean bean0 = new DefaultBean(cls0);
    testBean0GetSetSimple(cls0, bean0);

    final BeanClass cls1 = getDefaultBeanClass1();
    final DefaultBean bean1 = new DefaultBean(cls1);
    testBean1GetSetSimple(cls1, bean1);

    final BeanClass cls2 = getDefaultBeanClass2();
    final DefaultBean bean2 = new DefaultBean(cls2);
    testBean2GetSetSimple(cls2, bean2);

    final BeanClass cls3 = getDefaultBeanClass3();
    final DefaultBean bean3 = new DefaultBean(cls3);
    testBean3GetSetSimple(cls3, bean3);

    final BeanClass cls4 = getDefaultBeanClass4();
    final DefaultBean bean4 = new DefaultBean(cls4);
    testBean4GetSetSimple(cls4, bean4);
  }

  @Test
  public void testGetSetIndexedValue() {
    //  TODO
  }

  @Test
  public void testAddRemoveIndexedValue() {
//  TODO
  }

  @Test
  public void testGetSetMappedValue() {
//  TODO
  }

  @Test
  public void testRemoveMappedValue() {
//  TODO
  }

  @Test
  public void testGetKeySet() {
//  TODO
  }

  @Test
  public void testContainsKey() {
//  TODO
  }

  @Test
  public void testGetSize() {
//  TODO
  }

  @Test
  public void testClear() {
//  TODO
  }

}
