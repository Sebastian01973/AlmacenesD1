package TestPackage;

import models.Product;
import models.Store;

public class testAddProduct {

    public static void main(String[] args) {
        Store test = new Store("Hola","Mundo");
        Product p1 = new Product("web","Pollo",15,2000);
        Product p2 = new Product("ads","Carne",5,1000);
//        Product p3 = new Product("ok","Pescado",15,2300);
//        Product p4 = new Product("thb","Lechuga",15,2300);
        test.addProduct(p1);
        test.addProduct(p2);
//        test.addProduct(p3);
//        test.addProduct(p4);


        System.out.println(test.getSize());

        System.out.println("+++++++++++++++++");

        System.out.println(test.refreshAmount("web",15));
        System.out.println(test.getTotalInventary());
    }
}
