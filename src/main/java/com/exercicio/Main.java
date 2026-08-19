package com.exercicio;

import java.util.Scanner;

/**
 * Ponto de entrada do programa.
 * Le uma linha de texto da entrada padrao e imprime se ela e um pangram
 * (kata "Check if a Pangram" do CodeWars).
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();

        PangramChecker pangramChecker = new PangramChecker();
        boolean result = pangramChecker.isPangram(sentence);

        System.out.println(result);
        scanner.close();
    }
}
