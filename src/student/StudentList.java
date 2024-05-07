package student;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentList {
    public static void studentAdd(List<Student> studentList,int studentId, String studentName, String status, List<String> subjectList)
    {
        Student addStudent = new Student(studentId,studentName,status);
        addStudent.studentAdd(studentId, studentName, subjectList); // 과목 목록 추가
        studentList.add(addStudent);
        System.out.println(studentName + " 학생이 추가되었습니다.");
    }
    public static void studentRemove(List<Student> studentList, String name) {
        for (int i = 0; i < studentList.size(); i++) {
            //리스트에서 학생 객체를 가져옴
            Student student = studentList.get(i);
            //Student 클래스에서 객체의 이름을 가져옴
            if (student.getStudentName().equals(name)) {
                studentList.remove(i);
                System.out.println(name + " 학생의 데이터가 삭제되었습니다.");
                return;
            }
        }
        // 반복이 끝나도 해당 이름을 가진 학생을 찾지 못한 경우
        System.out.println("해당하는 이름의 학생을 찾을 수 없습니다.");
    }
}