/**
 * 
 */
package time;

/**
 * Threaded class that controls the timed element of the game
 */
public class TimerThread implements Runnable {
	
	// the current time the thread has been running in seconds
	private int currentCount;

	/**
	 * Starts the thread timer - runs to specified length but will quit naturally if not interrupted
	 */
	@Override
	public void run() {
		
		this.currentCount = 0;

		// start a silent timer - will run to twice the gameLength if not interrupted
		try {
			do {
				Thread.sleep(1000);
				this.currentCount++;
			} while(this.currentCount <= GameControl.gameLength * 2);
		} catch (InterruptedException e) {
			// here if interrupted - will cause the thread to end
		}
	
	}
	
	/**
	 * Returns the time the thread has been on the go
	 * @return
	 */
	public int getCurrentCount() {
		return currentCount;
	}

}
