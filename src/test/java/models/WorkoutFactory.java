package models;

import com.github.javafaker.Faker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class WorkoutFactory {

    static Faker faker = new Faker();

//    public static Workout get(){
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        LocalDateTime now = LocalDateTime.now();
//        System.out.println(dtf.format(now));
//        return Workout.builder()
//                .date(dtf.format(now))
//                .timeOfDay()
//                .activityType()
//                .workoutName()
//                .workoutDescription()
//                .distance()
//                .duration()
//                .pace()
//                .howIFelt()
//                .perceivedEffort()
//                .postWorkoutNotesResults()
//                .build();
//    }
}
