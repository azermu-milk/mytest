package com.example.mapper;

import com.example.bean.Bill;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillMapper {
    List<Bill> bListAll();
}
