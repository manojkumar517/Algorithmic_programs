package com.bridzlabs;
import java.util.*;
public class Palindromic_Prime {
        static boolean oneDigit(int num) {
            return (num >= 0 && num < 10);
        }

        static boolean isPalUtil(int num, int dupNum) {
            if (oneDigit(num))
                return (num == (dupNum) % 10);

            if (!isPalUtil(num/10, dupNum))
                return false;

            dupNum /= 10;

            return (num % 10 == (dupNum) % 10);
        }
        static boolean isPal(int num)
        {
            if (num < 0)
                num = -num;

            int dupNum = num; // dupNum = num

            return isPalUtil(num, dupNum);
        }
        static void printPalPrimesLessThanN(int n)
        {
            boolean prime[] = new boolean[n+1];

            Arrays.fill(prime, true);

            for (int p = 2; p*p <= n; p++)
            {
                if (prime[p])
                {
                    for (int i = p*2; i <= n; i += p){
                        prime[i] = false;}
                }
            }
            for (int p = 2; p <= n; p++){

                if (prime[p] && isPal(p)){
                    System.out.print(p + " ");
                }
            }
        }
        public static void main(String[] args)
        {
            int n = 100;
            System.out.printf("Palindromic primes smaller than or "
                    +"equal to %d are :\n", n);
            printPalPrimesLessThanN(n);
        }
}
