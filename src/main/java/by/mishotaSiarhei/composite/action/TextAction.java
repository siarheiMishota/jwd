package by.mishotaSiarhei.composite.action;

import by.mishotaSiarhei.composite.entity.Component;
import by.mishotaSiarhei.composite.entity.Type;

import java.util.*;

public class TextAction {

    private Component text;

    public TextAction(Component text) {
        this.text = text;
    }

    public void sortParagraphsByNumberSentences() {


        text.getComponents().sort(Comparator.comparingInt(a -> a.getComponents().size()));

    }

    public List<Component> getSentencesWithTheMostLongestWord() {

        int maxWordLength = -1;
        List<Component> sentencesWithTheMostLongestWord = new ArrayList<>();

        List<Component> paragraphs = text.getComponents();

        for (Component paragraph : paragraphs) {

            List<Component> sentences = paragraph.getComponents();

            for (Component sentence : sentences) {

                List<Component> words = sentence.getComponents();

                for (Component word : words) {

                    if (word.getComponents().size() > maxWordLength) {

                        maxWordLength = word.getComponents().size();
                        sentencesWithTheMostLongestWord.clear();
                        sentencesWithTheMostLongestWord.add(sentence);


                    } else if (word.getComponents().size() == maxWordLength) {

                        sentencesWithTheMostLongestWord.add(sentence);

                    }

                }

            }

        }

        return sentencesWithTheMostLongestWord;

    }

    public void deleteSentencesWhereNumberOfWordsLessThanSpecifiedValue(int specifiedValue) {


        List<Component> paragraphs = text.getComponents();

        for (Component paragraph : paragraphs) {

            List<Component> sentences = paragraph.getComponents();
            sentences.removeIf(component -> component.getComponents().size() < specifiedValue);

        }

        text.getComponents().removeIf(nextParagraph -> nextParagraph.getComponents().isEmpty());

    }

    public long numberOfIdenticalWords() {

        Map<String, Integer> identicalWords = new HashMap<>();

        List<Component> paragraphs = text.getComponents();

        for (Component paragraph : paragraphs) {

            List<Component> sentences = paragraph.getComponents();

            for (Component sentence : sentences) {

                List<Component> words = sentence.getComponents();

                for (Component word : words) {

                    String strWord;

                    if (hasPunctuation(word)) {

                        StringBuilder builderWord = new StringBuilder();

                        for (Component component : word.getComponents()) {

                            if (component.getType() != Type.PUNCTUATION) {
                                builderWord.append(component);
                            }

                        }

                        strWord = builderWord.toString();

                    } else {
                        strWord = word.toString();
                    }

                    if (identicalWords.containsKey(strWord)) {

                        identicalWords.put(strWord, identicalWords.get(strWord) + 1);
                    } else {

                        identicalWords.put(strWord, 1);
                    }

                }

            }

        }

        return identicalWords.values().stream().filter(a -> a > 1).count();
    }

    private boolean hasPunctuation(Component word) {
        return word.get(word.getComponents().size() - 1).get().getType() == Type.PUNCTUATION;
    }
}
