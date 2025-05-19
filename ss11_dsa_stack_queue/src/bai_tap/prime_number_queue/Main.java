package bai_tap.prime_number_queue;

import java.util.Scanner;
import java.util.Stack;

import static bai_tap.prime_number_queue.PrimeNumberWithStack.getPrimeStack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập số nguyên dương n: ");
        int n = scanner.nextInt();

        Stack<Integer> primeStack = getPrimeStack(n);
        System.out.println("Các số nguyên tố nhỏ hơn " + n + ": ");
        while (!primeStack.isEmpty()){
            System.out.print(primeStack.pop()+ " ");
        }
        System.out.println();
    }
}
