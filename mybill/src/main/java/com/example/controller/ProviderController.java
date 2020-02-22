package com.example.controller;

import com.example.bean.Provider;
import com.example.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
}
