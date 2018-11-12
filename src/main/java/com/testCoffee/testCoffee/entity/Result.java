package com.testCoffee.testCoffee.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime creationDate;

    @OneToMany(mappedBy = "result_coffee",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Coffee> coffees;

    @OneToMany(mappedBy = "result_syrup",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Syrup> syrups;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_id")
//    private User author;

    private boolean isLiked;

    public Result() {
    }
}