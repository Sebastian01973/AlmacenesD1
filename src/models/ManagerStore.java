package models;

import structures.ComparatorStore;
import structures.simpleList.SimpleList;

import java.util.ArrayList;

public class ManagerStore {

    private SimpleList<Store> storeList;
    private ComparatorStore comparatorStore;

    public ManagerStore(){
        comparatorStore = new ComparatorStore();
        storeList = new SimpleList<>(comparatorStore);
        addStores();
    }

    public Store getStore(String name){
        int size = getSize();
        for (int i = 0; i < size; i++) {
            if (storeList.getData(i).isValidateName(name)){
                return storeList.getData(i);
            }
        }
        return null;
    }

    public void addStore(Store store){
        storeList.insert(store);
    }


    public ArrayList<Object[]> getMatrixData(String name) {
        int size = getSize();
        for (int i = 0; i < size; i++) {
            if (storeList.getData(i).isValidateName(name)){
              return storeList.getData(i).getMatrixData();
            }
        }
        return null;
    }

    public Store createStore(String name,String address){
        return new Store(name,address);
    }

    public boolean isValidateStore(String name){
        int size = getSize();
        for (int i = 0; i < size; i++) {
            if (name.equals(storeList.getData(i).getNameStore())){
                return true;
            }
        }
        return false;
    }

    public double getTotalInventaryStores(){
        double total = 0;
        int size = getSize();
        for (int i = 0; i < size; i++) {
            total += storeList.getData(i).getTotalInventary();
        }
        return total;
    }

    public int getSize(){
        return storeList.size();
    }


    public ArrayList<Object[]> getMatrizStore(){
        ArrayList<Object[]> auxDatasArrayList = new ArrayList<>();
        int size = getSize();
        for (int i = 0; i < size; i++) {
            auxDatasArrayList.add(storeList.getData(i).toObjectVectorStore());
        }
        return auxDatasArrayList;
    }

    public void addStores(){
        Store store = new Store("Hola","Carrera df");
        store.addProduct(new Product("Ok","Pollo",20,2000));
        store.addProduct(new Product("Ok3","Carne",10,1000));
        store.addProduct(new Product("Ok2","Pescado",5,5000));
        addStore(store);
        addStore(new Store("Qhubo","Carrera df"));
        addStore(new Store("Qsedice","Carrera df"));
        addStore(new Store("JIjI","Carrera df"));
        addStore(new Store("KK","Carrera df"));
    }

}
