package org.example;

public class MultWorker implements Runnable {

    private final Matrix result;
    private Matrix matrix1;
    private Matrix matrix2;
    private final int row;

    public MultWorker(Matrix result, Matrix matrix1, Matrix matrix2, int row) {
        this.result = result;
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.row = row;
    }

    @Override
    public void run() {

        for (int i = 0; i < matrix2.matrx[0].length; i++) {
            result.matrx[row][i] = 0;
            for (int j = 0; j < matrix1.matrx[row].length; j++) {
                result.matrx[row][i] += matrix1.matrx[row][j] * matrix2.matrx[j][i];

            }

        }

    }

}
