package com.danwoo.eatgo.domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RestuarantRespositoryImplTest {

    @Test
    public void save(){
        RestuarantRespository repository = new RestuarantRespositoryImpl();
        int oldCount = repository.findAll().size();

        Restuarant restuarant = new Restuarant("BeRyong","Seoul");
        repository.save(restuarant);

        assertThat(restuarant.getId(),is(1234L));

        int newCount = repository.findAll().size();

        assertThat(newCount - oldCount, is(1));
    }
}