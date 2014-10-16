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

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLAssert;
import org.custommonkey.xmlunit.XMLUnit;
import org.custommonkey.xmlunit.examples.RecursiveElementNameAndTextQualifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.haixing_hu.text.xml.XmlUtils;

import static org.junit.Assert.assertEquals;

/**
 * Provides functions for testing XML serialization.
 *
 * @author Haixing Hu
 */
public class XmlSerializationTest {

  protected final Logger logger;

  protected XmlSerializationTest() {
    logger = LoggerFactory.getLogger(getClass());
  }

  protected <T> String marshal(final Class<T> cls, final T object)
      throws JAXBException {
    final JAXBContext context = JAXBContext.newInstance(cls);
    final Marshaller mr = context.createMarshaller();
    mr.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
    mr.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    XMLUnit.setIgnoreWhitespace(true);
    final StringWriter writer = new StringWriter();
    mr.marshal(object, writer);
    return writer.toString();
  }

  protected <T> void testXmlMarshal(final Class<T> cls, final T object,
      final String expectedXml) throws Exception {
    final String actual = marshal(cls, object);
    logger.info("Object is:\n{}", object);
    logger.info("Expected XML is:\n{}", XmlUtils.formatXml(expectedXml));
    logger.info("Actual XML is:\n{}\n", actual);
    final Diff diff = new Diff(expectedXml, actual);
    // we don't care about ordering
    diff.overrideElementQualifier(new RecursiveElementNameAndTextQualifier());
    XMLAssert.assertXMLEqual(diff, true);
  }

  @SuppressWarnings("unchecked")
  protected <T> T unmarshal(final Class<T> cls, final String xml)
      throws JAXBException {
    final JAXBContext context = JAXBContext.newInstance(cls);
    final Unmarshaller umr = context.createUnmarshaller();
    final StringReader reader = new StringReader(xml);
    return (T) umr.unmarshal(reader);
  }

  protected <T> void testXmlUnmarshal(final Class<T> cls, final String xml,
      final T expectedObject) throws Exception {
    final T actual = unmarshal(cls, xml);
    logger.info("XML is:\n{}", XmlUtils.formatXml(xml));
    logger.info("Expecte object is:\n{}", expectedObject);
    logger.info("Actual object is:\n{}\n", actual);
    assertEquals(expectedObject, actual);
  }
}
