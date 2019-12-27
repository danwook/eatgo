package com.danwoo.eatgo.application;

import com.danwoo.eatgo.domain.Restuarant;
import com.danwoo.eatgo.domain.RestuarantRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestuarantService {

    @Autowired
    RestuarantRespository restuarantRespository;

    public RestuarantService(RestuarantRespository restuarantRespository){
        this.restuarantRespository = restuarantRespository;
    }

    public Restuarant getRestuarant(Long id){

        Restuarant restuarant = restuarantRespository.findById(id);

        return restuarant;
    }

    public List<Restuarant> getRestuarants() {
        List<Restuarant> restuarants = restuarantRespository.findAll();
        return  restuarants;
    }
}
