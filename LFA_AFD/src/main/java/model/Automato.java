/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author clevs
 */
public class Automato {

    private TransicaoPilha[][] matriz;
    private int numStates;
    private int numSymbols;
    private int startState;
    private Set<Integer> acceptStates;

    public Automato(int numStates, int numSymbols, int startState, Set<Integer> acceptStates) {
        this.numStates = numStates;
        this.numSymbols = numSymbols;
        this.startState = startState;
        this.acceptStates = acceptStates;
        this.matriz = new TransicaoPilha[numStates][numSymbols + 1]; // +1 do Z||Epsilon||Vazio
    }

    public int charToIndex(char c) {
        if (c == 'Z') {
            return this.matriz[0].length - 1; // Epsilon transitions are at the last index
        }
        return c - 'a';
    }

    public void loadMatriz(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                int currentState = Integer.parseInt(parts[0]);
                int inputSymbol = charToIndex(parts[1].charAt(0));
                int nextState = Integer.parseInt(parts[2]);
                String unstackSymbol = parts[3];
                String stackSymbol = parts[4];
                this.matriz[currentState][inputSymbol] = new TransicaoPilha(nextState, unstackSymbol, stackSymbol);
            }
            reader.close();
            System.out.print(this.matriz);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean validateWord(String word) {
        int currentState = startState;
        Stack<String> stack = new Stack<>();
        stack.push("Z"); // Inicia a pilha com Z...base da pilha

        for (char inputSymbol : word.toCharArray()) {
            int index = charToIndex(inputSymbol);
            TransicaoPilha transition = this.matriz[currentState][index];
            if (transition == null || stack.isEmpty() || !stack.contains(transition.getDesempilhar())) {
                return false;
            }

            currentState = transition.getEstadoDestino();
            if (!transition.getDesempilhar().equals("Z")) {
                stack.pop();
            }

            if (!transition.getEmpilhar().equals("Z")) {
                for (int i = transition.getEmpilhar().length() - 1; i >= 0; i--) {
                    stack.push(String.valueOf(transition.getEmpilhar().charAt(i)));
                }
            }

            // Process epsilon transitions
            TransicaoPilha epsilonTransition = this.matriz[currentState][this.matriz[0].length - 1];
            while (epsilonTransition != null && !stack.isEmpty() && stack.peek().equals(epsilonTransition.getDesempilhar())) {
                currentState = epsilonTransition.getEstadoDestino();
                if (!epsilonTransition.getDesempilhar().equals("Z")) {
                    stack.pop();
                }
                if (!epsilonTransition.getEmpilhar().equals("Z")) {
                    for (int i = epsilonTransition.getEmpilhar().length() - 1; i >= 0; i--) {
                        stack.push(String.valueOf(epsilonTransition.getEmpilhar().charAt(i)));
                    }
                }
                epsilonTransition = this.matriz[currentState][this.matriz[0].length - 1];
            }
        }

        return acceptStates.contains(currentState) && (stack.isEmpty() || stack.peek().equals("Z"));
    }
}
