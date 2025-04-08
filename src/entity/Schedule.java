package entity;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Schedule implements IApp{
    private static int idSequence = 0;
    private int scheduleId;
    private int classroomId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Schedule() {
        this.scheduleId = ++idSequence;
    }

    public Schedule(int classroomId, LocalDateTime startTime, LocalDateTime endTime) {
        this.scheduleId = ++idSequence;
        this.classroomId = classroomId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public void inputData(Scanner scanner) {

    }
}
