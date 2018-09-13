package com.wlz.demo.service.impl;

import com.wlz.demo.dao.CityMapper;
import com.wlz.demo.domain.City;
import com.wlz.demo.service.CityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wlz
 * @date 9/12/18 14:49
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public List<City> findAllCities() {
        return cityMapper.findAll();
    }
}
