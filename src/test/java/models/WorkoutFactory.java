package models;

import com.github.javafaker.Faker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class WorkoutFactory {
    public static String [] activityRunSubTypes = {"No Sub-Type", "Fartlek", "Hills", "Lactate Threshold", "Long Run", "Marathon Pace", "Recovery Run", "Tempo Run", "Track Workout", "VO2 Max"};
    public static String [] perceivedEfforts = {"1 (Very Light)", "2 (Light)", "3 (Light)", "4 (Moderate)", "5 (Moderate)", "6 (Moderate)", "7 (Hard)", "8 (Hard)", "9 (Very Hard)", "10 (Max Effort)"};
    public static String [] howIFeltMass = {"Great", "Good", "Normal", "Poor", "Terrible"};
    static Faker faker = new Faker();
    //TODO добавить в get добавление рандомного значения из описанного мной списка в переменную activitySubType, perceivedEffort, howIFelt
    public static Workout get(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/dd/yyyy");
        DateTimeFormatter duration = DateTimeFormatter.ofPattern("m:ss");
        LocalDateTime now = LocalDateTime.now();
        return Workout.builder()
                .date(dtf.format(now))
                .timeOfDay("12:00 PM")
                .activityType("Run")
                .activitySubType(activityRunSubTypes[faker.number().numberBetween(0, activityRunSubTypes.length)])
                .workoutName(faker.esports().event() + duration.format(now))
                .workoutDescription(faker.weather().description())
                .distance(String.valueOf(faker.number().numberBetween(1, 10)) + ".00")
                .distanceMeasure("km")
                .duration(duration.format(now))
                .paceMeasure("min/km")
                //.pace()
                .howIFelt(howIFeltMass[faker.number().numberBetween(0, howIFeltMass.length)])
                .perceivedEffort(perceivedEfforts[faker.number().numberBetween(0, perceivedEfforts.length)])
                .postWorkoutNotesResults(faker.superhero().descriptor())
                .markAsRace(faker.bool().bool())
                .showPlannedDistance(faker.bool().bool())
                .saveToLibrary(faker.bool().bool())
                .workoutComment(faker.esports().player())
                .build();
    }
}
