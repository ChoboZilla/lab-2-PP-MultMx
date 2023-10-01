package org.example;
import java.io.*;
import java.util.*;

public class Main {
    public static void main( String[] args )throws Exception{
        String path = new File("src\\main\\resources").getAbsolutePath();

        Matrix mtrx1 = new Matrix(1000,1000);
        mtrx1.matrx = readMx.readFileArr(path + "\\array1.txt", mtrx1.getCol(), mtrx1.getRow());

        Matrix mtrx2 = new Matrix(1000,1000);
        mtrx2.matrx = readMx.readFileArr(path + "\\array2.txt", mtrx2.getCol(), mtrx2.getRow());

        long startTime = System.nanoTime();
        Matrix restmp = readMx.multMatrParallel(mtrx1,mtrx2);

        //printMx(mtrx1, mtrx2, readMx.multMatrParallel(mtrx1,mtrx2));
        long estimatedTime = System.nanoTime() - startTime;
        double time1 = estimatedTime / 1000000000f;
        startTime = System.nanoTime();
        readMx.multMatrWithOutParallel(mtrx1,mtrx2);
        //printMx(mtrx1, mtrx2, readMx.multMatrWithOutParallel(mtrx1,mtrx2));
        long estimatedTime2 = System.nanoTime() - startTime;

        System.out.println("Время с использованием ПП: " + time1 + " s.");
        System.out.println("Время БЕЗ использования ПП: " + estimatedTime2 / 1000000000f + " s.");
    }

    public static void printMx(Matrix m1, Matrix m2, Matrix res){
        System.out.println("Первая матрица:");
        for(int i = 0; i < m1.getCol(); i++) {
            for (int j = 0; j < m1.getRow(); j++) {
                System.out.print(m1.matrx[i][j] + "\t ");
            }
            System.out.print("\n");
        }

        System.out.println("Вторая матрица:");
        for(int i = 0; i < m2.getCol(); i++) {
            for (int j = 0; j < m2.getRow(); j++) {
                System.out.print(m2.matrx[i][j] + "\t ");
            }
            System.out.print("\n");
        }

        System.out.println("Результат умножения:");
        for(int i = 0; i < res.getCol(); i++) {
            for (int j = 0; j < res.getRow(); j++) {
                System.out.print(res.matrx[i][j] + " ");
            }
        }
        System.out.print("\n");
    }
}