/**
 * Created by Piotr on 2014-12-30.
 */

/**
 * Created by Piotr on 2014-12-29.
 */
public class Result {


    private String statementReceived;
    private String statementProcessed;
    private int threadId;
    private String timeStamp;


    Result(String statementReceived, String statementProcessed, int threadId, String timeStamp) {

        this.statementReceived = statementReceived;
        this.statementProcessed = statementProcessed;
        this.threadId = threadId;
        this.timeStamp = timeStamp;

    }

    @Override
    public String toString() {
        return "Result{" +
                "statementReceived='" + statementReceived + '\'' +
                ", statementProcessed='" + statementProcessed + '\'' +
                ", threadId=" + threadId +
                ", timeStamp='" + timeStamp + '\'' +
                '}';
    }


}
