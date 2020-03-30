package cricket;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to imitate a cricket match situation
 *
 */
public class Match {
	private int noOfBallsToPlay;
	private PriorityQueue bowlers;

	/**
	 * Constructor to initialize no of deleveries to be played by Virat Kohli
	 * should be a positive integer, and queue of bowlers
	 * 
	 * @param noOfBallsToPlay
	 *            by Virat should be a positive integer
	 * @param bowlers
	 *            array of bowlers
	 * @throws Exception
	 *             if bowlers is null or balls to bowl turns out to be
	 *             insufficient
	 */
	public Match(int noOfBallsToPlay, Bowler[] bowlers) throws Exception {
		if (bowlers == null) {
			throw new Exception("Null bowlers passed!");
		}
		this.noOfBallsToPlay = noOfBallsToPlay;
		this.bowlers = new PriorityQueueImplementation(bowlers.length);
		int totalBallsRemained = 0;
		for (Bowler bowler : bowlers) {
			if (bowler == null) {
				throw new Exception("Null bowler found!");
			}
			totalBallsRemained += bowler.getDeliveriesRemained();
			this.bowlers.push(bowler);
		}
		if (totalBallsRemained < this.noOfBallsToPlay) {
			throw new Exception("Not enough bowlers left!");
		}
	}

	/**
	 * Function to order bowlers and plan strategy
	 * @return array of bowler's names in bowling order
	 * @throws Exception
	 */
	public List<String> planStrategy() throws Exception {
		List<String> bowlersOrder = new ArrayList<String>();
		while (!this.bowlers.isEmpty() && this.noOfBallsToPlay != 0) {
			Bowler bowler = this.bowlers.pop();
			int noOfBallsToBowl = this.noOfBallsToPlay;
			if (!this.bowlers.isEmpty()) {
				noOfBallsToBowl = Math.min(noOfBallsToBowl,
						bowler.getDeliveriesRemained()
								- this.bowlers.top().getDeliveriesRemained()
								+ 1);
			} else {
				noOfBallsToBowl = Math.min(noOfBallsToBowl,
						bowler.getDeliveriesRemained());
			}
			bowlersOrder.add(bowler.getName());
			bowler.bowlDeliveries(noOfBallsToBowl);
			this.noOfBallsToPlay -= noOfBallsToBowl;

			if (bowler.getDeliveriesRemained() != 0) {
				this.bowlers.push(bowler);
			}
		}
		return bowlersOrder;
	}
}
