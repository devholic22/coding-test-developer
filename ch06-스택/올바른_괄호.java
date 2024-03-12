import java.util.ArrayDeque;

public class 올바른_괄호 {

    // 240312
    // String보다 Character가 빨라서 효율성에서 틀렸던 건데 너무 사소한 것 같음..
    
    public static void main(String[] args) {
        System.out.println(solution("()()")); // true
        System.out.println(solution("(())()")); // true
        System.out.println(solution(")()(")); // false
        System.out.println(solution("(()(")); // false
    }

    private static boolean solution(String s) {
        if (s.startsWith(")") || s.endsWith("(")) {
            return false;
        }
        ArrayDeque<Character> queue = new ArrayDeque<>();

        char[] tokens = s.toCharArray();

        for (char token : tokens) {
            if (token == '(') {
                queue.addLast(token);
            }
            if (!queue.isEmpty() && token == ')' && queue.peekLast() == '(') {
                queue.pollLast();
                continue;
            }
            if (queue.isEmpty() && token == ')') {
                return false;
            }
        }
        return queue.isEmpty();
    }
}
