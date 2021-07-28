package com.scqzyq.tearalgorithm.multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @Description: 1195. 交替打印字符串
 * @Author 盛春强
 * @Date 2021/7/28 10:22
 */
public class FizzBuzz {
    private int n;

    public FizzBuzz(int n) {
        this.n = n;
    }

    private volatile int i = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (i<=n) {
            lock.lock();
            try {
                if (i%3 == 0 && i%5 != 0) {
                    printFizz.run();
                    i++;
                    condition.signalAll();
                } else {
                    condition.await();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (i<=n) {
            lock.lock();
            try {
                if (i%3 != 0 && i%5 == 0) {
                    printBuzz.run();
                    i++;
                    condition.signalAll();
                } else {
                    condition.await();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (i<=n) {
            lock.lock();
            try {
                if (i%15 == 0) {
                    printFizzBuzz.run();
                    i++;
                    condition.signalAll();
                } else {
                    condition.await();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (i<=n) {
            lock.lock();
            try {
                if (i%3 != 0 && i%5 != 0) {
                    printNumber.accept(i++);
                    condition.signalAll();
                } else {
                    condition.await();
                }
            } finally {
                lock.unlock();
            }
        }
    }
}

class FizzBuzz1 {
    private int n;

    public FizzBuzz1(int n) {
        this.n = n;
    }

    private volatile int i = 1;

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        synchronized (this) {
            while (i<=n) {
                if (i%3 == 0 && i%5 != 0) {
                    printFizz.run();
                    i++;
                    this.notifyAll();
                } else {
                    this.wait();
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        synchronized (this) {
            while (i<=n) {
                if (i%3 != 0 && i%5 == 0) {
                    printBuzz.run();
                    i++;
                    this.notifyAll();
                } else {
                    this.wait();
                }
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        synchronized (this) {
            while (i<=n) {
                if (i%15 == 0) {
                    printFizzBuzz.run();
                    i++;
                    this.notifyAll();
                } else {
                    this.wait();
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        synchronized (this) {
            while (i<=n) {
                if (i%3 != 0 && i%5 != 0) {
                    printNumber.accept(i++);
                    this.notifyAll();
                } else {
                    this.wait();
                }
            }
        }
    }
}