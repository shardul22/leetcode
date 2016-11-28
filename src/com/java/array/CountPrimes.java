package com.java.array;

/**
 * https://leetcode.com/problems/count-primes/
 */
public class CountPrimes {
    /**
     * This is a naive approach which checks if number is PRIME or not, then it increments
     * the count.
     * @param n input number n to count prime numbers
     * @return the count of prime numbers
     */
    public int countPrimes(int n) {

        /*
        * Steps to solve the problem :-
        *
        * 1) Check boundry conditions.
        * 2) Check if the number is prime or not and mark all of its multiples as not prime.
        * 3) if number is prime then increment the count of prime numbers
        * 4) return the count of numbers
        *
        * */
        if(n<=2)
            return 0;

        int count = 0;

        // This array stores if the number at index i is prime or not.
        // Initially all the elements of array are assigned with default false value.
        // If the value at index "i"  is false then number is a prime number othewise
        // number is not a prime number.
        boolean[] nonPrimeNumberArray = new boolean[n];

        for(int i=2; i<n; i++) {
            if(nonPrimeNumberArray[i]) {
                continue;
            }

            // The number is prime number hence increment count.
            count++;

            // The for loop below marks all the multiples of number "i" as non prime numbers.
            for(int j=i+i; j<n; j=j+i) {
                nonPrimeNumberArray[j] = true;
            }
        }
        return count;
    }

    /**
     * This is a naive approach which checks if number is PRIME or not, then it increments
     * the count.
     * @param n input number n to count prime numbers
     * @return the count of prime numbers
     */
    public int countPrimesNaive(int n) {
        /*
        * Steps :-
        * 1) Check Boundry Condition
        * 2) Check if the number is prime or not then increment counter
        * */
        if(n<=2)
            return 0;
        int count = 0;
        for(int i=2; i<n; i++) {
            if(isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    /**
     * This method checks if number is prime or not and return true otherwise fasle.
     * @param inputNumber
     * @return true if prime otherwise false
     */
    private boolean isPrime(int inputNumber) {
        for(int j=2; j<=inputNumber; j++) {
            if(inputNumber != j && inputNumber%j == 0) {
                return false;
            }
        }
        return true;
    }
}
