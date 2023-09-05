/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author clevs
 */
public class Automato {

    private String word;
    private int initialState;
    private List<Integer> endStates;
    private Transicao matriz;

    public Automato(String fileName) {
        this.endStates = new ArrayList<>();
        this.word = "";
        this.initialState = 0;
        
        this.endStates.add(0);
        this.endStates.add(1);
        this.endStates.add(2);
        this.endStates.add(3);
        this.endStates.add(4);
        this.endStates.add(5);
        this.endStates.add(6);
        this.endStates.add(7);
        
        this.matriz = new Transicao(fileName);

    }

    private int parseToIndex(char m) {
        if (m < 97) {
//            A = 65 / a = 97
            m += 32;
        }
        return m - 'a';
    }

    public boolean validateWord(String word) {
        this.word = word;
        int state = this.initialState;

        for (int i = 0; i < this.word.length(); i++) {
            int col = this.parseToIndex(this.word.charAt(i));
            state = this.matriz.getCell(state, col);
            if (state == -1) {
                return false;
            }
        }

        return this.endStates.contains(state);

    }

}
