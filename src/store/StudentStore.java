package store;

import student.Student;

import java.util.Iterator;

public class StudentStore<T extends Student> extends DataStore<T> {

    public StudentStore() {
        super();
    }

//    추가하는 메서드 추상 메서드로 만들어서 오버라이딩할 때 추가해야하는 문장
//    System.out.println(student.getStudentName() + " 학생이 추가되었습니다.");
    @Override
    public void addData(T data) {
        data.setStudentId(super.getAutoIncrement().getIdx());
        super.getDataStore().add(data);
        super.getAutoIncrement().increase();
        System.out.println(data.getStudentName() + " 학생이 추가되었습니다.");
    }

    @Override
    public void inquiryData() {
        if (super.getDataStore().isEmpty()) {
            System.out.println("등록된 학생이 없습니다.");
        } else {
            System.out.println("전체 학생을 조회합니다.");
            System.out.println("===================== 등록된 학생 목록 =========================");
            for (int i = 0; i < super.getDataStore().size(); i++) {
                Student student = super.getDataStore().get(i);
                System.out.println("\n고유 번호 :" + student.getStudentId() + "\n이름 : " + student.getStudentName() +
                        "\n상태: " + student.getStatus());
                System.out.println("과목 목록:");
                for (String subject : student.getSubjectList()) {
                    System.out.println("    - " + subject);
                }
                System.out.print("-------------------------------------------------------------");
            }
        }
    }

//    학생을 목록에서 삭제하는 메서드
    public void remove(String name) {
        Iterator<Student> iterator = (Iterator<Student>) super.getDataStore().iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getStudentName().equals(name)) {
                iterator.remove();
                System.out.println(name + " 학생의 데이터가 삭제되었습니다.");
                return;
            }
        }
//        반복이 끝나도 해당 이름을 가진 학생을 찾지 못한 경우
        System.out.println("해당하는 이름의 학생을 찾을 수 없습니다.");
    }

}
