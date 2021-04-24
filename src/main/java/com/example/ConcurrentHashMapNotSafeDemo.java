package com.example;

import java.util.concurrent.ConcurrentHashMap;

//unsave
public class ConcurrentHashMapNotSafeDemo implements Runnable {
    private static ConcurrentHashMap<String, Integer> scores = new ConcurrentHashMap<>();
    public static void main(String[] args) throws InterruptedException {
        scores.put("John", 0);
        Thread t1 = new Thread(new ConcurrentHashMapNotSafeDemo(),"GUo");
        Thread t2 = new Thread(new ConcurrentHashMapNotSafeDemo(),"TT");
        Thread t3 = new Thread(new ConcurrentHashMapNotSafeDemo(),"AA");

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println(scores);
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            while(true){
                Integer score = scores.get("John");
                Integer newScore = score + 1;
//            Integer scoreA = scores.get("John");
//            if(!score.equals(scoreA)){
//                System.out.println(Thread.currentThread().getName()+" put new score into" +newScore+"to replace old"+score+ "but now is"+scoreA);
//            }
//            scores.put("John", newScore);
               boolean result= scores.replace("John",score,newScore);
//               System.out.println(Thread.currentThread().getName()+" put new score into result "  +result);

                if(result){
//                    System.out.println(Thread.currentThread().getName()+" put new score into result "  +result);
                    break;
               }else {
                    System.out.println(Thread.currentThread().getName()+" put new score into result "  +result);

                }
            }

        }
    }
}
