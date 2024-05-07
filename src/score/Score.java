package score;

import java.util.ArrayList;

// 1수강생, 1과목에 대한 점수를 저장하는 객체 생성 클래스
public class Score {
    private final int STUDENT_ID;  // 수강생 고유번호
    private final int SUBJECT_ID;  // 과목 고유번호
    private final int SUBJECT_TYPE;
    ArrayList<ArrayList<String>> scoreAndGrade;    // 회차는 Index를 기준으로 함 (0~9)

    // 수강생 ID, 과제 ID를 기준으로 점수 객체 생성
    public Score(int studentId, int subjectId, int subjectType) {
        this.STUDENT_ID = studentId;
        this.SUBJECT_ID = subjectId;
        this.SUBJECT_TYPE = subjectType;
        scoreAndGrade = new ArrayList<>();

        System.out.println("객체 생성");
    }

    // 회차별 점수 등록
    public void scoreAdd(int round, int score) {    // 입력할 회차에 점수가 기 등록되어있을 경우,이 메서드는 거부되어야함.
        String scoreToString = Integer.toString(score);
        String scoreToGrade = "";

        if (SUBJECT_TYPE == 1) {
            if (score >= 95) {
                scoreToGrade = "A";
            } else if (score >= 90) {
                scoreToGrade = "B";
            } else if (score >= 80) {
                scoreToGrade = "C";
            } else if (score >= 70) {
                scoreToGrade = "D";
            } else if (score >= 60) {
                scoreToGrade = "F";
            } else {
                scoreToGrade = "N";
            }
        } else if (SUBJECT_TYPE == 2) {
            if (score >= 90) {
                scoreToGrade = "A";
            } else if (score >= 80) {
                scoreToGrade = "B";
            } else if (score >= 70) {
                scoreToGrade = "C";
            } else if (score >= 60) {
                scoreToGrade = "D";
            } else if (score >= 50) {
                scoreToGrade = "F";
            } else {
                scoreToGrade = "N";
            }
        }


        ArrayList<String> scoreAndGradePair = new ArrayList<>();
        scoreAndGradePair.add(scoreToString);
        scoreAndGradePair.add(scoreToGrade);

        scoreAndGrade.add(scoreAndGradePair);

        System.out.println("점수 저장완료");
    }

    // 점수 및 등급 수정
    public void scoreSet(int studentId, int subjectId, int round, int score) {
        if (this.STUDENT_ID == studentId && this.SUBJECT_ID == subjectId) {
            String scoreToString = Integer.toString(score);
            String scoreToGrade = "";

            if (score >= 95) {
                scoreToGrade = "A";
            } else if (score >= 90) {
                scoreToGrade = "B";
            } else if (score >= 80) {
                scoreToGrade = "C";
            } else if (score >= 70) {
                scoreToGrade = "D";
            } else if (score >= 60) {
                scoreToGrade = "F";
            } else {
                scoreToGrade = "N";
            }

            ArrayList<String> scoreAndGradePair = new ArrayList<>();
            scoreAndGradePair.add(scoreToString);
            scoreAndGradePair.add(scoreToGrade);

            for (int i = 0; i < scoreAndGrade.size(); i++) {
                if (i == round-1) {
                    scoreAndGrade.set(i, scoreAndGradePair);
                }
            }
        }
    }

    // 과목별 점수 조회
    public void getScore (int studentId, int subjectId) {
        for (int i=0; i<scoreAndGrade.size(); i++) {
                System.out.println(i+1 + "회차 : " + scoreAndGrade.get(i).get(0) + ", " + scoreAndGrade.get(i).get(1));
        }
    }
}