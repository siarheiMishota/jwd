package by.mishotaSiarhei.composite.parsing;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parsing {

    private static String patternForParagraph = "\n";
    private static String patternParagraphOnSentences = "[\\.]{3}\\s|[\\.!?]\\s?";
    private static String patternSentencesOnWords = " ";

    private static Parsing instance=new Parsing();

    public static Parsing getInstance(){
        return instance;
    }

    public List<String> parsingOnParagraphs(String text) {

        String[] paragraphs = text.split(patternForParagraph);
        return List.of(paragraphs);

    }


    public List<String> parsingOnSentences(String paragraph) {

        List<String> sentences = new ArrayList<>();

        Pattern patternSentence = Pattern.compile(patternParagraphOnSentences);

        Matcher matcherSentence = patternSentence.matcher(paragraph);

        int indexStartingOfSentence = 0, indexEndingOfSentence = -1;

        while (matcherSentence.find()) {

            indexEndingOfSentence = matcherSentence.end();

            String sentence = paragraph.substring(indexStartingOfSentence, indexEndingOfSentence).trim();

            indexStartingOfSentence = indexEndingOfSentence + 1;

            sentences.add(sentence);

        }

        return sentences;


    }

    public List<String> parsingOnWords(String sentence) {

        String[] paragraphs = sentence.split(patternSentencesOnWords);
        return List.of(paragraphs);

    }

    public List<Character> parsingOnLetters(String word) {

        char[] chars = word.toCharArray();

        List<Character> characters = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {

            characters.add(chars[i]);

        }

        return  characters;
    }
}
