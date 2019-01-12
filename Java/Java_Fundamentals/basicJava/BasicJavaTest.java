public class BasicJavaTest {
    public static void main(String[] args){
        BasicJava iD = new BasicJava();

        // Print 1-255
        Integer answer1 = iD.print1to255();
        System.out.println(answer1);

        // Print odd numbers between 1-255
        Integer answer2 = iD.printOdd1to255();
        System.out.println(answer2);

        // Print sum
        Integer answer3 = iD.printSum();
        System.out.println(answer3 + "\n----");

        // Interating through an array
        int[] arr = {1,3,5,7,9,13};
        Integer answer4 = iD.iterating(arr);

        // Find max
        int[] arr2 = {1,3,5,7,9,13};
        Integer answer5 = iD.findMax(arr2);
        System.out.println(answer5 + "\n----");

        // Get Average
        int[] arr3 = {1,3,5,7,9,13};
        Integer answer6 = iD.getAverage(arr3);
        System.out.println(answer6 + "\n----");

        // Array with odd numbers
        Integer answer7 = iD.arrayOdd();
        System.out.println(answer7 + "\n----");

        // Greater than y
        int[] arr4 = {1, 3, 5, 7};
        Integer answer8 = iD.greaterThanY(arr4, 3);
        System.out.println(answer8 + "\n----");

        // Square the values
        int[] arr5 = {1, 5, 10, -2};
        Integer answer9 = iD.squareValues(arr5);
        System.out.println(answer9 + "\n----");

        // Eliminate Negative Numbers
        // int[] arr6 = {1, 5, 10, -2};
        // Integer answer10 = iD.noNegativeNum(arr6);
        // System.out.println(answer10 + "\n----");

        // Max, min and average
        int[] arr7 = {1, 5, 10, -2};
        String answer10 = iD.maxMinAverage(arr7);
        System.out.println(answer10 + "\n----");

        // Shifting the values in the array
        // int[] arr8 = {1, 5, 10, 7, -2};
        // Integer answer11 = iD.shiftingValues(arr8);
        // System.out.println(answer11 + "\n----");
    }
}