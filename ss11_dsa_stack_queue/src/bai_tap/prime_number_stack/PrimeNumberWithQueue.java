package bai_tap.prime_number_stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PrimeNumberWithQueue {
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

    public static Queue<Integer> getPrimeQueue(int n) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < n; i++) {
            if (isPrime(i)) {
                queue.add(i);
            }
        }
        return queue;
    }
}
