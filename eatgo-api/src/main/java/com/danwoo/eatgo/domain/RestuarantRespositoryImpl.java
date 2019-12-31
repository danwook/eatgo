package com.danwoo.eatgo.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RestuarantRespositoryImpl implements RestuarantRespository {

    private List<Restuarant> restuarants = new ArrayList<>();

    public RestuarantRespositoryImpl(){
        restuarants.add(new Restuarant(1004L,"Bov zip", "Seoul"));
        restuarants.add(new Restuarant(2020L,"Cyber Food", "Seoul"));
    }

    @Override
    public List<Restuarant> findAll() {
        return restuarants;
    }

    @Override
    public Restuarant findById(Long id) {
        return restuarants.stream()
              .filter(restuarant1 -> restuarant1.getId().equals(id))
              .findFirst()
                .orElse(null);
    }

    @Override
    public Restuarant save(Restuarant restuarant) {
        restuarants.add(restuarant);
        return restuarant;
    }
}
