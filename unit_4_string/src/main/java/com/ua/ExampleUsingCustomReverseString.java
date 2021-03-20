package com.ua;

import ua.com.StringReverse;

public class ExampleUsingCustomReverseString {

    public static void main(String[] args) {
        System.out.println(StringReverse.reverse("hello world"));
        System.out.println(StringReverse.reverse("hello world", "worl"));
        System.out.println(StringReverse.reverse("hello world", 3,7));
    }
}
