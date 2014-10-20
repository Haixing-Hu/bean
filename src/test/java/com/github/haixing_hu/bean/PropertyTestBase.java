/*
 * Copyright (C) 2014 Haixing Hu
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.github.haixing_hu.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * The base class for unit testing the implementation of {@link Property}.
 *
 * @author Haixing Hu
 */
public class PropertyTestBase extends PropertyDescriptorTestBase {

  protected void testProperty1(final Property prop1) {
    assertEquals("prop1", prop1.getName());
    assertEquals(String.class, prop1.getType());
    assertEquals(PropertyKind.SIMPLE, prop1.getKind());
    assertEquals(getPropertyDescriptor1(), prop1.getDescriptor());
    assertNull(prop1.getRawValue());
  }

  protected void testProperty2(final Property prop2) {
    assertEquals("_prop2", prop2.getName());
    assertEquals(Integer.class, prop2.getType());
    assertEquals(PropertyKind.INDEXED, prop2.getKind());
    assertEquals(getPropertyDescriptor2(), prop2.getDescriptor());
    assertNotNull(prop2.getRawValue());
    assertEquals(0, ((ArrayList<?>) prop2.getRawValue()).size());
  }

  protected void testProperty3(final Property prop3) {
    assertEquals("prop-3", prop3.getName());
    assertEquals(Boolean.class, prop3.getType());
    assertEquals(PropertyKind.MAPPED, prop3.getKind());
    assertEquals(getPropertyDescriptor3(), prop3.getDescriptor());
    assertNotNull(prop3.getRawValue());
    assertEquals(0, ((HashMap<?,?>) prop3.getRawValue()).size());
  }

  protected void testProperty4(final Property prop4) {
    assertEquals("prop_4", prop4.getName());
    assertEquals(MyBean.class, prop4.getType());
    assertEquals(PropertyKind.SIMPLE, prop4.getKind());
    assertEquals(getPropertyDescriptor4(), prop4.getDescriptor());
    assertNull(prop4.getRawValue());
  }

  protected void testProperty1GetSetRawValue(final Property prop1) {
    assertNull(prop1.getRawValue());
    prop1.setRawValue("Hello");
    assertEquals("Hello", prop1.getRawValue());
    prop1.setRawValue(null);
    assertNull(prop1.getRawValue());
  }

  protected void testProperty2GetSetRawValue(final Property prop2) {
    assertNotNull(prop2.getRawValue());
    assertEquals(0, ((List<?>) prop2.getRawValue()).size());
    final ArrayList<Object> list2 = new ArrayList<>();
    list2.add(1);
    list2.add(2);
    list2.add(3);
    prop2.setRawValue(list2);
    assertEquals(list2, prop2.getRawValue());


    try {
      prop2.setRawValue(null);
      fail("should throw");
    } catch (final NullPointerException e) {
      //  pass
    }

    try {
      prop2.setRawValue("Hello");
      fail("should throw");
    } catch (final ClassCastException e) {
      //  pass
    }
  }

  protected void testProperty3GetSetRawValue(final Property prop3) {
    assertNotNull(prop3.getRawValue());
    assertEquals(0, ((Map<?,?>) prop3.getRawValue()).size());

    final HashMap<String, Object> map3 = new HashMap<>();
    map3.put("item1", true);
    map3.put("item2", false);
    prop3.setRawValue(map3);
    assertEquals(map3, prop3.getRawValue());


    try {
      prop3.setRawValue(null);
      fail("should throw");
    } catch (final NullPointerException e) {
      //  pass
    }

    try {
      prop3.setRawValue("Hello");
      fail("should throw");
    } catch (final ClassCastException e) {
      //  pass
    }
  }

  protected void testProperty1GetSize(final Property prop1) {
    prop1.setRawValue("hello");
    try {
      prop1.getSize();
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }
  }

  protected void testProperty2GetSize(final Property prop2) {
    final ArrayList<Object> list2 = new ArrayList<>();
    list2.add(1);
    list2.add(2);
    list2.add(3);
    prop2.setRawValue(list2);
    assertEquals(3, prop2.getSize());
  }

  protected void testProperty3GetSize(final Property prop3) {
    final Map<String, Boolean> map3 = new HashMap<>();
    map3.put("item1", true);
    map3.put("item2", false);
    prop3.setRawValue(map3);
    assertEquals(2, prop3.getSize());
  }

  protected void testProperty1GetSetSimpleValue(final Property prop1) {
    prop1.setSimpleValue("hello");
    assertEquals("hello", prop1.getSimpleValue());
    prop1.setSimpleValue(null);
    assertNull(prop1.getSimpleValue());
    try {
      prop1.setSimpleValue(123);
      fail("should throw");
    } catch (final ClassCastException e) {
      //  pass
    }
  }

