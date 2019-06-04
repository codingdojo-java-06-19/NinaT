import java.util.ArrayList;

public class Basics {

    public void print1To255() {
        for (int i = 1; i < 256; i++) {
            System.out.println(i);
        }
    }

    public void print1To255Odd() {
        for (int i = 1; i < 256; i++) {
            if (i % 2 == 1) {
                System.out.println(i);
            }
        }
    }

    public void printSum1To255() {
        int sum = 0;
        for (int i = 0; i < 256; i++) {
            sum += i;
            System.out.println("New number: " + i + " Sum: " + sum);
        }
    }

    public void iterateArray(int[] myArr) {
        for (int i = 0; i < myArr.length; i++) {
            System.out.println(myArr[i]);
        }
    }

    public Integer findMax(int[] myArr) {
        int max = myArr[0];
        for (int i = 1; i < myArr.length; i++) {
            if (myArr[i] > max) {
                max = myArr[i];
            }
        }
        return max;
    }

    public Integer getAverage(int[] myArr) {
        int sum = 0;
        for (int i = 0; i < myArr.length; i++) {
            sum += myArr[i];
        }
        int avg = sum / myArr.length;
        return avg;
    }

    public ArrayList arrayWithOddNumbers() {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 1; i < 256; i++) {
            if (i % 2 == 1) {
                arr.add(i);
            }
        }
        System.out.println(arr);
        return arr;
    }

    public Integer greaterThanY(int[] myArr, int y) {
        int count = 0;
        for (int i = 0; i < myArr.length; i++) {
            if (myArr[i] > y) {
                count++;
            }
        }
        return count;
    }

    public int[] squareTheValues(int[] myArr) {
        for (int i = 0; i < myArr.length; i++) {
            myArr[i] = myArr[i] ^ 2;
        }
        return myArr;
    }

    public int[] eliminateNegNumbers(int[] myArr) {
        for (int i = 0; i < myArr.length; i++) {
            if (myArr[i] < 0) {
                myArr[i] *= -1;
            }
        }
        return myArr;
    }

    public int[] maxMinAverage(int[] myArr) {
        int max = myArr[0];
        int min = myArr[0];
        int sum = myArr[0];
        for (int i = 1; i < myArr.length; i++) {
            if (myArr[i] > max) {
                max = myArr[i];
            } else if (myArr[i] < min) {
                min = myArr[i];
            }
            sum += myArr[i];
        }
        int avg = sum / myArr.length;
        int[] newArr = { max, min, avg };
        return newArr;
    }

    public int[] shiftValues(int[] myArr) {
        for (int i = 0; i < myArr.length - 1; i++) {
            myArr[i] = myArr[i + 1];
        }
        myArr[myArr.length - 1] = 0;
        return myArr;
    }

}