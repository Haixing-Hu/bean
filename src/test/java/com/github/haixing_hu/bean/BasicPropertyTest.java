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

import java.util.List;
import java.util.Map;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * The unit test of the {@link BasicProperty} class.
 *
 * @author Haixing Hu
 */
public class BasicPropertyTest {

  @Test
  public void testConstructor() {
    final PropertyDescriptor desp1 = new PropertyDescriptor("prop1",
        String.class, PropertyKind.SIMPLE);
    final BasicProperty prop1 = new BasicProperty(desp1);
    assertEquals("prop1", prop1.getName());
    assertEquals(String.class, prop1.getType());
    assertEquals(PropertyKind.SIMPLE, prop1.getKind());
    assertSame(desp1, prop1.getDescriptor());
    assertNull(prop1.getRawValue());

    final PropertyDescriptor desp2 = new PropertyDescriptor("prop2", Long.class,
        PropertyKind.INDEXED);
    final BasicProperty prop2 = new BasicProperty(desp2);
    assertEquals("prop2", prop2.getName());
    assertEquals(Long.class, prop2.getType());
    assertEquals(PropertyKind.INDEXED, prop2.getKind());
    assertSame(desp2, prop2.getDescriptor());
    assertNotNull(prop2.getRawValue());
    assertTrue(prop2.getRawValue() instanceof List);

    final PropertyDescriptor desp3 = new PropertyDescriptor("prop3", Byte.class,
        PropertyKind.MAPPED);
    final BasicProperty prop3 = new BasicProperty(desp3);
    assertEquals("prop3", prop3.getName());
    assertEquals(Byte.class, prop3.getType());
    assertEquals(PropertyKind.MAPPED, prop3.getKind());
    assertSame(desp3, prop3.getDescriptor());
    assertNotNull(prop3.getRawValue());
    assertTrue(prop3.getRawValue() instanceof Map);

    try {
      new BasicProperty(null);
      fail("should throw");
    } catch (final NullPointerException e) {
      //  pass
    }
  }

  @Test
  public void testGetRawValue() {

  }

  @Test
  public void testSetRawValue() {

  }

  @Test
  public void testGetSize() {

  }

  @Test
  public void testGetSimpleValue() {

  }

  @Test
  public void testSetSimpleValue() {

  }

  @Test
  public void testGetIndexedValue() {

  }

  @Test
  public void testSetIndexedValueList() {

  }

}
