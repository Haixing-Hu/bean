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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.annotation.Nullable;

/**
 * A {@link Property} represents a descriptor of a bean.
 *
 * @author Haixing Hu
 */
public interface Property {

  /**
   * Gets the name of this property.
   *
   * @return the name of this property.
   */
  String getName();

  /**
   * Gets the kind of this property.
   *
   * @return the kind of this property.
   */
  PropertyKind getKind();

  /**
   * Gets the type of values of this property.
   *
   * @return the type of values of this property.
   */
  Class<?> getType();

  /**
   * Gets the descriptor of this property.
   *
   * @return the descriptor of this property.
   */
  PropertyDescriptor getDescriptor();

  /**
   * Gets the size of this indexed property or a mapped property.
   *
   * @return the size (number of values) of this indexed or mapped property.
   * @throws IllegalArgumentException
   *           if this property is not an indexed property nor a mapped
   *           property.
   * @throws ReflectionException
   *           if any other error occurs during the reflection operation.
   */
  int getSize();

  /**
   * Gets the raw value of this property.
   *
   * @return the raw value of this property.
   * @throws ReflectionException
   *           if any other error occurs during the reflection operation.
   */
  Object getRawValue();

  /**
   * Sets the raw value of this property.
   * <p>
   * <b>IMPLEMENTATION NOTE:</b> if this property is indexed or mapped, the
   * implementation of this function should (shallow) copy the contents of the
   * argument passed to this function.
   *
   * @param value
   *          the new raw value to set, which could be {@code null} if this
   *          property is a simple property.
   * @throws NullPointerException
   *           if {@code value} is {@code null} while this property is not a
   *           simple property.
   * @throws ClassCastException
   *           if this property is an indexed property but the {@code value} is
   *           not an instance of {@link ArrayList}; or if this property is a
   *           mapped property but the {@code value} is not an instance of
   *           {@link HashMap}.
   * @throws ReflectionException
   *           if any other error occurs during the reflection operation.
   */
  void setRawValue(@Nullable Object value);

  /**
   * Gets the value of this simple property.
   *
   * @return the value of this property.
   * @throws InvalidPropertyKindException
   *           if this property is not a simple property.
   * @throws ReflectionException
   *           if any other error occurs during the reflection operation.
   */
  Object getSimpleValue();

  /**
   * Sets the value of this simple property.
   *
   * @param object
   *          the new value to be set, which could be {@code null} if the type
   *          of this property is not a primitive type.
   * @throws InvalidPropertyKindException
   *           if this property is not a simple property.
   * @throws ClassCastException
   *           if the type of the provided value does not match the type of this
   *           property.
   * @throws NullPointerException
   *           if {@code value} is {@code null} while the type of this property
   *           is a primitive type.
   * @throws ReflectionException
   *           if any other error occurs during the reflection operation.
   */
  void setSimpleValue(@Nullable Object object);

  /**
   * Gets the list storing the values of this indexed property.
   *
   * @return the list storing the values of this indexed property.
   * @throws InvalidPropertyKindException
   *           if this property is not an indexed property.
   * @throws ReflectionException
   *           if any other error occurs during the reflection operation.
   */
  ArrayList<Object> getIndexedValue();

  /**
   * Sets the list storing the values of this indexed property.
   * <p>
   * <b>IMPLEMENTATION NOTE:</b> the implementation of this function should
   * (shallow) copy the contents of the argument passed to this function.
   *
   * @param list
   *          the new list to be set, which cannot be {@code null}.
   * @throws InvalidPropertyKindException
   *           if this property is not an indexed property.
   * @throws ReflectionException
   *           if any other error occurs during the reflection operation.
   */
  void setIndexedValue(ArrayList<Object> list);

  /**
   * Gets the value at the specified index of this indexed property.
   *
   * @param index
   *          the index of the value to be retrieved.
   * @return the value at the specified index of this indexed property, which
   *         could be {@code null}, depending on the implementation.
   * @throws InvalidPropertyKindException
   *           if this is not an indexed property.
   * @throws IndexOutOfBoundsException
   *           if the {@code index} is outside the range of this indexed
   *           property.
   * @throws ReflectionException
   *           if any other error occurs during the reflection operation.
   */
  Object getIndexedValue(int index);

  /**
   * Sets the value at the specified index of this indexed property.
   *
   * @param index
   *          the index of the value to set.
   * @param value
   *          the value to be set to specified index of this property, which
   *          could be {@code null}, depending on the implementation.
   * @throws InvalidPropertyKindException
   *           if this property is not an indexed property.
   * @throws IndexOutOfBoundsException
   *           if the {@code index} is outside the range of this indexed
   *           property.
   * @throws ClassCastException
   *           if the type of the provided value does not match the type of this
   *           property.
   * @throws NullPointerException
   *           if attempt to set a primitive property to {@code null}.
   * @throws ReflectionException
   *           if any other error occurs during the reflection operation.
   */
  void setIndexedValue(int index, @Nullable Object value);

