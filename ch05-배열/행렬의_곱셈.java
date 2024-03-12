public class 행렬의_곱셈 {

    // 240312

    // 행렬의 곱셈은 arr1 x arr2일 때 answer[arr1.height][arr2.width]로 계산해야 함

    public static void main(String[] args) {
        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = {{3, 3}, {3, 3}};
        int[][] solution = solution(arr1, arr2);

        // 정답 확인용
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution[0].length; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] solution(int[][] arr1, int[][] arr2) {
        int height1 = arr1.length;
        int width1 = arr1[0].length; // == height2
        int height2 = arr2.length; // == width1
        int width2 = arr2[0].length;

        int[][] answer = new int[height1][width2];
        for (int i = 0; i < height1; i++) {
            for (int j = 0; j < width2; j++) {
                int sum = 0;
                for (int k = 0; k < width1; k++) {
                    sum += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = sum;
            }
        }
        return answer;
    }
}
