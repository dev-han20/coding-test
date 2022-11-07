package programmers.level.zero;


import java.util.*;

public class 최빈값_구하기 {
    public int solution(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int maxIndex = -1;
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (max < entry.getValue()) {
            }
        }





        return -1;
    }
}
