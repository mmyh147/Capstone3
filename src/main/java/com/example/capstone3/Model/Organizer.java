package com.example.capstone3.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
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
    @NotEmpty(message = "email should not be empty")
    @Email(message = "please provide a valid email")
    @Column(columnDefinition = "VARCHAR(30) NOT NULL UNIQUE")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organizer")
    private Set<Field> fields;




}
