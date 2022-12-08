package inflearn.hashMapTreeSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class 모든_아나그램_찾기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] bs = scanner.nextLine().split("");
        String[] os = scanner.nextLine().split("");

        Map<String, Integer> oMap = new HashMap<>();
        for (String s : os) {
            oMap.put(s, oMap.getOrDefault(s, 0) + 1);
        }

        Map<String, Integer> bMap = new HashMap<>();
        int lt = 0;
        int rt = 0;
        int count = 0;
        int reuslt = 0;
        while (rt != bs.length) {
            bMap.put(bs[rt], bMap.getOrDefault(bs[rt], 0) + 1);
            rt++;
            count++;

            if (count == os.length) {
                boolean isAna = true;
                for (int i = 0; i < os.length; i++) {
                    if (oMap.get(os[i]) != bMap.get(os[i])) {
                        isAna = false;
                        break;
                    }
                }
                if (isAna) {
                    reuslt++;
                }
                String key =  bs[lt];
                int value = bMap.get(key) - 1;
                bMap.put(key, value);
                count--;
                lt++;
            }
        }
        System.out.println(reuslt);





    }
}
