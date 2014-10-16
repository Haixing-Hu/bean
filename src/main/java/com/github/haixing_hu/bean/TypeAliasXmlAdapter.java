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

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.apache.commons.lang3.ClassUtils;

/**
 * The XML adapter for the value class of the {@link PropertyDescriptor} class.
 *
 * @author Haixing Hu
 */
public final class TypeAliasXmlAdapter extends XmlAdapter<String, Class<?>> {

  @Override
  public Class<?> unmarshal(final String name) throws Exception {
    Class<?> type = TypeAliasRegistry.getType(name);
    if (type == null) {
      type = ClassUtils.getClass(name);
    }
    return type;
  }

  @Override
  public String marshal(final Class<?> type) throws Exception {
    String name = TypeAliasRegistry.getAlias(type);
    if (name == null) {
      name = type.getName();
    }
    return name;
  }

}
