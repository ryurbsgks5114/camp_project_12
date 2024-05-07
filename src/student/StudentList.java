package student;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentList {
    /* 학생 목록을 저장할 List<Student> 타입의 멤버 변수*/
    private List<Student> studentList;

    public StudentList() {
        this.studentList = new ArrayList<>();
    }

    // 학생을 목록에 추가하는 메서드
    public void studentAdd(Student student) {
        studentList.add(student);
        System.out.println(student.getStudentName() + " 학생이 추가되었습니다.");
    }
    // 학생을 목록에서 삭제하는 메서드
    public void studentRemove(String name) {
        Iterator<Student> iterator = studentList.iterator();
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
    // 학생 목록을 반환하는 메서드
    public List<Student> getStudentList() {
        return this.studentList;
    }
}