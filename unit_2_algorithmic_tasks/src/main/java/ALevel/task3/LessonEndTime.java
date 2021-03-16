package ALevel.task3;

/**
 * About school
 */
public class LessonEndTime {

    private static int lessonTime = 55; //time of lesson + average break time

    private static void timeLastLesson(int countLessons) {
        int minutesLessons = lessonTime * countLessons - 15;
        int hoursLessons = minutesLessons / 60;
        int hours = hoursLessons + 9;
        int minutes = minutesLessons - hoursLessons * 60 + (countLessons % 2 * 5);
        System.out.println(hours + " hours " + minutes + " minutes");
    }


    public static void main(String[] args) {
        timeLastLesson(Integer.parseInt(args[0]));
    }
}
