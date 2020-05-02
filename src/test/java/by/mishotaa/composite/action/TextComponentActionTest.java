package by.mishotaa.composite.action;

import by.mishotaa.composite.entity.TextComponent;
import by.mishotaa.composite.exception.ReadingException;
import by.mishotaa.composite.parser.Parser;
import by.mishotaa.composite.parser.impl.ParagraphParser;
import by.mishotaa.composite.reader.TextReader;
import by.mishotaa.composite.reader.impl.TextReaderFile;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class TextComponentActionTest {
    TextAction action = new TextAction();
    TextComponent textComponent;

    @BeforeMethod
    public void setUp() throws ReadingException {
        String stringSrc = "src";
        Path path = Path.of(stringSrc, "test/java/resources/parsingText.txt");
        TextReader reading = new TextReaderFile();
        String sourceTextWithFile = reading.read(path);
        Parser parser = ParagraphParser.getInstance();
        textComponent = parser.parse(sourceTextWithFile);
    }

    @Test
    public void testGetSentencesWithTheMostLongestWord() {
        String actual = " Дистанционный формат позволит индивидуализировать процесс обучения и обеспечит мобильность при изучении материалов и выполнении заданий. " +
                "Где будут удобно располагаться все лекции, конференции , тренинги, интернет-семинаров, тестов и других материалов.";

        List<TextComponent> expectedSentences = action.findSentencesWithLongestWord(textComponent);
        StringBuilder builderExpected = new StringBuilder();

        for (TextComponent textComponentForEach : expectedSentences) {
            builderExpected.append(textComponentForEach);
        }

        assertEquals(actual, builderExpected.toString());
    }

    @Test
    public void testDeleteSentencesWhereNumberOfWordsLessThanSpecifiedValue() {
        String actual = "\n\t Для студентов станет стандартом выбирать дополнительные предметы, которые затем внесут в диплом, в количестве их никто не ограничивает," +
                " но дополнительное обучение не должно мешать основной специальности.\n" +
                "\t Также лекций скорее всего больше не будет, так как уже упоминалась , что будет платформа с необходимыми лекциями и тренингами, " +
                "которые также будут при необходимости высылаться в группу студентов.";
        action.deleteSentencesWhereNumberOfWordsLessThanSpecifiedValue(textComponent, 25);

        assertEquals(actual, textComponent.toString());

    }

    @Test
    public void testNumberOfIdenticalWor2s() {
        long actual = 43;
        long expected = action.numberOfIdenticalWords(textComponent);

        assertEquals(actual, expected);

    }
}
