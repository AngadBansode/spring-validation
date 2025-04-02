package com.validation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Media {

    @JsonProperty("mi_industries")
    public List<MiIndustries> mi_industries;

    @JsonProperty("gics_industries")
    public List<GicsIndustries> gics_industries;
}
