package pers.qlc.wechat.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pers.qlc.wechat.enums.OpenIdEnum;
import pers.qlc.wechat.util.Pusher;

/**
 * @author QLC
 */
@Component
public class JobWorker {

    /**
     * 定时任务
     */
    @Scheduled(cron = "0 30 7 * * ?")
    public void goodMorningLin() {
        Pusher.push(OpenIdEnum.QLC.getOpenId());
    }

}
