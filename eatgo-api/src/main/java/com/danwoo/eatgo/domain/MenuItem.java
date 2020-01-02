package com.danwoo.eatgo.domain;


import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class MenuItem {

    @Id
    @GeneratedValue
    private Long id;

    private Long restaurantId;

    private String name;

//    public String getName() {
//        return name;
//
//    }
//    public MenuItem(String name) {
//        this.name = name;
//    }

}
