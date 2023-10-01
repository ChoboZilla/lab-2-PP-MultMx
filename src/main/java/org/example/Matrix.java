package org.example;

public class Matrix {
    int col;
    int row;
    public int[][] matrx;

    public Matrix(int c_col, int c_row){
        col = c_col;
        row = c_row;
        matrx = new int[c_col][c_row];
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
}
