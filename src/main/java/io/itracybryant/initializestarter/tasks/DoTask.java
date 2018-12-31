package io.itracybryant.initializestarter.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * @ClassName DoTask
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/31 13:06
 * @Version 1.0
 */
@RestController
@RequestMapping("tasks")
public class DoTask {

    @Autowired
    private AsyncTask asyncTask;

    @Autowired
    private TestTask testTask;

    @RequestMapping("test")
    public String test() throws Exception {
        long start = System.currentTimeMillis();

        Future<Boolean> a = asyncTask.doTask1();
        testTask.reportCurrentTime();
        Future<Boolean> b = asyncTask.doTask2();
        Future<Boolean> c = asyncTask.doTask3();

        // 保证三个任务全部执行
        while (!a.isDone() || !b.isDone() || !c.isDone()) {
            if (a.isDone() && b.isDone() && c.isDone()) {
                break;
            }
        }
        long end = System.currentTimeMillis();
        String times = "任务全部完成，总耗时：" + (end - start) + "ms";
        System.out.println(times);
        return times;
    }
}
