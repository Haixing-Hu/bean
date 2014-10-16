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

/**
 * Thrown to indicates that a specified property does not exist.
 *
 * @author Haixing Hu
 */
public class PropertyNotExistException extends IllegalArgumentException {

  private static final long serialVersionUID = -3150292143937316123L;

  /**
   * Constructs a {@link PropertyNotExistException}.
   *
   * @param name
   *          the name of the property.
   */
  public PropertyNotExistException(final String name) {
    super("The property '" + name + "' does not exist.");
  }
}
