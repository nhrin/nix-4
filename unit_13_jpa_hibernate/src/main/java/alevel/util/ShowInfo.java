package alevel.util;

import alevel.entity.*;
import alevel.repository.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShowInfo {

    static LessonRepository lessonRepository = new LessonRepository();
    static StudentRepository studentRepository = new StudentRepository();
    static LecturerRepository lecturerRepository = new LecturerRepository();
    static CourseRepository courseRepository = new CourseRepository();

    public static void getNextLesson(Long studentId, Instant instant) {
        Student student = studentRepository.findById(studentId);
        Lesson lesson = lessonRepository.findNextLesson(student, instant);
        System.out.println("Next lesson by student" + student.getFirstName() + " "
                + student.getLastName()
                + "at "
                + lesson.getDateAndTime()
                + " "
                + "topic is "
                + lesson.getTopic()
                + "lecture is "
                + lesson.getCourse().getLecturer()
        );
    }

    public static void bestGroup(Long lecturerId) {
        Course course = courseRepository.findByLecturerId(lecturerId);
        List<Group> groups = course.getGroups();
        Lecturer lecturer = lecturerRepository.findById(lecturerId);
        Group bestGroup = null;
        int median = 0;
        for (Group group : groups) {
            if (medianOfMarks(group) > median) {
                bestGroup = group;
                median = medianOfMarks(group);
            }
        }
        System.out.println("Best group of " + lecturer.getFirstName()
                + " "
                + lecturer.getLastName()
                + " is "
                + bestGroup.getName()
                + " id "
                + bestGroup.getId()
                + " "
                + bestGroup.getCourse().getName()
        );
    }

    private static Integer medianOfMarks(Group group) {
        List<Student> students = group.getStudents();
        List<Integer> marksForFinalProject = new ArrayList<>();

        for (Student student : students) {
            List<Mark> marks = student.getMarks();
            for (Mark mark : marks) {
                if (mark.getLesson().getTopic().getId() == 8L) {
                    marksForFinalProject.add(mark.getMark());
                }
            }
        }
        Collections.sort(marksForFinalProject);

        int middle = marksForFinalProject.size() / 2;
        if (marksForFinalProject.size() % 2 == 1) {
            return marksForFinalProject.get(middle + 1);
        } else {
            return (marksForFinalProject.get(middle) + marksForFinalProject.get(middle + 1)) / 2;
        }
    }
}
