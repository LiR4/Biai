package com.api.biai.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class BiFileResponse {
    private Long id;

    private String pathFile;
    
    private String fileLocalDateTime;
}
