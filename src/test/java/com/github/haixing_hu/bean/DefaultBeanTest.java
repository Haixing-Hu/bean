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
  public void testSimplePropertyOperations() {
    final BeanClass cls0 = getDefaultBeanClass0();
    final DefaultBean bean0 = new DefaultBean(cls0);
    testSimplePropertyOperations(cls0, bean0);

    final BeanClass cls1 = getDefaultBeanClass1();
    final DefaultBean bean1 = new DefaultBean(cls1);
    testSimplePropertyOperations(cls1, bean1);

    final BeanClass cls2 = getDefaultBeanClass2();
    final DefaultBean bean2 = new DefaultBean(cls2);
    testSimplePropertyOperations(cls2, bean2);

    final BeanClass cls3 = getDefaultBeanClass3();
    final DefaultBean bean3 = new DefaultBean(cls3);
    testSimplePropertyOperations(cls3, bean3);

    final BeanClass cls4 = getDefaultBeanClass4();
    final DefaultBean bean4 = new DefaultBean(cls4);
    testSimplePropertyOperations(cls4, bean4);
  }

  @Test
  public void testIndexedPropertyOperations() {
    final BeanClass cls0 = getDefaultBeanClass0();
    final DefaultBean bean0 = new DefaultBean(cls0);
    testIndexedPropertyOperations(cls0, bean0);

    final BeanClass cls1 = getDefaultBeanClass1();
    final DefaultBean bean1 = new DefaultBean(cls1);
    testIndexedPropertyOperations(cls1, bean1);

    final BeanClass cls2 = getDefaultBeanClass2();
    final DefaultBean bean2 = new DefaultBean(cls2);
    testIndexedPropertyOperations(cls2, bean2);

    final BeanClass cls3 = getDefaultBeanClass3();
    final DefaultBean bean3 = new DefaultBean(cls3);
    testIndexedPropertyOperations(cls3, bean3);

    final BeanClass cls4 = getDefaultBeanClass4();
    final DefaultBean bean4 = new DefaultBean(cls4);
    testIndexedPropertyOperations(cls4, bean4);
  }

  @Test
  public void testMappedPropertyOperations() {
    final BeanClass cls0 = getDefaultBeanClass0();
    final DefaultBean bean0 = new DefaultBean(cls0);
    testMappedPropertyOperations(cls0, bean0);

    final BeanClass cls1 = getDefaultBeanClass1();
    final DefaultBean bean1 = new DefaultBean(cls1);
    testMappedPropertyOperations(cls1, bean1);

    final BeanClass cls2 = getDefaultBeanClass2();
    final DefaultBean bean2 = new DefaultBean(cls2);
    testMappedPropertyOperations(cls2, bean2);

    final BeanClass cls3 = getDefaultBeanClass3();
    final DefaultBean bean3 = new DefaultBean(cls3);
    testMappedPropertyOperations(cls3, bean3);

    final BeanClass cls4 = getDefaultBeanClass4();
    final DefaultBean bean4 = new DefaultBean(cls4);
    testMappedPropertyOperations(cls4, bean4);
  }


  @Test
  public void testEqualHashCode() {
    final DefaultBean bean0 = new DefaultBean(getDefaultBeanClass0());
    final DefaultBean bean0c = new DefaultBean(getDefaultBeanClass0());

    final DefaultBean bean1 = new DefaultBean(getDefaultBeanClass1());
    final DefaultBean bean1c = new DefaultBean(getDefaultBeanClass1());

    final DefaultBean bean2 = new DefaultBean(getDefaultBeanClass2());
    final DefaultBean bean2c = new DefaultBean(getDefaultBeanClass2());

    final DefaultBean bean3 = new DefaultBean(getDefaultBeanClass3());
    final DefaultBean bean3c = new DefaultBean(getDefaultBeanClass3());

    final DefaultBean bean4 = new DefaultBean(getDefaultBeanClass4());
    final DefaultBean bean4c = new DefaultBean(getDefaultBeanClass4());

    assertEquals(true, bean0.equals(bean0));
    assertEquals(true, bean0.equals(bean0c));
    assertEquals(false, bean0.equals(bean1));
    assertEquals(false, bean0.equals(bean2));
    assertEquals(false, bean0.equals(bean3));
    assertEquals(false, bean0.equals(bean4));
    assertEquals(false, bean0.equals(null));
    assertEquals(false, bean0.equals("str"));

    assertEquals(bean0.hashCode(), bean0.hashCode());
    assertEquals(bean0.hashCode(), bean0c.hashCode());
    assertNotEquals(bean0.hashCode(), bean1.hashCode());
    assertNotEquals(bean0.hashCode(), bean2.hashCode());
    assertNotEquals(bean0.hashCode(), bean3.hashCode());
    assertNotEquals(bean0.hashCode(), bean4.hashCode());

    assertEquals(true, bean1.equals(bean1));
    assertEquals(true, bean1.equals(bean1c));
    assertEquals(false, bean1.equals(bean0));
    assertEquals(false, bean1.equals(bean2));
    assertEquals(false, bean1.equals(bean3));
    assertEquals(false, bean1.equals(bean4));
    assertEquals(false, bean1.equals(null));
    assertEquals(false, bean1.equals("str"));

    assertEquals(bean1.hashCode(), bean1.hashCode());
    assertEquals(bean1.hashCode(), bean1c.hashCode());
    assertNotEquals(bean1.hashCode(), bean0.hashCode());
    assertNotEquals(bean1.hashCode(), bean2.hashCode());
    assertNotEquals(bean1.hashCode(), bean3.hashCode());
    assertNotEquals(bean1.hashCode(), bean4.hashCode());

    assertEquals(true, bean2.equals(bean2));
    assertEquals(true, bean2.equals(bean2c));
    assertEquals(false, bean2.equals(bean0));
    assertEquals(false, bean2.equals(bean1));
    assertEquals(false, bean2.equals(bean3));
    assertEquals(false, bean2.equals(bean4));
    assertEquals(false, bean2.equals(null));
    assertEquals(false, bean2.equals("str"));

    assertEquals(bean2.hashCode(), bean2.hashCode());
    assertEquals(bean2.hashCode(), bean2c.hashCode());
    assertNotEquals(bean2.hashCode(), bean0.hashCode());
    assertNotEquals(bean2.hashCode(), bean1.hashCode());
    assertNotEquals(bean2.hashCode(), bean3.hashCode());
    assertNotEquals(bean2.hashCode(), bean4.hashCode());

    assertEquals(true, bean3.equals(bean3));
    assertEquals(true, bean3.equals(bean3c));
    assertEquals(false, bean3.equals(bean0));
    assertEquals(false, bean3.equals(bean1));
    assertEquals(false, bean3.equals(bean2));
    assertEquals(false, bean3.equals(bean4));
    assertEquals(false, bean3.equals(null));
    assertEquals(false, bean3.equals("str"));

    assertEquals(bean3.hashCode(), bean3.hashCode());
    assertEquals(bean3.hashCode(), bean3c.hashCode());
    assertNotEquals(bean3.hashCode(), bean0.hashCode());
    assertNotEquals(bean3.hashCode(), bean1.hashCode());
    assertNotEquals(bean3.hashCode(), bean2.hashCode());
    assertNotEquals(bean3.hashCode(), bean4.hashCode());

    assertEquals(true, bean4.equals(bean4));
    assertEquals(true, bean4.equals(bean4c));
    assertEquals(false, bean4.equals(bean0));
    assertEquals(false, bean4.equals(bean1));
    assertEquals(false, bean4.equals(bean2));
    assertEquals(false, bean4.equals(bean3));
    assertEquals(false, bean4.equals(null));
    assertEquals(false, bean4.equals("str"));

    assertEquals(bean4.hashCode(), bean4.hashCode());
    assertEquals(bean4.hashCode(), bean4c.hashCode());
    assertNotEquals(bean4.hashCode(), bean0.hashCode());
    assertNotEquals(bean4.hashCode(), bean1.hashCode());
    assertNotEquals(bean4.hashCode(), bean2.hashCode());
    assertNotEquals(bean4.hashCode(), bean3.hashCode());
  }

  @Test
  public void testToString() {
    final DefaultBean bean0 = new DefaultBean(getDefaultBeanClass0());
    final DefaultBean bean0c = new DefaultBean(getDefaultBeanClass0());

    final DefaultBean bean1 = new DefaultBean(getDefaultBeanClass1());
    final DefaultBean bean1c = new DefaultBean(getDefaultBeanClass1());

    final DefaultBean bean2 = new DefaultBean(getDefaultBeanClass2());
    final DefaultBean bean2c = new DefaultBean(getDefaultBeanClass2());

    final DefaultBean bean3 = new DefaultBean(getDefaultBeanClass3());
    final DefaultBean bean3c = new DefaultBean(getDefaultBeanClass3());

    final DefaultBean bean4 = new DefaultBean(getDefaultBeanClass4());
    final DefaultBean bean4c = new DefaultBean(getDefaultBeanClass4());


    assertEquals(bean0.toString(), bean0.toString());
    assertNotEquals(bean0.toString(), bean0c.toString());
    assertNotEquals(bean0.toString(), bean1.toString());
    assertNotEquals(bean0.toString(), bean2.toString());
    assertNotEquals(bean0.toString(), bean3.toString());
    assertNotEquals(bean0.toString(), bean4.toString());

    assertEquals(bean1.toString(), bean1.toString());
    assertNotEquals(bean1.toString(), bean1c.toString());
    assertNotEquals(bean1.toString(), bean0.toString());
    assertNotEquals(bean1.toString(), bean2.toString());
    assertNotEquals(bean1.toString(), bean3.toString());
    assertNotEquals(bean1.toString(), bean4.toString());

    assertEquals(bean2.toString(), bean2.toString());
    assertNotEquals(bean2.toString(), bean2c.toString());
    assertNotEquals(bean2.toString(), bean0.toString());
    assertNotEquals(bean2.toString(), bean1.toString());
    assertNotEquals(bean2.toString(), bean3.toString());
    assertNotEquals(bean2.toString(), bean4.toString());

    assertEquals(bean3.toString(), bean3.toString());
    assertNotEquals(bean3.toString(), bean3c.toString());
    assertNotEquals(bean3.toString(), bean0.toString());
    assertNotEquals(bean3.toString(), bean1.toString());
    assertNotEquals(bean3.toString(), bean2.toString());
    assertNotEquals(bean3.toString(), bean4.toString());

    assertEquals(bean4.toString(), bean4.toString());
    assertNotEquals(bean4.toString(), bean4c.toString());
    assertNotEquals(bean4.toString(), bean0.toString());
    assertNotEquals(bean4.toString(), bean1.toString());
    assertNotEquals(bean4.toString(), bean2.toString());
    assertNotEquals(bean4.toString(), bean3.toString());
  }
}
