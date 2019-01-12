public class StringManipulator4Test {
    public static void main(String[] args) {
        StringManipulator4 manipulator = new StringManipulator4();
        String word = manipulator.concatSubstring("Hello", 1, 2, "world");
        System.out.println(word); // eworld
    }
}