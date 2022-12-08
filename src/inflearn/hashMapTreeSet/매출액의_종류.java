package inflearn.hashMapTreeSet;

import java.util.*;

public class 매출액의_종류 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int N = sc.nextInt();
        int K = sc.nextInt();
        List<Integer> infos = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            infos.add(sc.nextInt());
        }

        Map<Integer, Integer> map = new HashMap<>();

        int rt = 0;
        int lt = 0;
        int count = 0;
        while(rt != infos.size()){
            map.put(infos.get(rt), map.getOrDefault(infos.get(rt), 0) + 1);
            rt++;
            count++;

            if (count == K) {
                sb.append(map.size()).append(" ");
                int key = infos.get(lt);
                int value = map.get(key) - 1;
                if (value == 0) {
                    map.remove(key);
                } else {
                    map.put(key, value);
                }

                lt++;
                count--;
            }

        }
        System.out.println(sb.toString());

    }

}
