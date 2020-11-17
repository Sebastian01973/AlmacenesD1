package structures;

import models.Store;

import java.util.Comparator;

public class ComparatorStore implements Comparator<Store> {
    @Override
    public int compare(Store o1, Store o2) {
        return (o1.getAddress().equals(o2.getAddress())) ? 0:-1;
    }
}
