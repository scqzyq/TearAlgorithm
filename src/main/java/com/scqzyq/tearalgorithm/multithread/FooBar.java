package com.scqzyq.tearalgorithm.multithread;

import java.util.concurrent.Semaphore;

/**
 * @Description:
 * @Author 盛春强
 * @Date 2021/7/27 17:40
 */
public class FooBar {
    private int n;
    private Object o = new Object();
    private boolean f = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (o) {
                if (!f) {
                    o.wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                f = false;
                o.notify();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (o) {
                if (f) {
                    o.wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                o.notify();
            }
        }
    }
}

class FooBar1 {
    private int n;

    public FooBar1(int n) {
        this.n = n;
    }

    Semaphore foo = new Semaphore(1);
    Semaphore bar = new Semaphore(0);

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            foo.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            bar.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            foo.release();
        }
    }
}