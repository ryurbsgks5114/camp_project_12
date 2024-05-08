package subject;

public class Subject {
    private int subjectId;
    private final String subjectName;
    private final int subjectType;

    // 과목 ID, 이름 및 유형을 매개변수로 받아서 해당 필드에 할당
    public Subject(String subjectName, int subjectType) {
        this.subjectName = subjectName;
        this.subjectType = subjectType;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public int getSubjectType() {
        return subjectType;
    }
}
