import java.util.ArrayDeque;

public class 짝지어_제거하기 {

    // 240317

    public static void main(String[] args) {
        System.out.println(solution("baabaa")); // 1
        System.out.println(solution("cdcd")); // 0
    }

    private static int solution(String s) {
        if (clear(s)) {
            return 1;
        }
        return 0;
    }

    private static boolean clear(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] inputs = s.toCharArray();
        for (char input : inputs) {
            if (!stack.isEmpty() && stack.peekLast() == input) {
                stack.pollLast();
                continue;
            } else {
                // isEmpty()일 때만 넣게 했는데 아니었다. (당연한 말..)
                stack.addLast(input);
            }
        }
        return stack.isEmpty();
    }
}
