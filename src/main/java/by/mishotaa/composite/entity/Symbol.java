package by.mishotaa.composite.entity;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Symbol implements TextComponent {

    private Character symbol;
    private SymbolType symbolType;

    public Symbol(Character symbol, SymbolType symbolType) {
        this.symbol = symbol;
        this.symbolType = symbolType;
    }

    @Override
    public void add(TextComponent textComponent) {
        throw new UnsupportedOperationException("Cannot be added to leaf");
    }

    @Override
    public List<TextComponent> getTextComponents() {
        throw new UnsupportedOperationException("Cannot be returned components");
    }

    @Override
    public Optional<TextComponent> get(int id) {
        return Optional.of(this);
    }

    @Override
    public void remove(TextComponent textComponent) {
        throw new UnsupportedOperationException("Cannot be removed to leaf");
    }

    @Override
    public LexemeType getLexemeType() {
        return LexemeType.SYMBOL;
    }

    @Override
    public SymbolType getSymbolType() {
        return symbolType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Symbol)) return false;
        Symbol symbol = (Symbol) o;
        return Objects.equals(this.symbol, symbol.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol);
    }

    @Override
    public String toString() {
        return symbol.toString();
    }
}
