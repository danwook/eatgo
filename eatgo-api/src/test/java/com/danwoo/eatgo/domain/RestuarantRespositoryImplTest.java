package com.danwoo.eatgo.domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RestuarantRespositoryImplTest {

    @Test
    public void save(){
        RestuarantRespository repository = new RestuarantRespositoryImpl();
        Restuarant restuarant = new Restuarant("BeRyong","Seoul");

        int oldCount = repository.findAll().size();

        repository.save(restuarant);

        int newCount = repository.findAll().size();

        assertThat(newCount - oldCount, is(1));
    }
}