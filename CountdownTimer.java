// Importing required libraries
import java.util.Timer;
import java.util.TimerTask;

// Class definition for CountdownTimer
public class CountdownTimer {
    Timer timer; // Initializing a Timer object
    int seconds; // Initializing an integer variable to store the number of seconds

    // Constructor for CountdownTimer class
    public CountdownTimer(int seconds) {
        this.seconds = seconds; // Assigning the input value to the variable 'seconds'
        timer = new Timer(); // Creating a new Timer object
        timer.schedule(new RemindTask(), 0, 1000); // Scheduling a new task to run after every second
    }

    // Class definition for RemindTask which extends TimerTask class
    class RemindTask extends TimerTask {
        public void run() {
            if (seconds > 0) { // Checking if there are any seconds left
                System.out.println("Time remaining: " + seconds + " seconds"); // Printing the remaining time in seconds
                seconds--; // Decrementing the value of 'seconds' by 1
            } else { 
                System.out.println("Time's up!"); // Printing "Time's up!" when there are no more seconds left
                timer.cancel(); // Cancelling the timer object once time is up
            }
        }
    }

    public static void main(String[] args) {
        new CountdownTimer(10); // Creating a new instance of CountdownTimer with 10 as input value (10 second countdown)
    }
}