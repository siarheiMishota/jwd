package by.mishotaSiarhei.composite.parsing;

import by.mishotaSiarhei.composite.entity.Component;
import by.mishotaSiarhei.composite.entity.Composite;
import by.mishotaSiarhei.composite.entity.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParsingOnSentences implements Parsing {

    private static String patternOnSentences = "[\\.]{3}\\s|[\\.!?]\\s?";


    private static ParsingOnSentences instance = new ParsingOnSentences();

    public static Parsing getInstance() {
        return instance;
    }

    @Override
    public Component parse(String value) {

        Component componentParagraph = new Composite(Type.PARAGRAPH);

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

            Parsing parsingOnWords = ParsingOnWords.getInstance();

            Component componentSentence = parsingOnWords.parse(sentence);
            componentParagraph.add(componentSentence);


        }

        return componentParagraph;
    }

}
