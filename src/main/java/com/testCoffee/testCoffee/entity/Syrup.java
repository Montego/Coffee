package com.testCoffee.testCoffee.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Syrup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private boolean isLiked;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "result_id")
    private Result result_syrup;

    public Syrup() {
    }
}