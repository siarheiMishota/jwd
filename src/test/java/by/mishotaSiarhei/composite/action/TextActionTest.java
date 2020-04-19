package by.mishotaSiarhei.composite.action;

import by.mishotaSiarhei.composite.entity.Component;
import by.mishotaSiarhei.composite.exception.ReadingException;
import by.mishotaSiarhei.composite.parsing.Parsing;
import by.mishotaSiarhei.composite.parsing.ParsingOnParagraphs;
import by.mishotaSiarhei.composite.reading.TextReading;
import by.mishotaSiarhei.composite.reading.TextReadingFile;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class TextActionTest {


    TextAction action;
    Component componentText;

    @BeforeMethod
    public void setUp() throws ReadingException {

        Path path = Path.of("src/test/java/resources/parsingText.txt");
        TextReading reading = new TextReadingFile(path);
        String sourceTextWithFile = reading.get();
        Parsing parsing = ParsingOnParagraphs.getInstance();
        componentText = parsing.parse(sourceTextWithFile);
        action = new TextAction(componentText);

    }

    @Test
    public void testGetSentencesWithTheMostLongestWord() {

        String actual = " Дистанционный формат позволит индивидуализировать процесс обучения и обеспечит мобильность при изучении материалов и выполнении заданий. " +
                "Где будут удобно располагаться все лекции, конференции , тренинги, интернет-семинаров, тестов и других материалов.";

        List<Component> expectedSentences = action.getSentencesWithTheMostLongestWord();

        StringBuilder builderExpected = new StringBuilder();

        for (Component component : expectedSentences) {
            builderExpected.append(component);
        }

        assertEquals(actual, builderExpected.toString());


    }

    @Test
    public void testDeleteSentencesWhereNumberOfWordsLessThanSpecifiedValue() {


        String actual = "\n     Для студентов станет стандартом выбирать дополнительные предметы, которые затем внесут в диплом, в количестве их никто не ограничивает," +
                " но дополнительное обучение не должно мешать основной специальности.\n" +
                "     Также лекций скорее всего больше не будет, так как уже упоминалась , что будет платформа с необходимыми лекциями и тренингами, " +
                "которые также будут при необходимости высылаться в группу студентов.";

        action.deleteSentencesWhereNumberOfWordsLessThanSpecifiedValue(25);


        assertEquals(actual, componentText.toString());

    }

    @Test
    public void testNumberOfIdenticalWords() {

        long actual = 43;
        long expected = action.numberOfIdenticalWords();

        assertEquals(actual, expected);

    }
}
