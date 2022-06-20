package com.example.springboottask1.db;

import java.util.ArrayList;

public class DBManager {
    private static ArrayList<Items> items = new ArrayList<>();
    private static Long id = 5L;

    static {
        items.add(new Items(1L, "MacBook Pro 2020", " 8 GB RAM\n 256 GB SSD\n Intel Core i7",
                1499.99));
        items.add(new Items(2L, "ASUS TUF GAMING", " 16 GB RAM\n 512 GB SSD\n AMD Ryzen 5",
                999.99));
        items.add(new Items(3L, "XIAOMI Redmi Note 8", " 6 GB RAM\n 64 GB Memory\n Android 9 Pie",
                199.99));
        items.add(new Items(4L, "Apple Iphone 12 PRO", " 6 GB RAM\n 128 GB Memory\n " +
                "Supper Retine XDR OLED Display", 1099.99));
    }

    public static ArrayList<Items> getAllItems(){
        return items;
    }

    public static void addItem(Items item){
        item.setId(id);
        items.add(item);
        id++;
    }

    public static Items getItem(Long id){
        return items.stream()
                .filter(item -> item.getId() == id)
                .findFirst().orElse(null);
    }
}