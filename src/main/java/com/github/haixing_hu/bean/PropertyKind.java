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

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * The enumeration of kinds of descriptors.
 *
 * @author Haixing Hu
 */
@XmlJavaTypeAdapter(PropertyKindXmlAdapter.class)
@XmlRootElement(name = "kind")
public enum PropertyKind {

  /**
   * Represents a simple property.
   */
  SIMPLE,

  /**
   * Represents an indexed property.
   */
  INDEXED,

  /**
   * Represents a mapped property.
   */
  MAPPED,
}