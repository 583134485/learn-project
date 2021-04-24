package com.example;

import javax.servlet.SingleThreadModel;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadMain {
    public static void main(String[] args) {
//        Thread

//
//                Condition
//        ReentrantLock
//                AbstractQueuedSynchronizer
//            AtomicInteger

            ExecutorService executor = Executors.newCachedThreadPool();
            Task task = new Task();
            Future<Integer> result = executor.submit(task);

            executor.shutdown();

            FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
            executor.submit(futureTask);
            executor.shutdown();


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }

            System.out.println("主线程在执行任务");

            try {
                System.out.println("task运行结果" + result.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            System.out.println("所有任务执行完毕");
        }
    }

    class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            System.out.println("子线程在进行计算");
            Thread.sleep(3000);
            int sum = 0;
            for (int i = 0; i < 100; i++)
                sum += i;
            return sum;
        }
    }

