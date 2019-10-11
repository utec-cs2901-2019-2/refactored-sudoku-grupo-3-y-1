package com.company;

import java.util.Random;
import java.util.Scanner;

public class Sudoku {
    private int [][]matrix;
    private int [][]changedMatrix;
    private int emptySpaces;
    Scanner input = new Scanner(System.in);

    public Sudoku(int [][] matrix){
        this.matrix=matrix;
        this.emptySpaces=51;
        changeMatrix();
    }

    public void startGame(){

        int i = 0;
        showMatrix(changedMatrix);

        while(i<this.emptySpaces) {
            int row,column;
            System.out.println("Ingrese fila :");
            row = input.nextInt();
            System.out.println("Ingrese columna: ");
            column = input.nextInt();
            insertValue(row, column);
            showMatrix(changedMatrix);
            i = i + 1;
        }
        if(verify()) {
            System.out.println("GANASTE FELICITACIONES");
        } else {
            System.out.println("FAIL !!");
        }


    }

    public boolean isEmpty(int row, int col)
    {
        return (this.changedMatrix[row][col] == 0);
    }

    public void changeMatrix() {
        this.changedMatrix = this.matrix;
        Random random = new Random();

        while (this.emptySpaces > 0) {
            int randomRow = random.nextInt(9);
            int randomCol = random.nextInt(9);

            if (!this.isEmpty(randomRow, randomCol)) {
                this.changedMatrix[randomRow][randomCol] = 0;
            }
        }
    }

    public void showMatrix(int [][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println('\n');
        }
    }

   public boolean verify(){
        for(int i  = 0 ; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if (this.changedMatrix[i][j] != this.matrix[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }


    public void insertValue(int row, int column){
        int value = 0;
        System.out.println("Ingrese el valor : ");
        value = input.nextInt();
        this.changedMatrix[row][column] = value;
    }

}
