package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Injury {
    String bodyDot;
    int painLevelXCoordinates;
    int painDurationStartXCoordinates;
    int painDurationEndXCoordinates;
    int painTrendXCoordinates;
    String painNotes;
    String withPainTrendConnectedText;
    String withPainLevelConnectedText;
}
