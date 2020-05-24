package by.mishota.xml.parser.dom;

import by.mishota.composite.exception.ReadingException;
import by.mishota.xml.entity.Postcard;
import by.mishota.xml.entity.Theme;
import by.mishota.xml.entity.Type;
import by.mishota.xml.entity.Valuable;
import by.mishota.xml.parser.Parser;
import by.mishota.xml.parser.sax.SaxParser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class DomParserTest {
    List<Postcard> actualPostcards=new ArrayList<>();
    static final String PATH_TO_TEXT="src/test/java/resources/xml/postcards";

    @BeforeMethod
    public void setUp() throws ReadingException {
        Postcard.Builder builder = new Postcard.Builder();
        builder.setId(1);
        builder.setTheme(Theme.ARCHITECTURE);
        builder.setType(Type.PROMOTIONAL);
        builder.setCountry("Poland");
        builder.setYearPublication(2020);
        builder.setValuable(Valuable.THEMATIC);
        builder.setAuthors(List.of("Сидоров", "Козлов"));
        actualPostcards.add(builder.build());

        builder = new Postcard.Builder();
        builder.setId(2);
        builder.setTheme(Theme.NATURE);
        builder.setType(Type.ORDINARY);
        builder.setCountry("Belarus");
        builder.setYearPublication(2010);
        builder.setValuable(Valuable.THEMATIC);
        builder.setAuthors(List.of("Петров", "Иванов"));
        actualPostcards.add(builder.build());

        builder = new Postcard.Builder();
        builder.setId(3);
        builder.setTheme(Theme.CITY);
        builder.setType(Type.GREETING);
        builder.setCountry("Belarus");
        builder.setYearPublication(2000);
        builder.setValuable(Valuable.THEMATIC);
        builder.setAuthors(List.of("Чумаков" ));
        actualPostcards.add(builder.build());
    }

    @Test
    public void testParse() {

        Parser parser = new DomParser();
        try {
            List<Postcard> expectedPostcards = parser.parse(PATH_TO_TEXT);
            assertEquals(actualPostcards,expectedPostcards);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}