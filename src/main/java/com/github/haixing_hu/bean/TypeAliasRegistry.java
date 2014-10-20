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

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.haixing_hu.lang.ClassUtils;

import static com.github.haixing_hu.lang.Argument.requireNonNull;

/**
 * A class used to register the alias of types.
 *
 * @author Haixing Hu
 */
public final class TypeAliasRegistry {

  private static final Map<String, Class<?>> ALIAS_TO_TYPE = new HashMap<>();
  private static final Map<Class<?>, String> TYPE_TO_ALIAS = new HashMap<>();
  private static final Logger LOGGER =
      LoggerFactory.getLogger(TypeAliasRegistry.class);

  private static void doRegister(final String alias, final Class<?> type) {
    LOGGER.info("Register type alias '{}' <==> '{}'", alias,
        ClassUtils.getShortCanonicalName(type));
    ALIAS_TO_TYPE.put(alias, type);
    TYPE_TO_ALIAS.put(type, alias);
  }

  static {
    // set predefined short names
    doRegister("boolean", Boolean.class);
    doRegister("byte", Byte.class);
    doRegister("short", Short.class);
    doRegister("int", Integer.class);
    doRegister("long", Long.class);
    doRegister("float", Float.class);
    doRegister("double", Double.class);

    doRegister("bigint", BigInteger.class);
    doRegister("bigdecimal", BigDecimal.class);

    doRegister("string", String.class);
    doRegister("class", Class.class);
    doRegister("object", Object.class);

    doRegister("boolean[]", boolean[].class);
    doRegister("byte[]", byte[].class);
    doRegister("short[]", short[].class);
    doRegister("int[]", int[].class);
    doRegister("long[]", long[].class);
    doRegister("float[]", float[].class);
    doRegister("double[]", double[].class);
    doRegister("string[]", String[].class);
    doRegister("class[]", Class[].class);
    doRegister("object[]", Object[].class);

    doRegister("list", List.class);
    doRegister("set", Set.class);
    doRegister("map", Map.class);
    doRegister("collection", Collection.class);

    doRegister("default-bean", DefaultBean.class);
  }

  private TypeAliasRegistry() { }

  /**
   * Registers the alias of a type.
   *
   * @param alias
   *          the alias of the type.
   * @param type
   *          the class of the type.
   */
  public static void register(final String alias, final Class<?> type) {
    requireNonNull("alias", alias);
    requireNonNull("type", type);
    synchronized (TypeAliasRegistry.class) {
      doRegister(alias, type);
    }
  }

  /**
   * Gets the alias of a type.
   *
   * @param type
   *          the class of a type.
   * @return the registered alias of the type, or {@code null} if none.
   */
  public static String getAlias(final Class<?> type) {
    LOGGER.debug("Getting alias for type '{}'...", type.getName());
    requireNonNull("type", type);
    synchronized (TypeAliasRegistry.class) {
      return TYPE_TO_ALIAS.get(type);
    }
  }

  /**
   * Gets the type with an alias.
   *
   * @param alias
   *          the alias of a type.
   * @return the registered type with the alias, or {@code null} if none.
   */
  public static Class<?> getType(final String alias) {
    LOGGER.debug("Getting type for alias '{}'...", alias);
    requireNonNull("alias", alias);
    synchronized (TypeAliasRegistry.class) {
      return ALIAS_TO_TYPE.get(alias);
    }
  }

}
