package com.samadhi.ih.fw.cacher;



public class SingleStoreResultManager<V> extends StoreResult {

    private volatile V value;

    private volatile StoreResultCode storeResultCode;

    public V getData() { return value;}

}
