package com.company;

import java.util.Random;
import java.util.Scanner;

public class Sudoku {
    private int [][]matrix;
    private int [][]changedMatrix;
    private int emptySpaces = 51;
    private Scanner input = new Scanner(System.in);

    public Sudoku(int[][] matrix) {
        System.out.println("Sudoku started.");
        this.matrix=matrix;
        changeMatrix();
    }

    private void getInput(){
        int row, column;  
        System.out.println("Ingrese fila :");
        row = input.nextInt();

        System.out.println("Ingrese columna: ");
        column = input.nextInt();

        insertValue(row, column);
    }
    
    public boolean finished() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (this.changedMatrix[row][col] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public void startGame() {
        
        while (!finished())
        {
            showMatrix(this.changedMatrix);
            getInput();
        }

        if(verify()) 
            System.out.println("GANASTE FELICITACIONES");
         else
            System.out.println("FAIL !!");
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
                this.emptySpaces--;
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

	public boolean isDifferent(int i, int j){
		return this.changedMatrix[i][j] != this.matrix[i][j];
	}

   public boolean verify(){
        for(int i  = 0 ; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if (isDifferent(i,j)) {
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
