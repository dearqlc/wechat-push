package pers.qlc.wechat.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author :QLC
 * @Date :2023/5/25 10:40
 * @Description :
 */
@Getter
public enum OpenIdEnum {

    /**
     * 裘力成
     */
    QLC("oOOdQ54bKBRnt4Xz3TiNHiFOARns", "裘力成");

    private final String openId;

    private final String name;

    OpenIdEnum(String openId, String name) {
        this.openId = openId;
        this.name = name;
    }

    /**
     * 根据openId查询名称
     *
     * @param openId
     * @return
     */
    public static String getNameById(String openId) {
        if (StringUtils.isBlank(openId)) {
            return null;
        }
        for (OpenIdEnum value : OpenIdEnum.values()) {
            if (value.getOpenId().equals(openId)) {
                return value.getName();
            }
            return null;
        }
        return null;
    }

}
