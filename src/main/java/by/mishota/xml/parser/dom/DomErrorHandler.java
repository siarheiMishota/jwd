package by.mishota.xml.parser.dom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class DomErrorHandler implements ErrorHandler {
    private static Logger logger= LogManager.getLogger();
    @Override
    public void warning(SAXParseException exception) throws SAXException {
        logger.warn(exception);
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        logger.error(exception);
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        logger.error(exception);
    }
}
