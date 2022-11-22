package inflearn.towpointersandslidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class 공통원소_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N1 = Integer.parseInt(br.readLine());
        List<Integer> arrayA = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int N2 = Integer.parseInt(br.readLine());
        List<Integer> arrayB = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int ltA = 0;
        int ltB = 0;

        Collections.sort(arrayA);
        Collections.sort(arrayB);

        List<Integer> commonElements = new ArrayList<>();

        while (ltA != N1 && ltB != N2) {
            int A = arrayA.get(ltA);
            int B = arrayB.get(ltB);

            if (A == B) {
                commonElements.add(A);
                ltA++;
                ltB++;
                continue;
            }

            if (A > B) {
                ltB++;
                continue;
            }

            if (A < B) {
                ltA++;
                continue;
            }
        }

        for (Integer commonElement : commonElements) {
            System.out.print(commonElement + " ");
        }

        br.close();
    }
}
