import java.util.Arrays;

public class 주식_가격 {

    // 240316

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 2, 3}))); // [4, 3, 1, 1, 0]
    }

    // 시간 복잡도에서 실패되는 코드임
    private static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int count = 1;
            for (int j = i + 1; j < prices.length; j++) {
                if (j >= prices.length) {
                    answer[i] = 0; // 0인 순간은 이 때만이 유일함
                    break;
                }
                if (prices[i] <= prices[j]) {
                    answer[i] = count; // 이걸 생략하면 실패함
                    count++;
                } else {
                    answer[i] = count; // 꺾여지면 더 이상 하지 않아야 한다.
                    break;
                }
            }
        }
        return answer;
    }
}
