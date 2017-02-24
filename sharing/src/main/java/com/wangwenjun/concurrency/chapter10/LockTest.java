package com.wangwenjun.concurrency.chapter10;

import java.util.Optional;
import java.util.stream.Stream;

/***************************************
 * @author:Alex Wang
 * @Date:2017/2/22 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class LockTest {
    public static void main(String[] args) throws InterruptedException {

        final BooleanLock booleanLock = new BooleanLock();
        Stream.of("T1", "T2", "T3", "T4")
                .forEach(name ->
                        new Thread(() -> {
                            try {
                                booleanLock.lock(100L);
                                Optional.of(Thread.currentThread().getName() + " have the lock Monitor")
                                        .ifPresent(System.out::println);
                                work();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } catch (Lock.TimeOutException e) {
                                Optional.of(Thread.currentThread().getName() + " time out")
                                        .ifPresent(System.out::println);
                            } finally {
                                booleanLock.unlock();
                            }
                        }, name).start()
                );
    }

    private static void work() throws InterruptedException {
        Optional.of(Thread.currentThread().getName() + " is Working...")
                .ifPresent(System.out::println);
        Thread.sleep(40_000);
    }
}