  /**
   * Inserts a value at the specified index of this indexed property.
   *
   * @param index
   *          the index where the value to be inserted.
   * @param value
   *          the value to be inserted to specified index of this property,
   *          which could be {@code null}, depending on the implementation.
   * @throws InvalidPropertyKindException
   *           if this property is not an indexed property.
   * @throws IndexOutOfBoundsException
   *           if the {@code index} is outside the range of this indexed
   *           property.
   * @throws ClassCastException
   *           if the type of the provided value does not match the type of this
   *           property.
   * @throws NullPointerException
   *           if attempt to set a primitive property to {@code null}.
   * @throws ReflectionException
   *           if any other error occurs during the reflection operation.
   */
  void addIndexedValue(int index, @Nullable Object value);

  /**
   * Adds a value at the end of this indexed property.
   *
   * @param value
   *          the value to be added to the end of this property, which could be
   *          {@code null}, depending on the implementation.
   * @throws InvalidPropertyKindException
   *           if this property is not an indexed property.
   * @throws ClassCastException
   *           if the type of the provided value does not match the type of this
   *           property.
   * @throws NullPointerException
   *           if attempt to set a primitive property to {@code null}.
   * @throws ReflectionException
   *           if any other error occurs during the reflection operation.
   */
  void addIndexedValue(@Nullable Object value);

  /**
   * Removes a value at the specified position from this indexed property.
   * <p>
   * Note that the removing operation will shift the subsequent values to the
   * left, as described by {@link List#remove(int)}.
   *
   * @param index
   *          the index of the value to be removed.
   * @return the value at the specified index that was removed from this indexed
   *         property, which may be {@code null} , depending on the
   *         implementation.
   * @throws InvalidPropertyKindException
   *           if this property is not a indexed property.
   * @throws IndexOutOfBoundsException
   *           if the {@code index} is outside the range of this indexed
   *           property.
   * @throws ReflectionException
   *           if any other error occurs during the reflection operation.
   */
  Object removeIndexedValue(int index);

  /**
   * Gets the map storing the values of this mapped property.
   *
   * @return the map storing the values of this mapped property.
   * @throws InvalidPropertyKindException
   *           if this property is not a mapped property.
   */
  HashMap<String, Object> getMappedValue();

  /**
   * Sets the map storing the values of this mapped property.
   * <p>
   * <b>IMPLEMENTATION NOTE:</b> the implementation of this function should
   * (shallow) copy the contents of the argument passed to this function.
   *
   * @param map
   *          the new map to be set, which cannot be {@code null}.
   * @throws InvalidPropertyKindException
   *           if this property is not a mapped property.
   */
  void setMappedValue(HashMap<String, Object> map);

  /**
   * Gets the key set of this mapped property.
   *
   * @return the key set of this mapped property.
   * @throws InvalidPropertyKindException
   *           if this property is not a mapped property.
   * @throws ReflectionException
   *           if any other error occurs during the reflection operation.
   */
  Set<String> getKeySet();

  /**
   * Tests whether this mapped property contains the specified key.
   *
   * @param key
   *          the key to check.
   * @return {@code true} if this mapped property contains the specified key;
   *         {@code false} otherwise.
   * @throws InvalidPropertyKindException
   *           if this property is not a mapped property.
   * @throws ReflectionException
   *           if any error occurs during the reflection operation.
   */
  boolean containsKey(String key);

  /**
   * Gets the value corresponds to a specified key of this mapped property.
   *
   * @param key
   *          the key of the value to be retrieved.
   * @return the value corresponds to the key of this mapped property, which
   *         could be {@code null}, depending on the implementation.
   * @throws InvalidPropertyKindException
   *           if this property is not a mapped property.
   * @throws ReflectionException
   *           if any other error occurs during the reflection operation.
   */
  Object getMappedValue(String key);

  /**
   * Sets the value corresponds to the specified key of a mapped property.
   *
   * @param key
   *          the key corresponds to the value to set.
   * @param value
   *          the value to be set corresponds to the specified key in this
   *          mapped property, which could be {@code null}, depending on the
   *          implementation.
   * @throws InvalidPropertyKindException
   *           if this property is not a mapped property.
   * @throws ClassCastException
   *           if the type of the provided value does not match the type of this
   *           property.
   * @throws NullPointerException
   *           if attempt to set a primitive property to {@code null}.
   * @throws ReflectionException
   *           if any other error occurs during the reflection operation.
   */
  void setMappedValue(String key, @Nullable Object value);

  /**
   * Removes a value corresponds to a specified key from this mapped property.
   *
   * @param key
   *          the key corresponds to the value to be removed.
   * @return the value corresponds to the specified key that was removed from
   *         this mapped property; or {@code null} if there is no value
   *         corresponds to the specified key in this mapped property.
   * @throws InvalidPropertyKindException
   *           if this property is not a mapped property.
   * @throws ReflectionException
   *           if any other error occurs during the reflection operation.
   */
  Object removeMappedValue(String key);

  /**
   * Clears all values in this indexed or mapped property.
   *
   * @throws InvalidPropertyKindException
   *           if this property is not an indexed nor mapped property.
   * @throws ReflectionException
   *           if any other error occurs during the reflection operation.
   */
  void clear();
}
