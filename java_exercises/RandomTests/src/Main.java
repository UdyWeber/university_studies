import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void swap(List<Integer> x, int i, int j) {
        int temp = x.get(i);
        x.set(i, x.get(j));
        x.set(j, temp);
    }

    public static void main(String[] args) {
        List<Integer> listToBeBubbleSorted = new ArrayList<>(Arrays.asList(1, 53, 92, 2, 5));
        System.out.println(listToBeBubbleSorted);

        for (int i = 0; i < listToBeBubbleSorted.size(); i++){
            for (int j = 0; j < listToBeBubbleSorted.size() - 1; j++){
                if (listToBeBubbleSorted.get(j) > listToBeBubbleSorted.get(i)) {
                    swap(listToBeBubbleSorted, i, j);
                }
            }
        }

        System.out.println(listToBeBubbleSorted);
    }
}