  protected void testProperty2GetSetSimpleValue(final Property prop2) {
    try {
      prop2.getSimpleValue();
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }
    try {
      prop2.setSimpleValue(Arrays.asList(1, 2, 3));
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }
  }

  protected void testProperty3GetSetSimpleValue(final Property prop3) {
    final Map<String, Boolean> map = new HashMap<>();
    map.put("item1", true);
    map.put("item2", false);
    try {
      prop3.getSimpleValue();
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }
    try {
      prop3.setSimpleValue(map);
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }
  }

  protected void testProperty1GetSetIndexedValue(final Property prop1) {
    final ArrayList<Object> list1 = new ArrayList<>();
    list1.add("str1");
    list1.add("str2");

    try {
      prop1.setIndexedValue(list1);
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }
    try {
      prop1.setIndexedValue(0, "str1");
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }
    try {
      prop1.getIndexedValue();
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }
    try {
      prop1.getIndexedValue(0);
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }
  }

  protected void testProperty2GetSetIndexedValue(final Property prop2) {
    final ArrayList<Object> list2 = new ArrayList<>();
    list2.add(1);
    list2.add(2);
    list2.add(3);

    prop2.setIndexedValue(list2);
    assertEquals(list2, prop2.getIndexedValue());
    assertNotSame(list2, prop2.getIndexedValue());

    assertEquals(1, prop2.getIndexedValue(0));
    assertEquals(2, prop2.getIndexedValue(1));
    assertEquals(3, prop2.getIndexedValue(2));

    list2.add(true);
    try {
      prop2.setIndexedValue(list2);
      fail("should throw");
    } catch (final ClassCastException e) {
      //  pass
    }

    try {
      prop2.getIndexedValue(-1);
      fail("should throw");
    } catch (final IndexOutOfBoundsException e) {
      //  pass
    }

    try {
      prop2.getIndexedValue(3);
      fail("should throw");
    } catch (final IndexOutOfBoundsException e) {
      //  pass
    }

    prop2.setIndexedValue(0, 4);
    assertEquals(4, prop2.getIndexedValue(0));
    try {
      prop2.setIndexedValue(0, "str");
      fail("should throw");
    } catch (final ClassCastException e) {
      //  pass
    }

  }

  protected void testProperty3GetSetIndexedValue(final Property prop3) {
    try {
      prop3.getIndexedValue();
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }
    try {
      prop3.getIndexedValue(0);
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }
    try {
      final ArrayList<Object> list3 = new ArrayList<>();
      list3.add(true);
      list3.add(false);
      prop3.setIndexedValue(list3);
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }
    try {
      prop3.setIndexedValue(0, true);
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }
  }

  protected void testProperty1AddRemoveIndexedValue(final Property prop1) {
    try {
      prop1.addIndexedValue(0, "str1");
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }
    try {
      prop1.addIndexedValue("str1");
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }
    try {
      prop1.removeIndexedValue(0);
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }
  }

  protected void testProperty2AddRemoveIndexedValue(final Property prop2) {
    final ArrayList<Object> list2 = new ArrayList<>();
    list2.add(1);
    list2.add(2);
    list2.add(3);

    prop2.setIndexedValue(list2);

    prop2.addIndexedValue(0, -1);
    assertEquals(Arrays.asList(-1, 1, 2, 3), prop2.getIndexedValue());
    try {
      prop2.addIndexedValue(0, "str");
      fail("should throw");
    } catch (final ClassCastException e) {
      //  pass
    }

    prop2.addIndexedValue(5);
    assertEquals(Arrays.asList(-1, 1, 2, 3, 5), prop2.getIndexedValue());
    try {
      prop2.addIndexedValue("str");
      fail("should throw");
    } catch (final ClassCastException e) {
      //  pass
    }

    prop2.removeIndexedValue(0);
    assertEquals(Arrays.asList(1, 2, 3, 5), prop2.getIndexedValue());
  }

  protected void testProperty3AddRemoveIndexedValue(final Property prop3) {
    try {
      prop3.addIndexedValue(0, false);
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }
    try {
      prop3.addIndexedValue(true);
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }
    try {
      prop3.removeIndexedValue(0);
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }
  }

  protected void testProperty1GetSetMappedValue(final Property prop1) {
    try {
      prop1.getMappedValue();
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }
    try {
      prop1.getMappedValue("key1");
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }
    try {
      final HashMap<String, Object> map1 = new HashMap<>();
      map1.put("key1", "str1");
      map1.put("key2", "str2");
      prop1.setMappedValue(map1);
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }
    try {
      prop1.setMappedValue("key1", "str1");
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }
  }

