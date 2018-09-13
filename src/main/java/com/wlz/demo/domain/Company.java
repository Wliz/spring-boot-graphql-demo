package com.wlz.demo.domain;

import java.util.Date;
import lombok.Data;

@Data
public class Company {
    private Long id;

    private String name;

    private String shortName;

    private String address;

    private String linkman;

    private String phone;

    private Integer cityId;

    private Integer status;

    private Date createdAt;

    private Date updatedAt;

    private Integer parentId;

    private String type;
}