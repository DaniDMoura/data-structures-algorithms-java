package dev.algorithms;

import java.util.Hashtable;

public class HashTable {
    public static void main(String[] args) {

        Hashtable<String,String> table = new Hashtable<>(200);

        table.put("100", "Test");
        table.put("123", "Test2");
        table.put("321", "Test3");
        table.put("555", "Test4");
        table.put("777", "Test5");

        for (String key : table.keySet()) {
            System.out.println(key.hashCode() % 200 + "\t" + key + "\t" + table.get(key));
        }






    }
}
