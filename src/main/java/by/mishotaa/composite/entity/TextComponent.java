package by.mishotaa.composite.entity;

import java.util.List;
import java.util.Optional;

public interface TextComponent {

    void add(TextComponent textComponent);

    Optional<TextComponent> get(int id);

    void remove(TextComponent textComponent);

    LexemeType getLexemeType();

    SymbolType getSymbolType();

    List<TextComponent> getTextComponents();
}
