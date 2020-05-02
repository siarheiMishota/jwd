package by.mishota.composite.parser;

import by.mishota.composite.entity.*;
import by.mishota.composite.parser.impl.ParagraphParser;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ParagraphParserTest {

    @Test
    public void testGetInstance() {
        Parser parserActual = ParagraphParser.getInstance();
        Parser parserExpected = ParagraphParser.getInstance();

        assertEquals(parserActual, parserExpected);
    }

    @Test
    public void testParse() {
        TextComponent actual = new Lexeme(LexemeType.TEXT);

        for (int j = 0; j < 4; j++) {
            TextComponent paragraph = new Lexeme(LexemeType.PARAGRAPH);
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

                paragraph.add(sentence);
            }
            actual.add(paragraph);
        }
        Parser parser = ParagraphParser.getInstance();
        TextComponent expected = parser.parse("Hello, how are you? Hello, how are you? Hello, how are you? Hello, how are you? Hello, how are you? Hello, how are you? Hello, how are you? Hello, how are you? Hello, how are you? Hello, how are you?\n    " +
                "Hello, how are you? Hello, how are you? Hello, how are you? Hello, how are you? Hello, how are you? Hello, how are you? Hello, how are you? Hello, how are you? Hello, how are you? Hello, how are you?\n    " +
                "Hello, how are you? Hello, how are you? Hello, how are you? Hello, how are you? Hello, how are you? Hello, how are you? Hello, how are you? Hello, how are you? Hello, how are you? Hello, how are you?\n    " +
                "Hello, how are you? Hello, how are you? Hello, how are you? Hello, how are you? Hello, how are you? Hello, how are you? Hello, how are you? Hello, how are you? Hello, how are you? Hello, how are you?\n    ");

        assertEquals(actual, expected);
    }
}
