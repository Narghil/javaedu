package ExcerciseProjects;

import java.util.Arrays;

import static PG.Utils.IOUtils.sopl;

public class EqualSubArrays {
    public static void main(String[] args) {
        int[] intArr = getTestData();

        ArrayProcessor ap = new ArrayProcessor(intArr);
        ap.search();
        sopl("A tömb:  " + ap.toString());
        if (ap.getResult() < 1) {
            sopl("Nincs megfelelő index!");
        } else {
            sopl("Az index:" + ap.getResult());
        }
    }

    static int[] getTestData() {
        return new int[]{10, 23, 1, 1, 99, 35};
    }
}

class ArrayProcessor {
    private int[] inputData;
    private int result = Integer.MIN_VALUE;

    public ArrayProcessor(int[] data) {
        this.inputData = data;
    }

    public int getResult() {
        return result;
    }

    public String toString() {
        return Arrays.toString(inputData);
    }

    /*
        private int sumElements(int from, int to) {
            int sum = 0;
            for (int i = from; i <= to; i++) {
                sum = sum + inputData[i];
            }
            return sum;
        }
    */
    public void search() {
        int sumL, sumR, middleIdx, sumAll = 0;

        for (int i = 0; i < inputData.length; i++) {
            sumAll += inputData[i];
        }

        middleIdx = inputData.length / 2;
        sumL = 0;
        sumR = sumAll;
        for (int i = 0; i < inputData.length - 1; i++) {
            if (i > 0) {
                sumL = sumL + inputData[i - 1];
            }
            sumR = sumR - inputData[i];
            /*
            if (i < middleIdx) {
                sumL = sumElements(0, i - 1);
                sumR = sumAll - sumL - inputData[i];
            } else {
                sumR = sumElements(i + 1, inputData.length - 1);
                sumL = sumAll - sumR - inputData[i];
            }
            */
            if (sumL == sumR) {
                result = i;
                break;
            }
        }
    }
}



