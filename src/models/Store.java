package models;

import structures.ComparatorProduct;
import structures.doublyList.DoublyList;

import java.util.ArrayList;
import java.util.Comparator;

public class Store {

    private DoublyList<Product> listProducts;
    private Comparator comparator;
    private String nameStore;
    private String address;

    public Store(String nameStore, String address) {
        comparator = new ComparatorProduct();
        this.listProducts = new DoublyList<Product>(comparator);
        this.nameStore = nameStore;
        this.address = address;
    }

    public void addProduct(Product product){
        listProducts.insert(product);
    }

    public int getSize(){
        return listProducts.size();
    }

    public Product createProduct(String code,String name,int amount,double value){
        return  new Product(code,name,amount,value);
    }


    public double getTotalInventary(){
        double total = 0;
        int size = getSize();
        for (int i = 0; i < size; i++) {
            total += listProducts.getData(i).getTotalProduct();
        }
        return total;
    }

    public boolean isValidateName(String nameStore){
        return this.nameStore.equals(nameStore);
    }

    public ArrayList<Object[]> getMatrixData() {
        ArrayList<Object[]> auxDatasArrayList = new ArrayList<>();
        int size = getSize();
        for (int i = 0; i < size; i++) {
            auxDatasArrayList.add(listProducts.getData(i).toObjectVector());
        }
        return auxDatasArrayList;
    }

    public Product getProduct(String code){
        int size = getSize();
        for (int i = 0; i < size; i++) {
            if (isValidateCode( code)){
                return listProducts.getData(i);
            }
        }
        return null;
    }

    public boolean isValidateCode(String code){
        int size = getSize();
        for (int i = 0; i < size; i++) {
            if (listProducts.getData(i).getCode().equals(code)){
                return true;
            }
        }
        return false;
    }

    public boolean refreshAmount(String code,int amount){
        int size = getSize();
        for (int i = 0; i < size; i++) {
            if (listProducts.getData(i).isValidateCode(code) && amount <= listProducts.getData(i).getAmount()){
                listProducts.getData(i).deleteAmount(amount);
                return true;
            }
        }
        return false;
    }

    public String getNameStore() {
        return nameStore;
    }

    public String getAddress() {
        return address;
    }

    public Object[] toObjectVectorStore(){
        return new Object[]{
             nameStore,address,getTotalInventary()
        };
    }

}
