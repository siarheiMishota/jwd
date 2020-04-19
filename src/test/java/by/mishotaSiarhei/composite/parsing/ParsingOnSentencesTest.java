package by.mishotaSiarhei.composite.parsing;

import by.mishotaSiarhei.composite.entity.Component;
import by.mishotaSiarhei.composite.entity.Composite;
import by.mishotaSiarhei.composite.entity.Leaf;
import by.mishotaSiarhei.composite.entity.Type;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ParsingOnSentencesTest {

    @Test
    public void testGetInstance() {

        Parsing parsingActual = ParsingOnSentences.getInstance();
        Parsing parsingExpected = ParsingOnSentences.getInstance();

        assertEquals(parsingActual, parsingExpected);

    }

    @Test
    public void testParse() {

        Component actual = new Composite(Type.PARAGRAPH);

        for (int i = 0; i < 10; i++) {


            Component sentence = new Composite(Type.SENTENCE);
            Component wordOne = new Composite(Type.WORD);
            Component wordTwo = new Composite(Type.WORD);
            Component wordThree = new Composite(Type.WORD);
            Component wordFour = new Composite(Type.WORD);

            wordOne.add(new Leaf("H",Type.LETTER));
            wordOne.add(new Leaf("e",Type.LETTER));
            wordOne.add(new Leaf("l",Type.LETTER));
            wordOne.add(new Leaf("l",Type.LETTER));
            wordOne.add(new Leaf("o",Type.LETTER));
            wordOne.add(new Leaf(",",Type.PUNCTUATION));
            wordTwo.add(new Leaf("h",Type.LETTER));
            wordTwo.add(new Leaf("o",Type.LETTER));
            wordTwo.add(new Leaf("w",Type.LETTER));
            wordThree.add(new Leaf("a",Type.LETTER));
            wordThree.add(new Leaf("r",Type.LETTER));
            wordThree.add(new Leaf("e",Type.LETTER));
            wordFour.add(new Leaf("y",Type.LETTER));
            wordFour.add(new Leaf("o",Type.LETTER));
            wordFour.add(new Leaf("u",Type.LETTER));
            wordFour.add(new Leaf("?",Type.PUNCTUATION));

            sentence.add(wordOne);
            sentence.add(wordTwo);
            sentence.add(wordThree);
            sentence.add(wordFour);

            actual.add(sentence);
        }

        Parsing parsing = ParsingOnSentences.getInstance();

        Component expected = parsing.parse("Hello, how are you? Hello, how are you? Hello, how are you? Hello, how are you? Hello, how are you? Hello, how are you? Hello, how are you? Hello, how are you? Hello, how are you? Hello, how are you?");

        assertEquals(actual, expected);
    }

}
