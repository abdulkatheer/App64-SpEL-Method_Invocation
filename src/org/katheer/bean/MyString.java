package org.katheer.bean;

public class MyString {
    private String string;

    public MyString(String string) {
        this.string = string;
    }

    public String reverseString() {
        return new StringBuffer(string).reverse().toString();
    }
}
