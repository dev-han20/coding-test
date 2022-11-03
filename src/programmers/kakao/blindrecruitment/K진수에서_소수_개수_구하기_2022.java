package programmers.kakao.blindrecruitment;

public class K진수에서_소수_개수_구하기_2022 {

    public static void main(String[] args) {
        K진수에서_소수_개수_구하기_2022 ss = new K진수에서_소수_개수_구하기_2022();
        String convertNumber = Long.toString(55768, 3);
        System.out.println(convertNumber);
    }

    public int solution(int n, int k) {

        String convertNumber = Long.toString(n, k);
        String[] numbers = convertNumber.split("0");
        int count = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i].isEmpty() || numbers[i].isBlank() || numbers[i].equals("1")) {
                continue;
            }

            if (isPrimeNumber(Long.parseLong(numbers[i]))) {
                count++;
            }
        }
        return count;
    }

    // 에라토스 테네스의 체 응용
    // 소수 판별 시 해당 값이 제곱근 정수를 구하고
    // 해당 정수까지만 나눠보면 소수 판별 가능
    // 제곱근 정수 이상의 수로 나눠진다해도 이미 나눠진 몫이 제곱근 정수보다 작으므로
    // 제곱근 정수 이상의 수로 나눠진다는 건 이미 앞에서 제곱근 정수 이하의 수로 나눠졌다는 의미
    private boolean isPrimeNumber(long number) {
        long sqrt = (long)Math.sqrt(number);

        for (long i = 2; i <= sqrt; i++) {
            if (number % i == 0) {
                return false;
            }

        }
        return true;
    }

}
