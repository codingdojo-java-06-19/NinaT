import java.util.ArrayList;

public class Exceptions {
    public static void main(String[] args) {
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add(Integer.parseInt("13"));
        myList.add("Hello world!");
        myList.add(48);
        myList.add("Goodbye cruel world");

        for (int i = 0; i < myList.size(); i++) {
            try {
                Integer castedValue = (Integer) myList.get(i);
                System.out.println(castedValue);
            } catch (Exception e) {
                System.out.println("The error is: " + e.getMessage());
            }

        }
    }
}