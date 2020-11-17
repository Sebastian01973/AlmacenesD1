package TestPackage;

import models.ManagerStore;
import models.Product;
import models.Store;

public class TestBig {
    public static void main(String[] args) {
        ManagerStore managerStore = new ManagerStore();

        Store store1 = new Store("Hola","Calle");
        Store store2 = new Store("Mundo","carrera");
        managerStore.addStore(store1);
        managerStore.addStore(store2);

        Product product1 = new Product("C1","carne",10,1000);
        Product product2 = new Product("C2","Pollo",5,2000);
        Product product3 = new Product("C3","Pescado",15,3000);
        store1.addProduct(product1);
        store1.addProduct(product2);
        store1.addProduct(product3);

        Product product4 = new Product("C4","fresa",10,500);
        Product product5 = new Product("C5","Mora",10,1500);
        Product product6 = new Product("C6","Mango",10,200);
        store2.addProduct(product4);
        store2.addProduct(product5);
        store2.addProduct(product6);

        System.out.println(""+managerStore.getTotalInventaryStores());

    }
}
