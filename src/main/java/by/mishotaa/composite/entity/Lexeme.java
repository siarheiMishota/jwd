package by.mishotaa.composite.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Lexeme implements TextComponent {

    private static final String INDENT_FOR_PARAGRAPH ="\n\t";
    private static final String INDENT_FOR_WORD =" ";
    private List<TextComponent> textComponents = new ArrayList<>();
    private LexemeType lexemeType;

    public Lexeme(LexemeType lexemeType) {
        this.lexemeType = lexemeType;
    }

    @Override
    public Optional<TextComponent> get(int index) {
        if (index >= 0 && index < textComponents.size()) {
            return Optional.of(textComponents.get(index));
        }
        return Optional.empty();
    }

    @Override
    public void add(TextComponent textComponent) {
        textComponents.add(textComponent);
    }

    @Override
    public void remove(TextComponent textComponent) {
        textComponents.remove(textComponent);
    }

    @Override
    public LexemeType getLexemeType() {
        return lexemeType;
    }

    @Override
    public SymbolType getSymbolType() {
        throw new UnsupportedOperationException("Lexeme does not support this method");
    }

    @Override
    public List<TextComponent> getTextComponents() {
        return textComponents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lexeme)) return false;
        Lexeme lexeme = (Lexeme) o;
        return Objects.equals(textComponents, lexeme.textComponents) &&
                lexemeType == lexeme.lexemeType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(textComponents, lexemeType);
    }

    @Override
    public String toString() {
        StringBuilder stringComponents = new StringBuilder();
        for (TextComponent textComponent : textComponents) {
            switch (textComponent.getLexemeType()) {
                case PARAGRAPH:
                    stringComponents.append(INDENT_FOR_PARAGRAPH);
                    break;
                case WORD:
                    stringComponents.append(INDENT_FOR_WORD);
                    break;
            }
            stringComponents.append(textComponent.toString());
        }
        return stringComponents.toString();
    }
}
