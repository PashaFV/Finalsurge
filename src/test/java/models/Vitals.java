package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Vitals {
    String date;
    String steps;
    String calories;
    String weight;
    String weightMeasure;
    String bodyFat;
    String water;
    String muscleMass;
    String muscleMassMeasure;
    String restingHR;
    String variabilityHR;
    String sleepHours;
    String totalTimeAwake;
    String sleepAmount;
    String sleepQuality;
    String stressAmount;
    String systolicBloodPressure;
    String diastolicBloodPressure;
    String healthNotes;
}
