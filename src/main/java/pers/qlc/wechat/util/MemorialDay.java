package pers.qlc.wechat.util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @author QLC
 */
public class MemorialDay {

    /**
     * 认识天数
     *
     * @return
     */
    public static int getMeet() {
        long day = ChronoUnit.DAYS.between(LocalDate.of(2000, 7, 17), LocalDate.now());
        return (int) (day + 1);
    }

    /**
     * 恋爱天数
     *
     * @return
     */
    public static int getLianAi() {
        long day = ChronoUnit.DAYS.between(LocalDate.of(2000, 7, 17), LocalDate.now());
        return (int) (day + 1);
    }

    public static void main(String[] args) {
        System.out.println(getMeet());
        System.out.println(getLianAi());
    }

}
