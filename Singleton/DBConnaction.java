package Singleton;

import java.util.concurrent.locks.ReentrantLock;

public class DBConnaction {

    private static volatile DBConnaction volatileInstance;
    private static  DBConnaction instance;
    private final static ReentrantLock lock = new ReentrantLock();


    private DBConnaction() {
       
    }

    public static  DBConnaction getInstance() {
        return createNewInstance() ;
        // return reentrantLockInstance() ;
        //   return synchronizedInstance() ;
        // return blockSynchronizedInstance() ;
        // return volatileInstance() ;      

        
    }
    private static  DBConnaction volatileInstance() {
      if ( volatileInstance == null) {
            volatileInstance = new DBConnaction();
            System.out.println("Creating new instance of DBConnaction" +
                    " with hashcode: " + System.identityHashCode(volatileInstance));
                    return volatileInstance;
        }
        System.out.println("Returning existing instance of DBConnaction"+
                " with hashcode: " + System.identityHashCode(volatileInstance));
        return volatileInstance;
    }
    public static DBConnaction createNewInstance() {
         if (instance == null) {
             instance = new DBConnaction();
             System.out.println("Creating new instance of DBConnaction" +
                    " with hashcode: " + System.identityHashCode(instance));
        }
         System.out.println("Returning existing instance of DBConnaction"+
                " with hashcode: " + System.identityHashCode(instance));
        return instance;
    }   
    public static DBConnaction blockSynchronizedInstance() {
        synchronized (DBConnaction.class) {
            if ( instance == null) {
                        instance = new DBConnaction();
                        System.out.println("Creating new instance of DBConnaction" +
                                " with hashcode: " + System.identityHashCode(instance));
                                return instance;
                    }
                }
                System.out.println("Returning existing instance of DBConnaction"+
                        " with hashcode: " + System.identityHashCode(instance));
                return instance;
    }
    public static synchronized DBConnaction synchronizedInstance() {
 
            if ( instance == null) {
                        instance = new DBConnaction();
                        System.out.println("Creating new instance of DBConnaction" +
                                " with hashcode: " + System.identityHashCode(instance));
                                return instance;
                    }
                
                System.out.println("Returning existing instance of DBConnaction"+
                        " with hashcode: " + System.identityHashCode(instance));
                return instance;
    }
    public static DBConnaction reentrantLockInstance() {
        lock.lock();
        try {
            if ( instance == null) {
                        instance = new DBConnaction();
                        System.out.println("Creating new instance of DBConnaction" +
                                " with hashcode: " + System.identityHashCode(instance));
                                return instance;
                    }
        } finally {
            lock.unlock();
        }
        System.out.println("Returning existing instance of DBConnaction"+
                " with hashcode: " + System.identityHashCode(instance));
        return instance;
    }

}
