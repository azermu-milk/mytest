package com.example.service.imlp;

import com.example.dao.RegionDao;
import com.example.entities.Region;
import com.example.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @className UserServiceImpl
 * @date 2021/4/21 12:16
 * @description
 **/
@Service("regionService")
@Transactional
public class RegionServiceImpl implements RegionService {
    @Autowired
    private RegionDao regionDao;
    @Override
    public List<Region> list() {
        return regionDao.list();
    }
}
