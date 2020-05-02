package by.mishota.composite.parser;

import by.mishota.composite.entity.*;
import by.mishota.composite.parser.impl.SentenceParser;
import by.mishotaa.composite.entity.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SentenceParserTest {

    @Test
    public void testGetInstance() {
        Parser parserActual = SentenceParser.getInstance();
        Parser parserExpected = SentenceParser.getInstance();

        assertEquals(parserActual, parserExpected);
    }

    @Test
    public void testParse() {
        TextComponent actual = new Lexeme(LexemeType.PARAGRAPH);

        for (int i = 0; i < 10; i++) {
            TextComponent sentence = new Lexeme(LexemeType.SENTENCE);
            TextComponent wordOne = new Lexeme(LexemeType.WORD);
            TextComponent wordTwo = new Lexeme(LexemeType.WORD);
            TextComponent wordThree = new Lexeme(LexemeType.WORD);
            TextComponent wordFour = new Lexeme(LexemeType.WORD);

            wordOne.add(new Symbol('H', SymbolType.LETTER));
            wordOne.add(new Symbol('e', SymbolType.LETTER));
            wordOne.add(new Symbol('l', SymbolType.LETTER));
            wordOne.add(new Symbol('l', SymbolType.LETTER));
            wordOne.add(new Symbol('o', SymbolType.LETTER));
            wordOne.add(new Symbol(',', SymbolType.PUNCTUATION));
            wordTwo.add(new Symbol('h', SymbolType.LETTER));
            wordTwo.add(new Symbol('o', SymbolType.LETTER));
            wordTwo.add(new Symbol('w', SymbolType.LETTER));
            wordThree.add(new Symbol('a', SymbolType.LETTER));
            wordThree.add(new Symbol('r', SymbolType.LETTER));
            wordThree.add(new Symbol('e', SymbolType.LETTER));
            wordFour.add(new Symbol('y', SymbolType.LETTER));
            wordFour.add(new Symbol('o', SymbolType.LETTER));
            wordFour.add(new Symbol('u', SymbolType.LETTER));
            wordFour.add(new Symbol('?', SymbolType.PUNCTUATION));

            sentence.add(wordOne);
            sentence.add(wordTwo);
            sentence.add(wordThree);
            sentence.add(wordFour);

            actual.add(sentence);
        }

        Parser parser = SentenceParser.getInstance();
        TextComponent expected = parser.parse("Hello, how are you? Hello, how are you? Hello, how are you? Hello, how are you? Hello, how are you? Hello, how are you? Hello, how are you? Hello, how are you? Hello, how are you? Hello, how are you?");

        assertEquals(actual, expected);
    }
}
