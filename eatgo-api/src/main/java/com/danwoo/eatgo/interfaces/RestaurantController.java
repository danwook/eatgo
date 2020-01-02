package com.danwoo.eatgo.interfaces;

import com.danwoo.eatgo.application.RestuarantService;
import com.danwoo.eatgo.domain.MenuItem;
import com.danwoo.eatgo.domain.MenuItemRepository;
import com.danwoo.eatgo.domain.Restuarant;
import com.danwoo.eatgo.domain.RestuarantRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin
@RestController
public class RestaurantController {

//    @Autowired
//    private RestuarantRespository restuarantRespository;
//
//    @Autowired
//    private MenuItemRepository menuItemRepository;

    @Autowired
    private RestuarantService restuarantService;


    @GetMapping("/restaurants")
    public List<Restuarant> list() {

        List<Restuarant> restuarants = restuarantService.getRestuarants();

        return restuarants;
    }

    @GetMapping("/restaurants/{id}")
    public Restuarant detail(@PathVariable("id") Long id){

        //하나의 가게정보를 바로 얻게? : 기본정보+메뉴정보
        Restuarant restuarant = restuarantService.getRestuarant(id);


        return restuarant;
    }

    @PostMapping("/restaurants")
    public ResponseEntity<?> create(@RequestBody Restuarant resource) throws URISyntaxException {

        String name = resource.getName();
        String address = resource.getAddress();

        Restuarant restuarant = new Restuarant(name, address);
        restuarantService.addRestuarant(restuarant);
        
        URI location = new URI("/restaurants/"+restuarant.getId());
        return ResponseEntity.created(location).body("{}");
    }
}
