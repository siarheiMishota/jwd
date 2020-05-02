package by.mishotaa.composite.parser;

import by.mishota.composite.entity.*;
import by.mishotaa.composite.parser.impl.WordParser;
import by.mishotaa.composite.entity.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WordParserTest {

    @Test
    public void testGetInstance() {
        Parser parserActual = WordParser.getInstance();
        Parser parserExpected = WordParser.getInstance();

        assertEquals(parserActual, parserExpected);
    }

    @Test
    public void testParse() {
        TextComponent actual=new Lexeme(LexemeType.SENTENCE);
        TextComponent wordOne=new Lexeme(LexemeType.WORD);

        wordOne.add(new Symbol('H', SymbolType.LETTER));
        wordOne.add(new Symbol('e', SymbolType.LETTER));
        wordOne.add(new Symbol('l', SymbolType.LETTER));
        wordOne.add(new Symbol('l', SymbolType.LETTER));
        wordOne.add(new Symbol('o', SymbolType.LETTER));
        wordOne.add(new Symbol(',', SymbolType.PUNCTUATION));
        actual.add(wordOne);

        TextComponent wordTwo=new Lexeme(LexemeType.WORD);
        wordTwo.add(new Symbol('h', SymbolType.LETTER));
        wordTwo.add(new Symbol('o', SymbolType.LETTER));
        wordTwo.add(new Symbol('w', SymbolType.LETTER));
        actual.add(wordTwo);

        TextComponent wordThree=new Lexeme(LexemeType.WORD);
        wordThree.add(new Symbol('a', SymbolType.LETTER));
        wordThree.add(new Symbol('r', SymbolType.LETTER));
        wordThree.add(new Symbol('e', SymbolType.LETTER));
        actual.add(wordThree);

        TextComponent wordFour=new Lexeme(LexemeType.WORD);
        wordFour.add(new Symbol('y', SymbolType.LETTER));
        wordFour.add(new Symbol('o', SymbolType.LETTER));
        wordFour.add(new Symbol('u', SymbolType.LETTER));
        wordFour.add(new Symbol('?', SymbolType.PUNCTUATION));
        actual.add(wordFour);

        Parser parser = WordParser.getInstance();
        TextComponent expected = parser.parse("Hello, how are you?");

        assertEquals(actual,expected);
    }
}
