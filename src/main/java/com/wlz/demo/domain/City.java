package com.wlz.demo.domain;

import java.util.Date;
import lombok.Data;

@Data
public class City {
    private Long id;

    private String name;

    private Integer level;

    private String areaCode;

    private String parentCode;

    private Integer status;

    private Date createdAt;

    private Date updatedAt;

    private Integer parentId;
}