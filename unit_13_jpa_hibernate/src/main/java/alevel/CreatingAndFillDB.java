package alevel;

import alevel.entity.*;
import alevel.repository.*;
import lombok.SneakyThrows;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.List;

public class CreatingAndFillDB {

    @SneakyThrows
    public static void createDB() {


        CourseRepository courseRepository = new CourseRepository();
        GroupRepository groupRepository = new GroupRepository();
        LessonRepository lessonRepository = new LessonRepository();
        MarkRepository markRepository = new MarkRepository();
        StudentRepository studentRepository = new StudentRepository();
        LecturerRepository lecturerRepository = new LecturerRepository();
        TopicRepository topicRepository = new TopicRepository();

        lecturerRepository.save(new Lecturer(1L, "Mark", "Jons"));
        lecturerRepository.save(new Lecturer(2L, "Robert", "Brovich"));
        lecturerRepository.save(new Lecturer(3L, "James", "Doms"));

        topicRepository.save(new Topic(1L, "JPA"));
        topicRepository.save(new Topic(2L, "Hibernate"));
        topicRepository.save(new Topic(3L, "JDBC"));
        topicRepository.save(new Topic(4L, "Introductory"));
        topicRepository.save(new Topic(5L, "Algorithms"));
        topicRepository.save(new Topic(6L, "HTML"));
        topicRepository.save(new Topic(7L, "CSS"));
        topicRepository.save(new Topic(8L, "Final project"));

        courseRepository.save(new Course(1L, "Java", lecturerRepository.findById(1L)));
        courseRepository.save(new Course(2L, "Python", lecturerRepository.findById(2L)));
        courseRepository.save(new Course(3L, "Front", lecturerRepository.findById(3L)));

        groupRepository.save(new Group(1L, "AJava", courseRepository.findById(1L)));
        groupRepository.save(new Group(2L, "BJava", courseRepository.findById(1L)));
        groupRepository.save(new Group(3L, "APython", courseRepository.findById(2L)));
        groupRepository.save(new Group(3L, "BPython", courseRepository.findById(2L)));
        groupRepository.save(new Group(3L, "AFront", courseRepository.findById(3L)));
        groupRepository.save(new Group(3L, "BFront", courseRepository.findById(3L)));

        studentRepository.save(new Student(1L, "Test", "Test",  29, groupRepository.findById(1L)));
        studentRepository.save(new Student(2L, "Test1", "Test", 29, groupRepository.findById(1L)));
        studentRepository.save(new Student(3L, "Test2", "Test", 29, groupRepository.findById(1L)));
        studentRepository.save(new Student(4L, "Test3", "Test", 29, groupRepository.findById(1L)));
        studentRepository.save(new Student(5L, "Test4", "Test", 29, groupRepository.findById(1L)));
        studentRepository.save(new Student(6L, "Test5", "Test", 29, groupRepository.findById(2L)));
        studentRepository.save(new Student(7L, "Test6", "Test", 29, groupRepository.findById(2L)));
        studentRepository.save(new Student(8L, "Test7", "Test", 29, groupRepository.findById(2L)));
        studentRepository.save(new Student(9L, "Test8", "Test", 29, groupRepository.findById(2L)));
        studentRepository.save(new Student(10L, "Test9", "Test", 29, groupRepository.findById(2L)));
        studentRepository.save(new Student(11L, "Test10", "Test", 29, groupRepository.findById(2L)));
        studentRepository.save(new Student(12L, "Test11", "Test", 29, groupRepository.findById(3L)));
        studentRepository.save(new Student(13L, "Test12", "Test", 29, groupRepository.findById(4L)));
        studentRepository.save(new Student(14L, "Test13", "Test", 29, groupRepository.findById(5L)));
        studentRepository.save(new Student(15L, "Test14", "Test", 29, groupRepository.findById(6L)));


        Instant instant = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2022-05-01 10:00").toInstant();

        lessonRepository.save(new Lesson(1L, instant, topicRepository.findById(1L), courseRepository.findById(1L)));
        lessonRepository.save(new Lesson(2L, instant.plusSeconds(86400), topicRepository.findById(2L), courseRepository.findById(1L)));
        lessonRepository.save(new Lesson(3L, instant.plusSeconds(86400*2), topicRepository.findById(3L), courseRepository.findById(1L)));
        lessonRepository.save(new Lesson(4L, instant.plusSeconds(86400*3), topicRepository.findById(4L), courseRepository.findById(2L)));
        lessonRepository.save(new Lesson(6L, instant.plusSeconds(86400*5), topicRepository.findById(6L), courseRepository.findById(2L)));
        lessonRepository.save(new Lesson(7L, instant.plusSeconds(86400*6), topicRepository.findById(6L), courseRepository.findById(3L)));
        lessonRepository.save(new Lesson(8L, instant.plusSeconds(86400*7), topicRepository.findById(7L), courseRepository.findById(3L)));
        lessonRepository.save(new Lesson(9L, instant.plusSeconds(86400*9), topicRepository.findById(8L), courseRepository.findById(3L)));
        lessonRepository.save(new Lesson(10L, instant.plusSeconds(86400*9), topicRepository.findById(8L), courseRepository.findById(1L)));
        lessonRepository.save(new Lesson(11L, instant.plusSeconds(86400*9), topicRepository.findById(8L), courseRepository.findById(2L)));


        List<Lesson> lessons = lessonRepository.findAll();
        List<Student> students = studentRepository.findAll();
        List<Group> groups = groupRepository.findAll();


        Long idMark = 1L;

        for (Student student : students) {

            markRepository.save(new Mark(idMark, (int) (Math.random() * 10 + 1), lessonRepository.findById(10L), student, student.getGroup()));
        }

    }
}
