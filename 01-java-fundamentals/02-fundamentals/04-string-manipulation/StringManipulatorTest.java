public class StringManipulatorTest {
    public static void main(String[] args) {
        StringManipulator stringManipulator = new StringManipulator();
        String myString = stringManipulator.trimAndConcat("Hello", "World");
        System.out.println(myString);

        char letter = 'o';
        Integer a = stringManipulator.getIndexOrNull("Coding", letter);
        Integer b = stringManipulator.getIndexOrNull("Hello World", letter);
        Integer c = stringManipulator.getIndexOrNull("Hi", letter);
        System.out.println(a); // 1
        System.out.println(b); // 4
        System.out.println(c); // null

        String word = "Hello";
        String subString = "llo";
        String notSubString = "world";
        Integer one = stringManipulator.getIndexOrNull(word, subString);
        Integer two = stringManipulator.getIndexOrNull(word, notSubString);
        System.out.println(one); // 2
        System.out.println(two); // null

    }

}