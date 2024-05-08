package store;

import idx.AutoIncrement;

import java.util.ArrayList;

public abstract class DataStore<T> {

    private final ArrayList<T> dataStore;
    private final AutoIncrement autoIncrement;

    public DataStore() {
        this.dataStore = new ArrayList<>();
        this.autoIncrement = new AutoIncrement();
    }

    public ArrayList<T> getDataStore() {
        return dataStore;
    }

    public AutoIncrement getAutoIncrement() {
        return autoIncrement;
    }

    public abstract void addData(T data);

    public abstract void inquiryData();

}
