package com.activatedgeek.mesosframework;

public class Main {
    public static void main(String[] args) {
        if (args.length == 1) {
            System.out.println("found argument " + args[0]);
        } else {
            System.out.println("No arg found");   
        }
    }
}
