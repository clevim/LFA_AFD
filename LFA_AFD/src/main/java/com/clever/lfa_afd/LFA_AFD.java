/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.clever.lfa_afd;

import java.io.File;
import java.io.FilenameFilter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import model.Automato;

/**
 *
 * @author clevs
 */
public class LFA_AFD {

    public static void main(String[] args) {
        // Create a new automaton with 4 states, 2 symbols ('a' and 'b'), start state 0, and accept state 3
        Set<Integer> acceptStates = new HashSet<>();
        acceptStates.add(3);
        Automato automato = new Automato(4, 2, 0, acceptStates);

        // Load transitions from file
        automato.loadMatriz(System.getProperty("user.dir") + "/matrizTrans/PilhaTeste.txt");

        String word = "aaabbb";
        boolean result = automato.validateWord(word);
        System.out.println("The word " + word + " is " + (result ? "accepted" : "not accepted") + " by the automaton.");


         // Create a new automaton with 4 states, 2 symbols ('a' and 'b'), start state 0, and accept state 3
        Set<Integer> acceptStates2 = new HashSet<>();
        acceptStates2.add(1);
        Automato automato2 = new Automato(2, 3, 0, acceptStates2);

        // Load transitions from file
        automato2.loadMatriz(System.getProperty("user.dir") + "/matrizTrans/PilhaTeste2.txt");

        String word2 = "aaabbccccc";
        boolean result2 = automato2.validateWord(word2);
        System.out.println("The word " + word2 + " is " + (result2 ? "accepted" : "not accepted") + " by the automaton.");
        
        
         // Create a new automaton with 4 states, 2 symbols ('a' and 'b'), start state 0, and accept state 3
        Set<Integer> acceptStates3 = new HashSet<>();
        acceptStates3.add(2);
        acceptStates3.add(1);
        Automato automato3 = new Automato(3, 3, 0, acceptStates3);

        // Load transitions from file
        automato3.loadMatriz(System.getProperty("user.dir") + "/matrizTrans/PilhaTeste3.txt");

        String word3 = "aaabbc";
        boolean result3 = automato3.validateWord(word3);
        System.out.println("The word " + word3 + " is " + (result3 ? "accepted" : "not accepted") + " by the automaton.");
    }
}
