package com.zenhomes.village.service.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A Village Dto.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class VillageDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    
    @JsonProperty("village_name")
    private String name;

}
