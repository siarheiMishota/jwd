package by.mishota.composite.parser.impl;

import by.mishota.composite.entity.Lexeme;
import by.mishota.composite.entity.TextComponent;
import by.mishota.composite.entity.LexemeType;
import by.mishota.composite.parser.Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser implements Parser {

    private static String patternOnSentences = "[\\.]{3}\\s|[\\.!?]\\s?";
    private static SentenceParser instance = new SentenceParser();
    public static Parser getInstance() {
        return instance;
    }

    private Parser parserOnWords = WordParser.getInstance();

    @Override
    public TextComponent parse(String value) {
        TextComponent textComponentParagraph = new Lexeme(LexemeType.PARAGRAPH);
        List<String> sentences = new ArrayList<>();

        Pattern patternSentence = Pattern.compile(patternOnSentences);
        Matcher matcherSentence = patternSentence.matcher(value);
        int indexStartingOfSentence = 0, indexEndingOfSentence;

        while (matcherSentence.find()) {
            indexEndingOfSentence = matcherSentence.end();
            String sentence = value.substring(indexStartingOfSentence, indexEndingOfSentence).trim();
            indexStartingOfSentence = indexEndingOfSentence;
            sentences.add(sentence);
        }

        for (String sentence : sentences) {
            TextComponent textComponentSentence = parserOnWords.parse(sentence);
            textComponentParagraph.add(textComponentSentence);
        }
        return textComponentParagraph;
    }
}
