package bai_tap.prime_number_stack;

import java.util.Queue;
import java.util.Scanner;

import static bai_tap.prime_number_stack.PrimeNumberWithQueue.getPrimeQueue;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập số nguyên dương n: ");
        int n = scanner.nextInt();

        Queue<Integer> primeQueue = getPrimeQueue(n);
        System.out.println("Các số nguyên tố nhỏ hơn " + n + ": ");
        while (!primeQueue.isEmpty()){
            System.out.print(primeQueue.poll()+ " ");
        }
        System.out.println();
    }
}
