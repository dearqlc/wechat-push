package pers.qlc.wechat.util;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import pers.qlc.wechat.constant.GeneralConstant;
import pers.qlc.wechat.enums.OpenIdEnum;

/**
 * @author QLC
 */
@Slf4j
public class Pusher {

    public static void push(String openId) {
        // 1.配置
        WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
        wxStorage.setAppId(GeneralConstant.APP_ID);
        wxStorage.setSecret(GeneralConstant.SECRET);
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxStorage);

        // 2.创建实例
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser(openId)
                .templateId(GeneralConstant.TEMPLATE_ID)
                .build();

        // 3.填写变量信息，比如天气之类的
        JSONObject todayWeather = TianApi.getWeather();
        templateMessage.addData(new WxMpTemplateData("date", todayWeather.getString("date") + "  " + todayWeather.getString("week")));
        templateMessage.addData(new WxMpTemplateData("weather", todayWeather.getString("weather")));
        templateMessage.addData(new WxMpTemplateData("city", todayWeather.getString("area")));
        templateMessage.addData(new WxMpTemplateData("low", todayWeather.getString("lowest")));
        templateMessage.addData(new WxMpTemplateData("high", todayWeather.getString("highest")));
        templateMessage.addData(new WxMpTemplateData("words", TianApi.getQingHua()));
        templateMessage.addData(new WxMpTemplateData("meet", MemorialDay.getMeet() + ""));
        templateMessage.addData(new WxMpTemplateData("love", MemorialDay.getLianAi() + ""));

        // 4.推送
        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
            log.info("向" + OpenIdEnum.getNameById(templateMessage.getToUser()) + "推送成功：" + templateMessage.getData().get(5).getValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
