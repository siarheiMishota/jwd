package by.mishotaa.composite.action;

import by.mishotaa.composite.entity.SymbolType;
import by.mishotaa.composite.entity.TextComponent;

import java.util.*;

public class TextAction {
    public void sortParagraphsByNumberSentences(TextComponent textComponent) {
        textComponent.getTextComponents().sort(Comparator.comparingInt(a -> a.getTextComponents().size()));
    }

    public List<TextComponent> findSentencesWithLongestWord(TextComponent textComponent) {
        int maxWordLength = -1;
        List<TextComponent> sentencesWithTheMostLongestWord = new ArrayList<>();

        List<TextComponent> paragraphs = textComponent.getTextComponents();

        for (TextComponent paragraph : paragraphs) {
            List<TextComponent> sentences = paragraph.getTextComponents();

            for (TextComponent sentence : sentences) {
                List<TextComponent> words = sentence.getTextComponents();

                for (TextComponent word : words) {
                    if (word.getTextComponents().size() > maxWordLength) {

                        maxWordLength = word.getTextComponents().size();
                        sentencesWithTheMostLongestWord.clear();
                        sentencesWithTheMostLongestWord.add(sentence);
                    } else if (word.getTextComponents().size() == maxWordLength) {
                        sentencesWithTheMostLongestWord.add(sentence);
                    }
                }
            }
        }
        return sentencesWithTheMostLongestWord;
    }

    public void deleteSentencesWhereNumberOfWordsLessThanSpecifiedValue(TextComponent textComponent, int specifiedValue) {
        List<TextComponent> paragraphs = textComponent.getTextComponents();

        for (TextComponent paragraph : paragraphs) {
            List<TextComponent> sentences = paragraph.getTextComponents();
            sentences.removeIf(componentLambda -> componentLambda.getTextComponents().size() < specifiedValue);
        }
        textComponent.getTextComponents().removeIf(nextParagraph -> nextParagraph.getTextComponents().isEmpty());
    }

    public long numberOfIdenticalWords(TextComponent textComponent) {

        Map<String, Integer> identicalWordsInText = new HashMap<>();
        List<TextComponent> paragraphs = textComponent.getTextComponents();

        for (TextComponent paragraph : paragraphs) {
            List<TextComponent> sentences = paragraph.getTextComponents();

            for (TextComponent sentence : sentences) {
                List<TextComponent> words = sentence.getTextComponents();

                for (TextComponent word : words) {
                    String strWord;

                    if (hasPunctuation(word)) {
                        StringBuilder builderWord = new StringBuilder();
                        for (TextComponent textComponentBuilder : word.getTextComponents()) {
                            if (textComponentBuilder.getSymbolType() != SymbolType.PUNCTUATION) {
                                builderWord.append(textComponentBuilder);
                            }
                        }
                        strWord = builderWord.toString();
                    } else {
                        strWord = word.toString();
                    }

                    if (identicalWordsInText.containsKey(strWord)) {

                        identicalWordsInText.put(strWord, identicalWordsInText.get(strWord) + 1);
                    } else {

                        identicalWordsInText.put(strWord, 1);
                    }
                }
            }
        }
        return identicalWordsInText.values().stream().filter(a -> a > 1).count();
    }

    private boolean hasPunctuation(TextComponent word) {
        return word.get(word.getTextComponents().size() - 1).get().getSymbolType() == SymbolType.PUNCTUATION;
    }
}
