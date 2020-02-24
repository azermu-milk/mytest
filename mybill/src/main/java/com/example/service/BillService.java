package com.example.service;

import com.example.bean.BillProvider;
import com.example.mapper.BillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService implements BillMapper {

    @Autowired
    BillMapper billMapper;

    @Override
    public List<BillProvider> bListAll() {
        return billMapper.bListAll();
    }
}
