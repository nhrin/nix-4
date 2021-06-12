package alevel.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "marks")
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int mark;

    @ManyToOne
    @JoinColumn(name = "lesson_id", nullable = false)
    private Lesson lesson;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    public Mark(Long id, int mark, Lesson lesson, Student student, Group group) {
        this.id = id;
        this.mark = mark;
        this.lesson = lesson;
        this.student = student;
        this.group = group;
    }

    public Mark() {
    }

}
