package com.danwoo.eatgo.application;

import com.danwoo.eatgo.domain.Restuarant;
import com.danwoo.eatgo.domain.RestuarantRespository;
import com.danwoo.eatgo.domain.RestuarantRespositoryImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class RestuarantServiceTest {

    private RestuarantService restuarantService;
    private RestuarantRespository restuarantRespository;

    @Before
    public void setUp(){
        restuarantRespository = new RestuarantRespositoryImpl();
        restuarantService = new RestuarantService(restuarantRespository);
    }
    //Before - 모든 테스트 실행전 바로 실행
    @Test
    public void getRestuarant(){

        Restuarant restuarant = restuarantService.getRestuarant(1004L);

        assertThat(restuarant.getId(), is(1004L));
    }

    @Test
    public void getRestuarants(){
        List<Restuarant> restuarants = restuarantService.getRestuarants();

        Restuarant restuarant = restuarants.get(0);
        assertThat(restuarant.getId(),is(1004L));

    }

}