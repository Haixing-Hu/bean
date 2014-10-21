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

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

/**
 * Unit test for the {@link PropertyDescriptorGroup} class.
 *
 * @author Haixing Hu
 */
public class PropertyDescriptorGroupTest extends PropertyDescriptorTestBase {

  @Test
  public void testConstructor() {
    final PropertyDescriptorGroup group0 = getPropertyDescriptorGroup0();
    assertEquals("group0", group0.getName());
    assertArrayEquals(new PropertyDescriptor[0], group0.getDescriptors());

    final PropertyDescriptorGroup group1 = getPropertyDescriptorGroup1();
    assertEquals("group1", group1.getName());
    assertArrayEquals(new PropertyDescriptor[] {
        getPropertyDescriptor1(),
    }, group1.getDescriptors());

    final PropertyDescriptorGroup group2 = getPropertyDescriptorGroup2();
    assertEquals("group2", group2.getName());
    assertArrayEquals(new PropertyDescriptor[] {
        getPropertyDescriptor2(),
        getPropertyDescriptor3(),
    }, group2.getDescriptors());

    final PropertyDescriptorGroup group3 = getPropertyDescriptorGroup3();
    assertEquals("group3", group3.getName());
    assertArrayEquals(new PropertyDescriptor[] {
        getPropertyDescriptor4(),
        getPropertyDescriptor5(),
        getPropertyDescriptor6(),
    }, group3.getDescriptors());

    try {
      new PropertyDescriptorGroup(null, new PropertyDescriptor[0]);
      fail("should throw");
    } catch (final NullPointerException e) {
      //  pass
    }

    try {
      new PropertyDescriptorGroup("group0", null);
      fail("should throw");
    } catch (final NullPointerException e) {
      //  pass
    }

    try {
      new PropertyDescriptorGroup("group.group", new PropertyDescriptor[0]);
      fail("should throw");
    } catch (final IllegalArgumentException e) {
      //  pass
    }

    try {
      new PropertyDescriptorGroup("12group", new PropertyDescriptor[0]);
      fail("should throw");
    } catch (final IllegalArgumentException e) {
      //  pass
    }

    try {
      new PropertyDescriptorGroup("group*", new PropertyDescriptor[0]);
      fail("should throw");
    } catch (final IllegalArgumentException e) {
      //  pass
    }
  }

  @Test
  public void testEqualsHashCode() {
    final PropertyDescriptorGroup group0 = getPropertyDescriptorGroup0();
    final PropertyDescriptorGroup group0c = getPropertyDescriptorGroup0();

    final PropertyDescriptorGroup group1 = getPropertyDescriptorGroup1();
    final PropertyDescriptorGroup group1c = getPropertyDescriptorGroup1();

    final PropertyDescriptorGroup group2 = getPropertyDescriptorGroup2();
    final PropertyDescriptorGroup group2c = getPropertyDescriptorGroup2();

    final PropertyDescriptorGroup group3 = getPropertyDescriptorGroup3();
    final PropertyDescriptorGroup group3c = getPropertyDescriptorGroup3();

    assertEquals(true, group0.equals(group0));
    assertEquals(true, group0.equals(group0c));
    assertEquals(false, group0.equals(group1));
    assertEquals(false, group0.equals(group2));
    assertEquals(false, group0.equals(group3));
    assertEquals(false, group0.equals(null));
    assertEquals(false, group0.equals("str"));

    assertEquals(group0.hashCode(), group0.hashCode());
    assertEquals(group0.hashCode(), group0c.hashCode());
    assertNotEquals(group0.hashCode(), group1.hashCode());
    assertNotEquals(group0.hashCode(), group2.hashCode());
    assertNotEquals(group0.hashCode(), group3.hashCode());

    assertEquals(true, group1.equals(group1));
    assertEquals(true, group1.equals(group1c));
    assertEquals(false, group1.equals(group0));
    assertEquals(false, group1.equals(group2));
    assertEquals(false, group1.equals(group3));
    assertEquals(false, group1.equals(null));
    assertEquals(false, group1.equals("str"));

    assertEquals(group1.hashCode(), group1.hashCode());
    assertEquals(group1.hashCode(), group1c.hashCode());
    assertNotEquals(group1.hashCode(), group0.hashCode());
    assertNotEquals(group1.hashCode(), group2.hashCode());
    assertNotEquals(group1.hashCode(), group3.hashCode());

    assertEquals(true, group2.equals(group2));
    assertEquals(true, group2.equals(group2c));
    assertEquals(false, group2.equals(group0));
    assertEquals(false, group2.equals(group1));
    assertEquals(false, group2.equals(group3));
    assertEquals(false, group2.equals(null));
    assertEquals(false, group2.equals("str"));

    assertEquals(group2.hashCode(), group2.hashCode());
    assertEquals(group2.hashCode(), group2c.hashCode());
    assertNotEquals(group2.hashCode(), group0.hashCode());
    assertNotEquals(group2.hashCode(), group1.hashCode());
    assertNotEquals(group2.hashCode(), group3.hashCode());

    assertEquals(true, group3.equals(group3));
    assertEquals(true, group3.equals(group3c));
    assertEquals(false, group3.equals(group0));
    assertEquals(false, group3.equals(group1));
    assertEquals(false, group3.equals(group2));
    assertEquals(false, group3.equals(null));
    assertEquals(false, group3.equals("str"));

    assertEquals(group3.hashCode(), group3.hashCode());
    assertEquals(group3.hashCode(), group3c.hashCode());
    assertNotEquals(group3.hashCode(), group0.hashCode());
    assertNotEquals(group3.hashCode(), group1.hashCode());
    assertNotEquals(group3.hashCode(), group2.hashCode());
  }

