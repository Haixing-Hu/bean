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
import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import static com.github.haixing_hu.lang.Argument.requireNonNull;

/**
 * A {@link DefaultProperty} represents a descriptor of a bean.
 *
 * @author Haixing Hu
 */
public class DefaultProperty implements Property {

  protected final PropertyDescriptor descriptor;
  protected Object value;

  /**
   * Constructs a {@link DefaultProperty}.
   *
   * @param descriptor
   *          a property descriptor.
   */
  public DefaultProperty(final PropertyDescriptor descriptor) {
    this.descriptor = requireNonNull("descriptor", descriptor);
    switch (descriptor.getKind()) {
      case INDEXED:
        value = new ArrayList<Object>();
        break;
      case MAPPED:
        value = new HashMap<String, Object>();
        break;
      case SIMPLE:
      default:
        value = null;
        break;
    }
  }

  @Override
  public final String getName() {
    return descriptor.getName();
  }

  @Override
  public PropertyKind getKind() {
    return descriptor.getKind();
  }

  @Override
  public Class<?> getType() {
    return descriptor.getType();
  }

  /**
   * Checks the kind of this property.
   *
   * @param expectedKinds
   *          the array of expected kinds of this property.
   * @throws IllegalArgumentException
   *           if the kind of this property is not the required kind.
   */
  protected void checkKind(final PropertyKind ... expectedKinds) {
    final PropertyKind actualKind = descriptor.getKind();
    for (final PropertyKind kind : expectedKinds) {
      if (actualKind == kind) {
        return;
      }
    }
    throw new InvalidPropertyKindException(descriptor.getName(), actualKind,
        expectedKinds);
  }

  /**
   * Checks the type of a value.
   *
   * @param value
   *          the value to be checked, which could be {@code null}, depending on
   *          the implementation.
   * @throws ClassCastException
   *           if the value is not an instance of the type of this property.
   */
  protected void checkType(@Nullable final Object value) {
    if (value == null) {
      return;
    }
    final Class<?> type = descriptor.getType();
    if (! type.isAssignableFrom(value.getClass())) {
      throw new ClassCastException("Cannot cast the value of type "
          + value.getClass().getName() + " to the value of type "
          + type.getName());
    }
  }

  @Override
  public final PropertyDescriptor getDescriptor() {
    return descriptor;
  }

  @Override
  public final Object getRawValue() {
    return value;
  }

  @SuppressWarnings("unchecked")
  @Override
  public final void setRawValue(@Nullable final Object value) {
    switch (descriptor.getKind()) {
      case INDEXED:
        if (value == null) {
          throw new NullPointerException("value is null.");
        }
        if (! (value instanceof ArrayList)) {
          throw new ClassCastException(
              "The value of an indexed property must be a java.util.ArrayList.");
        }
        //  FIXME: check the generic argument type of the ArrayList
        setIndexedValue((ArrayList<Object>) value);
        return;
      case MAPPED:
        if (value == null) {
          throw new NullPointerException("value is null.");
        }
        if (! (value instanceof HashMap)) {
          throw new ClassCastException(
              "The value of a mapped property must be a java.util.HashMap.");
        }
        //  FIXME: check the generic argument type of the HashMap
        setMappedValue((HashMap<String, Object>) value);
        return;
      case SIMPLE:
      default:
        this.value = value;
        return;
    }
  }

  @Override
  public final int getSize() {
    final PropertyKind kind = descriptor.getKind();
    switch (kind) {
      case INDEXED:
        return ((List<?>) value).size();
      case MAPPED:
        return ((Map<?, ?>) value).size();
      case SIMPLE:
      default:
        throw new InvalidPropertyKindException(descriptor.getName(), kind,
            PropertyKind.INDEXED, PropertyKind.MAPPED);
    }
  }

  @Override
  public final Object getSimpleValue() {
    checkKind(PropertyKind.SIMPLE);
    return value;
  }

