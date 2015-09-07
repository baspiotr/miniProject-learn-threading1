import java.util.Date;

/**
 * Created by Piotr on 2014-12-30.
 */

public class ThreadThree implements Runnable {


    private Thread thread;

    ThreadThree() {
        thread = new Thread(this, "reverse");
        thread.start();
    }

    public void run() {

        String old = "as";

        while (!MyCommunicate.getStatementReceived().equals("END")) {


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (old != MyCommunicate.getStatementReceived() && MyCommunicate.getStatementReceived() != "END"&& MyCommunicate.getStatementReceived() != null) {


                Result r = new Result(MyCommunicate.getStatementReceived(), new StringBuilder(MyCommunicate.getStatementReceived()).reverse().toString(), 3, new Date().toString());
                // System.out.println("ThreadOne r = " + r.toString());
                Operation.setWynik(r);
                old = MyCommunicate.getStatementReceived();

                MyCommunicate.latch.countDown();
            }

            if (MyCommunicate.getStatementReceived() == "END") {
                MyCommunicate.latch.countDown();


                System.out.println("lastcase 3 latch= " + MyCommunicate.latch.getCount());

            }

        }


    }

}