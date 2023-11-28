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
    
//                                    Arquivo TXT
//         EstadoOrigem,Letra,EstadoDestino,Desempilhar,Empilhar   
//    
//                                        main
//    Automato(Numero de estados,Numero de simbolos,Estado Inicial,Estados Finais)
    

    public static void main(String[] args) {
        //Autômato com 4 estados, 2 símbolos ('a' e 'b'), estado inicial 0 e estado de aceitação|final 3.
        Set<Integer> acceptStates = new HashSet<>();
        acceptStates.add(3);
        Automato automato = new Automato(4, 2, 0, acceptStates);

        // Load transitions from file
        automato.loadMatriz(System.getProperty("user.dir") + "/matrizTrans/PilhaTeste.txt");

        String word = "aaabbb";
        boolean result = automato.validateWord(word);
        System.out.println("A Palavra " + word + " é " + (result ? "aceito" : "não aceito") + " pelo automato.");


         //Autômato com 2 estados, 3 símbolos ('a' , 'b' e  'c'), estado inicial 0 e estado de aceitação|final 1.
        Set<Integer> acceptStates2 = new HashSet<>();
        acceptStates2.add(1);
        Automato automato2 = new Automato(2, 3, 0, acceptStates2);

        // Load transitions from file
        automato2.loadMatriz(System.getProperty("user.dir") + "/matrizTrans/PilhaTeste2.txt");

        String word2 = "aaabbcccc";
        boolean result2 = automato2.validateWord(word2);
        System.out.println("A Palavra " + word2 + " é " + (result2 ? "aceito" : "não aceito") + " pelo automato.");
        
        
         //Autômato com 3 estados, 3 símbolos ('a' , 'b' e  'c'), estado inicial 0 e estado de aceitação|final 1,2.
        Set<Integer> acceptStates3 = new HashSet<>();
        acceptStates3.add(2);
        acceptStates3.add(1);
        Automato automato3 = new Automato(3, 3, 0, acceptStates3);

        // Load transitions from file
        automato3.loadMatriz(System.getProperty("user.dir") + "/matrizTrans/PilhaTeste3.txt");

        String word3 = "aabbc";
        boolean result3 = automato3.validateWord(word3);
        System.out.println("A Palavra " + word3 + " é " + (result3 ? "aceito" : "não aceito") + " pelo automato.");
        
        //Autômato com 3 estados, 3 símbolos ('a' , 'b' e  'c'), estado inicial 0 e estado de aceitação|final 1,2.
        Set<Integer> acceptStates4 = new HashSet<>();
        acceptStates4.add(4);
        acceptStates4.add(2);
        Automato automato4 = new Automato(5, 3, 0, acceptStates4);

        // Load transitions from file
        automato4.loadMatriz(System.getProperty("user.dir") + "/matrizTrans/PilhaTeste4.txt");

        String word4 = "abbc";
        boolean result4 = automato4.validateWord(word4);
        System.out.println("A Palavra " + word4 + " é " + (result4 ? "aceito" : "não aceito") + " pelo automato.");
        
        
       
    }
}
