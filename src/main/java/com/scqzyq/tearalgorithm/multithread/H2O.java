package com.scqzyq.tearalgorithm.multithread;

import java.util.concurrent.Semaphore;

/**
 * @Description:
 * @Author 盛春强
 * @Date 2021/7/27 19:31
 */
class H2O {

    public H2O() {

    }

    private int f = 0;
    Semaphore h = new Semaphore(2);
    Semaphore o = new Semaphore(0);
    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        h.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        f++;
        if (f == 2) {
            o.release();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        o.acquire();
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        f = 0;
        h.release(2);
    }
}