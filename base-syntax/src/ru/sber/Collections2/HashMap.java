package ru.sber.Collections2;

import ru.sber.Collections1.*;

import java.util.Arrays;

public class HashMap implements Map {


    private LinkedList[] buckets;
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
    public boolean containsKey(Object key) {
        int bucketNumber = key.hashCode() % buckets.length;
        LinkedList linkedList = buckets[bucketNumber];
        if (linkedList != null) {
            for (Object pair: linkedList) {
                Entry entry = (Entry) pair;
                if (entry.key.equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (LinkedList linkedList: buckets) {
            if (linkedList != null) {
                for (Object val : linkedList) {
                    if (((Entry) val).value.equals(value)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    @Override
    public Object put(Object key, Object value) {
        int bucketNumber = key.hashCode() % buckets.length;
        LinkedList list = buckets[bucketNumber];
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                if (((Entry) list.get(i)).getKey().equals(key)) {
                    ((Entry) list.get(i)).setValue(value);
                    return new Entry(key, value);
                }

            }
        } else {
            list = new LinkedList();
        }
        list.addLast(new Entry(key, value));
        buckets[bucketNumber] = list;
        x++;
        return new Entry(key, value);
   }

    @Override
    public Object get(Object key) {
        int bucketNumber = key.hashCode() % buckets.length;
        LinkedList list = buckets[bucketNumber];
        for (int i = 0; i < list.size(); i++) {
            if (((Entry) list.get(i)).getKey().equals(key)) {
                return ((Entry) list.get(i)).getValue();
            }
        }
        return null;
    }


    @Override
    public Object remove(Object key) {
        int bucketNumber = key.hashCode() % buckets.length;
        LinkedList linkedList = buckets[bucketNumber];
        if (linkedList != null) {
            for (Object pair: linkedList) {
                Entry entry = (Entry) pair;
                if (entry.key.equals(key)) {
                    linkedList.remove(pair);
                    x--;
                    buckets[bucketNumber] = linkedList;
                    return entry.value;
                }
            }
        }
        return null;
    }

    @Override
    public Collection values() {
        Collection values = new LinkedList();
        for (LinkedList linkedList: buckets) {
            if (linkedList != null) {
                for (Object val : linkedList) {
                    values.add(((Entry) val).value);
                }
            }
        }
        return values;
    }

    @Override
    public Collection keySet() {
        ArrayList keys = new ArrayList();
        for (LinkedList list: buckets) {
            if (list != null) {
                for (Object k : list) {
                    keys.add(((Entry) k).key);
                }
            }
        }
        return keys;
    }

    @Override
    public Collection entrySet() {
        Collection entryS = new LinkedList();
        for (LinkedList linkedList: buckets) {
            if (linkedList != null) {
                for (Object entry : linkedList) {
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
