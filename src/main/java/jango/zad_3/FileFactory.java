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
            case "xml": inputStream = createXmlFile(stringStatistics);
                break;
            case "json": inputStream = createJsonFile(stringStatistics);
                break;
            case "csv": inputStream = createCsvFile(stringStatistics);
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

    private InputStream createXmlFile(StatisticsResponse stringStatistics) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
            .append("<stringStatistics>")
                .append("\n")
                .append("<uppercaseLetters>")
                .append(stringStatistics.getUppercaseLetters())
                .append("</uppercaseLetters>")
                .append("\n")
                .append("<lowercaseLetters>")
                .append(stringStatistics.getLowercaseLetters())
                .append("</lowercaseLetters>")
                .append("\n")
                .append("<digits>")
                .append(stringStatistics.getDigits())
                .append("</digits>")
                .append("\n")
                .append("<specialCharacters>")
                .append(stringStatistics.getSpecialCharacters())
                .append("</specialCharacters>")
                .append("\n")
                .append("<combinationHits>")
                .append(stringStatistics.getCombinationHits())
                .append("</combinationHits>")
                .append("\n")
            .append("</stringStatistics>");

        return new ByteArrayInputStream(stringBuilder.toString().getBytes());
    }

    private InputStream createJsonFile(StatisticsResponse stringStatistics) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("{")
            .append("\"uppercase_letters:\" ")
            .append(stringStatistics.getUppercaseLetters())
            .append("\n")
            .append("\"lowercase_letters:\" ")
            .append(stringStatistics.getLowercaseLetters())
            .append("\n")
            .append("\"digits: \" ")
            .append(stringStatistics.getDigits())
            .append("\n")
            .append("\"special_characters:\" ")
            .append(stringStatistics.getSpecialCharacters())
            .append("\n")
            .append("\"combination_hits:\" ")
            .append(stringStatistics.getCombinationHits())
            .append("\n")
            .append("}");

        return new ByteArrayInputStream(stringBuilder.toString().getBytes());
    }

    private InputStream createCsvFile(StatisticsResponse stringStatistics) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
            .append("uppercase_letters,")
            .append("lowercase_letters,")
            .append("digits,")
            .append("special_characters,")
            .append("combination_hits:")
            .append("\n")
            .append(stringStatistics.getUppercaseLetters())
            .append(",")
            .append(stringStatistics.getLowercaseLetters())
            .append(",")
            .append(stringStatistics.getDigits())
            .append(",")
            .append(stringStatistics.getSpecialCharacters())
            .append(",")
            .append(stringStatistics.getCombinationHits())
            .append("\n");

        return new ByteArrayInputStream(stringBuilder.toString().getBytes());
    }

}
