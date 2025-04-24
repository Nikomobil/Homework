package com.webshop.data;

public class ContactData {
    static int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
    public static  final String Email = "test" + i + "@test.com";
    public static  final String Gender = "gender-male";
    public static  final String FirstName = "Mark";
    public static  final String LastName = "Twain";

    public static  final String Comment = "test comment";
}
