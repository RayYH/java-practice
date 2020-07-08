package com.rayyounghong.core.generics;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ray
 */
public class CustomMap<K, V> {
    private final Map<K, V> map = new HashMap<>();

    public void addKeyValue(K key, V value) {
        map.put(key, value);
    }

    public V getValue(K key) {
        return map.get(key);
    }
}
