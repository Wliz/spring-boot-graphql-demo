package com.wlz.demo.enumeration;

/**
 * 城市状态
 *
 * @author wlz
 * @date 9/6/18 17:35
 */
public enum CityStatus implements BaseEnum<Integer> {

    NOARMAL("正常", 1),   // 正常
    INVALID("无效", 0);   // 无效

    private final String msg;

    private final Integer value;

    CityStatus(String msg, Integer value) {
        this.msg = msg;
        this.value = value;
    }

    @Override
    public String getMsg() {
        return null;
    }

    @Override
    public Integer getValue() {
        return null;
    }

    public static Integer parseMsg(String msg) {
        return 1;
    }
}
