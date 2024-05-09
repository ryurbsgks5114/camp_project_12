package store;

import student.Student;

import java.util.Iterator;
import java.util.List;

public class StudentStore<T extends Student> extends DataStore<T> {

    public StudentStore() {
        super();
    }

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
            for (Student student : super.getDataStore()) {
                System.out.println("\n고유 번호: " + student.getStudentId());
                System.out.println("이름: " + student.getStudentName());
                System.out.println("상태: " + student.getStatus());
                System.out.println("과목 목록:");
                for (String subject : student.getSubjectList()) {
                    System.out.println("    - " + subject);
                }
                System.out.print("-------------------------------------------------------------");
            }
        }
    }

//학생을 목록에서 삭제하는 메서드
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
    // 반복이 끝나도 해당 이름을 가진 학생을 찾지 못한 경우
        System.out.println("해당하는 이름의 학생을 찾을 수 없습니다.");
    }
    public boolean validateSelections(String[] choicesStr, String[] sourceList, List<String> selections) {
        for (String choice : choicesStr) {
            int index = Integer.parseInt(choice) - 1; // 인덱스 변환
            if (index >= 0 && index < sourceList.length) {
                selections.add(sourceList[index]);
            } else {
                return false; // 유효하지 않은 선택이 있으면 false 반환
            }
        }
        return true; // 모든 선택이 유효하면 true 반환
    }

}
