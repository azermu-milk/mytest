package com.example.mapper;

import com.example.bean.Provider;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Create by Administrator on 2020/2/22.
 */
@Repository
public interface ProviderMapper {
    List<Provider> pListAll();

    Provider getProByPid(int pid);
}
