package com.danwoo.eatgo.application;

import com.danwoo.eatgo.domain.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;


public class RestuarantServiceTest {

    private RestuarantService restuarantService;

    @Mock
    private RestuarantRespository restuarantRespository;

    @Mock
    private MenuItemRepository menuItemRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mockRestaurantRepository();
        mockMenuItemRepository();
        restuarantService = new RestuarantService(restuarantRespository,menuItemRepository);
    }

    private void mockMenuItemRepository() {

        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Kimchi"));
        given(menuItemRepository.findAllByRestaurantId(1004L)).willReturn(menuItems);
    }

    private void mockRestaurantRepository() {
        List<Restuarant> restuarants = new ArrayList<>();
        Restuarant restuarant = new Restuarant(1004L, "Bov zip","Seoul");
        restuarants.add(restuarant);
        given(restuarantRespository.findAll()).willReturn(restuarants);

        given(restuarantRespository.findById(1004L)).willReturn(restuarant);
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