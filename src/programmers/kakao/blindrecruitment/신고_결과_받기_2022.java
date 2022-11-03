package programmers.kakao.blindrecruitment;

import java.util.*;

public class 신고_결과_받기_2022 {

    public static void main(String[] args) {
        신고_결과_받기_2022 ss = new 신고_결과_받기_2022();
        String[] ids = {"muzi", "frodo", "apeach", "neo"};
        String[] repo = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int[] solution = ss.solution(ids, repo, 2);
        for (int i : solution) {
            System.out.println(i);
        }
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        ReportMachine rm = new ReportMachine(k);

        for (int i = 0; i < report.length; i++) {
            String[] reportInfo = report[i].split(" ");
            rm.report(reportInfo[0], reportInfo[1]);
        }

        return rm.extractResult(id_list);
    }

    static class ReportMachine {
        private Map<String, Set<String>> reporters = new HashMap<>();
        private Map<String, Set<String>> reportedUsers = new HashMap<>();
        private Set<String> suspendUsers = new HashSet<>();
        private int suspendCount;

        public ReportMachine(int suspendCount) {
            this.suspendCount = suspendCount;
        }

        public void report(String reporter, String reported) {
            recodeReporters(reporter, reported);
            recodeReportedUsers(reported, reporter);
        }

        private void recodeReportedUsers(String reported, String reporter) {
            Set<String> temp = reportedUsers.getOrDefault(reported, new HashSet<>());
            temp.add(reporter);
            reportedUsers.put(reported, temp);

            if (temp.size() >= suspendCount) {
                suspendUsers.add(reported);
            }
        }

        private void recodeReporters(String reporter, String reported) {
            Set<String> temp = reporters.getOrDefault(reporter, new HashSet<>());
            temp.add(reported);
            reporters.put(reporter, temp);
        }

        public int[] extractResult(String[] userIds) {
            int[] result = new int[userIds.length];

            for (int i = 0; i < userIds.length; i++) {
                if (reporters.containsKey(userIds[i])) {
                    Set<String> reportedList = reporters.get(userIds[i]);
                    int count = 0;
                    for (String suspendUser : suspendUsers) {
                        if (reportedList.contains(suspendUser)) {
                            count++;
                        }
                    }
                    result[i] = count;
                    continue;
                }
                result[i] = 0;
            }

            return result;
        }
    }
}
