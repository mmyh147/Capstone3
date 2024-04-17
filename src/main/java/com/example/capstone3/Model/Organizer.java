package com.example.capstone3.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Organizer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name should not be empty")
    @Pattern(regexp = "^[A-Za-z]+$")
    @Column(columnDefinition = "VARCHAR(40) NOT NULL")
    private String name;
    @NotEmpty(message = "phone should not be empty")
    @Size(min = 10, max = 10, message = "phone number length should be 10 digit")
    @Pattern(regexp = "^(05)[0-9]+$")
    @Column(columnDefinition = "VARCHAR(10) NOT NULL UNIQUE")
    private String phone;
    @NotNull(message = "age should not be empty")
    @Min(value = 18,message = "minimum age should be 18")
    private Integer age;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organizer")
    private Set<Field> fields;




}
