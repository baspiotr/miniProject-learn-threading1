import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Piotr on 2014-12-30.
 */
public class MyCommunicate {


    private static String statementReceived;
    private static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    private static Lock readLock = rwl.readLock();
    private static Lock writeLock = rwl.writeLock();

    public static CountDownLatch latch = new CountDownLatch(5);


    static public String getStatementReceived() {
        readLock.lock();
        try {

            return statementReceived;
        } finally {
            readLock.unlock();
        }
    }


    static public void setData(String received) {
        writeLock.lock();
        try {

            statementReceived = received;


        } finally {
            writeLock.unlock();
        }
    }


}



