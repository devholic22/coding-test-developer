import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class 배열_제어하기 {

    // 240308

    /*
    배열 길이는 2 이상 1,000 이하 => O(N^2) 가능하긴 함
    각 배열의 데이터 값은 -100,000 이상 100,000 이하
     */
    public static void main(String[] args) {
        // 배열의 중복값을 제거하고 배열 데이터를 내림차순으로 정렬해서 반환하기
        int[] arr = {4, 2, 2, 1, 3, 4};
        System.out.println(Arrays.toString(solution(arr)));
    }

    private static int[] solution(int[] array) {
        HashSet<Integer> set = new HashSet<>();
        // O(N)
        for (int number : array) {
            set.add(number);
        }
        Object[] arr = set.toArray();
        Integer[] result = new Integer[arr.length];
        // O(N)
        for (int i = 0; i < arr.length; i++) {
            result[i] = (int) arr[i];
        }
        // O(NlogN)
        Arrays.sort(result, Collections.reverseOrder());

        return Arrays.stream(result)
                .mapToInt(x -> x)
                .toArray();

        /* 다른 접근 방법
        Integer[] result = Arrays.stream(array).boxed().distinct().toArray(Integer[]::new);
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder()); => O(NlogN)
         */
    }
}
