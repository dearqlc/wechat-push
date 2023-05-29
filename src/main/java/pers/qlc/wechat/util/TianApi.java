package pers.qlc.wechat.util;

import com.alibaba.fastjson.JSONObject;
import pers.qlc.wechat.constant.GeneralConstant;

import java.io.IOException;
import java.util.Objects;

/**
 * @author QLC
 */
public class TianApi {

    /**
     * 获取天气信息
     */
    public static JSONObject getWeather() {
        JSONObject today = new JSONObject();
        try {
            JSONObject jsonObject = JSONObject.parseObject(Objects.requireNonNull(HttpUtil.getUrl(GeneralConstant.TIANQI_URL + "?key=" + GeneralConstant.KEY + "&city=" + GeneralConstant.HangZhou + "&type=1")));

            if (jsonObject.getIntValue("code") == GeneralConstant.STATUS_200) {
                today = jsonObject.getJSONArray("newslist").getJSONObject(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return today;
    }

    /**
     * 获取土味情话
     */
    public static String getQingHua() {
        String str = "";
        try {
            JSONObject jsonObject = JSONObject.parseObject(Objects.requireNonNull(HttpUtil.getUrl(GeneralConstant.QINGHUA_URL + "?key=" + GeneralConstant.KEY)));
            if (jsonObject.getIntValue("code") == GeneralConstant.STATUS_200) {
                str = jsonObject.getJSONObject("result").getString("content");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(getQingHua());
        System.out.println(getWeather());
    }

}
