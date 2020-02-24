package com.example.mapper;

import com.example.bean.BillProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillMapper {
    List<BillProvider> bListAll();
}
