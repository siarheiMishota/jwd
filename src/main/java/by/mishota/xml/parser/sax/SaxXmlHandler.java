package by.mishota.xml.parser.sax;

import by.mishota.xml.entity.*;
import by.mishota.xml.exception.SaxException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SaxXmlHandler extends DefaultHandler {

    private static Logger logger = LogManager.getLogger();
    private List<Postcard> postcards = new ArrayList<>();
    private Postcard.Builder postcardBuilder;
    private long id;
    private Theme theme;
    private List<String> authors;
    private Valuable valuable;
    private Tag tag;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (Tag.POSTCARD.toString().equalsIgnoreCase(qName)) {
            postcardBuilder = new Postcard.Builder();

            if (attributes.getLength() == 2) {
                long parsingId = Long.parseLong(attributes.getValue("id").substring(1));
                id = parsingId;
                theme = Theme.valueOfIgnoreCase(attributes.getValue("theme"));
            } else {
                long parsingId = Long.parseLong(attributes.getValue("id").substring(1));
                id = parsingId;
                theme = Theme.ANIMAL;
            }

            postcardBuilder.setId(id);
            postcardBuilder.setTheme(theme);
        } else if (Tag.AUTHORS.toString().equalsIgnoreCase(qName)) {
            authors = new ArrayList<>();
        }
        tag = Tag.valueOfIgnoreCase(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (Tag.POSTCARD.toString().equalsIgnoreCase(qName)) {
            postcardBuilder.setAuthors(authors);
            postcards.add(postcardBuilder.build());
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        String content = new String(ch, start, length).strip();
        switch (tag) {
            case TYPE:
                Type type;
                if (content.isEmpty()) {
                    type = Type.ORDINARY;
                } else {
                    type = Type.valueOfIgnoreCase(content);
                }

                postcardBuilder.setType(type);
                break;
            case COUNTRY:
                String country;
                if (content.isEmpty()) {
                    country = "Belarus";
                } else {
                    country = content;
                }

                postcardBuilder.setCountry(country);
                break;
            case YEAR:
                int year;
                if (content.isEmpty()) {
                    year = 2000;
                } else {
                    year = Integer.parseInt(content);
                }

                postcardBuilder.setYearPublication(year);
                break;
            case VALUABLE:
                Valuable valuable;
                if (content.isEmpty()) {
                    valuable = Valuable.THEMATIC;
                } else {
                    valuable = Valuable.valueOfIgnoreCase(content);
                }

                postcardBuilder.setValuable(valuable);
                break;
            case AUTHOR:
                if (!content.isEmpty()) {
                    authors.add(content);
                }
                break;
            case POSTCARDS:
            case POSTCARD:
                break;
        }
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        logger.warn("Tag isn't correct in line -"+e.getLineNumber());
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        logger.warn("Error is in line "+e.getLineNumber());
    }

    public List<Postcard> getPostcards() {
        return postcards;
    }
}
