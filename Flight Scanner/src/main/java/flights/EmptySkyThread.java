/**
 * Ryan McCloy
 */
package flights;

/**
 * Thread displays a simple text animation when no flights are overhead. When
 * flights are found, the Thread is interrupted
 */
public class EmptySkyThread implements Runnable {

	private static final String MESSAGE = "EMPTY SKIES ABOVE ...";

	@Override
	public void run() {

		while (!Thread.interrupted()) {

			try {
				displayEmptySkyMessage();
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				break;
			}

		}

	}

	/**
	 * method prints a message letter by letter to the console
	 * @throws InterruptedException
	 */
	private void displayEmptySkyMessage() throws InterruptedException {

		for (int i = 0; i < MESSAGE.length(); i++) {

			Thread.sleep(100);
			System.out.print(MESSAGE.charAt(i));

		}
		System.out.println();

	}

}
