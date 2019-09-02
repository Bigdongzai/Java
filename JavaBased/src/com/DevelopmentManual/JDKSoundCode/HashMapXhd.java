package com.DevelopmentManual.JDKSoundCode;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * 作者: xhd
 * 创建时间: 2019/8/30 13:44
 * 版本: V1.0
 */
public class HashMapXhd<K, V> implements Serializable {

    private static final long serialVersionUID = 362498820763181265L;
    //初始化位数
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    //最大位数
    static final int MAXIMUM_CAPACITY = 1 << 30;
    //构造函数没指定时的副因子
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    static class Node<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }
        //TODO toSting hashCode equals重写
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }


}
