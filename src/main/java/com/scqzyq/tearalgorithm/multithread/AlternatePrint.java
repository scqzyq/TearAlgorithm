package com.scqzyq.tearalgorithm.multithread;

import lombok.SneakyThrows;

/**
 * @Description: 线程交替打印
 * @Author 盛春强
 * @Date 2021/7/27 16:40
 */
public class AlternatePrint {

    public static void main(String[] args) throws InterruptedException {
//        /*
//        两线程交替打印1-100
//         */
//        Print100 print100 = new Print100();
//        new Thread(print100,"thread-1").start();
//        new Thread(print100,"thread-2").start();

        Object a = new Object(),b = new Object(),c = new Object();
        PrintABC printA = new PrintABC("A",c,a);
        PrintABC printB = new PrintABC("B",a,b);
        PrintABC printC = new PrintABC("C",b,c);
        new Thread(printA,"t-1").start();
        Thread.sleep(10);
        new Thread(printB,"t-2").start();
        Thread.sleep(10);
        new Thread(printC,"t-3").start();
    }
}

class PrintABC implements Runnable {

    private String name;
    private Object prev;
    private Object self;

    public PrintABC(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    @SneakyThrows
    @Override
    public void run() {
        int count = 10;
        while (count>0) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.print(name+" ");
                    count--;
                    self.notify();
                }
                prev.wait();
            }
        }
    }
}


class Print100 implements Runnable {

    private int count = 1;

    @SneakyThrows
    @Override
    public void run() {
        synchronized (this) {
            while (count<=100) {
                System.out.println(Thread.currentThread().getName()+":"+count++);
                this.notify();
                this.wait();
            }
        }
    }
}