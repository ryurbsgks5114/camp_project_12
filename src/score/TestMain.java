//package score;
//
//import student.StudentList;
//
//import java.util.Scanner;
//
//public class TestMain {
//    public static void main(String[] args) {
//        ScoreList scoreList = new ScoreList();
//
//        Scanner sc = new Scanner(System.in);
//
//        while (true) {
//            System.out.println("점수를 등록할 수강생의 고유번호를 입력해주세요.");
//            int studentId = sc.nextInt();
//
//            System.out.println("과목 코드를 입력해주세요.");
//            int subjectId = sc.nextInt();
//
//            Score tempScore = scoreList.getScoreList(studentId, subjectId);
//
//            if (tempScore != null) {
//                System.out.println("등록할 점수의 시험회차를 입력해주세요.");
//                int round = sc.nextInt();
//
//                System.out.println("점수를 입력해주세요");
//                int scoreValue = sc.nextInt();
//
//                tempScore.scoreAdd(round, scoreValue);
//            } else {
//                System.out.println("등록할 점수의 시험회차를 입력해주세요.");
//                int round = sc.nextInt();
//
//                System.out.println("점수를 입력해주세요");
//                int scoreValue = sc.nextInt();
//
//                Score score = new Score(studentId, subjectId, 2);
//
//                score.scoreAdd(round, scoreValue);
//                scoreList.scoreListAdd(score);
//            }
//
//            scoreList.inquiryToScoreList(studentId,subjectId);
//
//            System.out.println("점수를 수정하시겠습니까? (수정 입력시 수정)");
//            if("수정".equals(sc.next())) {
//                System.out.println("수정할 회차를 입력해주세요");
//                int round = sc.nextInt();
//
//                System.out.println("수정될 점수를 입력해주세요.");
//                int scorevalue = sc.nextInt();
//
//                scoreList.setScoreList(studentId,subjectId,round,scorevalue);
//            }
//
//            scoreList.inquiryToScoreList(studentId,subjectId);
//
//            System.out.println("점수 등록을 종료하시겠습니까? (exit 입력 시 종료)");
//            if ("exit".equals(sc.next())) {
//                break;
//            }
//        }
//    }
//}