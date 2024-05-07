package store;

import java.util.ArrayList;

public abstract class DataStore<T> {

    private final ArrayList<T> dataStore;

    public DataStore() {
        dataStore = new ArrayList<>();
    }

    public ArrayList<T> getDataStore() {
        return dataStore;
    }

    public void addData(T data) {
        dataStore.add(data);
    }

    public abstract void inquiryData();

}
