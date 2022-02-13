package models;

import com.github.javafaker.Faker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class WorkoutFactory {

    static Faker faker = new Faker();

    public static Workout get(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter duration = DateTimeFormatter.ofPattern("mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        return Workout.builder()
                .date(dtf.format(now))
                .timeOfDay("12:00 PM")
                .activityType("Run")
                .workoutName(faker.esports().event() + duration.format(now))
                .workoutDescription(faker.weather().description())
                .distance(String.valueOf(faker.number().numberBetween(1, 10)))
                .distanceMeasure("km")
                .duration(duration.format(now))
                .paceMeasure("min/km")
                //.pace()
                .howIFelt("Great")
                .perceivedEffort("3 (Light)")
                .postWorkoutNotesResults(faker.superhero().descriptor())
                .build();
    }
}
