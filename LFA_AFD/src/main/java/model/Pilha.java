/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Stack;

/**
 *
 * @author clevs
 */
public class Pilha {
    
    private Stack<String> pilha;

   public Pilha() {
        this.pilha = new Stack<>();
    }

    public void empilhar(String simbolo) {
        this.pilha.push(simbolo);
    }

    public String desempilhar() {
        return this.pilha.pop();
    }

    public String peek() {
        return this.pilha.peek();
    }

    public boolean isEmpty() {
        return this.pilha.isEmpty();
    }

    public void clear() {
        this.pilha.clear();
    }
    
}
