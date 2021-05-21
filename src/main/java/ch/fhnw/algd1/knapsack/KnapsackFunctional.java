package ch.fhnw.algd1.knapsack;
/*
 * Created on Dec 12, 2013
 */
/**
 * @author Wolfgang Weck
 */
public final class KnapsackFunctional {
	private static final int[] weight = { 7, 6, 5, 3 }, value = { 70, 54, 50, 24 };
	private static final int capacity = 9;

	public static void main(String[] args) {
		System.out.println(maxValue());
	}

	private static int maxValue() {
		return maxValue(0, 0, 0);
	}

	private static int maxValue(int i, int knapsackWeight, int knapsackValue) {
		if (i < weight.length) return Math.max(maxValue(i + 1, knapsackWeight, knapsackValue),
				maxValue(i + 1, knapsackWeight + weight[i], knapsackValue + value[i]));
		else if (knapsackWeight <= capacity) return knapsackValue;
		else return 0;
	}
}
