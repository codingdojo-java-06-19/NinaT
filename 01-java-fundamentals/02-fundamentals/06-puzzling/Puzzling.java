import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Puzzling {

    // Challenge 1
    public ArrayList challenge1() {
        int myArr[] = { 3, 5, 1, 2, 7, 9, 8, 13, 25, 32 };
        int sum = 0;
        ArrayList<Integer> newArr = new ArrayList<Integer>();
        for (int i = 0; i < myArr.length; i++) {
            sum += myArr[i];
            if (myArr[i] > 10) {
                newArr.add(myArr[i]);
            }
        }
        System.out.println(sum);
        return newArr;

    }

    // Challenge 2
    public ArrayList challenge2() {
        String names[] = { "Nancy", "Jinichi", "Fujiabayashi", "Momochi", "Ishikawa" };
        ArrayList<String> longNames = new ArrayList<String>();
        List list = Arrays.asList(names);
        Collections.shuffle(list);
        for (String name : names) {
            System.out.println(name);
            if (name.length() > 5) {
                longNames.add(name);
            }
        }
        return longNames;
    }

    // Challenge 3
    public void challenge3() {
        char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
        Collections.shuffle(Arrays.asList(alphabet));
        char first = alphabet[0];
        System.out.println("The last letter is: " + alphabet[25]);
        System.out.println("The first letter is: " + first);
        if (first == 'a' || first == 'e' || first == 'i' || first == 'o' || first == 'u') {
            System.out.println("The first letter is a vowel. Kill it!!");
        }
    }

    // Challenge 4
    public int[] challenge4() {
        int[] arr = new int[10];
        Random random = new Random();
        for (int j = 0; j <= 10; j++) {
            arr[j] = random.nextInt(46) + 55;
        }
        return arr;
    }

    // Challenge 5
    public int[] challenge5() {
        int[] arr = new int[10];
        Random random = new Random();
        for (int k = 0; k <= 10; k++) {
            arr[k] = random.nextInt(46) + 55;
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("The minimum value is: " + arr[0] + " and the maximum value is: " + arr[arr.length - 1]);
        return arr;
    }

    // Challenge 6
    public String challenge6() {
        Random random = new Random();
        char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
        String myStr = "";
        for (int l = 0; l < 5; l++) {
            int randletter = random.nextInt(26);
            myStr += alphabet[randletter];
        }
        return myStr;
    }

    // Challenge 7
    public String[] challenge7() {
        Random rand = new Random();
        String[] stringArr = new String[10];
        char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
        for (int i = 0; i < 10; i++) {
            String str = "";
            for (int n = 0; n < 5; n++) {
                int random = rand.nextInt(26);
                str += alphabet[random];
            }
        }
        return stringArr;
    }
}