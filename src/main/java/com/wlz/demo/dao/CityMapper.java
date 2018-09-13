package com.wlz.demo.dao;

import com.wlz.demo.domain.City;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CityMapper {
    int insert(City record);

    int insertSelective(City record);

    List<City> findAll();

}
