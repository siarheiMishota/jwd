package by.mishotaSiarhei.composite.parsing;

import by.mishotaSiarhei.composite.entity.Component;
import by.mishotaSiarhei.composite.entity.Composite;
import by.mishotaSiarhei.composite.entity.Type;

public class ParsingOnParagraphs implements Parsing {

    private static ParsingOnParagraphs instance = new ParsingOnParagraphs();
    private static String patterOnParagraphs = "\n\\s\\s\\s\\s";

    public static ParsingOnParagraphs getInstance() {
        return instance;
    }

    @Override
    public Component parse(String value) {
        Component componentSentences = new Composite(Type.TEXT);

        String[] paragraphs = value.split(patterOnParagraphs);

        for (String paragraph : paragraphs) {

            Parsing parsingOnSentence = ParsingOnSentences.getInstance();

            Component componentSentence = parsingOnSentence.parse(paragraph);
            componentSentences.add(componentSentence);


        }

        return componentSentences;
    }


}
