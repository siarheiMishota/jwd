package by.mishota.composite.parser;

import by.mishota.composite.entity.TextComponent;

public interface Parser {
    TextComponent parse(String value);
}
