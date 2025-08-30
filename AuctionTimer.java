import java.util.Timer;
import java.util.TimerTask;

public class AuctionTimer {
    private Timer timer;

    public AuctionTimer() {
        this.timer = new Timer();
    }

    public void startTimer(int durationInSeconds, TimerTask task) {
        // Convert seconds to milliseconds
        long delay = durationInSeconds * 1000;
        timer.schedule(task, delay);
    }

    public void stopTimer() {
        timer.cancel();
    }
}
