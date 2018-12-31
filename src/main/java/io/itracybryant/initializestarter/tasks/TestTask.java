package io.itracybryant.initializestarter.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName TestTask
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/31 13:12
 * @Version 1.0
 */
@Component
public class TestTask {
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
    /**
     * 定义每过3s执行任务
     */
    @Scheduled(fixedRate = 3000)
    @Scheduled(cron = "4-40 * * * * ?")
    public void reportCurrentTime(){
        System.out.println("现在时间：" + simpleDateFormat.format(new Date()));
    }
}
