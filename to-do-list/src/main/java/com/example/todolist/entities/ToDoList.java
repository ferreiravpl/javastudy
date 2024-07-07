package com.example.todolist.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "todolist")
public class ToDoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long Id;

    @JsonProperty("description")
    private String description;

    @JsonProperty("initialDate")
    private Date initialDate;

    @JsonProperty("estimatedDate")
    private Date estimatedDate;

    @JsonProperty("concludedDate")
    private LocalDateTime concludedDate;

    @JsonProperty("isDone")
    private Boolean isDone;

}
