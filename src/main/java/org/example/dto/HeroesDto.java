package org.example.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString

public class HeroesDto {

    private int id;
    private String nature;
    private String name;
}
