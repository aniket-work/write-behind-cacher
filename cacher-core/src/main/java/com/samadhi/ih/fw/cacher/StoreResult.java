package com.samadhi.ih.fw.cacher;

public class StoreResult {

    private volatile StoreResultCode storeResultCode;

    public boolean isSuccess(){
        return getStoreResultCode() == StoreResultCode.SUCCESS;
    }

    public StoreResultCode getStoreResultCode(){
        return storeResultCode;
    }

}
