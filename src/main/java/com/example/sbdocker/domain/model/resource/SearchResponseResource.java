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
    String birth_day;
    String zodiac_sign;
    String height;
    String weight;
    String bwh;
    String dominant_hand;
    String birth_place;
    String favorite;
    String special_skill;
    String cv;
}
