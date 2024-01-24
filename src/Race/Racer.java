/* סלמון קסהון ת"ז 346254824
  שמאל למלם ת"ז 209487594
*/
package Race;

public class Racer implements Runnable {
    private static int globalId = 1; // Static field to generate unique ID
    private final int id;             // Unique ID for each racer
    private int speed;                // Racer's speed
    private Track track;              // Track on which the racer is running

    // Constructor
    public Racer(int speed, Track track) {
        this.id = globalId++;
        if (speed < 1 || speed > 10) {
            System.err.println("Invalid speed. Must be between 1 and 10.");
            return;
        }

        this.speed = speed;
        this.track = track;
    }

    // go() method
    private void go() {
        // Set the thread priority to the racer's speed
        Thread.currentThread().setPriority(this.speed);
        for (int meter = 1; meter <= 100; meter++) {
            System.out.println("Runner " + id + " ran " + meter + " meters");
            try {
                // Simulating the running by putting the thread to sleep
                Thread.sleep(1000 / speed);
            } catch (InterruptedException e) {
                System.err.println("Interrupted: " + e.getMessage());
            }
        }

        int position = track.racerFinished();
        System.out.println("Runner " + id + " finished " + ordinal(position));
    }

    // run() method from Runnable
    @Override
    public void run() {
        go();
    }

    // Helper method to format the position (1st, 2nd, 3rd, etc.)
    private static String ordinal(int number) {
        if (number >= 11 && number <= 13) {
            return number + "th";
        }
        switch (number % 10) {
            case 1:  return number + "st";
            case 2:  return number + "nd";
            case 3:  return number + "rd";
            default: return number + "th";
        }
    }
}
