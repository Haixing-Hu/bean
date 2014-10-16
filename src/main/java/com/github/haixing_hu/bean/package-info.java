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

/**
 * This package provides a model of dynamic beans.
 * <p>
 * It was inspired by the Apache Commons BeanUtils library, but the interface
 * and implementation was modified to satisfy our requirements.
 */
@XmlJavaTypeAdapters({
  @XmlJavaTypeAdapter(type = PropertyKind.class,
      value = PropertyKindXmlAdapter.class),
})
package com.github.haixing_hu.bean;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;

