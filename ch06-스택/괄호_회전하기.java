import java.util.ArrayDeque;

public class 괄호_회전하기 {

    // 240313

    public static void main(String[] args) {
        System.out.println(solution("[](){}")); // 3
        System.out.println(solution("}]()[{")); // 2
        System.out.println(solution("[)(]")); // 0
        System.out.println(solution("}}}")); // 0
    }

    public static int solution(String s) {
        int iterate = s.length();
        int count = 0;
        for (int i = 0; i < iterate; i++) {
            s = change(s);
            if (isValid(s)) {
                // System.out.println(s);
                count++;
            }
        }
        return count;
    }

    private static String change(String s) {
        ArrayDeque<String> queue = new ArrayDeque<>();
        String[] token = s.split("");
        for (String t : token) {
            queue.addLast(t);
        }
        // change!
        String head = queue.pollFirst();
        queue.addLast(head);

        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()) {
            builder.append(queue.pollFirst());
        }

        return builder.toString();
    }

    private static boolean isValid(String s) {
        char[] tokens = s.toCharArray();
        if (tokens.length % 2 != 0) {
            return false;
        }
        if (tokens[tokens.length - 1] == '[' || tokens[tokens.length - 1] == '{' || tokens[tokens.length - 1] == '(') {
            return false;
        }
        if (tokens[0] == ']' || tokens[0] == '}' || tokens[0] == ')') {
            return false;
        }
        ArrayDeque<Character> queue = new ArrayDeque<>(); // character로 바꾸는 게 더 빠름
        for (char t : tokens) {
            if (t == '[' || t == '{' || t == '(') {
                queue.addLast(t);
                continue;
            }
            if (queue.isEmpty() && (t == ']' || t == '}' || t == ')')) {
                return false;
            }
            if (!queue.isEmpty() && queue.peekLast() == '[' && t == ']') {
                queue.pollLast();
                continue;
            }
            if (!queue.isEmpty() && queue.peekLast() == '{' && t == '}') {
                queue.pollLast();
                continue;
            }
            if (!queue.isEmpty() && queue.peekLast() == '(' && t == ')') {
                queue.pollLast();
            }
        }
        return queue.isEmpty();
    }
}
