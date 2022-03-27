package com.samadhi.ih.fw.cacher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * This is single most contract as how to define a cache or say store
 *
 * @param <K>
 * @param <V>
 */
public interface Store<K, V> extends AutoCloseable {

    Logger logger = LoggerFactory.getLogger(Store.class); //Note : we cant use lombok on interface as, lombok will make this logger as private which you cant do on interface


    /**
     * Design choice : if there is no entry and a storeFiller is in place, this method will attempt to fill cache
     *
     * @param key
     * @return
     */
    default Optional<V> get(K key) {
        var singleStoreResultManager = getStoreEntry(key);

        if (singleStoreResultManager.isSuccess()) {
            return Optional.of(singleStoreResultManager.getData());
        } else {
            return Optional.empty();
        }
    }

    SingleStoreResultManager<V> getStoreEntry(K key);  //Nothing but : CacheGetResult<V> GET(K key);

    MultiStoreResultManager<K, V> getStoreEntries(Set<? extends K> keys);  //Nothing but : MultiGetResult<K, V> GET_ALL(Set<? extends K> keys);

    default Map<K, V> getAll(Set<? extends K> keys) {
        var storeEntries = getStoreEntries(keys);
        return null;
    }

}
