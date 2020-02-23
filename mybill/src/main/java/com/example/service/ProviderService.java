package com.example.service;

import com.example.bean.Provider;
import com.example.mapper.ProviderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by Administrator on 2020/2/22.
 */
@Service
public class ProviderService implements ProviderMapper {

    @Autowired
    ProviderMapper providerMapper;
    @Override
    public List<Provider> pListAll() {
        return providerMapper.pListAll();
    }

    public Provider getProByPid(int pid) {
        return providerMapper.getProByPid(pid);
    }

    @Override
    public int deleteProByPid(int pid) {
        return providerMapper.deleteProByPid(pid);
    }

    @Override
    public int updateProv(Provider provider) {
        return providerMapper.updateProv(provider);
    }

    @Override
    public int addProv(Provider provider) {
        return providerMapper.addProv(provider);
    }
}
