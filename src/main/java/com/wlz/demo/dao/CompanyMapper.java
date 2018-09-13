package com.wlz.demo.dao;

import com.wlz.demo.domain.Company;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyMapper {
    int insert(Company record);

    int insertSelective(Company record);
}
