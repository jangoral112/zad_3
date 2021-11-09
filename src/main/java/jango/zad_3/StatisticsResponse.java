package jango.zad_3;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StatisticsResponse {

    private Long uppercaseLetters;

    private Long lowercaseLetters;

    private Long digits;

    private Long specialCharacters;

    private Long combinationHits;
}
