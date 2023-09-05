/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.clever.lfa_afd;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;
import model.Automato;

/**
 *
 * @author clevs
 */
public class LFA_AFD {

    public static void main(String[] args) {

//        System.out.println('a' + 0);
//        System.out.println('A' + 0);
        String[] pathnames;
        Automato l = null;
        String dir = System.getProperty("user.dir") + "/matrizTrans";

        File file = new File(dir);

        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File f, String name) {
                return name.endsWith(".txt");
            }
        };
        pathnames = file.list(filter);

        if (pathnames != null && pathnames.length > 0) {
            System.out.println("Automatos disponiveis:");
            for (int i = 0; i < pathnames.length; i++) {
                System.out.println((i + 1) + ": " + pathnames[i]);
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("Selecione o numero do Automato desejado: ");
            int op = scanner.nextInt();

            if (op >= 1 && op <= pathnames.length) {
                String automatoSelect = pathnames[op - 1];
               l = new Automato(automatoSelect);
            }

        }
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite a senteça a ser validada: ");
        String word = scan.next();
        if(l != null && l.validateWord(word)){
            System.out.println("Valido");
        }
        else{
            System.out.println("Invalido");
        }
        
        
    }
}
