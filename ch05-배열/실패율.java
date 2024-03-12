import java.util.Arrays;

public class 실패율 {

    // 240312

    private static class Stage implements Comparable<Stage> {
        private int stage;
        private double failRate;

        public Stage(int stage, double failRate) {
            this.stage = stage;
            this.failRate = failRate;
        }

        @Override
        public int compareTo(Stage other) {
            if (other.failRate == this.failRate) {
                // 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저
                return Double.compare(this.failRate, other.failRate);
            }
            return Double.compare(other.failRate, this.failRate);
        }
    }

    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] solution = solution(N, stages);// [3, 4, 2, 1, 5]
        System.out.println(Arrays.toString(solution));
    }

    private static int[] solution(int N, int[] stages) {
        // N: 스테이지의 갯수
        // stages: 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열
        Stage[] store = new Stage[N];
        int[] answer = new int[N];

        for (int i = 1; i <= N; i++) {
            int failedPerson = getFailedPerson(i, stages);
            int challengedPerson = getChallengedPerson(i, stages);
            if (challengedPerson == 0) { // 스테이지에 도달한 유저가 없는 경우 0 처리
                store[i - 1] = new Stage(i, 0);
            } else {
                double rate = (double) failedPerson / challengedPerson;
                store[i - 1] = new Stage(i, rate);
            }
        }

        Arrays.sort(store);
        for (int i = 0; i < N; i++) {
            answer[i] = store[i].stage;
        }
        return answer;
    }

    private static int getFailedPerson(int stage, int[] stages) {
        int count = 0;
        for (int i = 0; i < stages.length; i++) {
            if (stages[i] == stage) {
                count++;
            }
        }
        return count;
    }

    private static int getChallengedPerson(int stage, int[] stages) {
        int count = 0;
        for (int i = 0; i < stages.length; i++) {
            if (stages[i] < stage) {
                continue;
            }
            count++;
        }
        return count;
    }
}
