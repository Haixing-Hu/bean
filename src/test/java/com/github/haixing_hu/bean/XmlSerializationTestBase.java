/*
 * Copyright (C) 2014 Haixing Hu
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
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
 * The base class for the unit test of XML serialization.
 *
 * @author Haixing Hu
 */
public class XmlSerializationTestBase {

  protected final Logger logger;

  protected XmlSerializationTestBase() {
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
