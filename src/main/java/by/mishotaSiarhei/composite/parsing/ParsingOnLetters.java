package by.mishotaSiarhei.composite.parsing;

import by.mishotaSiarhei.composite.entity.Component;
import by.mishotaSiarhei.composite.entity.Composite;
import by.mishotaSiarhei.composite.entity.Leaf;
import by.mishotaSiarhei.composite.entity.Type;

import java.util.regex.Pattern;

public class ParsingOnLetters implements Parsing {

    private static String patterOnLetters = "";
    private static String patterOnPunctuation = "\\.{3}|[\\.!?,]";
    private static ParsingOnLetters instance = new ParsingOnLetters();

    public static Parsing getInstance() {
        return instance;
    }


    @Override
    public Component parse(String value) {

        Component componentWord = new Composite(Type.WORD);

        String[] letters = value.split(patterOnLetters);

        for (String letter : letters) {

            Component component;
            if (Pattern.matches(patterOnPunctuation, letter)) {

                component = new Leaf(letter, Type.PUNCTUATION);
            } else {
                component = new Leaf(letter, Type.LETTER);
            }

            componentWord.add(component);

        }

        return componentWord;
    }

    public static void main(String[] args) {
        Parsing parsing=ParsingOnLetters.getInstance();

        Component parse = parsing.parse("hello.");
        System.out.println(parse);
    }


}
