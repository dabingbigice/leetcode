package com;

import java.util.concurrent.Semaphore;

public class 三个线程交替打印ABC {
    /*
    它本质上是用来控制对共享资源访问的计数器。
    * 可以把Semaphore想象成一个管理着固定数量"入场券"的发放器。线程在执行特定操作前，需要先成功获取一个"许可"
    * 获取许可：线程通过acquire()方法尝试获取许可。如果当前有可用许可，则成功获取并继续执行；如果许可不足，线程可能会被阻塞，直到有其他线程释放许可或被中断
    * 释放许可：线程使用完资源后，必须通过release()方法释放许可，以便其他等待的线程有机会获取
    * 非公平模式：默认模式。当有许可释放时，所有正在等待的线程会和新请求的线程一起竞争这个许可，不保证先等待的线程先获得。虽然可能造成"饥饿"，但吞吐量通常更高
     * */

    public static void main(String[] args) {
        Semaphore A = new Semaphore(1);
        Semaphore B = new Semaphore(0);
        Semaphore C = new Semaphore(0);
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    A.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("A");
                B.release();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    B.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("B");
                C.release();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    C.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("C");
                A.release();
            }
        }).start();
    }
}
