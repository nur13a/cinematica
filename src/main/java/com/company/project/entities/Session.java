package com.company.project.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Date date = new Date();
    @ManyToOne
    Hall hall;
    @ManyToOne
    Movie movie;
}
