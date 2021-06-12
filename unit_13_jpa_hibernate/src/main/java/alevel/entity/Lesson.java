package alevel.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "lessons")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_and_time", nullable = false)
    private Instant dateAndTime;

    @ManyToOne
    @JoinColumn(name = "topic_id", nullable = false)
    private Topic topic;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    public Lesson(Long id, Instant dateAndTime, Topic topic, Course course) {
        this.id = id;
        this.dateAndTime = dateAndTime;
        this.topic = topic;
        this.course = course;
    }

    public Lesson() {
    }


}
