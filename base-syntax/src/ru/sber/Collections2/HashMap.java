package ru.sber.Collections2;

import ru.sber.Collections1.*;

import java.util.Arrays;

public class HashMap<K, V> implements Map<K, V> {

    private LinkedList<Entry<K, V>>[] buckets;
    int x;
    private int size;
   public HashMap() {
        x=0;
        size = (int) Math.pow(2,x);
        buckets = new LinkedList[size];
    }

    @Override
    public int size() {
        return x;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        else return false;
    }

    @Override
    public void clear() {
        x = 0;
        buckets = new LinkedList[size];
    }


    @Override
    public boolean containsKey(K key) {
        int bucketNumber = key.hashCode() % buckets.length;
        LinkedList<Entry<K, V>> linkedList = buckets[bucketNumber];
        if (linkedList != null) {
            for (Entry<K,V> pair: linkedList) {
                if (key.equals(pair.key)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        for (LinkedList<Entry<K,V>> linkedList: buckets) {
            if (linkedList != null) {
                for (Entry<K,V> val : linkedList) {
                    if (val.value.equals(value)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    @Override
    public Entry<K,V> put(K key, V value) {
        int bucketNumber = key.hashCode() % buckets.length;
        LinkedList<Entry<K, V>> list = buckets[bucketNumber];
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                if (((Entry<K,V>) list.get(i)).getKey().equals(key)) {
                    ((Entry<K,V>) list.get(i)).setValue(value);
                    return new Entry<>(key, value);
                }

            }
        } else {
            list = new LinkedList<Entry<K,V>>();
        }
        list.addLast(new Entry<>(key, value));
        buckets[bucketNumber] = list;
        x++;
        return new Entry<>(key, value);
   }

    @Override
    public V get(K key) {
        int bucketNumber = key.hashCode() % buckets.length;
        LinkedList<Entry<K, V>> list = buckets[bucketNumber];
        for (int i = 0; i < list.size(); i++) {
            if (((Entry<K,V>) list.get(i)).getKey().equals(key)) {
                return ((Entry<K,V>) list.get(i)).getValue();
            }
        }
        return null;
    }


    @Override
    public V remove(K key) {
        int bucketNumber = key.hashCode() % buckets.length;
        LinkedList<Entry<K, V>> linkedList = buckets[bucketNumber];
        if (linkedList != null) {
            for (Entry<K,V> pair: linkedList) {
                if (key.equals(pair.key)) {
                    linkedList.remove(pair);
                    x--;
                    buckets[bucketNumber] = linkedList;
                    return pair.value;
                }
            }
        }
        return null;
    }

    @Override
    public Collection<V> values() {
        Collection<V> values = new LinkedList<>();
        for (LinkedList<Entry<K,V>> linkedList: buckets) {
            if (linkedList != null) {
                for (Entry<K,V> val : linkedList) {
                    values.add(val.value);
                }
            }
        }
        return values;
    }

    @Override
    public Collection<K> keySet() {
        Collection<K> values = new LinkedList<>();
        for (LinkedList<Entry<K,V>> linkedList: buckets) {
            if (linkedList != null) {
                for (Entry<K,V> k : linkedList) {
                    values.add(k.key);
                }
            }
        }
        return values;
    }


    @Override
    public Collection<Entry<K,V>> entrySet() {
        Collection<Entry<K,V>> entryS = new LinkedList<>();
        for (LinkedList<Entry<K,V>> linkedList: buckets) {
            if (linkedList != null) {
                for (Entry<K,V> entry : linkedList) {
                    entryS.add(entry);
                }
            }
        }
        return entryS;
    }

    @Override
    public String toString() {
        return "Hashmap: " + Arrays.toString(buckets);
    }

}
