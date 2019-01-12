public class StringManipulation3Test {
    public static void main(String[] args) {
        StringManipulation3 manipulator = new StringManipulation3();
        String word = "Hello";
        String subString = "llo";
        String notSubString = "world";
        Integer a = manipulator.getIndexOrNull(word, subString);
        Integer b = manipulator.getIndexOrNull(word, notSubString);
        System.out.println(a); // 2
        System.out.println(b); // null
    }
}