package inflearn.array;

import java.util.*;

public class 등수구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        Student[] sortedStudents = new Student[N];
        Student[] students = new Student[N];
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            Student student = new Student(i + 1, sc.nextInt(), 1);
            students[i] = student;
            sortedStudents[i] = student;
        }
        Arrays.sort(sortedStudents);

        for (int i = 1; i < sortedStudents.length; i++) {
            if (sortedStudents[i].value == sortedStudents[i - 1].value) {
                sortedStudents[i].rank = sortedStudents[i - 1].rank;
                continue;
            }
            sortedStudents[i].rank = i+1;
        }

        for (int i = 0; i < students.length; i++) {
            sb.append(students[i].rank);
            sb.append(" ");
        }
        System.out.println(sb.toString());


    }

    static class Student implements Comparable<Student>{
        int index;
        int value;
        int rank;

        public Student(int index, int value, int rank) {
            this.index = index;
            this.value = value;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student o) {
            return Integer.compare(o.value, this.value);
        }

    }
}
