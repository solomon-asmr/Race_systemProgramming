/* סלמון קסהון ת"ז 346254824
  שמאל למלם ת"ז 209487594
*/
package Race;

public class Track {
    private int finishedRacers = 0;

    // Synchronized method to increment the number of finished racers
    public synchronized int racerFinished() {
        return ++finishedRacers;
    }
}

