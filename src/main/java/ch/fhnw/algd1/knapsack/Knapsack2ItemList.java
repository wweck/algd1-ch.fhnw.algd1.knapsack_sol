package ch.fhnw.algd1.knapsack;

/*
 * Created on Dec 12, 2013
 */
/**
 * @author Wolfgang Weck
 */
public final class Knapsack2ItemList {
	private static final int[] weight = Example2.weight, value = Example2.value;
	private static final int capacity = Example2.capacity;
	private static int totWeight, totValue, maxValue;
	private static long items, maxItems;

	public static void main(String[] args) {
		System.out.println(maxValue() + " with items:");
		boolean first = true;
		for (int i = 0; i < weight.length; i++) {
			if ((maxItems & (1L << i)) != 0) {
				if (first) {
					System.out.print(i);
					first = false;
				} else System.out.print(", " + i);
			}
		}
	}

	private static int maxValue() {
		maxValue = 0;
		items = 0;
		maxItems = 0;
		pack(0);
		return maxValue;
	}

	private static void pack(int i) {
		if (i < weight.length) {
			pack(i + 1);
			packItem(i);
			if(totWeight <= capacity) pack(i + 1);
			unpackItem(i);
		} else if (totWeight <= capacity && totValue > maxValue) {
			maxValue = totValue;
			maxItems = items;
			System.out.println("new max value " + maxValue + " with weight " + totWeight);
		}
	}

	private static void packItem(int i) {
		totWeight += weight[i];
		totValue += value[i];
		items |= 1L << i;
	}

	private static void unpackItem(int i) {
		totWeight -= weight[i];
		totValue -= value[i];
		items &= ~(1L << i);
	}
}
