package com.danwoo.eatgo.domain;

import java.util.List;

public interface RestuarantRespository {
    List<Restuarant> findAll();
    Restuarant findById(Long id);

    Restuarant save(Restuarant restuarant);
}
