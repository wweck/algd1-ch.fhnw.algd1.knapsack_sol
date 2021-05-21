package ch.fhnw.algd1.knapsack;
/*
 * Created on Dec 12, 2013
 */
/**
 * @author Wolfgang Weck
 */
public final class KnapsackObjectoriented {
	private static final int[] weight = { 7, 6, 5, 3 }, value = { 70, 54, 50, 24 };
	private static final int capacity = 9;

	private static class Knapsack implements Cloneable {
		private int totWeight, totValue;

		void packItem(int i) {
			totWeight += weight[i];
			totValue += value[i];
			System.out.println("packing item " + i);
		}

		void unpackItem(int i) {
			totWeight -= weight[i];
			totValue -= value[i];
			System.out.println("unpacking item " + i);
		}

		@Override
		protected Knapsack clone() {
			try {
				return (Knapsack)super.clone();
			}
			catch (CloneNotSupportedException e) {
				throw new InternalError();
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(maxValue());
	}

	private static int maxValue() {
		return pack(0, new Knapsack()).totValue;
	}

	private static Knapsack pack(int i, Knapsack sack) {
		if (i < weight.length) {
			Knapsack s1 = pack(i + 1, sack);
			sack.packItem(i);
			Knapsack s2 = pack(i + 1, sack);
			sack.unpackItem(i);
			if (s1 != null && (s2 == null || s1.totValue > s2.totValue)) return s1;
			else return s2;
		} else if (sack.totWeight <= capacity) {
			return sack.clone();
		} else {
			return null;
		}
	}
}
