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

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Base class for the unit tests of implementations of {@link Bean}.
 *
 * @author Haixing Hu
 */
public abstract class BeanTestBase extends BeanClassTestBase {

  protected abstract Property newProperty(PropertyDescriptor descriptor);

  protected void testBeanConstructor(final BeanClass cls, final Bean bean) {
    assertEquals(cls, bean.getBeanClass());
  }

  protected void testBeanGetProperty(final BeanClass cls, final Bean bean) {
    assertEquals(newProperty(cls.getPropertyDescriptor("prop1")),
        bean.getProperty("prop1"));
    assertEquals(newProperty(cls.getPropertyDescriptor("_prop2")),
        bean.getProperty("_prop2"));
    assertEquals(newProperty(cls.getPropertyDescriptor("prop-3")),
        bean.getProperty("prop-3"));
    assertEquals(newProperty(cls.getPropertyDescriptor("prop_4")),
        bean.getProperty("prop_4"));
    assertEquals(newProperty(cls.getPropertyDescriptor("prop5")),
        bean.getProperty("prop5"));
    assertEquals(newProperty(cls.getPropertyDescriptor("prop6")),
        bean.getProperty("prop6"));

    try {
      bean.getProperty(null);
      fail("should throw");
    } catch (final NullPointerException e) {
      // pass
    }
  }

