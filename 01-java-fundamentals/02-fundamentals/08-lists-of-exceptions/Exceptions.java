import java.util.ArrayList;

public class Exceptions {
    public ArrayList<String> tryAndCatch() {
        ArrayList<String> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("Hello world!");
        myList.add(48);
        myList.add("Goodbye cruel world");

        for (int i = 0; i < myList.size(); i++) {
            try{
                Integer castedValue = (Integer) myList.get(i);
            }
            catch (IntegerException i){
                System.out.println("not sure what to do");
            }

    }
}