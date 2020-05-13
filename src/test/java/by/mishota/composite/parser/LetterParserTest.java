package by.mishota.composite.parser;

import by.mishota.composite.entity.*;
import by.mishota.composite.parser.impl.LetterParser;
import by.mishota.composite.entity.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LetterParserTest {

    @Test
    public void testGetInstance() {
        Parser parserActual = LetterParser.getInstance();
        Parser parserExpected = LetterParser.getInstance();

        assertEquals(parserActual, parserExpected);
    }

    @Test
    public void testParse() {
        TextComponent actual=new Lexeme(LexemeType.WORD);
        actual.add(new Symbol('H', SymbolType.LETTER));
        actual.add(new Symbol('e', SymbolType.LETTER));
        actual.add(new Symbol('l', SymbolType.LETTER));
        actual.add(new Symbol('l', SymbolType.LETTER));
        actual.add(new Symbol('o', SymbolType.LETTER));

        Parser parser = LetterParser.getInstance();
        TextComponent expected = parser.parse("Hello");

        assertEquals(actual,expected);
    }
}
