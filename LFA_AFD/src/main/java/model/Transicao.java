/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author clevs
 */
public class Transicao {

    private int[][] matriz;
    private int rows, cols;

    public Transicao(String fileName) {
        this.loadMatriz(fileName);
    }

    public void loadMatriz(String pathname) {
        try {
            String dir = System.getProperty("user.dir") + "/matrizTrans/"+pathname;
            FileReader file = new FileReader(dir);
            Scanner arq = new Scanner(file);

            arq.useDelimiter("\n");
            String firstLine = arq.next();
            String[] param = firstLine.split(";");
            this.cols = Integer.parseInt(param[1]);
            this.rows = Integer.parseInt(param[0]);
            this.matriz = new int[this.rows][this.cols];

            String actLine = "";
            int Line = 0;
            while (arq.hasNext()) {
                actLine = arq.next();
                param = actLine.split(";");

                for (int i = 0; i < this.cols; i++) {
                    int value = Integer.parseInt(param[i]);
                    this.matriz[Line][i] = value;
                }
                Line++;
            }

        } catch (FileNotFoundException e) {
            System.err.println("O arquivo não foi encontrado: " + e.getMessage());
        }

    }

    public int getCell(int r, int c) {
        return this.matriz[r][c];
    }

    public void setCell(int r, int c, int value) {
        this.matriz[r][c] = value;

    }

}
