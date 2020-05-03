package by.mishota.composite.parser.impl;

import by.mishota.composite.entity.*;
import by.mishota.composite.parser.Parser;

import java.util.regex.Pattern;

public class LetterParser implements Parser {

    private static final String PATTER_ON_LETTERS = "";
    private static final String PATTER_ON_PUNCTUATION = "\\.{3}|[\\.!?,]";
    private static LetterParser instance = new LetterParser();

    public static Parser getInstance() {
        return instance;
    }

    @Override
    public TextComponent parse(String value) {
        TextComponent textComponentWord = new Lexeme(LexemeType.WORD);
        String[] letters = value.split(PATTER_ON_LETTERS);

        for (String letter : letters) {
            TextComponent textComponent;

            if (Pattern.matches(PATTER_ON_PUNCTUATION, letter)) {
                textComponent = new Symbol(letter.charAt(0), SymbolType.PUNCTUATION);
            } else {
                textComponent = new Symbol(letter.charAt(0), SymbolType.LETTER);
            }
            textComponentWord.add(textComponent);
        }
        return textComponentWord;
    }
}
