package pers.qlc.wechat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.qlc.wechat.enums.OpenIdEnum;
import pers.qlc.wechat.util.Pusher;

/**
 * @author QLC
 */
@RestController
public class PushController {

    /**
     * 推送
     */
    @GetMapping("qlc/push")
    public void qlc() {
        Pusher.push(OpenIdEnum.QLC.getOpenId());
    }

}
