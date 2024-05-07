package subject;

public class Subject {
    private final int subjectId;
    private final String subjectName;
    private final int subjectType;

    // 과목 ID, 이름 및 유형을 매개변수로 받아서 해당 필드에 할당
    public Subject(int subjectId, String subjectName, int subjectType) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.subjectType = subjectType;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public int getSubjectType() {
        return subjectType;
    }
}