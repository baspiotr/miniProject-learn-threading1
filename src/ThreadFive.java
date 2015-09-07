import java.util.Date;

/**
 * Created by Piotr on 2014-12-30.
 */
public class ThreadFive implements Runnable {


    private Thread thread;

    ThreadFive() {
        thread = new Thread(this, "five");
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

            if (old != MyCommunicate.getStatementReceived() && MyCommunicate.getStatementReceived() != "END" && MyCommunicate.getStatementReceived() != null) {


                Result r = new Result(MyCommunicate.getStatementReceived(), MyCommunicate.getStatementReceived().toLowerCase(), 5, new Date().toString());

                Operation.setWynik(r);
                old = MyCommunicate.getStatementReceived();

                MyCommunicate.latch.countDown();
            }

        }

        if (MyCommunicate.getStatementReceived() == "END") {
            MyCommunicate.latch.countDown();


            System.out.println("lastcase 5 latch= " + MyCommunicate.latch.getCount());

        }

    }


}
