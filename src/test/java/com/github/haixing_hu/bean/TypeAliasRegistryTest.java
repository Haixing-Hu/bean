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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Unit test of the {@link TypeAliasRegistry} class.
 *
 * @author Haixing Hu
 */
public class TypeAliasRegistryTest {

  @Test
  public void testRegister() {

    TypeAliasRegistry.register("my-bean", MyBean.class);

    try {
      TypeAliasRegistry.register(null, MyBean.class);
      fail("should throw");
    } catch (final NullPointerException e) {
      //  pass
    }

    try {
      TypeAliasRegistry.register("my-class", null);
      fail("should throw");
    } catch (final NullPointerException e) {
      //  pass
    }
  }

  @Test
  public void testGetAlias() {
    assertEquals("int", TypeAliasRegistry.getAlias(Integer.class));
    TypeAliasRegistry.register("my-bean", MyBean.class);
    assertEquals("my-bean", TypeAliasRegistry.getAlias(MyBean.class));

    try {
      TypeAliasRegistry.getAlias(null);
      fail("should throw");
    } catch (final NullPointerException e) {
      //  pass
    }
  }

  @Test
  public void testGetType() {
    assertEquals(Integer.class, TypeAliasRegistry.getType("int"));
    TypeAliasRegistry.register("my-bean", MyBean.class);
    assertEquals(MyBean.class, TypeAliasRegistry.getType("my-bean"));

    try {
      TypeAliasRegistry.getType(null);
      fail("should throw");
    } catch (final NullPointerException e) {
      //  pass
    }
  }

}
