package com.narberalgamma.com.demo;

import com.narberalgamma.com.demo.repositories.Phone;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="mydata")
@Setter
@Getter
public class MyData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column
    private long id;

    @Column(length = 50, nullable = false)
    @NotEmpty
    private String name;

    @Column(length = 200, nullable = true)
    private String mail;

    @Column(nullable = true)
    @Min(0)
    @Max(100)
    private Integer age;

    @Column(nullable = true)
    @Phone
    private String memo;
}
