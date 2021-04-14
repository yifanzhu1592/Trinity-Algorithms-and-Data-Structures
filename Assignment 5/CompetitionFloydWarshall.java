/*
 * A Contest to Meet (ACM) is a reality TV contest that sets three contestants at three random
 * city intersections. In order to win, the three contestants need all to meet at any intersection
 * of the city as fast as possible.
 * It should be clear that the contestants may arrive at the intersections at different times, in
 * which case, the first to arrive can wait until the others arrive.
 * From an estimated walking speed for each one of the three contestants, ACM wants to determine the
 * minimum time that a live TV broadcast should last to cover their journey regardless of the contestantsâ€™
 * initial positions and the intersection they finally meet. You are hired to help ACM answer this question.
 * You may assume the following:
 *    ï‚· Each contestant walks at a given estimated speed.
 *    ï‚· The city is a collection of intersections in which some pairs are connected by one-way
 * streets that the contestants can use to traverse the city.
 *
 * This class implements the competition using Floyd-Warshall algorithm
 */

import java.io.BufferedReader;
import java.io.FileReader;

public class CompetitionFloydWarshall {

	String filename;
	int sA, sB, sC;
	int slowest;
	boolean valid = true;
	int numberOfIntersections, numberOfStreets;
	double[][] distanceArray;

	/**
	 * @param filename: A filename containing the details of the city road network
	 * @param sA,       sB, sC: speeds for 3 contestants
	 */
	CompetitionFloydWarshall(String filename, int sA, int sB, int sC) {

		// TODO
		this.filename = filename;
		this.sA = sA;
		this.sB = sB;
		this.sC = sC;
		if (sA < sB && sA < sC) {
			slowest = sA;
		} else if (sB < sA && sB < sC) {
			slowest = sB;
		} else {
			slowest = sC;
		}

		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
			numberOfIntersections = Integer.parseInt(bufferedReader.readLine());
			numberOfStreets = Integer.parseInt(bufferedReader.readLine());

			if (numberOfIntersections == 0 || numberOfStreets == 0) {
				valid = false;
			} else {
				distanceArray = new double[numberOfIntersections][numberOfIntersections];
				for (int i = 0; i < numberOfIntersections; i++) {
					for (int j = 0; j < numberOfIntersections; j++) {
						distanceArray[i][j] = Double.MAX_VALUE;
					}
				}
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					String[] lineNumbers = line.split(" ");
					distanceArray[Integer.parseInt(lineNumbers[0])][Integer.parseInt(lineNumbers[1])] = Double
							.parseDouble(lineNumbers[2]);
				}
				bufferedReader.close();
			}
		} catch (Exception e) {
			valid = false;
		}
	}

	/**
	 * @return int: minimum minutes that will pass before the three contestants can
	 *         meet
	 */
	public int timeRequiredforCompetition() {

		// TO DO
		if (!valid) {
			return -1;
		}

		if ((sA > 100 || sA < 50) || (sB > 100 || sB < 50) || (sC > 100 || sC < 50)) {
			return -1;
		}

		for (int i = 0; i < numberOfIntersections; i++) {
			for (int j = 0; j < numberOfIntersections; j++) {
				for (int k = 0; k < numberOfIntersections; k++) {
					if (distanceArray[j][i] + distanceArray[i][k] < distanceArray[j][k]) {
						distanceArray[j][k] = distanceArray[j][i] + distanceArray[i][k];
					}
				}
			}
		}

		double longestShortest = 0;
		for (int m = 0; m < numberOfIntersections; m++) {
			for (int n = 0; n < numberOfIntersections; n++) {
				longestShortest = (distanceArray[m][n] > longestShortest && m != n) ? distanceArray[m][n]
						: longestShortest;
			}
		}

		if (longestShortest == Double.MAX_VALUE) {
			return -1;
		}

		return (int) Math.ceil(longestShortest * 1000 / slowest);
	}

}
