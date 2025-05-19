package bai_tap.prime_number_queue;

import java.util.Stack;

public class PrimeNumberWithStack {
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static Stack<Integer> getPrimeStack(int n) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i < n; i++) {
            if (isPrime(i)) {
                stack.push(i);
            }
        }
        return stack;
    }
}
