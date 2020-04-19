package by.mishotaSiarhei.composite.parsing;

import by.mishotaSiarhei.composite.entity.Component;
import by.mishotaSiarhei.composite.entity.Composite;
import by.mishotaSiarhei.composite.entity.Leaf;
import by.mishotaSiarhei.composite.entity.Type;
import org.testng.annotations.Test;

import java.text.spi.CollatorProvider;

import static org.testng.Assert.assertEquals;

public class ParsingOnWordsTest {

    @Test
    public void testGetInstance() {

        Parsing parsingActual = ParsingOnWords.getInstance();
        Parsing parsingExpected = ParsingOnWords.getInstance();

        assertEquals(parsingActual, parsingExpected);

    }

    @Test
    public void testParse() {

        Component actual=new Composite(Type.SENTENCE);

        Component wordOne=new Composite(Type.WORD);
        wordOne.add(new Leaf("H",Type.LETTER));
        wordOne.add(new Leaf("e",Type.LETTER));
        wordOne.add(new Leaf("l",Type.LETTER));
        wordOne.add(new Leaf("l",Type.LETTER));
        wordOne.add(new Leaf("o",Type.LETTER));
        wordOne.add(new Leaf(",",Type.PUNCTUATION));
        actual.add(wordOne);

        Component wordTwo=new Composite(Type.WORD);
        wordTwo.add(new Leaf("h",Type.LETTER));
        wordTwo.add(new Leaf("o",Type.LETTER));
        wordTwo.add(new Leaf("w",Type.LETTER));
        actual.add(wordTwo);

        Component wordThree=new Composite(Type.WORD);
        wordThree.add(new Leaf("a",Type.LETTER));
        wordThree.add(new Leaf("r",Type.LETTER));
        wordThree.add(new Leaf("e",Type.LETTER));
        actual.add(wordThree);

        Component wordFour=new Composite(Type.WORD);
        wordFour.add(new Leaf("y",Type.LETTER));
        wordFour.add(new Leaf("o",Type.LETTER));
        wordFour.add(new Leaf("u",Type.LETTER));
        wordFour.add(new Leaf("?",Type.PUNCTUATION));
        actual.add(wordFour);

        Parsing parsing=ParsingOnWords.getInstance();

        Component expected = parsing.parse("Hello, how are you?");

        assertEquals(actual,expected);
    }
}
