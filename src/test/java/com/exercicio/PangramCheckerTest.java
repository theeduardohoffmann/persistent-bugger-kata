package com.exercicio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Testes da classe PangramChecker (kata Check if a Pangram)")
class PangramCheckerTest {

    private PangramChecker pangramChecker;

    // Executado antes de CADA teste: garante uma instancia nova a cada caso.
    @BeforeEach
    void setUp() {
        pangramChecker = new PangramChecker();
    }

    @Test
    @DisplayName("Frase com todas as letras do alfabeto deve ser um pangram")
    void classicPangramReturnsTrue() {
        assertTrue(pangramChecker.isPangram("The quick brown fox jumps over the lazy dog"));
    }

    @Test
    @DisplayName("Frase sem todas as letras nao deve ser um pangram")
    void notAllLettersReturnsFalse() {
        assertFalse(pangramChecker.isPangram("This is not a pangram"));
    }

    @Test
    @DisplayName("Deve ignorar maiusculas e minusculas")
    void isCaseInsensitive() {
        assertTrue(pangramChecker.isPangram("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG"));
    }

    @Test
    @DisplayName("String nula deve lancar excecao")
    void nullSentenceThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> pangramChecker.isPangram(null));
    }

    // Teste parametrizado: varios casos de entrada/saida rodados de uma vez so.
    @ParameterizedTest(name = "isPangram(\"{0}\") deve ser {1}")
    @DisplayName("Casos de teste variados para o pangram")
    @CsvSource({
            "'The quick brown fox jumps over the lazy dog', true",
            "'This is not a pangram',                       false",
            "'',                                             false",
            "'abcdefghijklmnopqrstuvwxyz',                   true",
            "'Pack my box with five dozen liquor jugs',      true",
            "'Hello world',                                  false"
    })
    void variousPangramCases(String sentence, boolean expected) {
        assertEquals(expected, pangramChecker.isPangram(sentence));
    }
}
