package com.danwoo.eatgo.domain;

import java.util.ArrayList;
import java.util.List;

//테스트 코드 생성
public class Restuarant {


    private String name;
    private String address;
    private Long id;
    private List<MenuItem> menuItems = new ArrayList<MenuItem>();

    public Restuarant(Long id, String name, String address) {
        this.name = name;
        this.address = address;
        this.id = id;
    }
    public Restuarant() {


    }
    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getInformation() {
        return name + " in "+address;
    }

    public Long getId() {
        return id;
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        for(MenuItem menuItem : menuItems){
            addMenuItem(menuItem);
        }
    }

}
