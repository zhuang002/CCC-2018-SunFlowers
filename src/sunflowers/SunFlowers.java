/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sunflowers;

import java.util.Scanner;

/**
 *
 * @author zhuan
 */
public class SunFlowers {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] table=readTable();
        while (!validate(table)) {
            table=rotateTable(table);
        }
        printTable(table);
    }

    private static int[][] readTable() {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[][] table=new int[size][size];
        for (int i=0;i<size;i++) {
            for (int j=0;j<size;j++) {
                table[i][j]=sc.nextInt();
            }
        }
        return table;
    }

    private static boolean validate(int[][] table) {
        for (int i=0;i<table.length;i++) {
            if (!isRowValidate(table,i)) return false;
        }
        for (int i=0;i<table.length;i++) {
            if (!isColumnValidate(table,i)) return false;
        }
        return true;
    }

    private static int[][] rotateTable(int[][] table) {
        int size=table.length;
        int[][] rotatedTable=new int[size][size];
        for (int i=0;i<size;i++) {
            for (int j=0;j<size;j++) {
                rotatedTable[j][size-1-i]=table[i][j];
            }
        }
        return rotatedTable;
    }

    private static void printTable(int[][] table) {
        for (int i=0;i<table.length;i++) {
            for (int j=0;j<table[i].length;j++) {
                System.out.print(table[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static boolean isRowValidate(int[][] table, int row) {
        for (int i=0;i<table[row].length-1;i++) {
            if (table[row][i]>table[row][i+1])
                return false;
        }
        return true;
    }

    private static boolean isColumnValidate(int[][] table, int column) {
        for (int i=0;i<table.length-1;i++) {
            if (table[i][column]>table[i+1][column])
                return false;
        }
        return true;
    }
}
