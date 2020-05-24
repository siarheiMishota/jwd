package by.mishota.xml.parser.sax;

import by.mishota.xml.entity.Postcard;
import by.mishota.xml.parser.Parser;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

public class SaxParser implements Parser {

    @Override
    public List<Postcard> parse(String path) throws SAXException, IOException {
        XMLReader xmlReader = XMLReaderFactory.createXMLReader();
        SaxXmlHandler handler = new SaxXmlHandler();
        xmlReader.setContentHandler(handler);
        xmlReader.parse(path);
        return handler.getPostcards();
    }
}
