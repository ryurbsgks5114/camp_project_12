package store;

import subject.Subject;

public class StaticDataStore<T> extends DataStore<T> {

    public StaticDataStore() {
        super();
    }

    @Override
    public void inquiryData() {

        if (super.getDataStore().isEmpty()) {
            System.out.println("등록된 과목이 없습니다.");
        } else {
            System.out.println("===== 등록된 과목 목록 =====");

            for (int i = 0; i < super.getDataStore().size(); i++) {
                Subject subject = (Subject) super.getDataStore().get(i);
                System.out.println((i + 1) + ". 과목 ID: " + subject.getSubjectId() + ", 과목 이름: " + subject.getSubjectName() + ", 과목 유형: " + (subject.getSubjectType() == 1 ? "필수" : "선택"));
            }

            System.out.println("=============================");
        }

    }

}
