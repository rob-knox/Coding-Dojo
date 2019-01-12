import java.util.ArrayList;
public class BasicJava {
    // Print 1-255
    public Integer print1to255() {
        for (int i = 1; i < 256; i++) {
            System.out.println(i);
        }
        return null;
    }

    // Print odd numbers between 1-255
    public Integer printOdd1to255() {
        for (int i = 1; i < 256; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
        return null;
    }

    // Print sum
    public Integer printSum() {
        int sum = 0;
        for (int i = 0; i < 256; i++) {
            sum = sum + i;
            String output = "New number: " + i + " Sum: " + sum;
            System.out.println(output);
        }
        return null;
    }

    // Interating through an array
    public Integer iterating(int[] x) {
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i]);
        }
        return null;
    }

    // Find max
    public Integer findMax(int[] x) {
        int max = 0;
        for(int i = 0; i < x.length; i++) {
            if (x[i] > max) {
                max = x[i];
            }
        }
        return max;
    }

    // Get Average
    public Integer getAverage(int[] x) {
        int sum = 0;
        for(int i = 0; i < x.length; i++) {
            sum = sum + x[i];
        }
        int result = sum / x.length;
        return result;
    }

    // Array with odd numbers
    public Integer arrayOdd() {
        ArrayList<Integer> y = new ArrayList<Integer>();
        for (int i = 0; i < 256; i++) {
            if (i % 2 != 0) {
                y.add(i);
            }
        }
        System.out.println(y);
        return null;
    }

    // Greater than y
    public Integer greaterThanY(int[] x, int y) {
        int count = 0;
        for (int i = 0; i < x.length; i++) {
            if (x[i] > y) {
                count++;
            }
        }
        return count;
    }

    // Square the values
    public Integer squareValues(int[] x) {
        int squared = 0;
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i] * x[i]);
        }
        return null;
    }

    // Eliminate Negative Numbers - Not working
    // public Integer noNegativeNum(int[] x) {
    //     for (int i = 0; i < x.length; i++) {
    //         if (x[i] < 0) {
    //             x[i] = 0;
    //         }
    //         //System.out.println(x);
    //     }
    //     return x;
    // }

    // Max, min and average
    public String maxMinAverage(int[] x) {
        int max = 0;
        int min = x[0];
        int avg = 0;
        int sum = 0;
        for (int i = 0; i < x.length; i++) {
            if (x[i] > max) {
                max = x[i];
            }
            if (min <= x[i]) {
                min = x[i];
            }
            sum = sum + x[i];
        }
        avg = sum / x.length;
        String message = String.format("%s, %s, %s", max, min, avg);
        return message;
    }

    // Shifting the values in the array
    // public Integer shiftingValues(int[] x) {
    //     for (int i = x.length -1; i < 0; i--) {
    //         x[i] = x[i-1];
    //         //System.out.println(x); 
    //     }
        
    //     return x;
    // }
}