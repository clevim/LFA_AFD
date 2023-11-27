/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author clevs
 */
public class TransicaoPilha {
  private int estadoDestino;
    private String desempilhar;
    private String empilhar;

    public TransicaoPilha(int estadoDestino, String desempilhar, String empilhar) {
        this.estadoDestino = estadoDestino;
        this.desempilhar = desempilhar;
        this.empilhar = empilhar;
    }

    public int getEstadoDestino() {
        return this.estadoDestino;
    }

    public String getDesempilhar() {
        return this.desempilhar;
    }

    public String getEmpilhar() {
        return this.empilhar;
    }

}
