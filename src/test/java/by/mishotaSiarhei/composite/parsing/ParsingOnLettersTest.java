package by.mishotaSiarhei.composite.parsing;

import by.mishotaSiarhei.composite.entity.Component;
import by.mishotaSiarhei.composite.entity.Composite;
import by.mishotaSiarhei.composite.entity.Leaf;
import by.mishotaSiarhei.composite.entity.Type;
import org.testng.annotations.Test;

import javax.xml.stream.events.Comment;

import static org.testng.Assert.*;

public class ParsingOnLettersTest {

    @Test
    public void testGetInstance() {

        Parsing parsingActual=ParsingOnLetters.getInstance();
        Parsing parsingExpected=ParsingOnLetters.getInstance();

        assertEquals(parsingActual, parsingExpected);

    }

    @Test
    public void testParse() {

        Component actual=new Composite(Type.WORD);

        actual.add(new Leaf("H",Type.LETTER));
        actual.add(new Leaf("e",Type.LETTER));
        actual.add(new Leaf("l",Type.LETTER));
        actual.add(new Leaf("l",Type.LETTER));
        actual.add(new Leaf("o",Type.LETTER));

        Parsing parsing=ParsingOnLetters.getInstance();

        Component expected = parsing.parse("Hello");

        assertEquals(actual,expected);

    }
}