  @Override
  public final void setSimpleValue(@Nullable final Object object) {
    checkKind(PropertyKind.SIMPLE);
    checkType(object);
    value = object;
  }

  @SuppressWarnings("unchecked")
  @Override
  public final ArrayList<Object> getIndexedValue() {
    checkKind(PropertyKind.INDEXED);
    return (ArrayList<Object>) value;
  }

  @Override
  public final void setIndexedValue(final ArrayList<Object> list) {
    checkKind(PropertyKind.INDEXED);
    requireNonNull("list", list);
    for (final Object obj : list) {
      checkType(obj);
    }
    @SuppressWarnings("unchecked")
    final ArrayList<Object> valueList = (ArrayList<Object>) value;
    valueList.clear();
    valueList.addAll(list);
  }

  @Override
  public final Object getIndexedValue(final int index) {
    final ArrayList<Object> list = getIndexedValue();
    return list.get(index);
  }

  @Override
  public final void setIndexedValue(final int index, final Object value) {
    final ArrayList<Object> list = getIndexedValue();
    checkType(value);
    list.set(index, value);
  }

  @Override
  public final void addIndexedValue(final int index, final Object value) {
    final ArrayList<Object> list = getIndexedValue();
    checkType(value);
    list.add(index, value);
  }

  @Override
  public final void addIndexedValue(final Object value) {
    final ArrayList<Object> list = getIndexedValue();
    checkType(value);
    list.add(value);
  }

  @Override
  public final Object removeIndexedValue(final int index) {
    final ArrayList<Object> list = getIndexedValue();
    return list.remove(index);
  }

  @SuppressWarnings("unchecked")
  @Override
  public final HashMap<String, Object> getMappedValue() {
    checkKind(PropertyKind.MAPPED);
    return (HashMap<String, Object>) value;
  }

  @Override
  public final void setMappedValue(final HashMap<String, Object> map) {
    checkKind(PropertyKind.MAPPED);
    requireNonNull("map", map);
    for (final Object obj : map.values()) {
      checkType(obj);
    }
    @SuppressWarnings("unchecked")
    final HashMap<String, Object> valueMap = (HashMap<String, Object>) value;
    valueMap.clear();
    valueMap.putAll(map);
  }

  @Override
  public final Set<String> getKeySet() {
    final HashMap<String, Object> map = getMappedValue();
    return map.keySet();
  }

  @Override
  public final boolean containsKey(final String key) {
    final HashMap<String, Object> map = getMappedValue();
    return map.containsKey(key);
  }

  @Override
  public final Object getMappedValue(final String key) {
    final HashMap<String, Object> map = getMappedValue();
    return map.get(key);
  }

  @Override
  public final void setMappedValue(final String key, final Object value) {
    final HashMap<String, Object> map = getMappedValue();
    checkType(value);
    map.put(key, value);
  }

  @Override
  public final Object removeMappedValue(final String key) {
    final HashMap<String, Object> map = getMappedValue();
    return map.remove(key);
  }

  @Override
  public final void clear() {
    final PropertyKind kind = descriptor.getKind();
    switch (kind) {
      case INDEXED:
        ((List<?>) value).clear();
        break;
      case MAPPED:
        ((Map<?, ?>) value).clear();
        break;
      case SIMPLE:
      default:
        throw new InvalidPropertyKindException(descriptor.getName(), kind,
            PropertyKind.INDEXED, PropertyKind.MAPPED);
    }
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(11, 7)
        .append(descriptor)
        .append(value)
        .build();
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (obj == this) {
      return true;
    }
    if (obj.getClass() != getClass()) {
      return false;
    }
    final DefaultProperty rhs = (DefaultProperty) obj;
    return new EqualsBuilder()
        .append(descriptor, rhs.descriptor)
        .append(value, rhs.value)
        .build();
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("descriptor", descriptor)
        .append("value", value)
        .build();
  }

}