  private void testSimplePropertyOperationsProperty1(final BeanClass cls,
      final Bean bean) {
    if (cls.hasProperty("prop1")) {
      assertEquals(null, bean.get("prop1"));
      bean.set("prop1", "str1");
      assertEquals("str1", bean.get("prop1"));
      bean.set("prop1", null);
      assertEquals(null, bean.get("prop1"));
      try {
        bean.set("prop1", 123);
        fail("should throw");
      } catch (final ClassCastException e) {
        // pass
      }
    } else {
      try {
        bean.get("prop1");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.set("prop1", "str");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
    }
  }

  private void testSimplePropertyOperationsProperty2(final BeanClass cls,
      final Bean bean) {
    if (cls.hasProperty("_prop2")) {
      try {
        bean.get("_prop2");
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      try {
        bean.set("_prop2", 123);
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
    } else {
      try {
        bean.get("_prop2");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.set("_prop2", 123);
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
    }
  }

  private void testSimplePropertyOperationsProperty3(final BeanClass cls,
      final Bean bean) {
    if (cls.hasProperty("prop-3")) {
      try {
        bean.get("prop-3");
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      try {
        bean.set("prop-3", true);
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
    } else {
      try {
        bean.get("prop-3");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.set("prop-3", true);
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
    }
  }

  private void testSimplePropertyOperationsProperty4(final BeanClass cls,
      final Bean bean) {
    if (cls.hasProperty("prop_4")) {
      assertEquals(null, bean.get("prop_4"));
      bean.set("prop_4", new MyBean(cls));
      assertEquals(new MyBean(cls), bean.get("prop_4"));
      bean.set("prop_4", null);
      assertEquals(null, bean.get("prop_4"));
      try {
        bean.set("prop_4", 123);
        fail("should throw");
      } catch (final ClassCastException e) {
        // pass
      }
    } else {
      try {
        bean.get("prop_4");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.set("prop_4", new MyBean(cls));
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
    }
  }

  private void testSimplePropertyOperationsProperty5(final BeanClass cls,
      final Bean bean) {
    if (cls.hasProperty("prop5")) {
      try {
        bean.get("prop5");
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      try {
        bean.set("prop5", 3.14f);
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
    } else {
      try {
        bean.get("prop5");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.set("prop5", 3.14f);
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
    }
  }

  private void testSimplePropertyOperationsProperty6(final BeanClass cls,
      final Bean bean) {
    if (cls.hasProperty("prop6")) {
      try {
        bean.get("prop6");
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      try {
        bean.set("prop6", new DefaultProperty(getPropertyDescriptor1()));
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
    } else {
      try {
        bean.get("prop6");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.set("prop6", new DefaultProperty(getPropertyDescriptor1()));
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
    }
  }

  private void testSimplePropertyOperationsNull(final BeanClass cls,
      final Bean bean) {
    try {
      bean.set(null, 123);
      fail("should throw");
    } catch (final NullPointerException e) {
      // pass
    }
    try {
      bean.get(null);
      fail("should throw");
    } catch (final NullPointerException e) {
      // pass
    }
  }

  protected void testSimplePropertyOperations(final BeanClass cls,
      final Bean bean) {
    testSimplePropertyOperationsProperty1(cls, bean);
    testSimplePropertyOperationsProperty2(cls, bean);
    testSimplePropertyOperationsProperty3(cls, bean);
    testSimplePropertyOperationsProperty4(cls, bean);
    testSimplePropertyOperationsProperty5(cls, bean);
    testSimplePropertyOperationsProperty6(cls, bean);
    testSimplePropertyOperationsNull(cls, bean);
  }

  private void testIndexedPropertyOperationsProperty1(final BeanClass cls,
      final Bean bean) {
    if (cls.hasProperty("prop1")) {
      try {
        bean.add("prop1", "str1");
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      try {
        bean.add("prop1", 0, "str1");
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      try {
        bean.get("prop1", 0);
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      try {
        bean.set("prop1", 0, "str1");
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      try {
        bean.remove("prop1", 0);
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      try {
        bean.getSize("prop1");
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      try {
        bean.clear("prop1");
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
    } else {
      try {
        bean.add("prop1", "str1");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.add("prop1", 0, "str1");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.get("prop1", 0);
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.set("prop1", 0, "str1");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.remove("prop1", 0);
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.getSize("prop1");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.clear("prop1");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
    }
  }

  private void testIndexedPropertyOperationsProperty2(final BeanClass cls,
      final Bean bean) {
    if (cls.hasProperty("_prop2")) {
      assertEquals(0, bean.getSize("_prop2"));
      bean.add("_prop2", 314);
      assertEquals(314, bean.get("_prop2", 0));
      assertEquals(1, bean.getSize("_prop2"));
      bean.add("_prop2", 0, 618);
      assertEquals(618, bean.get("_prop2", 0));
      assertEquals(314, bean.get("_prop2", 1));
      assertEquals(2, bean.getSize("_prop2"));
      bean.set("_prop2", 1, 111);
      assertEquals(111, bean.get("_prop2", 1));
      assertEquals(2, bean.getSize("_prop2"));
      bean.remove("_prop2", 0);
      assertEquals(111, bean.get("_prop2", 0));
      assertEquals(1, bean.getSize("_prop2"));
      bean.add("_prop2", null);
      assertEquals(null, bean.get("_prop2", 1));
      assertEquals(2, bean.getSize("_prop2"));
      bean.add("_prop2", 0, null);
      assertEquals(null, bean.get("_prop2", 0));
      assertEquals(111, bean.get("_prop2", 1));
      assertEquals(null, bean.get("_prop2", 2));
      assertEquals(3, bean.getSize("_prop2"));
      bean.set("_prop2", 1, null);
      assertEquals(null, bean.get("_prop2", 1));
      assertEquals(3, bean.getSize("_prop2"));

      try {
        bean.get("_prop2", -1);
        fail("should throw");
      } catch (final IndexOutOfBoundsException e) {
        // pass
      }
      try {
        bean.set("_prop2", -1, 314);
        fail("should throw");
      } catch (final IndexOutOfBoundsException e) {
        // pass
      }
      try {
        bean.add("_prop2", -1, 314);
        fail("should throw");
      } catch (final IndexOutOfBoundsException e) {
        // pass
      }
      try {
        bean.remove("_prop2", -1);
        fail("should throw");
      } catch (final IndexOutOfBoundsException e) {
        // pass
      }
      try {
        bean.set("_prop2", 0, true);
        fail("should throw");
      } catch (final ClassCastException e) {
        // pass
      }
      try {
        bean.add("_prop2", 0, true);
        fail("should throw");
      } catch (final ClassCastException e) {
        // pass
      }
      try {
        bean.add("_prop2", true);
        fail("should throw");
      } catch (final ClassCastException e) {
        // pass
      }
      bean.clear("_prop2");
      assertEquals(0, bean.getSize("_prop2"));
    } else {
      try {
        bean.add("_prop2", 123);
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.add("_prop2", 0, 123);
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.get("_prop2", 0);
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.set("_prop2", 0, 123);
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.remove("_prop2", 0);
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.getSize("_prop2");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.clear("_prop2");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
    }
  }

  private void testIndexedPropertyOperationsProperty3(final BeanClass cls,
      final Bean bean) {
    final Boolean value = true;
    if (cls.hasProperty("prop-3")) {
      try {
        bean.add("prop-3", value);
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      try {
        bean.add("prop-3", 0, value);
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      try {
        bean.get("prop-3", 0);
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      try {
        bean.set("prop-3", 0, value);
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      try {
        bean.remove("prop-3", 0);
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      assertEquals(0, bean.getSize("prop-3"));
      bean.clear("prop-3");
      assertEquals(0, bean.getSize("prop-3"));
    } else {
      try {
        bean.add("prop-3", value);
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.add("prop-3", 0, value);
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.get("prop-3", 0);
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.set("prop-3", 0, value);
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.remove("prop-3", 0);
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.getSize("prop-3");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.clear("prop-3");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
    }
  }

  private void testIndexedPropertyOperationsProperty4(final BeanClass cls,
      final Bean bean) {
    final MyBean value = new MyBean(cls);
    if (cls.hasProperty("prop_4")) {
      try {
        bean.add("prop_4", value);
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      try {
        bean.add("prop_4", 0, value);
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      try {
        bean.get("prop_4", 0);
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      try {
        bean.set("prop_4", 0, value);
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      try {
        bean.remove("prop_4", 0);
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      try {
        bean.getSize("prop_4");
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      try {
        bean.clear("prop_4");
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
    } else {
      try {
        bean.add("prop_4", value);
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.add("prop_4", 0, value);
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.get("prop_4", 0);
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.set("prop_4", 0, value);
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.remove("prop_4", 0);
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.getSize("prop_4");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.clear("prop_4");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
    }
  }

  private void testIndexedPropertyOperationsProperty5(final BeanClass cls,
      final Bean bean) {
    if (cls.hasProperty("prop5")) {
      assertEquals(0, bean.getSize("prop5"));
      bean.add("prop5", 3.14f);
      assertEquals(3.14f, bean.get("prop5", 0));
      assertEquals(1, bean.getSize("prop5"));
      bean.add("prop5", 0, 0.618f);
      assertEquals(0.618f, bean.get("prop5", 0));
      assertEquals(3.14f, bean.get("prop5", 1));
      assertEquals(2, bean.getSize("prop5"));
      bean.set("prop5", 1, 1.11f);
      assertEquals(1.11f, bean.get("prop5", 1));
      assertEquals(2, bean.getSize("prop5"));
      bean.remove("prop5", 0);
      assertEquals(1.11f, bean.get("prop5", 0));
      assertEquals(1, bean.getSize("prop5"));
      bean.add("prop5", null);
      assertEquals(1.11f, bean.get("prop5", 0));
      assertEquals(null, bean.get("prop5", 1));
      assertEquals(2, bean.getSize("prop5"));
      bean.add("prop5", 0, null);
      assertEquals(null, bean.get("prop5", 0));
      assertEquals(1.11f, bean.get("prop5", 1));
      assertEquals(null, bean.get("prop5", 2));
      assertEquals(3, bean.getSize("prop5"));
      bean.set("prop5", 1, null);
      assertEquals(null, bean.get("prop5", 0));
      assertEquals(null, bean.get("prop5", 1));
      assertEquals(null, bean.get("prop5", 2));
      assertEquals(3, bean.getSize("prop5"));
      try {
        bean.get("prop5", -1);
        fail("should throw");
      } catch (final IndexOutOfBoundsException e) {
        // pass
      }
      try {
        bean.set("prop5", -1, 3.14f);
        fail("should throw");
      } catch (final IndexOutOfBoundsException e) {
        // pass
      }
      try {
        bean.add("prop5", -1, 3.14f);
        fail("should throw");
      } catch (final IndexOutOfBoundsException e) {
        // pass
      }
      try {
        bean.remove("prop5", -1);
        fail("should throw");
      } catch (final IndexOutOfBoundsException e) {
        // pass
      }
      try {
        bean.set("prop5", 0, true);
        fail("should throw");
      } catch (final ClassCastException e) {
        // pass
      }
      try {
        bean.add("prop5", 0, true);
        fail("should throw");
      } catch (final ClassCastException e) {
        // pass
      }
      try {
        bean.add("prop5", true);
        fail("should throw");
      } catch (final ClassCastException e) {
        // pass
      }
      bean.clear("prop5");
      assertEquals(0, bean.getSize("prop5"));
    } else {
      try {
        bean.add("prop5", 3.14f);
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.add("prop5", 0, 3.14f);
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.get("prop5", 0);
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.set("prop5", 0, 3.14f);
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.remove("prop5", 0);
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.getSize("prop5");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.clear("prop5");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
    }
  }

  private void testIndexedPropertyOperationsProperty6(final BeanClass cls,
      final Bean bean) {
    final DefaultProperty value = new DefaultProperty(getPropertyDescriptor1());
    if (cls.hasProperty("prop6")) {
      try {
        bean.add("prop6", value);
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      try {
        bean.add("prop6", 0, value);
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      try {
        bean.get("prop6", 0);
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      try {
        bean.set("prop6", 0, value);
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      try {
        bean.remove("prop6", 0);
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      assertEquals(0, bean.getSize("prop6"));
      bean.clear("prop6");
      assertEquals(0, bean.getSize("prop6"));
    } else {
      try {
        bean.add("prop6", value);
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.add("prop6", 0, value);
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.get("prop6", 0);
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.set("prop6", 0, value);
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.remove("prop6", 0);
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.getSize("prop6");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.clear("prop6");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
    }
  }

  private void testIndexedPropertyOperationsNull(final BeanClass cls,
      final Bean bean) {
    try {
      bean.add(null, 123);
      fail("should throw");
    } catch (final NullPointerException e) {
      // pass
    }
    try {
      bean.add(null, 0, 123);
      fail("should throw");
    } catch (final NullPointerException e) {
      // pass
    }
    try {
      bean.get(null, 0);
      fail("should throw");
    } catch (final NullPointerException e) {
      // pass
    }
    try {
      bean.set(null, 0, 123);
      fail("should throw");
    } catch (final NullPointerException e) {
      // pass
    }
    try {
      bean.remove(null, 0);
      fail("should throw");
    } catch (final NullPointerException e) {
      // pass
    }
    try {
      bean.getSize(null);
      fail("should throw");
    } catch (final NullPointerException e) {
      // pass
    }
    try {
      bean.clear(null);
      fail("should throw");
    } catch (final NullPointerException e) {
      // pass
    }
  }

  protected void testIndexedPropertyOperations(final BeanClass cls,
      final Bean bean) {
    testIndexedPropertyOperationsProperty1(cls, bean);
    testIndexedPropertyOperationsProperty2(cls, bean);
    testIndexedPropertyOperationsProperty3(cls, bean);
    testIndexedPropertyOperationsProperty4(cls, bean);
    testIndexedPropertyOperationsProperty5(cls, bean);
    testIndexedPropertyOperationsProperty6(cls, bean);
    testIndexedPropertyOperationsNull(cls, bean);
  }

  private void testMappedPropertyOperationsProperty1(final BeanClass cls,
      final Bean bean) {
    if (cls.hasProperty("prop1")) {
      try {
        bean.set("prop1", "key1", true);
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      try {
        bean.get("prop1", "key1");
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      try {
        bean.getKeySet("prop1");
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      try {
        bean.containsKey("prop1", "key1");
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      try {
        bean.getSize("prop1");
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      try {
        bean.clear("prop1");
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
    } else {
      try {
        bean.set("prop1", "key1", true);
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.get("prop1", "key1");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.getKeySet("prop1");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.containsKey("prop1", "key1");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.getSize("prop1");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.clear("prop1");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
    }
  }

  private void testMappedPropertyOperationsProperty2(final BeanClass cls,
      final Bean bean) {
    if (cls.hasProperty("_prop2")) {
      try {
        bean.set("_prop2", "key1", true);
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      try {
        bean.get("_prop2", "key1");
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      try {
        bean.getKeySet("_prop2");
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      try {
        bean.containsKey("_prop2", "key1");
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      assertEquals(0, bean.getSize("_prop2"));
      bean.clear("_prop2");
      assertEquals(0, bean.getSize("_prop2"));
    } else {
      try {
        bean.set("_prop2", "key1", true);
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.get("_prop2", "key1");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.getKeySet("_prop2");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.containsKey("_prop2", "key1");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.getSize("_prop2");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.clear("_prop2");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
    }
  }

  private void testMappedPropertyOperationsProperty3(final BeanClass cls,
      final Bean bean) {
    if (cls.hasProperty("prop-3")) {
      assertEquals(0, bean.getSize("prop-3"));
      assertEquals(Collections.emptySet(), bean.getKeySet("prop-3"));
      assertEquals(null, bean.get("prop-3", "key1"));

      bean.set("prop-3", "key1", true);
      assertEquals(true, bean.get("prop-3", "key1"));
      assertEquals(1, bean.getSize("prop-3"));
      final Set<String> keySet = new HashSet<>();
      keySet.add("key1");
      assertEquals(keySet, bean.getKeySet("prop-3"));
      assertEquals(true, bean.containsKey("prop-3", "key1"));
      assertEquals(false, bean.containsKey("prop-3", "key2"));

      bean.set("prop-3", "key2", false);
      assertEquals(true, bean.get("prop-3", "key1"));
      assertEquals(false, bean.get("prop-3", "key2"));
      assertEquals(2, bean.getSize("prop-3"));
      keySet.add("key2");
      assertEquals(keySet, bean.getKeySet("prop-3"));
      assertEquals(true, bean.containsKey("prop-3", "key1"));
      assertEquals(true, bean.containsKey("prop-3", "key2"));

      bean.remove("prop-3", "key1");
      assertEquals(null, bean.get("prop-3", "key1"));
      assertEquals(1, bean.getSize("prop-3"));
      keySet.remove("key1");
      assertEquals(keySet, bean.getKeySet("prop-3"));
      assertEquals(false, bean.containsKey("prop-3", "key1"));
      assertEquals(true, bean.containsKey("prop-3", "key2"));

      bean.set("prop-3", "key1", null);
      assertEquals(null, bean.get("prop-3", "key1"));
      assertEquals(2, bean.getSize("prop-3"));
      keySet.add("key1");
      assertEquals(keySet, bean.getKeySet("prop-3"));
      assertEquals(true, bean.containsKey("prop-3", "key1"));
      assertEquals(true, bean.containsKey("prop-3", "key2"));

      try {
        bean.set("prop-3", null, true);
        fail("should throw");
      } catch (final NullPointerException e) {
        // pass
      }
      try {
        bean.set(null, "key1", true);
        fail("should throw");
      } catch (final NullPointerException e) {
        // pass
      }
      try {
        bean.set("prop-3", "key1", 123);
        fail("should throw");
      } catch (final ClassCastException e) {
        // pass
      }
      assertEquals(2, bean.getSize("prop-3"));
      bean.clear("prop-3");
      assertEquals(0, bean.getSize("prop-3"));
    } else {
      try {
        bean.set("prop-3", "key1", true);
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.get("prop-3", "key1");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.getKeySet("prop-3");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.containsKey("prop-3", "key1");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.getSize("prop-3");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.clear("prop-3");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
    }
  }

  private void testMappedPropertyOperationsProperty4(final BeanClass cls,
      final Bean bean) {
    if (cls.hasProperty("prop_4")) {
      try {
        bean.set("prop_4", "key1", true);
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      try {
        bean.get("prop_4", "key1");
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      try {
        bean.getKeySet("prop_4");
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      try {
        bean.containsKey("prop_4", "key1");
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      try {
        bean.getSize("prop_4");
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      try {
        bean.clear("prop_4");
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
    } else {
      try {
        bean.set("prop_4", "key1", true);
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.get("prop_4", "key1");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.getKeySet("prop_4");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.containsKey("prop_4", "key1");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.getSize("prop_4");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.clear("prop_4");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
    }
  }

  private void testMappedPropertyOperationsProperty5(final BeanClass cls,
      final Bean bean) {
    if (cls.hasProperty("prop5")) {
      try {
        bean.set("prop5", "key1", true);
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      try {
        bean.get("prop5", "key1");
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      try {
        bean.getKeySet("prop5");
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      try {
        bean.containsKey("prop5", "key1");
        fail("should throw");
      } catch (final InvalidPropertyKindException e) {
        // pass
      }
      assertEquals(0, bean.getSize("prop5"));
      bean.clear("prop5");
      assertEquals(0, bean.getSize("prop5"));
    } else {
      try {
        bean.set("prop5", "key1", true);
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.get("prop5", "key1");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.getKeySet("prop5");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.containsKey("prop5", "key1");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.getSize("prop5");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.clear("prop5");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
    }
  }

  private void testMappedPropertyOperationsProperty6(final BeanClass cls,
      final Bean bean) {
    if (cls.hasProperty("prop6")) {
      assertEquals(0, bean.getSize("prop6"));
      assertEquals(Collections.emptySet(), bean.getKeySet("prop6"));
      assertEquals(null, bean.get("prop6", "key1"));
      final DefaultProperty prop1 = new DefaultProperty(getPropertyDescriptor1());
      bean.set("prop6", "key1", prop1);
      assertEquals(prop1, bean.get("prop6", "key1"));
      assertEquals(1, bean.getSize("prop6"));
      final Set<String> keySet = new HashSet<>();
      keySet.add("key1");
      assertEquals(keySet, bean.getKeySet("prop6"));
      assertEquals(true, bean.containsKey("prop6", "key1"));
      assertEquals(false, bean.containsKey("prop6", "key2"));

      final DefaultProperty prop2 = new DefaultProperty(getPropertyDescriptor2());
      bean.set("prop6", "key2", prop2);
      assertEquals(prop1, bean.get("prop6", "key1"));
      assertEquals(prop2, bean.get("prop6", "key2"));
      assertEquals(2, bean.getSize("prop6"));
      keySet.add("key2");
      assertEquals(keySet, bean.getKeySet("prop6"));
      assertEquals(true, bean.containsKey("prop6", "key1"));
      assertEquals(true, bean.containsKey("prop6", "key2"));

      bean.remove("prop6", "key1");
      assertEquals(null, bean.get("prop6", "key1"));
      assertEquals(prop2, bean.get("prop6", "key2"));
      assertEquals(1, bean.getSize("prop6"));
      keySet.remove("key1");
      assertEquals(keySet, bean.getKeySet("prop6"));
      assertEquals(false, bean.containsKey("prop6", "key1"));
      assertEquals(true, bean.containsKey("prop6", "key2"));

      bean.set("prop6", "key1", null);
      assertEquals(null, bean.get("prop6", "key1"));
      assertEquals(2, bean.getSize("prop6"));
      keySet.add("key1");
      assertEquals(keySet, bean.getKeySet("prop6"));
      assertEquals(true, bean.containsKey("prop6", "key1"));
      assertEquals(true, bean.containsKey("prop6", "key2"));

      try {
        bean.set("prop6", null, true);
        fail("should throw");
      } catch (final NullPointerException e) {
        // pass
      }
      try {
        bean.set(null, "key1", true);
        fail("should throw");
      } catch (final NullPointerException e) {
        // pass
      }
      try {
        bean.set("prop6", "key1", 123);
        fail("should throw");
      } catch (final ClassCastException e) {
        // pass
      }

      assertEquals(2, bean.getSize("prop6"));
      bean.clear("prop6");
      assertEquals(0, bean.getSize("prop6"));
    } else {
      try {
        bean.set("prop6", "key1",
            new DefaultProperty(getPropertyDescriptor1()));
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.get("prop6", "key1");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.getKeySet("prop6");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.containsKey("prop6", "key1");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.getSize("prop6");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
      try {
        bean.clear("prop6");
        fail("should throw");
      } catch (final PropertyNotExistException e) {
        // pass
      }
    }
  }

  private void testMappedPropertyOperationsNull(final BeanClass cls,
      final Bean bean) {
    try {
      bean.get("prop", null);
      fail("should throw");
    } catch (final NullPointerException e) {
      // pass
    }
    try {
      bean.get(null, "key1");
      fail("should throw");
    } catch (final NullPointerException e) {
      // pass
    }
    try {
      bean.set(null, "key1", "str1");
      fail("should throw");
    } catch (final NullPointerException e) {
      // pass
    }
    try {
      bean.set("prop1", null, "str1");
      fail("should throw");
    } catch (final NullPointerException e) {
      // pass
    }
    try {
      bean.remove(null, "key1");
      fail("should throw");
    } catch (final NullPointerException e) {
      // pass
    }
    try {
      bean.remove("prop1", null);
      fail("should throw");
    } catch (final NullPointerException e) {
      // pass
    }
    try {
      bean.containsKey("prop-3", null);
      fail("should throw");
    } catch (final NullPointerException e) {
      // pass
    }
    try {
      bean.containsKey(null, "key1");
      fail("should throw");
    } catch (final NullPointerException e) {
      // pass
    }
    try {
      bean.getSize(null);
      fail("should throw");
    } catch (final NullPointerException e) {
      // pass
    }
    try {
      bean.getKeySet(null);
      fail("should throw");
    } catch (final NullPointerException e) {
      // pass
    }
    try {
      bean.clear(null);
      fail("should throw");
    } catch (final NullPointerException e) {
      // pass
    }
    try {
      bean.remove("xxx", "key1");
      fail("should throw");
    } catch (final PropertyNotExistException e) {
      // pass
    }
  }

  protected void testMappedPropertyOperations(final BeanClass cls,
      final Bean bean) {
    testMappedPropertyOperationsProperty1(cls, bean);
    testMappedPropertyOperationsProperty2(cls, bean);
    testMappedPropertyOperationsProperty3(cls, bean);
    testMappedPropertyOperationsProperty4(cls, bean);
    testMappedPropertyOperationsProperty5(cls, bean);
    testMappedPropertyOperationsProperty6(cls, bean);
    testMappedPropertyOperationsNull(cls, bean);
  }
}
