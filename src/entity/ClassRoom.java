package entity;

import util.validate;
import util.validateClass;
import util.validateCourse;
import util.validateStudent;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ClassRoom implements IApp{
    private static int idSequence = 0;
    private int classroomId;
    private String classRoomName;
    private String courseId;
    private int teacherId;
    private List<Student> listStudents;
    private LocalDate created;
    public enum ClassroomStatus {PENDING, PROCESS, CLOSE}
    private ClassroomStatus status;

    public ClassRoom() {
        this.classroomId = ++idSequence;
    }

    public ClassRoom(String classRoomName, String courseId, int teacherId, List<Student> listStudents, LocalDate created, ClassroomStatus status) {
        this.classroomId = ++idSequence;
        this.classRoomName = classRoomName;
        this.courseId = courseId;
        this.teacherId = teacherId;
        this.listStudents = listStudents;
        this.created = created;
        this.status = status;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public String getClassRoomName() {
        return classRoomName;
    }

    public void setClassRoomName(String classRoomName) {
        this.classRoomName = classRoomName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public List<Student> getListStudents() {
        return listStudents;
    }

    public void setListStudents(List<Student> listStudents) {
        this.listStudents = listStudents;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public ClassroomStatus getStatus() {
        return status;
    }

    public void setStatus(ClassroomStatus status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner) {
        while (true){
            try {
                this.classRoomName = validateClass.validateClassName(scanner);
                break;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                this.courseId = validateCourse.validateId(scanner);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
