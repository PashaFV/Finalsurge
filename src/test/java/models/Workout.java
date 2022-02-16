package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Workout {
    String date;
    String timeOfDay;
    String activityType;
    String activitySubType;
    String workoutName;
    String workoutDescription;
    String distance;
    String distanceMeasure;
    String duration;
    String pace;
    String paceMeasure;
    String howIFelt;
    String perceivedEffort; //Perceived Effort
    String postWorkoutNotesResults; //Post Workout Notes/Results
}
