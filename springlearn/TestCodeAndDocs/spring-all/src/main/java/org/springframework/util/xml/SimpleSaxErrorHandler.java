package org.springframework.util.xml;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class SimpleSaxErrorHandler implements ErrorHandler {

	public void warning(SAXParseException exception) throws SAXException {
		
	}

	public void error(SAXParseException exception) throws SAXException {
		
	}

	public void fatalError(SAXParseException exception) throws SAXException {
		
	}

}
