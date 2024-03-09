import java.util.Arrays;
import java.util.HashSet;

public class 두개_뽑아서_더하기 {

    // 240309
    
    public static void main(String[] args) {
        int[] numbers = {2, 1, 3, 4, 1};
        int[] numbers2 = {5, 0, 2, 7};
        int[] result = solution(numbers);
        int[] result2 = solution(numbers2);
        Arrays.sort(result); // O(logN^2)
        Arrays.sort(result2);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result2));
    }

    private static int[] solution(final int[] numbers) {
        HashSet<Integer> result = new HashSet<>();
        // O(N^2)
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i >= j) continue;
                result.add(numbers[i] + numbers[j]);
            }
        }
        return result.stream()
                .mapToInt(x -> x)
                .toArray();
    }
}
