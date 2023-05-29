package pers.qlc.wechat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author :QLC
 * @Date :2023/5/6 11:19
 * @Description :
 */
@EnableScheduling
@SpringBootApplication
public class WeChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeChatApplication.class, args);
    }

}
