package by.mishota.xml.parser.dom;

import by.mishota.xml.entity.Postcard;
import by.mishota.xml.entity.Theme;
import by.mishota.xml.entity.Type;
import by.mishota.xml.entity.Valuable;
import by.mishota.xml.parser.Parser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomParser implements Parser {

    private static Logger logger = LogManager.getLogger();

    private List<Postcard> postcards;
    private DocumentBuilder documentBuilder;

    public DomParser() {
        postcards = new ArrayList<>();
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newDefaultInstance();

        try {
            documentBuilderFactory.setValidating(true);
            documentBuilderFactory.setIgnoringElementContentWhitespace(true);

            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            documentBuilder.setErrorHandler(new DomErrorHandler());
        } catch (ParserConfigurationException e) {
            logger.error("Parser configuration error");
        }
    }

    public List<Postcard> getPostcards() {
        return postcards;
    }

    @Override
    public List<Postcard> parse(String path) throws SAXException, IOException {

        Document doc;

        try {
            doc = documentBuilder.parse(path);
            Element root = doc.getDocumentElement();
            NodeList postcardList = root.getElementsByTagName("postcard");

            for (int i = 0; i < postcardList.getLength(); i++) {
                Element postcardElement = (Element) postcardList.item(i);
                Postcard postcard = buildPostcard(postcardElement);
                postcards.add(postcard);
            }

        } catch (SAXException e) {
            logger.error("Parsing error");
        } catch (IOException e) {
            logger.error("File isn't found, path: " + path);
        }
        return postcards;
    }

    private Postcard buildPostcard(Element postcardElement) {

        Postcard.Builder builder = new Postcard.Builder();

        builder.setId(Long.parseLong(postcardElement.getAttribute("id").substring(1)));

        String themeString = postcardElement.getAttribute("theme");
        if (!themeString.isEmpty()) {
            builder.setTheme(Theme.valueOfIgnoreCase(themeString));
        }

        String typeString = getElementTextContent(postcardElement, "type");
        if (!typeString.isEmpty()) {
            builder.setType(Type.valueOfIgnoreCase(typeString));
        }

        String country = getElementTextContent(postcardElement, "country");
        if (country.isEmpty()) {
            country = "Belarus";
        }
        builder.setCountry(country);

        try {
            builder.setYearPublication(Integer.parseInt(getElementTextContent(postcardElement, "year")));
        } catch (NumberFormatException e) {
            logger.warn("Year is incorrect at block where id=" + postcardElement.getAttribute("id"));
        }

        String valuableString = getElementTextContent(postcardElement, "valuable");
        if (!valuableString.isEmpty()) {
            builder.setValuable(Valuable.valueOfIgnoreCase(valuableString));
        }

        List<String> authors = new ArrayList<>();
        NodeList authorsNode = postcardElement.getElementsByTagName("authors");
        for (int i = 0; i < authorsNode.getLength(); i++) {
            Element authorElement = (Element) authorsNode.item(i);
            String author = getElementTextContent(authorElement, "author");
            authors.add(author);

        }

        builder.setAuthors(authors);

        return builder.build();
    }

    private String getElementTextContent(Element postcardElement, String elementName) {

        NodeList nodeList = postcardElement.getElementsByTagName(elementName);
        Node node = nodeList.item(0);
        String text = node.getTextContent();
        return text;
    }
}
