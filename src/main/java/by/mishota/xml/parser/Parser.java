package by.mishota.xml.parser;

import by.mishota.xml.entity.Postcard;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

public interface Parser {

    List<Postcard> parse(String path) throws SAXException, IOException;
}
