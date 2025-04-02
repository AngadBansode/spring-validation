package com.validation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IndustryProfile {

    @JsonProperty("mi_industries")
    public ArrayList<MiIndustries> mi_industries;

    @JsonProperty("gics_industries")
    public ArrayList<GicsIndustries> gics_industries;



}
