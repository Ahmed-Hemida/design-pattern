package Singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonDesignPattern {

    public static void main(String[] args) {
        testSingleton();
    }
    
    public static void testSingleton() {
       ExecutorService threadManager = Executors.newFixedThreadPool(10);

        try {
            for (int i = 0; i < 10; i++) {
                final int threadIndex = i+1;
                threadManager.submit(() -> {
                   DBConnaction db =  DBConnaction.getInstance();
                //    System.out.println("Thread " + threadIndex + 
                //    " got instance of DBConnaction with hashcode: " + System.identityHashCode(db));
                    // System.out.println("Thread " + threadIndex + " completed.");
                   
                });
            }
        } finally {
            threadManager.shutdown();
        }
    }
}
