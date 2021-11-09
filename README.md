# DOCUMENTATION
##API

**Application port**: 8081  <br />
**Protocol**: http

### String statistics

Returns file in given format containing string statistics

**Path**: /statistics/file/:format <br />
**Method**: POST <br />

**Headers**: <br />
Content-Type: application/json

**Path parameters**: <br />
format: file format (json | txt | xml | csv)

**Request body**:
```
{
    "text": "Text for statistcs",
    "combination": "additional combination of characters to be search for as String"
}
```

**Sample response for format JSON for status *OK* *200*:**
```
{
    "uppercase_letters": Long,
    "lowercase_letters": Long,
    "digits": Long,
    "special_characters": Long,
    "combination_hits": Long,
}
```
**Sample response for format txt for status *OK* *200*:**
```
Uppercase letters: Long
Lowercase letters: Long
Digits: Long
Special characters: Long
Combination hits: Long
```

**Sample response for format xml for status *OK* *200*:**
```
<stringStatistics>
  <uppercaseLetters>Long</uppercaseLetters>
  <lowercaseLetters>Long</lowercaseLetters>
  <digits>Long</digits>
  <specialCharacters>Long</specialCharacters>
  <combinationHits>Long</combinationHits>
</stringStatistics>
```

**Sample response for format csv for status *OK* *200*:**
```
uppercaseLetters,lowercaseLetters,digits,specialCharacters,combinationHits
Long,Long,Long,Long,Long
```

##Requirements

Service requires access to service that calculates statistics for string under port `8080` with accessible path `/statistics`
