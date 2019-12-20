package com.danwoo.eatgo.interfaces;

import com.danwoo.eatgo.domain.MenuItem;
import com.danwoo.eatgo.domain.MenuItemRepository;
import com.danwoo.eatgo.domain.Restuarant;
import com.danwoo.eatgo.domain.RestuarantRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestuarantRespository restuarantRespository;

    @Autowired
    private MenuItemRepository menuItemRepository;


    @GetMapping("/restaurants")
    public List<Restuarant> list() {

        List<Restuarant> restuarants = restuarantRespository.findAll();

        return restuarants;
    }

    @GetMapping("/restaurants/{id}")
    public Restuarant detail(@PathVariable("id") Long id){

        Restuarant restuarant = restuarantRespository.findById(id);

        
        List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantId(id);
        restuarant.setMenuItems(menuItems);

        return restuarant;
    }

}
