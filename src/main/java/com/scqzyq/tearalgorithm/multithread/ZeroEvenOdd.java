package com.scqzyq.tearalgorithm.multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @Description:
 * @Author 盛春强
 * @Date 2021/7/27 18:33
 */
public class ZeroEvenOdd {

    private int n;

    private volatile int c = 0;
    private Lock l = new ReentrantLock();
    private Condition z = l.newCondition();
    private Condition o = l.newCondition();
    private Condition e = l.newCondition();

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        l.lock();
        try {
            for (int i = 1; i <= n; i++) {
                if (c!=0) {
                    z.await();
                }
                printNumber.accept(0);

                if (i%2 == 1) {
                    c = 1;
                    o.signal();
                } else {
                    c = 2;
                    e.signal();
                }
            }
        } finally {
            l.unlock();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        l.lock();
        try {
            for (int i = 2; i <= n; i+=2) {
                if (c != 2) {
                    e.await();
                }
                printNumber.accept(i);
                c = 0;
                z.signal();
            }
        } finally {
            l.unlock();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        l.lock();
        try {
            for (int i = 1; i <= n; i+=2) {
                if (c != 1) {
                    o.await();
                }
                printNumber.accept(i);
                c = 0;
                z.signal();
            }
        } finally {
            l.unlock();
        }
    }
}
