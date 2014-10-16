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
import java.util.Set;

import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * The interface for beans.
 * <p>
 * This interface provides a uniform way to access the descriptors of a bean.
 * Although we could access the descriptors of a bean through reflections, there
 * are still some situations that we need a uniform way to access the
 * descriptors of beans.
 * <p>
 * For example, suppose we have a {@code Article} class, which consists of a
 * list of {@code Field} objects. Each {@code Field} has a unique name. We want
 * to access a {@code Field} of a {@code Article} by the field's name, as if the
 * document has a property with that name. The {@link Bean} interface provides
 * getter and setter functions to access the internal property of a
 * {@code Article}, as well as the internal descriptors of the {@code Article}.
 * <p>
 * A {@link Bean} object can also be used with the {@link PropertyExpression}.
 * <p>
 * <b>NOTE:</b> the implementation of this interface <b>does not</b> have to be
 * thread-safe.
 *
 * @author Haixing Hu
 */
@NotThreadSafe
public interface Bean {

  /**
   * Gets the {@link BeanClass} instance that describes the set of descriptors
   * available for this {@link Bean}.
   *
   * @return the {@link BeanClass} instance that describes the set of
   *         descriptors available for this {@link Bean}.
   */
  BeanClass getBeanClass();

  /**
   * Gets a property.
   *
   * @param name
   *          the name of the property to be get.
   * @return the property with the specified name, or {@code null} if there is
   *         no such property.
   * @throws ReflectionException
   *           if any other error occurs during the reflection operation.
   */
  Property getProperty(String name);

  /**
   * Gets the value of a simple property.
   *
   * @param name
   *          the name of a simple property.
   * @return the value of the simple property with the specified name, which
   *         could be {@code null}, depending on the implementation.
   * @throws IllegalArgumentException
   *           if the specified property does not exist, or the specified
   *           property is not a simple property.
   * @throws ReflectionException
   *           if any other error occurs during the reflection operation.
   */
  Object get(String name);

  /**
   * Sets the value of a simple property.
   *
   * @param name
   *          the name of a simple property.
   * @param value
   *          the value to be set to the simple property with the specified
   *          name, which could be {@code null}, depending on the
   *          implementation.
   * @throws IllegalArgumentException
   *           if the specified property does not exist, or the specified
   *           property is not a simple property.
   * @throws ClassCastException
   *           if the type of the provided value does not match the type of the
   *           specified property.
   * @throws NullPointerException
   *           if attempt to set a primitive property to {@code null}.
   * @throws ReflectionException
   *           if any other error occurs during the reflection operation.
   */
  void set(String name, @Nullable Object value);

  /**
   * Gets the size of an indexed property or a mapped property.
   *
   * @param name
   *          the name of an indexed or mapped property.
   * @return the size (number of values) of the indexed or mapped property.
   * @throws IllegalArgumentException
   *           if the specified property does not exist, or the specified
   *           property is not an indexed property nor a mapped property.
   * @throws ReflectionException
   *           if any other error occurs during the reflection operation.
   */
  int getSize(String name);

  /**
   * Gets the value at the specified index of an indexed property.
   *
   * @param name
   *          the name of an indexed property.
   * @param index
   *          the index of the value to be retrieved.
   * @return the value at the specified index of the indexed property with the
   *         specified name, which could be {@code null}, depending on the
   *         implementation.
   * @throws IllegalArgumentException
   *           if the specified property does not exist, or the specified
   *           property exists but is not an indexed property.
   * @throws IndexOutOfBoundsException
   *           if the {@code index} is outside the range of the indexed
   *           property.
   * @throws ReflectionException
   *           if any other error occurs during the reflection operation.
   */
  Object get(String name, int index);

  /**
   * Sets the value at the specified index of an indexed property.
   *
   * @param name
   *          the name of an indexed property.
   * @param index
   *          the index of the value to set.
   * @param value
   *          the value to be set to specified index at the index property with
   *          the specified name, which could be {@code null}, depending on the
   *          implementation.
   * @throws IllegalArgumentException
   *           if the specified property does not exist, or the specified
   *           property is not an indexed property.
   * @throws IndexOutOfBoundsException
   *           if the {@code index} is outside the range of the indexed
   *           property.
   * @throws ClassCastException
   *           if the type of the provided value does not match the type of the
   *           specified property.
   * @throws NullPointerException
   *           if attempt to set a primitive property to {@code null}.
   * @throws ReflectionException
   *           if any other error occurs during the reflection operation.
   */
  void set(String name, int index, @Nullable Object value);

  /**
   * Inserts a value at the specified index of an indexed property.
   *
   * @param name
   *          the name of an indexed property.
   * @param index
   *          the index where the value to be inserted.
   * @param value
   *          the value to be inserted to specified index of the indexed
   *          property with the specified name, which could be {@code null},
   *          depending on the implementation.
   * @throws IllegalArgumentException
   *           if the specified property does not exist, or the specified
   *           property is not an indexed property.
   * @throws IndexOutOfBoundsException
   *           if the {@code index} is outside the range of the indexed
   *           property.
   * @throws ClassCastException
   *           if the type of the provided value does not match the type of this
   *           property.
   * @throws NullPointerException
   *           if attempt to set a primitive property to {@code null}.
   * @throws ReflectionException
   *           if any other error occurs during the reflection operation.
   */
  void add(String name, int index, @Nullable Object value);

