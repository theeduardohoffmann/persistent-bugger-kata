package com.exercicio;

/**
 * Kata CodeWars: "Detect Pangram"
 * https://www.codewars.com/kata/545cedaa9943f7fe7b000048
 *
 * Um "pangram" e uma frase que contem todas as letras do alfabeto ingles
 * pelo menos uma vez. Dada uma string, verifique se ela e um pangram.
 * A verificacao deve ignorar maiusculas/minusculas.
 *
 * Exemplo:
 *  check("The quick brown fox jumps over the lazy dog") == true
 *  check("This is not a pangram")                        == false
 */
public class PangramChecker {

    private static final int ALPHABET_SIZE = 26;

    public boolean check(String sentence) {
        if (sentence == null) {
            throw new IllegalArgumentException("sentence nao pode ser nula");
        }

        boolean[] seenLetters = new boolean[ALPHABET_SIZE];
        String lowerCaseSentence = sentence.toLowerCase();

        for (char c : lowerCaseSentence.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                seenLetters[c - 'a'] = true;
            }
        }

        for (boolean seen : seenLetters) {
            if (!seen) {
                return false;
            }
        }
        return true;
    }
}
