package models;

import com.github.javafaker.Faker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class VitalsFactory {
    static Faker faker = new Faker();
    public static String [] sleepAmountMas = {"Hardly Any", "Not Enough", "Enough", "More Than Enough"};
    public static String [] sleepQualityMas = {"Good", "Moderate", "Poor"};
    public static String [] stressAmountMas = {"Low", "Moderate", "High"};

    public static Vitals get(){

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/dd/yyyy");
        LocalDateTime now = LocalDateTime.now();
        return Vitals.builder()
                .date(dtf.format(now))
                .steps(String.valueOf(faker.number().numberBetween(1000, 20000)))
                .calories(String.valueOf(faker.number().numberBetween(1600, 2800)))
                .weight(String.valueOf(faker.number().numberBetween(70, 85)))
                .weightMeasure("kg")
                .bodyFat(String.valueOf(faker.number().numberBetween(15, 30)))
                .water(String.valueOf(faker.number().numberBetween(55, 65)))
                .muscleMass(String.valueOf(faker.number().numberBetween(32, 39)))
                .restingHR(String.valueOf(faker.number().numberBetween(60, 70)))
                .variabilityHR(String.valueOf(faker.number().numberBetween(53, 82)))
                .sleepHours(String.valueOf(faker.number().numberBetween(5, 10)))
                .totalTimeAwake(String.valueOf(faker.number().numberBetween(12, 16)))
                .sleepAmount(sleepAmountMas[faker.number().numberBetween(0, sleepAmountMas.length)])
                .sleepQuality(sleepQualityMas[faker.number().numberBetween(0, sleepQualityMas.length)])
                .stressAmount(stressAmountMas[faker.number().numberBetween(0, stressAmountMas.length)])
                .systolicBloodPressure(String.valueOf(faker.number().numberBetween(100, 140)))
                .diastolicBloodPressure(String.valueOf(faker.number().numberBetween(60, 100)))
                .healthNotes(faker.medical().medicineName())
                .build();
    }
}
