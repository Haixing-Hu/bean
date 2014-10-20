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
 * The unit test of the {@link DefaultProperty} class.
 *
 * @author Haixing Hu
 */
public class DefaultPropertyTest extends PropertyTestBase {

  @Test
  public void testConstructor() {
    final PropertyDescriptor desp1 = getPropertyDescriptor1();
    final DefaultProperty prop1 = new DefaultProperty(desp1);
    testProperty1(prop1);

    final PropertyDescriptor desp2 = getPropertyDescriptor2();
    final DefaultProperty prop2 = new DefaultProperty(desp2);
    testProperty2(prop2);

    final PropertyDescriptor desp3 = getPropertyDescriptor3();
    final DefaultProperty prop3 = new DefaultProperty(desp3);
    testProperty3(prop3);

    final PropertyDescriptor desp4 = getPropertyDescriptor4();
    final DefaultProperty prop4 = new DefaultProperty(desp4);
    testProperty4(prop4);

    try {
      new DefaultProperty(null);
      fail("should throw");
    } catch (final NullPointerException e) {
      //  pass
    }
  }

  @Test
  public void testGetSetRawValue() {

    final PropertyDescriptor desp1 = getPropertyDescriptor1();
    final DefaultProperty prop1 = new DefaultProperty(desp1);
    testProperty1GetSetRawValue(prop1);

    final PropertyDescriptor desp2 = getPropertyDescriptor2();
    final DefaultProperty prop2 = new DefaultProperty(desp2);
    testProperty2GetSetRawValue(prop2);

    final PropertyDescriptor desp3 = getPropertyDescriptor3();
    final DefaultProperty prop3 = new DefaultProperty(desp3);
    testProperty3GetSetRawValue(prop3);
  }

  @Test
  public void testGetSize() {

    final PropertyDescriptor desp1 = getPropertyDescriptor1();
    final DefaultProperty prop1 = new DefaultProperty(desp1);
    testProperty1GetSize(prop1);

    final PropertyDescriptor desp2 = getPropertyDescriptor2();
    final DefaultProperty prop2 = new DefaultProperty(desp2);
    testProperty2GetSize(prop2);

    final PropertyDescriptor desp3 = getPropertyDescriptor3();
    final DefaultProperty prop3 = new DefaultProperty(desp3);
    testProperty3GetSize(prop3);
  }

  @Test
  public void testGetSetSimpleValue() {
    final PropertyDescriptor desp1 = getPropertyDescriptor1();
    final DefaultProperty prop1 = new DefaultProperty(desp1);
    testProperty1GetSetSimpleValue(prop1);

    final PropertyDescriptor desp2 = getPropertyDescriptor2();
    final DefaultProperty prop2 = new DefaultProperty(desp2);
    testProperty2GetSetSimpleValue(prop2);

    final PropertyDescriptor desp3 = getPropertyDescriptor3();
    final DefaultProperty prop3 = new DefaultProperty(desp3);
    testProperty3GetSetSimpleValue(prop3);
  }

  @Test
  public void testGetSetIndexedValue() {
    final PropertyDescriptor desp1 = getPropertyDescriptor1();
    final DefaultProperty prop1 = new DefaultProperty(desp1);
    testProperty1GetSetIndexedValue(prop1);

    final PropertyDescriptor desp2 = getPropertyDescriptor2();
    final DefaultProperty prop2 = new DefaultProperty(desp2);
    testProperty2GetSetIndexedValue(prop2);

    final PropertyDescriptor desp3 = getPropertyDescriptor3();
    final DefaultProperty prop3 = new DefaultProperty(desp3);
    testProperty3GetSetIndexedValue(prop3);
  }

  @Test
  public void testAddRemoveIndexedValue() {
    final PropertyDescriptor desp1 = getPropertyDescriptor1();
    final DefaultProperty prop1 = new DefaultProperty(desp1);
    testProperty1AddRemoveIndexedValue(prop1);

    final PropertyDescriptor desp2 = getPropertyDescriptor2();
    final DefaultProperty prop2 = new DefaultProperty(desp2);
    testProperty2AddRemoveIndexedValue(prop2);

    final PropertyDescriptor desp3 = getPropertyDescriptor3();
    final DefaultProperty prop3 = new DefaultProperty(desp3);
    testProperty3AddRemoveIndexedValue(prop3);
  }

  @Test
  public void testGetSetMappedValue() {
    final PropertyDescriptor desp1 = getPropertyDescriptor1();
    final DefaultProperty prop1 = new DefaultProperty(desp1);
    testProperty1GetSetMappedValue(prop1);

    final PropertyDescriptor desp2 = getPropertyDescriptor2();
    final DefaultProperty prop2 = new DefaultProperty(desp2);
    testProperty2GetSetMappedValue(prop2);

    final PropertyDescriptor desp3 = getPropertyDescriptor3();
    final DefaultProperty prop3 = new DefaultProperty(desp3);
    testProperty3GetSetMappedValue(prop3);
  }

  @Test
  public void testGetKeySet() {
    final PropertyDescriptor desp1 = getPropertyDescriptor1();
    final DefaultProperty prop1 = new DefaultProperty(desp1);
    testProperty1GetKeySet(prop1);

    final PropertyDescriptor desp2 = getPropertyDescriptor2();
    final DefaultProperty prop2 = new DefaultProperty(desp2);
    testProperty2GetKeySet(prop2);

    final PropertyDescriptor desp3 = getPropertyDescriptor3();
    final DefaultProperty prop3 = new DefaultProperty(desp3);
    testProperty3GetKeySet(prop3);
  }

  @Test
  public void testContainsKey() {
    final PropertyDescriptor desp1 = getPropertyDescriptor1();
    final DefaultProperty prop1 = new DefaultProperty(desp1);
    testProperty1ContainsKey(prop1);

    final PropertyDescriptor desp2 = getPropertyDescriptor2();
    final DefaultProperty prop2 = new DefaultProperty(desp2);
    testProperty2ContainsKey(prop2);

    final PropertyDescriptor desp3 = getPropertyDescriptor3();
    final DefaultProperty prop3 = new DefaultProperty(desp3);
    testProperty3ContainsKey(prop3);
  }

  @Test
  public void testRemoveMappedValue() {
    final PropertyDescriptor desp1 = getPropertyDescriptor1();
    final DefaultProperty prop1 = new DefaultProperty(desp1);
    testProperty1RemoveMappedValue(prop1);

    final PropertyDescriptor desp2 = getPropertyDescriptor2();
    final DefaultProperty prop2 = new DefaultProperty(desp2);
    testProperty2RemoveMappedValue(prop2);

    final PropertyDescriptor desp3 = getPropertyDescriptor3();
    final DefaultProperty prop3 = new DefaultProperty(desp3);
    testProperty3RemoveMappedValue(prop3);
  }

  @Test
  public void testClear() {
    final PropertyDescriptor desp1 = getPropertyDescriptor1();
    final DefaultProperty prop1 = new DefaultProperty(desp1);
    testProperty1Clear(prop1);

    final PropertyDescriptor desp2 = getPropertyDescriptor2();
    final DefaultProperty prop2 = new DefaultProperty(desp2);
    testProperty2Clear(prop2);

    final PropertyDescriptor desp3 = getPropertyDescriptor3();
    final DefaultProperty prop3 = new DefaultProperty(desp3);
    testProperty3Clear(prop3);
  }


}
