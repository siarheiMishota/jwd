package by.mishota.xml.parser.stax;

import by.mishota.xml.entity.*;
import by.mishota.xml.parser.Parser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StaxParser implements Parser {
    private static Logger logger = LogManager.getLogger();

    private List<Postcard> postcards;
    private XMLInputFactory inputFactory;

    public StaxParser() {
        postcards = new ArrayList<>();
        inputFactory = XMLInputFactory.newInstance();
    }

    public List<Postcard> getPostcards() {
        return postcards;
    }

    @Override
    public List<Postcard> parse(String path) {
        FileInputStream inputStream = null;
        XMLStreamReader reader;
        String name;

        try {
            inputStream = new FileInputStream(new File(path));
            reader = inputFactory.createXMLStreamReader(inputStream);

            while (reader.hasNext()) {
                int type = reader.next();

                if (XMLStreamConstants.START_ELEMENT == type) {
                    name = reader.getLocalName();
                    if (Tag.POSTCARD == Tag.valueOfIgnoreCase(name)) {
                        Postcard postcard = buildPostcard(reader);
                        postcards.add(postcard);
                    }
                }
            }
        } catch (XMLStreamException e) {
            logger.error("File isn't found");
        } catch (FileNotFoundException e) {
            logger.error("File " + path + " not found! :" + e);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                logger.error("Impossible close the file -" + path + " :" + e);
            }
        }
        return postcards;
    }

    private Postcard buildPostcard(XMLStreamReader reader) throws XMLStreamException {
        Postcard.Builder builder = new Postcard.Builder();

        builder.setId(Long.parseLong(reader.getAttributeValue(null, Tag.ID.toString().toLowerCase()).substring(1)));

        String themeString = reader.getAttributeValue(null, Tag.THEME.toString());
        if (themeString != null) {
            builder.setTheme(Theme.valueOfIgnoreCase(themeString));
        }

        String name;
        List<String> authors = null;

        while (reader.hasNext()) {
            int type = reader.next();

            if (XMLStreamConstants.START_ELEMENT == type) {
                name = reader.getLocalName();

                switch (Tag.valueOfIgnoreCase(name)) {
                    case TYPE:
                        String typeString = getXmlText(reader);
                        if (typeString.isEmpty()) {
                            logger.warn("Type is empty and it has default value= ORDINARY");
                        } else {
                            builder.setType(Type.valueOfIgnoreCase(typeString));
                        }
                        break;
                    case COUNTRY:

                        String country = getXmlText(reader);
                        if (country.isEmpty()) {
                            logger.warn("Country is empty and it has default value= Belarus");
                        } else {
                            builder.setCountry(country);
                        }
                        break;
                    case YEAR:

                        String yearString = getXmlText(reader);
                        if (yearString.isEmpty()) {
                            logger.warn("Year publication is empty and it has default value= 2000");
                        } else {
                            builder.setYearPublication(Integer.parseInt(yearString));
                        }
                        break;
                    case VALUABLE:

                        String valuableString = getXmlText(reader);
                        if (valuableString.isEmpty()) {
                            logger.warn("Valuable is empty and it has default value= THEMATIC");
                        } else {
                            builder.setValuable(Valuable.valueOfIgnoreCase(valuableString));
                        }
                        break;
                    case AUTHORS:
                        authors = new ArrayList<>();
                        break;
                    case AUTHOR:
                        String author = getXmlText(reader);
                        if (!author.isEmpty()) {
                            authors.add(author);
                        }
                        break;
                }
            } else if (XMLStreamConstants.END_ELEMENT == type) {
                name = reader.getLocalName();
                if (Tag.AUTHORS == Tag.valueOfIgnoreCase(name)) {
                    builder.setAuthors(authors);
                }
            }
        }
        return builder.build();
    }

    private String getXmlText(XMLStreamReader reader) throws XMLStreamException {
        return reader.getElementText();
    }
}
