package com.danwoo.eatgo.interfaces;

import com.danwoo.eatgo.domain.Restuarant;
import com.danwoo.eatgo.domain.RestuarantRespository;
import org.apache.catalina.util.ErrorPageSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestaurantController {

    private RestuarantRespository repository = new RestuarantRespository();

    @GetMapping("/restaurants")
    public List<Restuarant> list() {

        List<Restuarant> restuarants = repository.findAll();

        return restuarants;
    }

    @GetMapping("/restaurants/{id}")
    public Restuarant detail(@PathVariable("id") Long id){

        Restuarant restuarant = repository.findById(id);

        return restuarant;
    }

}
