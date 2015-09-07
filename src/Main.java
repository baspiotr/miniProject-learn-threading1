/**
 * Created by Piotr on 2014-12-30.
 */
public class Main {


    public static void main(String args[]) throws InterruptedException {

        new MyWriter();

        Thread.sleep(3500);

        new ThreadOne();
        new ThreadTwo();
        new ThreadThree();
        new ThreadFour();
        new ThreadFive();

        Thread.sleep(15000);

        System.out.println("rozmiar listy = " + Operation.outputList.size());

        for (Result x : Operation.outputList) System.out.println("z listy " + x);

    }
}
