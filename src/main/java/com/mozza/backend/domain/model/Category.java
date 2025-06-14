package com.mozza.backend.domain.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Category {
    private Long id;
    private String name;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
}
