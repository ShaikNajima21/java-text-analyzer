# Build a text analyzer

A program that reads a sentence and reports on it: its characters, words and vowels, its longest word, the sentence in Title Case and reversed, and whether it is a **palindrome** (it reads the same backwards, ignoring spaces and case).

The user can analyze as many sentences as they like.

## Features

- Read a full sentence with `nextLine()`; ask again if it is empty.
- Print the number of characters and words.
- Count the vowels (a, e, i, o, u), in upper or lower case.
- Print the longest word and the sentence in Title Case.
- Print the sentence reversed, and whether it is a palindrome.
- Ask `Analyze another? (y/n)` and repeat on `y`.
- Digits and symbols are kept as they are: for `12321` the program prints `Longest word: 12321`, `Title case: 12321` and `Reversed: 12321`.

## How to run

```
javac *.java
java TextAnalyzer
```

## Sample run

```
=== Text Analyzer ===
Enter a sentence: Java is fun to learn
Characters: 20
Words: 5
Vowels: 7
Longest word: learn
Title case: Java Is Fun To Learn
Reversed: nrael ot nuf si avaJ
Palindrome: no
Analyze another? (y/n): y
Enter a sentence: Never odd or even
Characters: 17
Words: 4
Vowels: 6
Longest word: Never
Title case: Never Odd Or Even
Reversed: neve ro ddo reveN
Palindrome: yes
Analyze another? (y/n): n
Bye!
```

## Author

ShaikNajima21
