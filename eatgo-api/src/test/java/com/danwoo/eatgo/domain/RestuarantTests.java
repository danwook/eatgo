package com.danwoo.eatgo.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RestuarantTests {

    @Test
    public void creation(){
        Restuarant restuarant = new Restuarant(1004L,"Bov zip","Seoul");
        assertThat(restuarant.getId(), is(1004L));
        assertThat(restuarant.getName(), is("Bov zip"));
        assertThat(restuarant.getAddress(), is("Seoul"));
    }

    @Test
    public void information(){
        Restuarant restuarant = new Restuarant(1004L,"Bov zip", "Seoul");
        assertThat(restuarant.getInformation(), is("Bov zip in Seoul"));
    }
}