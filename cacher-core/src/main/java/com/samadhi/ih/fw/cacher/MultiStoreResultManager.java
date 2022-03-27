package com.samadhi.ih.fw.cacher;

import java.util.Map;

public class MultiStoreResultManager<K, V> extends StoreResult {

    private volatile Map<K, SingleStoreResultManager<V>> entries;


}
