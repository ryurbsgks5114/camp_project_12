package score;

import java.util.ArrayList;

public class Score {
    int studentId;  // 수강생 고유번호
    int subjectId;  // 과목 고유번호
    ArrayList<Integer> roundAndScore;
    ArrayList<String> grade;

    public Score() {
        roundAndScore = new ArrayList<>();
        grade = new ArrayList<>();
    }
}