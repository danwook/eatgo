package com.danwoo.eatgo.domain;

import java.util.ArrayList;
import java.util.List;

public class RestuarantRespository {

    private List<Restuarant> restuarants = new ArrayList<>();

    public RestuarantRespository(){
        restuarants.add(new Restuarant(1004L,"Bov zip", "Seoul"));
        restuarants.add(new Restuarant(2020L,"Cyber Food", "Seoul"));
    }

    public List<Restuarant> findAll() {
        return restuarants;
    }

    public Restuarant findById(Long id) {
        return restuarants.stream()
              .filter(restuarant1 -> restuarant1.getId().equals(id))
              .findFirst()
                .orElse(null);
    }
}
