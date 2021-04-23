package com.example.action;

import com.example.entities.Region;
import com.example.entities.Usera;
import com.example.service.RegionService;
import com.example.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @className UserAction
 * @date 2021/4/21 11:44
 * @description
 **/
public class UserAction extends ActionSupport implements RequestAware, ModelDriven<Usera>, Preparable {


    @Autowired
    private UserService userService;
    @Autowired
    private RegionService regionService;

    public String list(){
        List<Usera> useraList = userService.list();
        requestMap.put("useraList",useraList);
        return "list";
    }
    public String input(){
        List<Region> regionList = regionService.list();
        requestMap.put("regionList",regionList);
        return "input";
    }

    private Usera usera;
    public String insert(){
        userService.insert(usera);
        return "success";
    }
    public void prepareInsert(){
        usera = new Usera();
    }
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public String delete(){
        userService.deleteById(id);
        return "success";
    }

    public String edit(){
        /*Usera user = userService.queryById(usera.getId());
        usera.setName(user.getName());
        usera.setAge(user.getAge());
        usera.setRegion(user.getRegion());*/
        /*
        * 使用paramsPrepareParamsStack拦截器，提前给id赋值
        * */
        List<Region> regionList = regionService.list();
        requestMap.put("regionList",regionList);
        return "success";
    }
    public void prepareEdit(){
        usera = userService.queryById(id);
    }
    public String update(){
        userService.insert(usera);
        return "success";
    }
    public void prepareUpdate(){
        usera = new Usera();
    }

    private Map<String,Object> requestMap;
    @Override
    public void setRequest(Map<String, Object> map) {
        this.requestMap = map;
    }


    @Override
    public Usera getModel() {

        return usera;
    }

    /**
     * @Date 21:04 2021/4/22
     * @Description //主要作用是为getModel()准备model
     **/
    @Override
    public void prepare() throws Exception {
        /*if( id != 0)
            usera = userService.queryById(id);
        else
            usera = new Usera();*/
        System.out.println("UserAction.prepare");
    }
}
