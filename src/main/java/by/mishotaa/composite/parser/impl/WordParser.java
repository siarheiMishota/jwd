package by.mishotaa.composite.parser.impl;

import by.mishotaa.composite.entity.TextComponent;
import by.mishotaa.composite.entity.Lexeme;
import by.mishotaa.composite.entity.LexemeType;
import by.mishotaa.composite.parser.Parser;

public class WordParser implements Parser {

    private static String patternOnWords = " ";
    private static WordParser instance = new WordParser();

    private Parser parserOnLetters = LetterParser.getInstance();

    public static Parser getInstance() {
        return instance;
    }

    @Override

    public TextComponent parse(String value) {
        TextComponent textComponentSentence = new Lexeme(LexemeType.SENTENCE);
        String[] words = value.split(patternOnWords);

        for (String word : words) {
            TextComponent textComponentWord = parserOnLetters.parse(word);
            textComponentSentence.add(textComponentWord);
        }
        return textComponentSentence;
    }
}