package store;

import subject.Subject;

public class SubjectStore<T extends Subject> extends DataStore<T> {

    public SubjectStore() {
        super();
    }

    @Override
    public void addData(T data) {
        data.setSubjectId(super.getAutoIncrement().getIdx());
        super.getDataStore().add(data);
        super.getAutoIncrement().increase();
    }

    @Override
    public void inquiryData() {
        if (super.getDataStore().isEmpty()) {
            System.out.println("등록된 과목이 없습니다.");
        } else {
            System.out.println("===== 등록된 과목 목록 =====");

            for (int i = 0; i < super.getDataStore().size(); i++) {
                Subject subject = super.getDataStore().get(i);
                System.out.println((i + 1) + ". 과목 ID: " + subject.getSubjectId() + ", 과목 이름: " + subject.getSubjectName() + ", 과목 유형: " + (subject.getSubjectType() == 1 ? "필수" : "선택"));
            }

            System.out.println("=============================");
        }
    }

}
