package utils;

import java.util.ArrayList;
import java.util.List;

public class TestUtil {
    public static Integer getNumberFromString(String str) {
        StringBuilder myNumbers = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                myNumbers.append(str.charAt(i));
            }
        }
        return Integer.parseInt(myNumbers.toString());
    }

    public static List<Integer> getNumbersFromStringList(List<String> elements) {
        List<Integer> intElements = new ArrayList<>();
        for (String element : elements) {
            intElements.add(TestUtil.getNumberFromString(element));
        }
        return intElements;
    }
}
