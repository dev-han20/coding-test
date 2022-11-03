package programmers.level.zero;

public class 옹알이_1 {
    public static void main(String[] args) {
        옹알이_1 ss = new 옹알이_1();
        String[] qw = {"aya", "yee", "u", "maa", "wyeoo"};
        System.out.println(ss.solution(qw));
    }

    public int solution(String[] babbling) {
        int count = babbling.length;
        String[] words = {"aya", "ye", "woo", "ma"};
        for (int i = 0; i < babbling.length; i++) {
            for (int j = 0; j < words.length; j++) {
                babbling[i] = babbling[i].replace(words[j], String.valueOf(j));
            }
        }

        for (int i = 0; i < babbling.length; i++) {
            char[] chars = babbling[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (Character.isLetter(chars[j])) {
                    count--;
                    break;
                }
            }
        }

        return count;
    }
}