  @Test
  public void testToString() {
    final PropertyDescriptorGroup group0 = getPropertyDescriptorGroup0();
    final PropertyDescriptorGroup group0c = getPropertyDescriptorGroup0();

    final PropertyDescriptorGroup group1 = getPropertyDescriptorGroup1();
    final PropertyDescriptorGroup group1c = getPropertyDescriptorGroup1();

    final PropertyDescriptorGroup group2 = getPropertyDescriptorGroup2();
    final PropertyDescriptorGroup group2c = getPropertyDescriptorGroup2();

    final PropertyDescriptorGroup group3 = getPropertyDescriptorGroup3();
    final PropertyDescriptorGroup group3c = getPropertyDescriptorGroup3();

    assertEquals(group0.toString(), group0.toString());
    assertNotEquals(group0.toString(), group0c.toString());
    assertNotEquals(group0.toString(), group1.toString());
    assertNotEquals(group0.toString(), group2.toString());
    assertNotEquals(group0.toString(), group3.toString());

    assertEquals(group1.toString(), group1.toString());
    assertNotEquals(group1.toString(), group1c.toString());
    assertNotEquals(group1.toString(), group0.toString());
    assertNotEquals(group1.toString(), group2.toString());
    assertNotEquals(group1.toString(), group3.toString());

    assertEquals(group2.toString(), group2.toString());
    assertNotEquals(group2.toString(), group2c.toString());
    assertNotEquals(group2.toString(), group0.toString());
    assertNotEquals(group2.toString(), group1.toString());
    assertNotEquals(group2.toString(), group3.toString());

    assertEquals(group3.toString(), group3.toString());
    assertNotEquals(group3.toString(), group3c.toString());
    assertNotEquals(group3.toString(), group0.toString());
    assertNotEquals(group3.toString(), group1.toString());
    assertNotEquals(group3.toString(), group2.toString());
  }


  @Test
  public void testXmlSerialize() throws Exception {
    final PropertyDescriptorGroup group1 = getPropertyDescriptorGroup1();
    final String xml1 = getPropertyDescriptorGroup1Xml();
    testXmlMarshal(PropertyDescriptorGroup.class, group1, xml1);

    final PropertyDescriptorGroup group2 = getPropertyDescriptorGroup2();
    final String xml2 = getPropertyDescriptorGroup2Xml();
    testXmlMarshal(PropertyDescriptorGroup.class, group2, xml2);

    final PropertyDescriptorGroup group3 = getPropertyDescriptorGroup3();
    final String xml3 = getPropertyDescriptorGroup3Xml();
    testXmlMarshal(PropertyDescriptorGroup.class, group3, xml3);
  }

  @Test
  public void testXmlDeserialize() throws Exception {
    final PropertyDescriptorGroup group1 = getPropertyDescriptorGroup1();
    final String xml1 = getPropertyDescriptorGroup1Xml();
    testXmlUnmarshal(PropertyDescriptorGroup.class, xml1, group1);

    final PropertyDescriptorGroup group2 = getPropertyDescriptorGroup2();
    final String xml2 = getPropertyDescriptorGroup2Xml();
    testXmlUnmarshal(PropertyDescriptorGroup.class, xml2, group2);

    final PropertyDescriptorGroup group3 = getPropertyDescriptorGroup3();
    final String xml3 = getPropertyDescriptorGroup3Xml();
    testXmlUnmarshal(PropertyDescriptorGroup.class, xml3, group3);

  }
}
