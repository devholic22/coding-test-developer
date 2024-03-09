import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class 모의고사 {

    // 240309

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {1, 3, 2, 4, 2};
        System.out.println(Arrays.toString(solution(array1)));
        System.out.println(Arrays.toString(solution(array2)));
    }

    private static int[] solution(final int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        HashMap<Integer, Integer> result = new HashMap<>();
        result.put(1, 0);
        result.put(2, 0);
        result.put(3, 0);

        // O(N)
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == one[i % 5]) result.put(1, result.get(1) + 1);
            if (answers[i] == two[i % 8]) result.put(2, result.get(2) + 1);
            if (answers[i] == three[i % 10]) result.put(3, result.get(3) + 1);
        }

        // 3개 고정되어 있음
        int max = 0;
        max = Math.max(result.get(1), Math.max(result.get(2), result.get(3)));

        ArrayList<Integer> temp = new ArrayList<>();

        // O(N)
        for (int number : result.keySet()) {
            if (result.get(number) == max) {
                temp.add(number);
            }
        }

        return temp.stream()
                .mapToInt(x -> x)
                .toArray();
    }
}
