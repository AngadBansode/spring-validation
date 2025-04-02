package com.validation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GicsIndustries {

    @JsonProperty("industryId")
    public int industryId;
    @JsonProperty("industryName")
    public String industryName;
    @JsonProperty("profile")
    public String profile;
}
