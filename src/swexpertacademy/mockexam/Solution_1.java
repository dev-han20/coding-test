package swexpertacademy.mockexam;

/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;
// double b = 1.0;
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
/*
#####################################################################################################
문제 및 풀이에 대해 사외 온라인/오프라인에 게시/공유 하는 것은 금지되어 있습니다.
        SW Expert 아카데미의 문제는 삼성전자 직원에게만 오픈 되어 있습니다.


        [제한 사항]


        시간

        32개 테스트케이스를 합쳐서 C/C++의 경우 10초 / Java의 경우 20초

        메모리

        힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내


        호설이는 연말을 맞아 휴가를 끌어 모아 여행을 가려고 한다.



        이 여행지에는 관광 도시들이 1행, 1열부터 R행 C열까지 있으며, 총 R x C 개의 도시로 이루어져 있다.

        호설이는 여행 첫날엔 1행 1열의 도시로 출발한다.

        각 도시에는 A부터 Z 중 하나의 알파벳으로 나타낼 수 있는 기념품이 있으며, 같은 알파벳은 같은 기념품이다.



        호설이는 파트원들에게 나눠주기 위해 도시에 도착할 때마다 기념품을 구매할 계획이다.

        그리고, 호설이는 현재 위치에서 기념품을 구매 후 4방향(동, 서, 남, 북) 중 한 방향으로 1칸 이동하여 다음 도시로 이동한다.



        호설이는 휴가까지 아끼며 일을 했지만 모아둔 돈이 많지 않다.

        따라서 기념품을 최대한 많이 구매하되, 종류가 겹치지 않도록 여행 경로를 계획하고 싶다.



        호설이가 1행 1열에서 여행을 시작했을 때, 같은 기념품을 두 개 이상 사지 않도록 여행을 떠나는 방법 중에 가장 많은 기념품을 구매할 수 있는 최대 개수를 구하여라.



        [입력]


        첫 번째 줄에 테스트 케이스의 수 T가 주어진다.


        각 테스트 케이스의 첫 번째 줄에는 여행지의 크기 R, C(1≤R, C≤20)가 주어진다.


        이어서 R개의 줄마다 C개의 알파벳 대문자가 빈 칸 없이 주어진다.




        [출력]


        각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,

        각 테스트 케이스마다 호설이가 여행하면서 살 수 있는 기념품 개수의 최대치를 출력하라.

#####################################################################################################
*/

import java.math.BigDecimal;
import java.util.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution_1 {
    private static final int[] moveRow = {-1, 0, 1, 0};
    private static final int[] moveCol = {0, 1, 0, -1};

    public static void main(String args[]) throws Exception {
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
        //System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int row = sc.nextInt();     // 행
            int col = sc.nextInt();     // 열

            String[][] cities = new String[row][col];   // 도시들

            // 도시들 기념품 초기 셋팅
            initCities(sc, cities);

            // 호설이의 기념품 최대 구매 경로 찾기 시작
            int count = findMaxSouvenirCount(new Man(0, 0), cities);
            System.out.println("#" + test_case + " " + count);
        }
    }

    private static int findMaxSouvenirCount(Man man, String[][] cities) {
        int maxSouvenirCount = 0;
        Queue<Man> bfsQueue = new LinkedList<>();
        man.buy(cities[man.row][man.col]);    // 현재 위치 기념품 구매
        bfsQueue.offer(man);    // 출발위치 지정

        while (!bfsQueue.isEmpty()) {
            Man manOfCurrentLocation = bfsQueue.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = manOfCurrentLocation.row + moveRow[i];    // 다음 도시 행 좌표
                int nextCol = manOfCurrentLocation.col + moveCol[i];    // 다음 도시 열 좌표

                // 도시 벗어나면 다음 도시로
                if (nextRow < 0 || nextCol < 0 || nextRow >= cities.length || nextCol >= cities[0].length) {
                    continue;
                }

                String souvenir = cities[nextRow][nextCol];    // 다음 도시 기념품

                // 기념품이 이미 있으면 다음 도시
                if (manOfCurrentLocation.isExist(souvenir)) {
                    // 현재까지 구매한 기념품 개수 확인
                    maxSouvenirCount = Math.max(maxSouvenirCount, manOfCurrentLocation.getSouvenirCount());
                    continue;
                }

                Man manOfNextLocation = new Man(nextRow, nextCol, manOfCurrentLocation.purchasedSouvenirs);
                manOfNextLocation.buy(souvenir);
                bfsQueue.add(manOfNextLocation);
            }
        }

        return maxSouvenirCount;
    }

    private static void initCities(Scanner sc, String[][] cities) {
        for (int i = 0; i < cities.length; i++) {
            String[] rowInfo = sc.next().split("");
            for (int j = 0; j < rowInfo.length; j++) {
                cities[i][j] = rowInfo[j];
            }
            sc.nextLine();
        }
    }

    static class Man {
        private int row;    // 현재 행 좌표
        private int col;    // 현재 열 좌표
        private Set<String> purchasedSouvenirs;    // 기념품 구매 목록

        public Man(int row, int col) {
            this.row = row;
            this.col = col;
            this.purchasedSouvenirs = new HashSet<>();
        }

        public Man(int row, int col, Set<String> souvenirs) {
            this.row = row;
            this.col = col;
            this.purchasedSouvenirs = new HashSet<>(souvenirs);
        }

        public void buy(String souvenir) {
            this.purchasedSouvenirs.add(souvenir);
        }

        public boolean isExist(String souvenir) {
            return this.purchasedSouvenirs.contains(souvenir);
        }

        public int getSouvenirCount() {
            return this.purchasedSouvenirs.size();
        }
    }
}