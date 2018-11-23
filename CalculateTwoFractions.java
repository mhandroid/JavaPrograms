package com.mub.main;
/**
 * Class to calculate fraction
 *e.g. Input:  1/2 + 3/2. => 2/1
 *     Input:  1/3 + 3/9 => 2/3
 *     Input:  1/5 + 3/15 => 2/5
 * Created by @author Mubarak Hussain.
 */
public class CalculateTwoFractions {
	public static void main(String[] args) {
		System.out.println(calFractionSums("1/4+4/6"));
		System.out.println(calFractionSums("1/3+4/6"));

	}

	static long lcm(long n1, long n2) {

		if (n1 == 0) {
			return n2;
		}
		long lcm = (n1 > n2) ? n1 : n2;
		while (true) {
			if (lcm % n1 == 0 && lcm % n2 == 0)
				break;
			++lcm;
		}
		return lcm;
	}
	
	static long calGCD(long n1,long n2) {
		while(n1 != n2)
        {
            if(n1 > n2)
                n1 -= n2;
            else
                n2 -= n1;
        }

        System.out.println("G.C.D = " + n1);
        return n1;
	}

	static String calFractionSums(String expressions) {
		String result = "";
		if (expressions == null)
			return result;

		String expFirstPart = expressions.split("\\+")[0];
		String expSecondPart = expressions.split("\\+")[1];

		long den1 = Long.parseLong(expFirstPart.split("/")[1]);
		long den2 = Long.parseLong(expSecondPart.split("/")[1]);
		long no1 = Long.parseLong(expFirstPart.split("/")[0]);
		long no2 = Long.parseLong(expSecondPart.split("/")[0]);

		long lcm = lcm(den1, den2);
		System.out.println("LCM is: " + lcm);
		long sum = (lcm / den1) * no1 + (lcm / den2) * no2;

		System.out.println("Sum is: " + sum);

		long gcd = calGCD(sum, lcm);
		sum = sum/gcd;
		lcm = lcm/gcd;
		result = sum + "/" + lcm;

		return result;
	}
}
