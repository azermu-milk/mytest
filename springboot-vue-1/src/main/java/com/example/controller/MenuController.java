package com.example.controller;

import com.example.bean.AdminMenu;
import com.example.service.AdminMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

/**
 * Create by Administrator on 2020/1/17.
 */
@RestController
public class MenuController {

    @Autowired
    AdminMenuService adminMenuService;

    @GetMapping("/api/menu")
    public List<AdminMenu> menu(){
        List<AdminMenu> menus = adminMenuService.getMenusByCurrentUser();

        for (AdminMenu menu : menus) {
            menu.setChildren(adminMenuService.getAllByParentId(menu.getId()));
        }
        Iterator<AdminMenu> iterator = menus.iterator();
        while(iterator.hasNext()){
            AdminMenu menu = iterator.next();
            if(menu.getParentId() != 0){
                iterator.remove();
            }
        }
        return menus;
    }
}
