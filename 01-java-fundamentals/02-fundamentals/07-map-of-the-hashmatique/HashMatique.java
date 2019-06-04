import java.util.HashMap;
import java.util.Set;

public class HashMatique {
        public static void main(String[] args) {
                HashMap<String, String> trackList = new HashMap<String, String>();
                trackList.put("Boom Boom Pow",
                                "I'm so 3008 / You so 2000 and late / I got that boom boom boom / That future boom boom boom");
                trackList.put("Gold Digger",
                                "Now I'm not saying she's a gold digger / But she ain't messing with no broke, broke");
                trackList.put("Hey Ya!",
                                "Now what's cooler than being cool? / Ice cold! / I can't hear ya - I say, what's cooler than being cold? / ICE COLD!");
                trackList.put("Hips Don't Lie",
                                "I never really knew that she could dance like this / She makes a man want to speak Spanish / Commo se llama, bonita, mi casu, su casa /Shakira Shakira");
                System.out.println("The lyrics to Hips Don't Lie: " + trackList.get("Hips Don't Lie"));
                Set<String> titles = trackList.keySet();
                for (String title : titles) {

                        System.out.println(title + " : " + trackList.get(title));
                }
        }
}