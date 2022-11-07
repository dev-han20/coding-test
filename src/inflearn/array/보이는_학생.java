package inflearn.array;

import java.util.Scanner;

public class 보이는_학생 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String[] arr = sc.nextLine().split(" ");

        int maxHeight = Integer.MIN_VALUE;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            int height = Integer.parseInt(arr[i]);
            if(height > maxHeight){
                maxHeight = height;
                count++;
            }
        }
        System.out.println(count);
    }
}
