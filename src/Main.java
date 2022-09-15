import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public class Main {
    static String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna " +
            "aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
            "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint " +
            "occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    public static void main(String[] args) {
        Map<Character, Integer> charCount = new HashMap<>();
        int min = 1; // меньше одного раза символ войти не может, это будет означать что его просто нет!!!
        int max = 1;
        for (int i = 0; i < text.length(); i++) {
            char position = text.charAt(i);
            if (Character.isLetter(position)) {
                if (!charCount.containsKey(position)) {
                    charCount.put(position, 1);
                } else {
                    int sum = charCount.get(position);
                    charCount.put(position, sum + 1);
                    max = (sum + 1 > max) ? sum + 1 : max;
                    min = (sum + 1 < min) ? sum + 1 : min;
                }
            }
        }
        System.out.println("Если нужно вывести все символы которые встречались меньше всего и больше всего раз");
        for (Map.Entry<Character, Integer> iterator : charCount.entrySet()) {
            if (iterator.getValue() == max) {
                System.out.println("Больше всех символов был: " + iterator + " раз");
            } else if (iterator.getValue() == min) {
                System.out.println("Меньше всего встретился символ " + iterator + " раз");
            }
        }
        System.out.println("Если выводим только по одному максимальному значению и одному минимальному тогда");
        for (Map.Entry<Character, Integer> iterator : charCount.entrySet()) {
            if (min == 0 && max == 0) {
                break;
            }
            if (iterator.getValue() == max) {
                System.out.println("Больше всех символов был: " + iterator + " раз");
                max = 0;
            } else if (iterator.getValue() == min) {
                System.out.println("Меньше всего встретился символ " + iterator + " раз");
                min = 0;
            }
        }
    }
}
