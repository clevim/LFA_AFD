/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clever.lfa_afd;

/**
 *
 * @author clevs
 */
public class Transicao {
    private String origem;
    private char letra;
    private String destino;

    public Transicao(String origem, char letra, String destino) {
        this.origem = origem;
        this.letra = letra;
        this.destino = destino;
    }

    public String getOrigem() {
        return origem;
    }

    public char getLetra() {
        return letra;
    }

    public String getDestino() {
        return destino;
    }

    @Override
    public String toString() {
        return "d(" + origem + ";" + letra + ") = " + destino;
    }
}
