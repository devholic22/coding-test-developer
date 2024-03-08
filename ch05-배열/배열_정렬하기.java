import java.util.Arrays;

public class 배열_정렬하기 {

    // 240308

    /*
    정수 배열의 길이는 2 이상 10^5 (100000) 이하 => O(NlogN) 접근
    정수 배열의 각 데이터 값은 -100,000 이상 100,000 이하
     */
    public static void main(String[] args) {
        int[] arr = {1, -5, 2, 4, 3};
        System.out.println(Arrays.toString(solution(arr)));
    }

    private static int[] solution(int[] array) {
        int[] clone = array.clone(); // 배열.clone()은 원본 배열을 그대로 두면서 새로운 배열을 복제할 때 사용
        Arrays.sort(clone);

        return clone;
    }
}
