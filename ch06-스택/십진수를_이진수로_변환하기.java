import java.util.ArrayDeque;
import static java.lang.Integer.toBinaryString;

public class 십진수를_이진수로_변환하기 {

    // 240313

    public static void main(String[] args) {
        // 10: 1010
        // 27: 11011
        // 12345: 11000000111001

        /*
        이진수 체계법
        2^n + 2^(n-1) + ... + 2^1 + 2^0
         */
        // 접근법 1: 직접 구현 -> O(logN)
        System.out.println(solution(10)); // 1010
        System.out.println(solution(27)); // 11011
        System.out.println(solution(12345)); // 11000000111001

        // 접근법 2: 기본 API 이용 -> O(logN)
        System.out.println(solution2(10));
        System.out.println(solution2(27));
        System.out.println(solution2(12345));

        // 접근법 3: 스택 구조 이용 -> O(logN)
        System.out.println(solution3(10));
        System.out.println(solution3(27));
        System.out.println(solution3(12345));
    }

    private static String solution(int number) {
        int size = calculateLength(number);
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < size; i++) {
            if (number >= Math.pow(2, size - i - 1)) {
                number -= (int) Math.pow(2, size - i - 1);
                builder.append("1");
            } else {
                builder.append("0");
            }
        }
        return builder.toString();
    }

    private static int calculateLength(int number) {
        if (number <= 2) {
            return 1;
        }
        int length = 0;
        int start = 1;
        while (start < number) {
            start *= 2;
            length++;
        }
        return length;
    }

    private static String solution2(int number) {
        return toBinaryString(number);
    }

    private static String solution3(int number) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        while (number > 0) {
            stack.addLast(number % 2);
            number /= 2;
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pollLast());
        }
        return builder.toString();
    }
}
