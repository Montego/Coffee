package com.testCoffee.testCoffee.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private boolean isLiked;

    private String filename;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm:ss yyyy-MM-dd")
    private LocalDateTime creationDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id" )
    private User author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "result_id")
    private Result result_coffee;

    public Coffee() {
    }

    public Coffee(String name, User user) {
        this.name = name;
        this.author = user;
    }

    public String getAuthorName(){
        return author !=null ? author.getUsername(): "<none>";
    }
}

