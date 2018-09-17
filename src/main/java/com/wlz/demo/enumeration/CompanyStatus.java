package com.wlz.demo.enumeration;

/**
 * 公司状态
 *
 * @author wlz
 * @date 9/6/18 14:40
 */
public enum CompanyStatus implements BaseEnum {
    NORMAL("正常", 1),    // 正常
    LOGOFF("注销", 0);    // 注销

    private String msg;

    private Integer value;

    CompanyStatus(String msg, Integer value) {
        this.msg = msg;
        this.value = value;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
