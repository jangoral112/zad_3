package jango.zad_3;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.springframework.stereotype.Component;

@Component
public class FileFactory {

    public InputStream createFile(String format, StatisticsResponse stringStatistics) {
        InputStream inputStream = null;

        switch (format) {
            case "txt": inputStream = createTextFile(stringStatistics);
                break;
        }

        return inputStream;
    }

    private InputStream createTextFile(StatisticsResponse stringStatistics) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Uppercase letters: ")
            .append(stringStatistics.getUppercaseLetters())
            .append("\n")
            .append("Lowercase letters: ")
            .append(stringStatistics.getLowercaseLetters())
            .append("\n")
            .append("Digits: ")
            .append(stringStatistics.getDigits())
            .append("\n")
            .append("Special characters: ")
            .append(stringStatistics.getSpecialCharacters())
            .append("\n")
            .append("Combination hits: ")
            .append(stringStatistics.getCombinationHits())
            .append("\n");

        return new ByteArrayInputStream(stringBuilder.toString().getBytes());
    }

}
