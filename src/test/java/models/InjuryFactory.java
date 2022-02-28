package models;

import com.github.javafaker.Faker;

public class InjuryFactory {

    static Faker faker = new Faker();

    public static Injury get(){
        return Injury.builder()
                .bodyDot(String.valueOf(faker.number().numberBetween(1, 29)))
                .painLevelXCoordinates(faker.number().numberBetween(1, 330))
                .painDurationEndXCoordinates(faker.number().numberBetween(-1, -150))
                .painDurationStartXCoordinates(faker.number().numberBetween(1, 150))
                .painTrendXCoordinates(faker.number().numberBetween(-150, 150))
                .painNotes(faker.medical().symptoms())
                .build();
    }
}
