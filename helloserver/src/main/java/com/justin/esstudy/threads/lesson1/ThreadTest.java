package com.justin.esstudy.threads.lesson1;

import java.util.Objects;

public class ThreadTest {

    public static void main(String[] args) {
        String s = "cane";

        System.out.println(s.hashCode());
        System.out.println(Objects.hash(s));
    }
}
