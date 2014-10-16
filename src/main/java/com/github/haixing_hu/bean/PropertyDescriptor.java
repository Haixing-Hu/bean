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

import java.io.Serializable;
import java.util.regex.Pattern;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import static com.github.haixing_hu.lang.Argument.requireNonEmpty;
import static com.github.haixing_hu.lang.Argument.requireNonNull;

/**
 * A {@link PropertyDescriptor} object represents the descriptor of a property
 * of a bean.
 * <p>
 * There are three kinds of descriptors supported by this library:
 * <ul>
 * <li><b>Simple</b> - Simple, or scalar, descriptors have a single value that
 * may be retrieved or modified. The underlying property type might be a Java
 * language primitive (such as {@code int}, a simple object (such as a
 * {@code String}), or a more complex object whose class is defined either by
 * the Java language, by the application, or by a class library included with
 * the application.</li>
 * <li><b>Indexed</b> - An indexed property stores an ordered collection of
 * objects (all of the same type) that can be individually accessed by an
 * integer-valued, non-negative index (or subscript). Alternatively, the entire
 * set of values may be set or retrieved using an array. As an extension to the
 * JavaBeans specification, the BeanUtils package considers any property whose
 * underlying data type is java.util.List (or an implementation of List) to be
 * indexed as well.</li>
 * <li><b>Mapped</b> - As an extension to standard JavaBeans APIs, this library
 * considers any property whose underlying value is a {@link java.util.Map} to
 * be "mapped". You can set and retrieve individual values via a {@link String}
 * valued key.</li>
 * </ul>
 * <h2>XML Serialization</h2>
 * A {@link PropertyDescriptor} instance can be serialized to and from XML. The
 * XML representation of a {@link PropertyDescriptor} has the following shap:
 *
 * <pre>
 * <code>
 * &lt;property&gt;
 *     &lt;name&gt;prop&lt;/name&gt;
 *     &lt;type&gt;string&lt;/type&gt;
 *     &lt;kind&gt;indexed&lt;/kind&gt;
 * &lt;/property&gt;
 * </code>
 * </pre>
 *
 * Where the content of the {@code <type>} tag could be either the alias of a
 * type, or the full name (including the package name) of the class of a type.
 * The alias of a type could be registered by calling the
 * {@link TypeAliasRegistry#register(String, Class)} function. The following
 * common used types has been registered with aliases:
 * <ul>
 * <li>{@code java.lang.Boolean} - alias {@code "boolean"}</li>
 * <li>{@code java.lang.Byte} - alias {@code "byte"}</li>
 * <li>{@code java.lang.Short} - alias {@code "short"}</li>
 * <li>{@code java.lang.Integer} - alias {@code "int"}</li>
 * <li>{@code java.lang.Long} - alias {@code "long"}</li>
 * <li>{@code java.lang.Float} - alias {@code "float"}</li>
 * <li>{@code java.lang.Double} - alias {@code "double"}</li>
 * <li>{@code java.math.BigInteger} - alias {@code "bigint"}</li>
 * <li>{@code java.math.BigDecimal} - alias {@code "bigdecimal"}</li>
 * <li>{@code java.lang.String} - alias {@code "string"}</li>
 * <li>{@code java.lang.Class} - alias {@code "class"}</li>
 * </ul>
 *
 * @author Haixing Hu
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "property")
public final class PropertyDescriptor implements Serializable {

  private static final long serialVersionUID = 3888156978033183567L;

  private static final Pattern NAME_PATTERN =
      Pattern.compile("[a-zA-Z_][a-zA-Z_0-9-]*");

  /**
   * Tests whether a name is a valid property name.
   * <p>
   * A valid property name should starts with an ASCII alphabetic character or
   * an underscore, and followed by zero or more alphabetic characters, digital
   * characters, underscores, or hyphens. Formally, its syntax is as follows:
   *
   * <pre>
   * <code>
   * name ::= [a-zA-Z_][a-zA-Z_0-9-]*
   * </code>
   * </pre>
   *
   * @param name
   *          the name to be test.
   * @return {@code true} if the name is a valid property name; {@code false}
   *         otherwise.
   */
  public static boolean isValidName(final String name) {
    if ((name == null) || (name.length() == 0)) {
      return false;
    }
    return (NAME_PATTERN.matcher(name).matches());
  }

  @XmlElement(name = "name", required = true)
  private final String name;

  @XmlJavaTypeAdapter(TypeAliasXmlAdapter.class)
  @XmlElement(name = "type", required = true)
  private final Class<?> type;

  @XmlJavaTypeAdapter(PropertyKindXmlAdapter.class)
  @XmlElement(name = "kind", required = false, defaultValue = "simple")
  private final PropertyKind kind;

  /**
   * A default constructor used by the JAXB.
   */
  PropertyDescriptor() {
    name = StringUtils.EMPTY;
    type = String.class;
    kind = PropertyKind.SIMPLE;
  }

  /**
   * Constructs a simple {@link PropertyDescriptor}.
   *
   * @param name
   *          the name of the property, which cannot be {@code null} nor empty.
   * @param type
   *          the type of the values stored in the property, which cannot be
   *          {@code null}.
   * @throws NullPointerException
   *           if {@code name} or {@code type} is {@code null}.
   * @throws IllegalArgumentException
   *           if {@code name} is not a valid property name.
   * @see #isValidName(String)
   */
  public PropertyDescriptor(final String name, final Class<?> type) {
    this(name, type, PropertyKind.SIMPLE);
  }

  /**
   * Constructs a {@link PropertyDescriptor} of the specified kind.
   *
   * @param name
   *          the name of the property, which cannot be {@code null} and must be
   *          a valid property name.
   * @param type
   *          the type of the values stored in the property, which cannot be
   *          {@code null}.
   * @param kind
   *          the kind of the property, which cannot be {@code null}.
   * @throws NullPointerException
   *           if {@code name}, {@code type}, or {@code kind} is {@code null}.
   * @throws IllegalArgumentException
   *           if {@code name} is not a valid property name.
   * @see #isValidName(String)
   */
  public PropertyDescriptor(final String name, final Class<?> type,
      final PropertyKind kind) {
    this.name = requireNonEmpty("name", name);
    this.type = requireNonNull("type", type);
    this.kind = requireNonNull("kind", kind);
    if (!isValidName(name)) {
      throw new IllegalArgumentException("Invalid property name: " + name);
    }
  }

  /**
   * Gets the name of this property.
   *
   * @return the name of this property.
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the type of values stored in this property.
   *
   * @return the type of values stored in this property.
   */
  public Class<?> getType() {
    return type;
  }

  /**
   * Gets the kind of this property.
   *
   * @return the kind of this property.
   */
  public PropertyKind getKind() {
    return kind;
  }

  /**
   * Tests whether this property is a simple property.
   *
   * @return {@code true} if this property is a simple property; {@code false}
   *         otherwise.
   */
  public boolean isSimple() {
    return kind == PropertyKind.SIMPLE;
  }

  /**
   * Tests whether this property is an indexed property.
   *
   * @return {@code true} if this property is an indexed property; {@code false}
   *         otherwise.
   */
  public boolean isIndexed() {
    return kind == PropertyKind.INDEXED;
  }

  /**
   * Tests whether this property is a mapped property.
   *
   * @return {@code true} if this property is a mapped property; {@code false}
   *         otherwise.
   */
  public boolean isMapped() {
    return kind == PropertyKind.MAPPED;
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(11, 13)
        .append(name)
        .append(type)
        .append(kind)
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
    final PropertyDescriptor rhs = (PropertyDescriptor) obj;
    return new EqualsBuilder()
        .append(name, rhs.name)
        .append(type, rhs.type)
        .append(kind, rhs.kind)
        .build();
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("name", name)
        .append("type", type)
        .append("kind", kind)
        .build();
  }
}
