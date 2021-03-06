package com.danwoo.eatgo.interfaces;

import com.danwoo.eatgo.application.RestuarantService;
import com.danwoo.eatgo.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(RestaurantController.class)
public class RestaurantControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private RestuarantService restuarantService;

//    @SpyBean(RestuarantRespositoryImpl.class)
//    private RestuarantRespository restuarantRespository;

//    @SpyBean(RestuarantService.class)
//    private RestuarantService restuarantService;
//
//    @SpyBean(MenuItemRepositoryImpl.class)
//    private MenuItemRepository menuItemRepository;

    @Test
    public void list() throws Exception {

        List<Restuarant> restuarants = new ArrayList<>();
        restuarants.add(new Restuarant(1004L,"Bov zip","Seoul"));
        given(restuarantService.getRestuarants()).willReturn(restuarants);

        mvc.perform(get("/restaurants"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("\"id\":1004")
                ))
                .andExpect(content().string(
                containsString("\"name\":\"Bov zip\"")
                ));

    }

    @Test
    public void detail() throws Exception {

        Restuarant restuarant1 = new Restuarant(1004L,"Bov zip","Seoul");
        restuarant1.addMenuItem(new MenuItem("Kimchi"));

        Restuarant restuarant2 = new Restuarant(2020L,"Cyber Food","Seoul");

        given(restuarantService.getRestuarant(1004L)).willReturn(restuarant1);
        given(restuarantService.getRestuarant(2020L)).willReturn(restuarant2);

        mvc.perform(get("/restaurants/1004"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("\"id\":1004")
                ))
                .andExpect(content().string(
                        containsString("\"name\":\"Bov zip\"")
                ))
                .andExpect(content().string(
                        containsString("Kimchi")
                ));
        mvc.perform(get("/restaurants/2020"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("\"id\":2020")
                ))
                .andExpect(content().string(
                        containsString("\"name\":\"Cyber Food\"")
                ));
    }



    @Test
    public void create() throws Exception {

        mvc.perform(post("/restaurants")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"BeRyong\",\"address\":\"Seoul\"}"))
                .andExpect(status().isCreated())
                .andExpect(header().string("location", "/restaurants/1234"))
                .andExpect(content().string("{}"));

        verify(restuarantService).addRestuarant(any());
    }
}