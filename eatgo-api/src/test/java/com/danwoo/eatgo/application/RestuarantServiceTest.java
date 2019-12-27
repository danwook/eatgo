package com.danwoo.eatgo.application;

import com.danwoo.eatgo.domain.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class RestuarantServiceTest {

    private RestuarantService restuarantService;
    private RestuarantRespository restuarantRespository;
    private MenuItemRepository menuItemRepository;

    @Before
    public void setUp(){
        restuarantRespository = new RestuarantRespositoryImpl();
        menuItemRepository = new MenuItemRepositoryImpl();

        restuarantService = new RestuarantService(restuarantRespository,menuItemRepository);
    }
    //Before - 모든 테스트 실행전 바로 실행
    @Test
    public void getRestuarant(){

        Restuarant restuarant = restuarantService.getRestuarant(1004L);

        assertThat(restuarant.getId(), is(1004L));

        MenuItem menuItem = restuarant.getMenuItems().get(0);
        assertThat(menuItem.getName(), is("Kimchi"));

    }

    @Test
    public void getRestuarants(){
        List<Restuarant> restuarants = restuarantService.getRestuarants();

        Restuarant restuarant = restuarants.get(0);
        assertThat(restuarant.getId(),is(1004L));

    }

}