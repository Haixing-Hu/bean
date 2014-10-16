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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

/**
 * Unit test of the {@link BasicBeanClass}.
 *
 * @author Haixing Hu
 */
public class BasicBeanClassTest extends XmlSerializationTest {

  @Test
  public void testConstructorStringPropertyDescriptorArray() {
    final BasicBeanClass cls1 = new BasicBeanClass("bean1",
        new PropertyDescriptor[0]);
    assertEquals("bean1", cls1.getName());
    assertArrayEquals(new PropertyDescriptor[0], cls1.getPropertyDescriptors());
    assertEquals(BasicBean.class, cls1.getBeanType());
    assertEquals(false, cls1.hasProperty("prop1"));

    final BasicBeanClass cls2 = new BasicBeanClass("bean2",
        new PropertyDescriptor[]{
          new PropertyDescriptor("prop1", String.class),
        }
    );
    assertEquals("bean2", cls2.getName());
    assertArrayEquals(new PropertyDescriptor[]{
          new PropertyDescriptor("prop1", String.class),
    },  cls2.getPropertyDescriptors());
    assertEquals(BasicBean.class, cls2.getBeanType());
    assertEquals(true, cls2.hasProperty("prop1"));
    assertEquals(false, cls2.hasProperty("prop2"));
    assertEquals(new PropertyDescriptor("prop1", String.class),
        cls2.getPropertyDescriptor("prop1"));

    final BasicBeanClass cls3 = new BasicBeanClass("bean3",
        new PropertyDescriptor[]{
          new PropertyDescriptor("prop1", String.class),
          new PropertyDescriptor("prop2", Integer.class, PropertyKind.INDEXED),
          new PropertyDescriptor("prop3", MyBean.class, PropertyKind.MAPPED),
        }
    );
    assertEquals("bean3", cls3.getName());
    assertArrayEquals(new PropertyDescriptor[]{
          new PropertyDescriptor("prop1", String.class),
          new PropertyDescriptor("prop2", Integer.class, PropertyKind.INDEXED),
          new PropertyDescriptor("prop3", MyBean.class, PropertyKind.MAPPED),
        }, cls3.getPropertyDescriptors());
    assertEquals(BasicBean.class, cls3.getBeanType());
    assertEquals(true, cls3.hasProperty("prop1"));
    assertEquals(true, cls3.hasProperty("prop2"));
    assertEquals(true, cls3.hasProperty("prop3"));
    assertEquals(false, cls3.hasProperty("prop4"));
    assertEquals(new PropertyDescriptor("prop1", String.class),
        cls3.getPropertyDescriptor("prop1"));
    assertEquals(new PropertyDescriptor("prop2", Integer.class,
        PropertyKind.INDEXED),
        cls3.getPropertyDescriptor("prop2"));
    assertEquals(new PropertyDescriptor("prop3", MyBean.class,
        PropertyKind.MAPPED),
        cls3.getPropertyDescriptor("prop3"));

    try {
      new BasicBeanClass(null, new PropertyDescriptor[0]);
      fail("should throw");
    } catch (final NullPointerException e) {
      //  pass
    }

    try {
      new BasicBeanClass("bean1", null);
      fail("should throw");
    } catch (final NullPointerException e) {
      //  pass
    }

    try {
      new BasicBeanClass("bean1", new PropertyDescriptor[]{ null });
      fail("should throw");
    } catch (final NullPointerException e) {
      //  pass
    }
  }

