import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Piotr on 2014-12-30.
 */
public class Operation {

    public static ArrayList<Result> outputList = new ArrayList<Result>();

    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private static Lock wLock = lock.writeLock();


    static public void setWynik(Result r) {

        wLock.lock();
        try {

            outputList.add(r);


        } finally {
            wLock.unlock();
        }

    }

    static public void showList() {
        System.out.println("Lista wyników:");
        for (Result x : outputList) System.out.println(x);
    }


}
