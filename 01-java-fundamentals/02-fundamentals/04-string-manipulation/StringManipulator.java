public class StringManipulator {

    public String trimAndConcat(String string1, String string2) {
        String result = string1.trim() + string2.trim();
        return result;
    }

    public Integer getIndexOrNull(String str, char charac) {
        if (str.indexOf(charac) >= 0) {
            return str.indexOf(charac);
        } else {
            return null;
        }
    }

    public Integer getIndexOrNull(String string1, String string2) {
        if (string1.indexOf(string2) >= 0) {
            return string1.indexOf(string2);
        } else {
            return null;
        }
    }

    public String concatSubstring(String string1, int one, int two, String string2) {
        return string1.substring(one, two).concat(string2);
    }
}
