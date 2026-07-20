package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void startGrocery(){
        Scanner scan = new Scanner(System.in);
        int choose = -1;
        while(choose != 0){
            System.out.println("\n0: Kapat | 1: Ekle | 2: Çıkar");
            System.out.print("Seçiminiz: ");
            choose = scan.nextInt();
            scan.nextLine();
            if (choose == 1){
                System.out.println("Eklenecek Ürünleri Girin");
                String item = scan.nextLine();
                addItems(item);
            } else if (choose == 2) {
                System.out.println("Çıkarılacak Ürünlleri Girin");
                String item = scan.nextLine();
                removeItems(item);
            }else if (choose != 0) {
                System.out.println("Geçersiz seçim!");
            }
        }
        scan.close();
    }

    public static void addItems(String item) {
        String[] products = item.split(",");
        for(String product : products){
            String trimProduct = product.trim();

            if (!checkInItemsList(trimProduct)){
                groceryList.add(trimProduct);
            }else {
                System.out.println("-> " + trimProduct + " zaten listede var, tekrar eklenmedi!");
            }
        }
        printSorted();
    }

    public static void removeItems(String item){
        String[] products = item.split(",");
        for (String product : products){
            String trimProduct = product.trim();

            if (checkInItemsList(trimProduct)){
                groceryList.remove(trimProduct);
            }else {
                System.out.println("-> " + trimProduct + " zaten listede yok!");

            }
        }
        printSorted();
    }

    public static boolean checkInItemsList(String product){
        return groceryList.contains(product);
    }

    public static void printSorted(){
        Collections.sort(groceryList);
        System.out.println("Güncel Listeniz: " + groceryList);
    }
}
