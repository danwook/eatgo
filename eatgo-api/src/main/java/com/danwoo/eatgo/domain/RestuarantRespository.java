package com.danwoo.eatgo.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RestuarantRespository extends CrudRepository<Restuarant, Long> {
    List<Restuarant> findAll();

    Optional<Restuarant> findById(Long id);

    Restuarant save(Restuarant restuarant);
}
