package inflearn.array;

import java.util.Scanner;

public class 가위바위보 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String[] A = sc.nextLine().split(" ");
        String[] B = sc.nextLine().split(" ");

        for (int i = 0; i < N; i++) {
            int numA = Integer.parseInt(A[i]);
            int numB = Integer.parseInt(B[i]);

            if (numA == numB) {
                System.out.println("D");
                continue;
            }

            switch (numA) {
                case 1: //가위
                    if (numB == 2) {
                        System.out.println("B");
                    } else if (numB == 3) {
                        System.out.println("A");
                    }
                    break;
                case 2: // 바위
                    if (numB == 1) {
                        System.out.println("A");
                    } else if (numB == 3) {
                        System.out.println("B");
                    }
                    break;
                case 3: // 보
                    if (numB == 1) {
                        System.out.println("B");
                    } else if (numB == 2) {
                        System.out.println("A");
                    }
                    break;
            }
        }
    }

}