  /**
   * Adds a value at the end of an indexed property.
   *
   * @param name
   *          the name of an indexed property.
   * @param value
   *          the value to be added to the end of the indexed property with the
   *          specified name, which could be {@code null}, depending on the
   *          implementation.
   * @throws IllegalArgumentException
   *           if the specified property does not exist, or the specified
   *           property is not an indexed property.
   * @throws ClassCastException
   *           if the type of the provided value does not match the type of this
   *           property.
   * @throws NullPointerException
   *           if attempt to set a primitive property to {@code null}.
   * @throws ReflectionException
   *           if any other error occurs during the reflection operation.
   */
  void add(String name, @Nullable Object value);

  /**
   * Removes a value at the specified position from an indexed property.
   * <p>
   * Note that the removing operation will shift the subsequent values to the
   * left, as described by {@link List#remove(int)}.
   *
   * @param name
   *          the name of an indexed property.
   * @param index
   *          the index of the value to be removed.
   * @return the value at the specified index that was removed from the indexed
   *         property with the specified name, which may be {@code null} ,
   *         depending on the implementation.
   * @throws IllegalArgumentException
   *           if the specified property does not exist, or the specified
   *           property is not a indexed property.
   * @throws IndexOutOfBoundsException
   *           if the {@code index} is outside the range of the indexed
   *           property.
   * @throws ReflectionException
   *           if any other error occurs during the reflection operation.
   */
  Object remove(String name, int index);

  /**
   * Gets the key set of a mapped property.
   *
   * @param name
   *          the name of a mapped property.
   * @return the key set of the mapped property.
   * @throws IllegalArgumentException
   *           if the specified property does not exist, or the specified
   *           property is not a mapped property.
   * @throws ReflectionException
   *           if any other error occurs during the reflection operation.
   */
  Set<String> getKeySet(String name);

  /**
   * Tests whether a mapped property contains the specified key.
   *
   * @param name
   *          the name of a mapped property.
   * @param key
   *          the key to check.
   * @return {@code true} if the mapped property with the specified name
   *         contains the specified key; {@code false} otherwise.
   * @throws IllegalArgumentException
   *           if the specified property does not exist, or the specified
   *           property exists but is not a mapped property.
   * @throws ReflectionException
   *           if any error occurs during the reflection operation.
   */
  boolean containsKey(String name, String key);

  /**
   * Gets the value corresponds to a specified key of a mapped property.
   *
   * @param name
   *          the name of a mapped property.
   * @param key
   *          the key of the value to be retrieved.
   * @return the value corresponds to the specified key of the mapped property
   *         with the specified name, which could be {@code null}, depending on
   *         the implementation.
   * @throws IllegalArgumentException
   *           if the specified property does not exist, or the specified
   *           property exists but is not a mapped property.
   * @throws ReflectionException
   *           if any other error occurs during the reflection operation.
   */
  Object get(String name, String key);

  /**
   * Sets the value corresponds to the specified key of a mapped property.
   *
   * @param name
   *          the name of a mapped property.
   * @param key
   *          the key corresponds to the value to set.
   * @param value
   *          the value to be set corresponds to the specified key in the mapped
   *          property with the specified name, which could be {@code null},
   *          depending on the implementation.
   * @throws IllegalArgumentException
   *           if the specified property does not exist, or the specified
   *           property is not a mapped property.
   * @throws ClassCastException
   *           if the type of the provided value does not match the type of the
   *           specified property.
   * @throws NullPointerException
   *           if attempt to set a primitive property to {@code null}.
   * @throws ReflectionException
   *           if any other error occurs during the reflection operation.
   */
  void set(String name, String key, @Nullable Object value);

  /**
   * Removes a value corresponds to a specified key from a mapped property.
   *
   * @param name
   *          the name of a mapped property.
   * @param key
   *          the key corresponds to the value to be removed.
   * @return the value corresponds to the specified key that was removed from
   *         the mapped property with the specified name; or {@code null} if
   *         there is no value corresponds to the specified key in the mapped
   *         property.
   * @throws IllegalArgumentException
   *           if the specified property does not exist, or the specified
   *           property is not a mapped property.
   * @throws ReflectionException
   *           if any other error occurs during the reflection operation.
   */
  Object remove(String name, String key);

  /**
   * Clears all values of an indexed or mapped property.
   *
   * @param name
   *          the name of a indexed or mapped property.
   * @throws IllegalArgumentException
   *           if the specified property does not exist, or the specified
   *           property is not an indexed nor mapped property.
   * @throws ReflectionException
   *           if any other error occurs during the reflection operation.
   */
  void clear(String name);
}
