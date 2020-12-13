package com.example.sbdocker.domain.model.resource;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SearchResponseResource {
    String name;
    String nameKana;
    String unitName;
    String age;
    String blood;
    String birthDay;
    String zodiacSign;
    String height;
    String weight;
    String bwh;
    String dominantHand;
    String birthPlace;
    String favorite;
    String specialSkill;
    String cv;
}
