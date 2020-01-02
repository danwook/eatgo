package com.danwoo.eatgo.application;

import com.danwoo.eatgo.domain.MenuItem;
import com.danwoo.eatgo.domain.MenuItemRepository;
import com.danwoo.eatgo.domain.Restuarant;
import com.danwoo.eatgo.domain.RestuarantRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestuarantService {

    @Autowired
    RestuarantRespository restuarantRespository;

    @Autowired
    MenuItemRepository menuItemRepository;

    public RestuarantService(RestuarantRespository restuarantRespository, MenuItemRepository menuItemRepository){
        this.restuarantRespository = restuarantRespository;
        this.menuItemRepository = menuItemRepository;
    }

    public Restuarant getRestuarant(Long id){

        Restuarant restuarant = restuarantRespository.findById(id).orElse(null);

        List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantId(id);
        restuarant.setMenuItems(menuItems);

        return restuarant;
    }

    public List<Restuarant> getRestuarants() {
        List<Restuarant> restuarants = restuarantRespository.findAll();
        return  restuarants;
    }

    public Restuarant addRestuarant(Restuarant restuarant) {
        //restuarant.setId(1234L);
        return restuarantRespository.save(restuarant);
    }
}
