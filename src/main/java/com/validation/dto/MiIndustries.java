package com.validation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MiIndustries {

    @JsonProperty("industryId")
    public int industryId;
    @JsonProperty("industryName")
    public String industryName;
    @JsonProperty("profile")
    public String profile;
}
