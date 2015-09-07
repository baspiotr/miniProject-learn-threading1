import java.util.concurrent.CountDownLatch;

/**
 * Created by Piotr on 2014-12-30.
 */
public class MyWriter implements Runnable {

    Thread thread;

    MyWriter() {

        thread = new Thread(this, "Pisarz");

        thread.start();

    }

    @Override
    public void run() {


        String[] s = {"Pies", "Kot", "Zebra", "END"};


        for (int i = 0; i < s.length; i++) {


            try { // autor zastanawia się chwilę co napisać
                thread.sleep((int) (Math.random() * 1000));

            } catch (InterruptedException exc) {
            }

            MyCommunicate.setData(s[i]);
            MyCommunicate.latch= new CountDownLatch(5);

            try {
                MyCommunicate.latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
