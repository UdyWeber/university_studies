import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int[] testIntArray = new int[]{1, 2, 3, 4, 5};
        String[] testStringArray = new String[]{"Jolestest", "Claudete", "Jhonson"};
        boolean[] testBooleanArray = new boolean[]{true, true, false, true};

        assert Arrays.equals(Exercises.exercise2(testIntArray), new int[]{5, 4, 3, 2, 1});
        assert Arrays.equals(Exercises.exercise3(testIntArray), new int[]{2, 4});
        assert Exercises.exercise4(testStringArray, "Jolestest") == 1;
        assert Exercises.exercise4(testStringArray, "Cleison") == -1;
        assert Arrays.equals(Exercises.exercise5(testBooleanArray), new int[]{1, 1, 0, 1});
        assert Arrays.equals(Exercises.exercise6(new int[]{1, 2}, new int[]{3, 4}), new int[]{1, 2, 3, 4});
        Exercises.exercise8(new char[]{'J', 'a', 'w'});
        assert Exercises.exercise9(testIntArray) == 3;
        assert Exercises.exercise10(testIntArray) == 3;
        Exercises.exercise19(3);
    }
}