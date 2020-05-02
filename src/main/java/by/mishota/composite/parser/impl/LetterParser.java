package by.mishota.composite.parser.impl;

import by.mishota.composite.entity.*;
import by.mishota.composite.parser.Parser;
import by.mishotaa.composite.entity.*;

import java.util.regex.Pattern;

public class LetterParser implements Parser {

    private static String patterOnLetters = "";
    private static String patterOnPunctuation = "\\.{3}|[\\.!?,]";
    private static LetterParser instance = new LetterParser();

    public static Parser getInstance() {
        return instance;
    }


    @Override
    public TextComponent parse(String value) {
        TextComponent textComponentWord = new Lexeme(LexemeType.WORD);
        String[] letters = value.split(patterOnLetters);

        for (String letter : letters) {
            TextComponent textComponent;

            if (Pattern.matches(patterOnPunctuation, letter)) {
                textComponent = new Symbol(letter.charAt(0), SymbolType.PUNCTUATION);
            } else {
                textComponent = new Symbol(letter.charAt(0), SymbolType.LETTER);
            }
            textComponentWord.add(textComponent);
        }
        return textComponentWord;
    }
}
