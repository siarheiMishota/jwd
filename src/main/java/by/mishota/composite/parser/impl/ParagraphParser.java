package by.mishota.composite.parser.impl;

import by.mishota.composite.entity.Lexeme;
import by.mishota.composite.entity.TextComponent;
import by.mishota.composite.entity.LexemeType;
import by.mishota.composite.parser.Parser;

public class ParagraphParser implements Parser {

    private static final String PATTER_ON_PARAGRAPHS = "\n\\s{4}";
    private static ParagraphParser instance = new ParagraphParser();

    private Parser parserOnSentence = SentenceParser.getInstance();

    public static ParagraphParser getInstance() {
        return instance;
    }

    @Override
    public TextComponent parse(String value) {
        TextComponent textComponentSentences = new Lexeme(LexemeType.TEXT);
        String[] paragraphs = value.split(PATTER_ON_PARAGRAPHS);

        for (String paragraph : paragraphs) {
            TextComponent textComponentSentence = parserOnSentence.parse(paragraph);
            textComponentSentences.add(textComponentSentence);
        }
        return textComponentSentences;
    }
}
