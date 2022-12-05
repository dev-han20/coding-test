package boj;

import java.util.Scanner;

public class BOJ_1476 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int E = Star.EARTH.computeYear(sc.nextInt());
        int S = Star.SUN.computeYear(sc.nextInt());
        int M = Star.MOON.computeYear(sc.nextInt());

        long result = 1;
        while (!((result % 15 == E) && (result % 28 == S) && (result % 19 == M))) {
            result++;
        }
        System.out.println(result);


    }

    enum Star {
        EARTH(15), SUN(28), MOON(19);

        int year;

        Star(int year) {
            this.year = year;
        }


        public int computeYear(int N) {
            if (this.year == N) {
                return 0;
            }
            return N;
        }
    }

}
