package com.example.controller;

import com.example.bean.Provider;
import com.example.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Create by Administrator on 2020/2/22.
 */
@Controller
public class ProviderController {

    @Autowired
    ProviderService providerService;

    @GetMapping("/list/providers")
    public String toProvidersList(HttpServletRequest httpServletRequest, Map<String, Object> map){
        System.out.println("toProviderList method="+httpServletRequest.getMethod());
        List<Provider> providers = providerService.pListAll();
        map.put("providers", providers);
        return "provider/list";
    }

    @GetMapping("/provider/{pid}")
    public String view(@RequestParam(value="type", defaultValue = "view") String type, HttpServletRequest httpServletRequest, @PathVariable(value = "pid") int pid, Map<String, Object> map){
        System.out.println("view method="+httpServletRequest.getMethod());
        Provider provider = providerService.getProByPid(pid);
        map.put("provider", provider);
        return "provider/"+type;
    }

    @PostMapping("/provider")
    public String update(HttpServletRequest httpServletRequest, Provider provider){
        System.out.println("update method="+httpServletRequest.getMethod());
        providerService.updateProv(provider);
        return "redirect:/list/providers";
    }
    @GetMapping("/delete/provider/{pid}")
    public String delete(HttpServletRequest httpServletRequest, @PathVariable(value = "pid") int pid){
        System.out.println("delete method="+httpServletRequest.getMethod());
        providerService.deleteProByPid(pid);
        return "redirect:/list/providers";
    }

    @GetMapping("/provider/add")
    public String toAdd(HttpServletRequest httpServletRequest){
        System.out.println("toAdd method="+httpServletRequest.getMethod());
        return "provider/add";
    }
    @PostMapping("/provider/add")
    public String add(HttpServletRequest httpServletRequest, Provider provider){
        System.out.println("add method="+httpServletRequest.getMethod());
        providerService.addProv(provider);
        return "redirect:/list/providers";
    }
}
