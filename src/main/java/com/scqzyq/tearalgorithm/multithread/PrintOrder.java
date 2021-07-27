package com.scqzyq.tearalgorithm.multithread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: 1114. 按序打印
 * @Author 盛春强
 * @Date 2021/7/27 17:25
 */
public class PrintOrder {
}

class Foo {
    private volatile int f = 1;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        f++;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (f != 2) ;
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        f++;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (f != 3) ;
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}

class Foo2 {
    private int f = 1;
    private Object o = new Object();

    public Foo2() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        synchronized (o) {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            f++;
            o.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (o) {
            while (f != 2) {
                o.wait();
            }
            printSecond.run();
            f++;
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (o) {
            while (f != 3) {
                o.wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}

class Foo3 {

    public Foo3() {

    }

    private Semaphore two = new Semaphore(0);
    private Semaphore three = new Semaphore(0);

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        two.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        two.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        three.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        three.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}

class Foo4 {

    public Foo4() {

    }

    private AtomicInteger f = new AtomicInteger(1);
    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        f.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (f.get()!=2);
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        f.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (f.get()!=3);

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}