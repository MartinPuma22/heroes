package org.example.dto;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString

public class HeroesDto implements Serializable {

    private int id;
    private String nature;
    private String name;
}
