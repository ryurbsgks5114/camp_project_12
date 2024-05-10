package store;

import score.Score;

public class ScoreStore<T extends Score> extends DataStore<T> {

    public ScoreStore() {
        super();
    }

    @Override
    public void addData(T data) {
        super.getDataStore().add(data);
    }

    @Override
    public void inquiryData() {

    }

    public Score getScoreList (int studentId, int subjectId) {
        for (Score score : super.getDataStore()) {
            if (score.getStudentId() == studentId && score.getSubjectid() == subjectId) {
                return score;
            }
        }
        return null;
    }

    public void removeScoreList(int studentId) {
        for (int i=0; i < super.getDataStore().size(); i++) {
            if (studentId == super.getDataStore().get(i).getStudentId()) {
                super.getDataStore().remove(i);
            }
        }
    }

    public void setScoreList (int studentId, int subjectId, int round, int scoreValue) {
        super.getDataStore().stream().filter(score -> score.getStudentId() == studentId && score.getSubjectid() == subjectId).forEach(score -> score.setScore(studentId,subjectId,round,scoreValue));
    }

    public void inquiryToScoreList (int studentId, int subjectId) {
        super.getDataStore().stream().filter(score -> score.getStudentId() == studentId && score.getSubjectid() == subjectId).forEach(Score::getScore);
    }

}
