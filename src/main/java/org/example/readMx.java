package org.example;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class readMx {
    public static int[][] readFileArr(String filename, int col, int row)throws Exception {
        Scanner scanner = new Scanner(new File(filename));
        int[] tall = new int[col * row];
        int i = 0;
        while (scanner.hasNextInt()) {
            tall[i++] = scanner.nextInt();
        }

        int[][] result = new int[col][row];
        for(int k = 0; k < col; k++){
            for(int l = 0; l < row; l++){
                result[k][l] = tall[k*row +l];
            }
        }
        return result;
    }
    public static Matrix multMatrWithOutParallel(Matrix m1, Matrix m2) {
        Matrix resMx = new Matrix(m1.getCol(), m2.getRow());

        if(m1.getRow() != m2.getCol()) {
            resMx = null;
            return resMx;
        }
        for(int i = 0; i < m1.getCol(); i++){
            for(int j = 0; j < m2.getRow(); j++){
                for(int k = 0; k < m1.getRow(); k++){
                    resMx.matrx[i][j] += m1.matrx[i][k] * m2.matrx[k][j];
                }
            }
        }

        return resMx;
    }
    public static Matrix multMatrParallel(Matrix m1, Matrix m2) {
        Matrix resultMx = new Matrix(m1.getCol(), m2.getRow());

        if (m1.getRow() != m2.getCol()) {
            resultMx = null;
            return resultMx;
        }

        List threads = new ArrayList<>();
        int rows1 = m1.matrx.length;
        for (int i = 0; i < rows1; i++) {
            MultWorker task = new MultWorker(resultMx, m1, m2, i);
            Thread thread = new Thread(task);
            thread.start();
            threads.add(thread);
            if (threads.size() % 10 == 0) {
                waitForThreads(threads);
            }
        }
        return resultMx;
    }
    private static void waitForThreads(List<Thread> threads) {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        threads.clear();
    }
}
