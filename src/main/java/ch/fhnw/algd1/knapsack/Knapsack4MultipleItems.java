package ch.fhnw.algd1.knapsack;
/*
 * Created on Dec 12, 2013
 */
/**
 * @author Wolfgang Weck
 */
public final class Knapsack4MultipleItems {
	private static final int[] weight = { 7, 6, 5, 3 }, value = { 70, 54, 50, 24 };
	private static final int capacity = 19, maxN = 3;
	private static int totWeight, totValue, maxValue;

	public static void main(String[] args) {
		System.out.println(maxValue());
	}

	private static int maxValue() {
		maxValue = 0;
		pack(0);
		return maxValue;
	}

	private static void pack(int i) {
		if (i < weight.length) {
			if (totWeight > capacity) {
				System.out.println("too heavy already...");
			} else {
				pack(i + 1);
				for (int n = 0; n < maxN; n++) {
					packItem(i);
					pack(i + 1);
				}
				unpackItem(i, maxN);
			}
		} else if (totWeight <= capacity && totValue > maxValue) {
			maxValue = totValue;
			System.out.println("new max value " + maxValue + " with weight "
					+ totWeight);
		}
	}

	private static void packItem(int i) {
		totWeight += weight[i];
		totValue += value[i];
		System.out.println("packing item " + i);
	}

	private static void unpackItem(int i, int n) {
		totWeight -= weight[i] * n;
		totValue -= value[i] * n;
		System.out.println("unpacking item " + i);
	}
}
