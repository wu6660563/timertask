package com.latin.test;

public class Test1 {

	public static void main(String[] args) {

		Double[] d = { 10764D, 1757.34, 1408.68, 19657.17, 5751.72, 70.2,
				11664.9, 40366.76, 2310.75, 6174.09, 3208.14, 2019.42, 4965.48,
				2356.38, 2740.14, 17709.12, 20844.72, 30366.65, 301.86,
				6998.94, 3208.14, 42054.48, 14703.39, 400.14, 3793.4, 262.08,
				1692.99, 919.62, 9126D };

		double s = 0.0;
		int count = 0;
		double a = 5560.54;
		for (int i = 0; i < 24; i++) {
			for (int j = 1; j < 24; j++) {
				for (int x = 2; x < 24; x++) {
					for (int y = 3; y < 24; y++) {
						s = d[i] + d[j] + d[x] + d[y];

						if (s == a) {

							System.out.print(d[i] + ",");
							System.out.print(d[j] + ",");
							System.out.print(d[x] + ",");
							System.out.println(d[y]);
							System.out.println("------");

						}
						count = count + 1;

					}
				}
			}
		}
		System.out.println(count);
	}

}