  protected void testProperty2GetSetMappedValue(final Property prop2) {
    try {
      prop2.getMappedValue();
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }
    try {
      prop2.getMappedValue("key1");
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }
    try {
      final HashMap<String, Object> map2 = new HashMap<>();
      map2.put("key1", "str1");
      map2.put("key2", "str2");
      prop2.setMappedValue(map2);
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }
    try {
      prop2.setMappedValue("key1", "str1");
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }
  }

  protected void testProperty3GetSetMappedValue(final Property prop3) {
    final HashMap<String, Object> map3 = new HashMap<>();
    map3.put("key1", true);
    map3.put("key2", false);

    prop3.setMappedValue(map3);

    assertEquals(map3, prop3.getMappedValue());
    assertNotSame(map3, prop3.getMappedValue());

    map3.put("key4", "hello");
    try {
      prop3.setMappedValue(map3);
      fail("should throw");
    } catch (final ClassCastException e) {
      //  pass
    }

    assertEquals(true, prop3.getMappedValue("key1"));
    assertEquals(false, prop3.getMappedValue("key2"));
    assertEquals(null, prop3.getMappedValue("key3"));

    prop3.setMappedValue("key1", false);
    assertEquals(false, prop3.getMappedValue("key1"));

    prop3.setMappedValue("key3", true);
    assertEquals(true, prop3.getMappedValue("key3"));
  }

  protected void testProperty1GetKeySet(final Property prop1) {
    try {
      prop1.getKeySet();
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }
  }

  protected void testProperty2GetKeySet(final Property prop2) {
    try {
      prop2.getKeySet();
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }
  }

  protected void testProperty3GetKeySet(final Property prop3) {
    assertEquals(Collections.emptySet(), prop3.getKeySet());

    final HashMap<String, Object> map3 = new HashMap<>();
    map3.put("key1", true);
    map3.put("key2", false);
    prop3.setMappedValue(map3);

    assertEquals(map3.keySet(), prop3.getKeySet());
  }

  protected void testProperty1ContainsKey(final Property prop1) {
    try {
      prop1.containsKey("key1");
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }
  }

  protected void testProperty2ContainsKey(final Property prop2) {
    try {
      prop2.containsKey("key1");
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }
  }

  protected void testProperty3ContainsKey(final Property prop3) {
    assertEquals(false, prop3.containsKey("key1"));
    assertEquals(false, prop3.containsKey("key2"));
    assertEquals(false, prop3.containsKey("key3"));

    final HashMap<String, Object> map3 = new HashMap<>();
    map3.put("key1", true);
    map3.put("key2", false);
    prop3.setMappedValue(map3);

    assertEquals(true, prop3.containsKey("key1"));
    assertEquals(true, prop3.containsKey("key2"));
    assertEquals(false, prop3.containsKey("key3"));
  }

  protected void testProperty1RemoveMappedValue(final Property prop1) {
    try {
      prop1.removeMappedValue("key1");
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }
  }

  protected void testProperty2RemoveMappedValue(final Property prop2) {
    try {
      prop2.removeMappedValue("key1");
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }
  }

  protected void testProperty3RemoveMappedValue(final Property prop3) {
    prop3.removeMappedValue("key3");
    assertEquals(null, prop3.getMappedValue("key3"));

    final HashMap<String, Object> map3 = new HashMap<>();
    map3.put("key1", true);
    map3.put("key2", false);
    map3.put("key3", false);
    prop3.setMappedValue(map3);

    prop3.removeMappedValue("key3");
    assertEquals(null, prop3.getMappedValue("key3"));
  }

  protected void testProperty1Clear(final Property prop1) {
    prop1.setRawValue("hello");
    try {
      prop1.clear();
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }
  }

  protected void testProperty2Clear(final Property prop2) {
    final ArrayList<Object> list2 = new ArrayList<>();
    list2.add(1);
    list2.add(2);
    list2.add(3);
    prop2.setRawValue(list2);
    assertEquals(3, prop2.getSize());
    prop2.clear();
    assertEquals(0, prop2.getSize());
  }

  protected void testProperty3Clear(final Property prop3) {
    final Map<String, Boolean> map3 = new HashMap<>();
    map3.put("item1", true);
    map3.put("item2", false);
    prop3.setRawValue(map3);
    assertEquals(2, prop3.getSize());
    prop3.clear();
    assertEquals(0, prop3.getSize());
  }
}
