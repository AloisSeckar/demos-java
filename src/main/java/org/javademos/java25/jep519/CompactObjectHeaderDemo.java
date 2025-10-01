package com.example.jep519;

public class CompactObjectHeaderDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {
            new Object();
        }
        System.out.println("JEP 519 Compact Object Headers demo completed.");
    }
}
