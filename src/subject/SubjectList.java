package subject;

import java.util.ArrayList;
import java.util.List;

public class SubjectList {
    private final List<Subject> subjectList;

    public SubjectList() {
        this.subjectList = new ArrayList<>();
    }

    //주어진 과목을 목록에 추가
    public void addSubject(Subject subject) {
        subjectList.add(subject);
    }

    //목록에 있는 과목을 화면에 출력
    public void displaySubjects() {
        if (subjectList.isEmpty()) {
            System.out.println("등록된 과목이 없습니다.");
        } else {
            System.out.println("===== 등록된 과목 목록 =====");
            for (int i = 0; i < subjectList.size(); i++) {
                Subject subject = subjectList.get(i);
                System.out.println((i + 1) + ". 과목 ID: " + subject.getSubjectId() + ", 과목 이름: " + subject.getSubjectName() + ", 과목 유형: " + (subject.getSubjectType() == 1 ? "필수" : "선택"));
            }
            System.out.println("=========================");
        }
    }
}
