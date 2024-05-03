public class Subject {
    private int subjectId;
    private String subjectName;
    private int subjectType;

    public Subject(int subjectId, String subjectName, int subjectType)
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