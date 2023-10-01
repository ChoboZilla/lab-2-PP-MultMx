
import  org.example.*;
import org.junit.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class MultTest{

    @Test
    public void Test10x10() throws Exception{
        String path = new File("src\\main\\resources").getAbsolutePath();

        Matrix mtrx1 = new Matrix(10,10);
        mtrx1.matrx = readMx.readFileArr(path + "\\test10x10_1.txt", mtrx1.getCol(), mtrx1.getRow());

        Matrix mtrx2 = new Matrix(10,10);
        mtrx2.matrx = readMx.readFileArr(path + "\\test10x10_2.txt", mtrx2.getCol(), mtrx2.getRow());

        Matrix res = new Matrix(10,10);
        res.matrx = readMx.readFileArr(path + "\\test10x10_res.txt", res.getCol(), res.getRow());

        Matrix resOfMult = readMx.multMatrParallel(mtrx1, mtrx2);
        for(int i = 0; i < resOfMult.getCol(); i++) {
            for (int j = 0; j < resOfMult.getRow(); j++) {
                assertEquals(resOfMult.matrx[i][j], res.matrx[i][j]);
            }
        }
    }
    @Test
    public void Test100x100() throws Exception{
        String path = new File("src\\main\\resources").getAbsolutePath();

        Matrix mtrx1 = new Matrix(100,100);
        mtrx1.matrx = readMx.readFileArr(path + "\\test100x100_1.txt", mtrx1.getCol(), mtrx1.getRow());

        Matrix mtrx2 = new Matrix(100,100);
        mtrx2.matrx = readMx.readFileArr(path + "\\test100x100_2.txt", mtrx2.getCol(), mtrx2.getRow());

        Matrix res = new Matrix(100,100);
        res.matrx = readMx.readFileArr(path + "\\test100x100_res.txt", res.getCol(), res.getRow());

        Matrix resOfMult = readMx.multMatrParallel(mtrx1, mtrx2);
        for(int i = 0; i < resOfMult.getCol(); i++) {
            for (int j = 0; j < resOfMult.getRow(); j++) {
                assertEquals(resOfMult.matrx[i][j], res.matrx[i][j]);
            }
        }
    }
    @Test
    public void Test500x500() throws Exception{
        String path = new File("src\\main\\resources").getAbsolutePath();

        Matrix mtrx1 = new Matrix(500,500);
        mtrx1.matrx = readMx.readFileArr(path + "\\test500x500_1.txt", mtrx1.getCol(), mtrx1.getRow());

        Matrix mtrx2 = new Matrix(500,500);
        mtrx2.matrx = readMx.readFileArr(path + "\\test500x500_2.txt", mtrx2.getCol(), mtrx2.getRow());

        Matrix res = new Matrix(500,500);
        res.matrx = readMx.readFileArr(path + "\\test500x500_res.txt", res.getCol(), res.getRow());

        Matrix resOfMultP = readMx.multMatrParallel(mtrx1, mtrx2);
        Matrix resOfMultNP = readMx.multMatrWithOutParallel(mtrx1, mtrx2);
        for(int i = 0; i < resOfMultP.getCol(); i++) {
            for (int j = 0; j < resOfMultP.getRow(); j++) {
                assertEquals(resOfMultP.matrx[i][j], resOfMultNP.matrx[i][j]);
            }
        }
    }

}
