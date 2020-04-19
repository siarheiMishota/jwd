package by.mishotaSiarhei.composite.parsing;

import by.mishotaSiarhei.composite.entity.Component;
import by.mishotaSiarhei.composite.entity.Composite;
import by.mishotaSiarhei.composite.entity.Type;

public class ParsingOnWords implements Parsing {

    private static String patternOnWords = " ";

    private static ParsingOnWords instance = new ParsingOnWords();

    public static Parsing getInstance() {
        return instance;
    }

    @Override

    public Component parse(String value) {

        Component componentSentence = new Composite(Type.SENTENCE);

        String[] words = value.split(patternOnWords);

        for (String word : words) {

            Parsing parsingOnLetters = ParsingOnLetters.getInstance();

            Component componentWord = parsingOnLetters.parse(word);
            componentSentence.add(componentWord);

        }

        return componentSentence;


    }


}
