package com.example.service;

import com.example.bean.AdminMenu;
import com.example.bean.AdminRoleMenu;
import com.example.bean.AdminUserRole;
import com.example.bean.User;
import com.example.mapper.AdminMenuDAO;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Create by Administrator on 2020/1/17.
 */
@Service
public class AdminMenuService {

    @Autowired
    AdminMenuDAO adminMenuDAO;
    @Autowired
    UserService userService;
    @Autowired
    AdminUserRoleService adminUserRoleService;
    @Autowired
    AdminRoleMenuService adminRoleMenuService;

    public List<AdminMenu> getAllByParentId(int parentId) {
        return adminMenuDAO.findAllByParentId(parentId);
    }

    public List<AdminMenu> getMenusByCurrentUser() {
        String username = SecurityUtils.getSubject().getPrincipal().toString();
        User user = userService.getUserByName(username);
        List<AdminUserRole> userRoleList = adminUserRoleService.listAllByUid(user.getId());
        List<AdminMenu> menus = new ArrayList<>();
        for (AdminUserRole userRole : userRoleList) {
            List<AdminRoleMenu> roleMenuList = adminRoleMenuService.findAllByRid(userRole.getRid());
            for (AdminRoleMenu roleMenu : roleMenuList) {
                menus.add(adminMenuDAO.findById(roleMenu.getMid()));
            }
        }
        return menus;
    }

    public void handleMenus(List<AdminMenu> menus) {
        for (AdminMenu menu : menus) {
            menu.setChildren(getAllByParentId(menu.getId()));
        }

        Iterator<AdminMenu> iterator = menus.iterator();
        while (iterator.hasNext()) {
            AdminMenu menu = iterator.next();
            if (menu.getParentId() != 0) {
                iterator.remove();
            }
        }
    }
}