  @Test
  public void testConstructorStringPropertyDescriptorArrayClass() {
    final BasicBeanClass cls1 = new BasicBeanClass("bean1",
        new PropertyDescriptor[0], null);
    assertEquals("bean1", cls1.getName());
    assertArrayEquals(new PropertyDescriptor[0], cls1.getPropertyDescriptors());
    assertEquals(BasicBean.class, cls1.getBeanType());

    final BasicBeanClass cls2 = new BasicBeanClass("bean2",
        new PropertyDescriptor[]{
          new PropertyDescriptor("prop1", String.class),
        },
        BasicBean.class
    );
    assertEquals("bean2", cls2.getName());
    assertArrayEquals(new PropertyDescriptor[]{
          new PropertyDescriptor("prop1", String.class),
    },  cls2.getPropertyDescriptors());
    assertEquals(BasicBean.class, cls2.getBeanType());

    final BasicBeanClass cls3 = new BasicBeanClass("bean3",
        new PropertyDescriptor[]{
          new PropertyDescriptor("prop1", String.class),
          new PropertyDescriptor("prop2", Integer.class, PropertyKind.INDEXED),
          new PropertyDescriptor("prop3", MyBean.class, PropertyKind.MAPPED),
        },
        MyBean.class
    );
    assertEquals("bean3", cls3.getName());
    assertArrayEquals(new PropertyDescriptor[]{
          new PropertyDescriptor("prop1", String.class),
          new PropertyDescriptor("prop2", Integer.class, PropertyKind.INDEXED),
          new PropertyDescriptor("prop3", MyBean.class, PropertyKind.MAPPED),
        }, cls3.getPropertyDescriptors());
    assertEquals(MyBean.class, cls3.getBeanType());

    try {
      new BasicBeanClass(null, new PropertyDescriptor[0], MyBean.class);
      fail("should throw");
    } catch (final NullPointerException e) {
      //  pass
    }

    try {
      new BasicBeanClass("bean1", null, MyBean.class);
      fail("should throw");
    } catch (final NullPointerException e) {
      //  pass
    }

    try {
      new BasicBeanClass("bean1", new PropertyDescriptor[]{ null },
          MyBean.class);
      fail("should throw");
    } catch (final NullPointerException e) {
      //  pass
    }
  }

  @Test
  public void testNewInstance() {
    final BasicBeanClass cls1 = new BasicBeanClass("bean-name1",
        new PropertyDescriptor[0]);
    final Bean bean1 = cls1.newInstance();
    assertEquals(BasicBean.class, bean1.getClass());
    assertSame(cls1, bean1.getBeanClass());

    final BasicBeanClass cls2 = new BasicBeanClass("bean-name2",
        new PropertyDescriptor[]{
          new PropertyDescriptor("prop1", String.class),
        }
    );
    final Bean bean2 = cls2.newInstance();
    assertEquals(BasicBean.class, bean2.getClass());
    assertSame(cls2, bean2.getBeanClass());

    final BasicBeanClass cls3 = new BasicBeanClass("bean-name3",
        new PropertyDescriptor[]{
          new PropertyDescriptor("prop1", String.class),
          new PropertyDescriptor("prop2", Integer.class, PropertyKind.INDEXED),
          new PropertyDescriptor("prop3", MyBean.class, PropertyKind.MAPPED),
        },
        MyBean.class
    );
    final Bean bean3 = cls3.newInstance();
    assertEquals(MyBean.class, bean3.getClass());
    assertSame(cls3, bean3.getBeanClass());
  }

  @Test
  public void testXmlSerialize() throws Exception {
    final BasicBeanClass cls1 = new BasicBeanClass("bean-name1",
        new PropertyDescriptor[0]);
    final String xml1 = "<bean>"
                + "<name>bean-name1</name>"
                + "<type>" + BasicBean.class.getName() + "</type>"
                + "<properties></properties>"
                + "</bean>";
    testXmlMarshal(BasicBeanClass.class, cls1, xml1);

    final BasicBeanClass cls2 = new BasicBeanClass("bean-name2",
        new PropertyDescriptor[]{
          new PropertyDescriptor("prop1", String.class),
        }
    );
    final String xml2 = "<bean>"
                + "<name>bean-name2</name>"
                + "<type>" + BasicBean.class.getName() + "</type>"
                + "<properties>"
                + "<property>"
                + "<name>prop1</name>"
                + "<type>string</type>"
                + "<kind>simple</kind>"
                + "</property>"
                + "</properties>"
                + "</bean>";
    testXmlMarshal(BasicBeanClass.class, cls2, xml2);

    TypeAliasRegistry.register("my-bean", MyBean.class);
    final BasicBeanClass cls3 = new BasicBeanClass("bean-name3",
        new PropertyDescriptor[]{
          new PropertyDescriptor("prop1", String.class),
          new PropertyDescriptor("prop2", Integer.class, PropertyKind.INDEXED),
          new PropertyDescriptor("prop3", MyBean.class, PropertyKind.MAPPED),
        },
        MyBean.class
    );
    final String xml3 = "<bean>"
                + "<name>bean-name3</name>"
                + "<type>my-bean</type>"
                + "<properties>"
                + "<property>"
                + "<name>prop1</name>"
                + "<type>string</type>"
                + "<kind>simple</kind>"
                + "</property>"
                + "<property>"
                + "<name>prop2</name>"
                + "<type>int</type>"
                + "<kind>indexed</kind>"
                + "</property>"
                + "<property>"
                + "<name>prop3</name>"
                + "<type>my-bean</type>"
                + "<kind>mapped</kind>"
                + "</property>"
                + "</properties>"
                + "</bean>";
    testXmlMarshal(BasicBeanClass.class, cls3, xml3);
  }

