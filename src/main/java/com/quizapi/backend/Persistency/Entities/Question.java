package com.quizapi.backend.Persistency.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "QUIZQUESTION")
public class Question implements Serializable {
    private static final long serialVersionUID = -4936049134302300393L;

    @Id
    @GeneratedValue
    @Column(name = "QUESTIONID", unique = true)
    private long questionId;

    @NonNull
    @Size(min = 8, max = 140, message = "Your question should be between 8 and 140 characters")
    @Column(name = "QUESTION", unique = true)
    private String question;

    @NonNull
    @Size(min = 3, max = 60, message = "Your answer shoud be between 3 and 60 characters")
    @Column(name = "ANSWER")
    private String answer;

    @NonNull
    @Size(min = 3, max = 60, message = "Your wrog answer shoud be between 3 and 60 characters")
    @Column(name = "WRONGANSER_1")
    private String wrongAnswer_1;

    @NonNull
    @Size(min = 3, max = 60, message = "Your wrog answer shoud be between 3 and 60 characters")
    @Column(name = "WRONGANSER_2")
    private String wrongAnswer_2;

    @NonNull
    @Size(min = 3, max = 60, message = "Your wrog answer shoud be between 3 and 60 characters")
    @Column(name = "WRONGANSER_3")
    private String wrongAnswer_3;

    @Size(min = 1, max = 3, message = "Put in a number between 1 and 3. 1 is easy. 3 is hard")
    @Column(name = "SEVERITY")
    private int severity;

}
