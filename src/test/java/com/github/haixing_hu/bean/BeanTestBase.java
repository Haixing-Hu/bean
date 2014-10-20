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
  }

  protected void testBean0GetSetSimple(final BeanClass cls0, final Bean bean0) {
    try {
      bean0.get("prop1");
      fail("should throw");
    } catch (final PropertyNotExistException e) {
      //  pass
    }
    try {
      bean0.set("prop1", "str1");
      fail("should throw");
    } catch (final PropertyNotExistException e) {
      //  pass
    }

    try {
      bean0.get("_prop2");
      fail("should throw");
    } catch (final PropertyNotExistException e) {
      //  pass
    }
    try {
      bean0.set("_prop2", 123);
      fail("should throw");
    } catch (final PropertyNotExistException e) {
      //  pass
    }

    try {
      bean0.get("prop-3");
      fail("should throw");
    } catch (final PropertyNotExistException e) {
      //  pass
    }
    try {
      bean0.set("prop-3", true);
      fail("should throw");
    } catch (final PropertyNotExistException e) {
      //  pass
    }

    try {
      bean0.get("prop_4");
      fail("should throw");
    } catch (final PropertyNotExistException e) {
      //  pass
    }
    try {
      bean0.set("prop_4", new MyBean(cls0));
      fail("should throw");
    } catch (final PropertyNotExistException e) {
      //  pass
    }

    try {
      bean0.get("prop5");
      fail("should throw");
    } catch (final PropertyNotExistException e) {
      //  pass
    }
    try {
      bean0.set("prop5", 3.14f);
      fail("should throw");
    } catch (final PropertyNotExistException e) {
      //  pass
    }

    try {
      bean0.get("prop6");
      fail("should throw");
    } catch (final PropertyNotExistException e) {
      //  pass
    }
    try {
      bean0.set("prop6", new DefaultProperty(getPropertyDescriptor1()));
      fail("should throw");
    } catch (final PropertyNotExistException e) {
      //  pass
    }
  }

  protected void testBean1GetSetSimple(final BeanClass cls1, final Bean bean1) {
    try {
      bean1.get("prop1");
      fail("should throw");
    } catch (final PropertyNotExistException e) {
      //  pass
    }
    try {
      bean1.set("prop1", "str1");
      fail("should throw");
    } catch (final PropertyNotExistException e) {
      //  pass
    }

    try {
      bean1.get("_prop2");
      fail("should throw");
    } catch (final PropertyNotExistException e) {
      //  pass
    }
    try {
      bean1.set("_prop2", 123);
      fail("should throw");
    } catch (final PropertyNotExistException e) {
      //  pass
    }

    try {
      bean1.get("prop-3");
      fail("should throw");
    } catch (final PropertyNotExistException e) {
      //  pass
    }
    try {
      bean1.set("prop-3", true);
      fail("should throw");
    } catch (final PropertyNotExistException e) {
      //  pass
    }

    try {
      bean1.get("prop_4");
      fail("should throw");
    } catch (final PropertyNotExistException e) {
      //  pass
    }
    try {
      bean1.set("prop_4", new MyBean(cls1));
      fail("should throw");
    } catch (final PropertyNotExistException e) {
      //  pass
    }

    try {
      bean1.get("prop5");
      fail("should throw");
    } catch (final PropertyNotExistException e) {
      //  pass
    }
    try {
      bean1.set("prop5", 3.14f);
      fail("should throw");
    } catch (final PropertyNotExistException e) {
      //  pass
    }

    try {
      bean1.get("prop6");
      fail("should throw");
    } catch (final PropertyNotExistException e) {
      //  pass
    }
    try {
      bean1.set("prop6", new DefaultProperty(getPropertyDescriptor1()));
      fail("should throw");
    } catch (final PropertyNotExistException e) {
      //  pass
    }
  }

  protected void testBean2GetSetSimple(final BeanClass cls2, final Bean bean2) {
    assertEquals(null, bean2.get("prop1"));
    bean2.set("prop1", "str1");
    assertEquals("str1", bean2.get("prop1"));
    try {
      bean2.set("prop1", 1234);
      fail("should throw");
    } catch (final ClassCastException e) {
      //  pass
    }

    try {
      bean2.get("_prop2");
      fail("should throw");
    } catch (final PropertyNotExistException e) {
      //  pass
    }
    try {
      bean2.set("_prop2", 123);
      fail("should throw");
    } catch (final PropertyNotExistException e) {
      //  pass
    }

    try {
      bean2.get("prop-3");
      fail("should throw");
    } catch (final PropertyNotExistException e) {
      //  pass
    }
    try {
      bean2.set("prop-3", true);
      fail("should throw");
    } catch (final PropertyNotExistException e) {
      //  pass
    }

    try {
      bean2.get("prop_4");
      fail("should throw");
    } catch (final PropertyNotExistException e) {
      //  pass
    }
    try {
      bean2.set("prop_4", new MyBean(cls2));
      fail("should throw");
    } catch (final PropertyNotExistException e) {
      //  pass
    }

    try {
      bean2.get("prop5");
      fail("should throw");
    } catch (final PropertyNotExistException e) {
      //  pass
    }
    try {
      bean2.set("prop5", 3.14f);
      fail("should throw");
    } catch (final PropertyNotExistException e) {
      //  pass
    }

    try {
      bean2.get("prop6");
      fail("should throw");
    } catch (final PropertyNotExistException e) {
      //  pass
    }
    try {
      bean2.set("prop6", new DefaultProperty(getPropertyDescriptor1()));
      fail("should throw");
    } catch (final PropertyNotExistException e) {
      //  pass
    }
  }


  protected void testBean3GetSetSimple(final BeanClass cls3, final Bean bean3) {
    assertEquals(null, bean3.get("prop1"));
    bean3.set("prop1", "str1");
    assertEquals("str1", bean3.get("prop1"));
    try {
      bean3.set("prop1", 1234);
      fail("should throw");
    } catch (final ClassCastException e) {
      //  pass
    }

    try {
      bean3.get("_prop2");
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }
    try {
      bean3.set("_prop2", 123);
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }

    try {
      bean3.get("prop-3");
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }
    try {
      bean3.set("prop-3", true);
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }

    try {
      bean3.get("prop_4");
      fail("should throw");
    } catch (final PropertyNotExistException e) {
      //  pass
    }
    try {
      bean3.set("prop_4", new MyBean(cls3));
      fail("should throw");
    } catch (final PropertyNotExistException e) {
      //  pass
    }

    try {
      bean3.get("prop5");
      fail("should throw");
    } catch (final PropertyNotExistException e) {
      //  pass
    }
    try {
      bean3.set("prop5", 3.14f);
      fail("should throw");
    } catch (final PropertyNotExistException e) {
      //  pass
    }

    try {
      bean3.get("prop6");
      fail("should throw");
    } catch (final PropertyNotExistException e) {
      //  pass
    }
    try {
      bean3.set("prop6", new DefaultProperty(getPropertyDescriptor1()));
      fail("should throw");
    } catch (final PropertyNotExistException e) {
      //  pass
    }
  }


  protected void testBean4GetSetSimple(final BeanClass cls4, final Bean bean4) {
    assertEquals(null, bean4.get("prop1"));
    bean4.set("prop1", "str1");
    assertEquals("str1", bean4.get("prop1"));
    try {
      bean4.set("prop1", 1234);
      fail("should throw");
    } catch (final ClassCastException e) {
      //  pass
    }

    try {
      bean4.get("_prop2");
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }
    try {
      bean4.set("_prop2", 123);
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }

    try {
      bean4.get("prop-3");
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }
    try {
      bean4.set("prop-3", true);
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }

    assertEquals(null, bean4.get("prop_4"));
    bean4.set("prop_4", new MyBean(cls4));
    assertEquals(new MyBean(cls4), bean4.get("prop_4"));
    try {
      bean4.set("prop_4", "str");
      fail("should throw");
    } catch (final ClassCastException e) {
      //  pass
    }

    try {
      bean4.get("prop5");
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }
    try {
      bean4.set("prop5", 3.14f);
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }

    try {
      bean4.get("prop6");
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }
    try {
      bean4.set("prop6", new DefaultProperty(getPropertyDescriptor1()));
      fail("should throw");
    } catch (final InvalidPropertyKindException e) {
      //  pass
    }
  }
}