  @Test
  public void testXmlDeserialize() throws Exception {
    final BasicBeanClass cls1 = new BasicBeanClass("bean-name1",
        new PropertyDescriptor[0]);
    final String xml1 = "<bean>"
                + "<name>bean-name1</name>"
                + "<type>" + BasicBean.class.getName() + "</type>"
                + "</bean>";
    testXmlUnmarshal(BasicBeanClass.class, xml1, cls1);

    final BasicBeanClass cls2 = new BasicBeanClass("bean-name2",
        new PropertyDescriptor[]{
          new PropertyDescriptor("prop1", String.class),
        }
    );
    final String xml2 = "<bean>"
                + "<name>bean-name2</name>"
                + "<properties>"
                + "<property>"
                + "<name>prop1</name>"
                + "<type>string</type>"
                + "<kind>simple</kind>"
                + "</property>"
                + "</properties>"
                + "</bean>";
    testXmlUnmarshal(BasicBeanClass.class, xml2, cls2);

    final BasicBeanClass actualCls2 = unmarshal(BasicBeanClass.class, xml2);
    assertEquals(true, actualCls2.hasProperty("prop1"));
    assertEquals(new PropertyDescriptor("prop1", String.class),
        actualCls2.getPropertyDescriptor("prop1"));

    assertEquals(false, actualCls2.hasProperty("prop2"));

    TypeAliasRegistry.register("my-bean", MyBean.class);
    final BasicBeanClass cls3 = new BasicBeanClass("bean-name3",
        new PropertyDescriptor[]{
          new PropertyDescriptor("prop1", String.class),
          new PropertyDescriptor("prop2", Integer.class, PropertyKind.INDEXED),
          new PropertyDescriptor("prop3", MyBean.class, PropertyKind.MAPPED),
        },
        MyBean.class
    );
    final String xml3 = "<bean>"
                + "<name>bean-name3</name>"
                + "<type>my-bean</type>"
                + "<properties>"
                + "<property>"
                + "<name>prop1</name>"
                + "<type>string</type>"
                + "<kind>simple</kind>"
                + "</property>"
                + "<property>"
                + "<name>prop2</name>"
                + "<type>int</type>"
                + "<kind>indexed</kind>"
                + "</property>"
                + "<property>"
                + "<name>prop3</name>"
                + "<type>my-bean</type>"
                + "<kind>mapped</kind>"
                + "</property>"
                + "</properties>"
                + "</bean>";
    testXmlUnmarshal(BasicBeanClass.class, xml3, cls3);

    final BasicBeanClass actualCls3 = unmarshal(BasicBeanClass.class, xml3);
    assertEquals(true, actualCls3.hasProperty("prop1"));
    assertEquals(new PropertyDescriptor("prop1", String.class),
        actualCls3.getPropertyDescriptor("prop1"));

    assertEquals(true, actualCls3.hasProperty("prop2"));
    assertEquals(new PropertyDescriptor("prop2",
        Integer.class, PropertyKind.INDEXED),
        actualCls3.getPropertyDescriptor("prop2"));

    assertEquals(true, actualCls3.hasProperty("prop3"));
    assertEquals(new PropertyDescriptor("prop3",
        MyBean.class, PropertyKind.MAPPED),
        actualCls3.getPropertyDescriptor("prop3"));

    assertEquals(false, actualCls3.hasProperty("prop4"));
  }
}
