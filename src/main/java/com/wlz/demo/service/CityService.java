package com.wlz.demo.service;

import com.wlz.demo.domain.City;
import java.util.List;

public interface CityService extends BaseService {

    /**
     * 获取所有城市
     * @return
     */
    List<City> findAllCities();

}
