package com.northcoders.recordshop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Table(name = "albums", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name","artist"})
})
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Album name is mandatory")
    private String name;

    private String description;

    @NotNull(message = "Artist cannot be null")
    @NotBlank(message = "Artist name is mandatory")
    private String artist;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Genre is mandatory")
    private Genre genre;

    @NotNull(message = "Release year is mandatory")
    @Min(value = 1900, message = "Release year cannot be less than 1900")
    private int releaseYear;

    @Min(value = 0, message = "Stock level cannot be less than 0")
    private int stockLevel;

}
