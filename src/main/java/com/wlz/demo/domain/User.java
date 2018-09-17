package com.wlz.demo.domain;

import com.wlz.demo.enumeration.UserStatus;
import java.util.Date;
import lombok.Data;

@Data
public class User {
    private Long id;

    private String username;

    private String phone;

    private Long cityId;

//    private Integer status;

    private UserStatus status;

    private Date createdAt;

    private Date updatedAt;

    private Integer companyId;

//    public String getCreatedAt(DataFetchingEnvironment fetchingEnvironment) {
//        String dateFormat = fetchingEnvironment.getArgument("dateFormat");
//        return
//    }


}
