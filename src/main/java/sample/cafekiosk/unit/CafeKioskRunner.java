package sample.cafekiosk.unit;

import sample.cafekiosk.unit.beverages.Americano;
import sample.cafekiosk.unit.beverages.Latte;

public class CafeKioskRunner {
    public static void main(String[] args) {
        CafeKiosk cafeKiosk = new CafeKiosk();
        cafeKiosk.add(new Americano());
        cafeKiosk.add(new Latte());

        int totalPrice = cafeKiosk.calculateTotalPrice();
        System.out.println("총 주문 가격 : " + totalPrice);
    }
}
