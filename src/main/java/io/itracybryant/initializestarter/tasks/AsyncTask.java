package io.itracybryant.initializestarter.tasks;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @ClassName AsyncTask
 * @Description 异步任务Future封装，返回AsyncResult<V>
 * @Author Administrator
 * @Date 2018/12/31 12:33
 * @Version 1.0
 */
@Component
public class AsyncTask {

    @Async
    public Future<Boolean> doTask1() throws Exception {
        long start = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        System.out.println("Task 1 耗时：" + (end - start) + "ms");
        return new AsyncResult<>(true);
    }

    @Async
    public Future<Boolean> doTask2() throws Exception{
        long start = System.currentTimeMillis();
        Thread.sleep(700);
        long end = System.currentTimeMillis();
        System.out.println("Task 2 耗时：" + (end - start) + "ms");
        return new AsyncResult<>(true);
    }

    @Async
    public Future<Boolean> doTask3() throws Exception{
        long start = System.currentTimeMillis();
        Thread.sleep(500);
        long end = System.currentTimeMillis();
        System.out.println("Task 3 耗时：" + (end - start) + "ms");
        return new AsyncResult<>(true);
    }
}
