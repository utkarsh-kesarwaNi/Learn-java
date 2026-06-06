package com.uk.hashmap;

import java.util.HashMap;
import java.util.Map;

public class DebugHashMap {
    static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        /*
        What happens behind when map is declared and instantiated ?
        It will create an array of buckets(hash table) with default initial capacity of 16
        The default load factor is 0.75 which means, when 75% of capacity is occupied, then the capacity gets doubled
        With 12 elements, the capacity is 12 but with 13 elements the capacity becomes 32

        Also both get and put provide constant time performance
        * +----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+
        * | 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  | 10 | 11 | 12 | 13 | 14 | 15 |
        * +----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+
        Each bucket here is a node/LinkedList
        */

        map.put("First prime number", 2);
        /*
         * Whenever we start adding elements to hashmap, it will perform following operations
         * 1. Calculate hashcode of key, so here it will be hash("First prime number") which is 683617178.
         *    Hashcode will help us to store the key at a specific index in that array of node
         *    It will also help us in retrieval.
         * 2. What index ?
         *    index = hash(key) & (n-1)
         *    index = 683617178 & (16-1) = 10
         * So our key and value will be stored in a node with index 10
         * 3. Each node is a Linked List, and this node contains 4 things
         * +-----------------------------+
         * |          Node<K, V>         |
         * +-----------------------------+
         * | int hash : 683617178        |
         * | K key : "First prime number"|
         * | V value : 2                 |
         * | Node next : null            |
         * +-----------------------------+
         */

        map.put("Second prime number", 3);
        /*
         * Works the same way as above
         * hash("Second prime number") = 1020314646
         * index = hash(key) & (n-1) = 1020314646 & 15 = 6
         * So this will be stored in a node with index 6.
         * +-----------------------------+
         * |          Node<K, V>         |
         * +-----------------------------+
         * | int hash : 683617178        |
         * | K key : "First prime number"|
         * | V value : 2                 |
         * | Node next : null            |
         * +-----------------------------+
         *
         * What if hashcode is same for 2 keys and then the index value is same also?
         * Then at the same index we will have another linked list/node created, where the next pointer of first node
         * will have address of second node
         *
         * hash("Second prime number") and hash("TFcond prime number") are same
         */
        map.put("TFcond prime number", 3);

        /*
         * HashMap can have null keys, where it will be saved in this case ?
         * It will be stored in a bucket/node with index 0.
         */
        map.put(null, 2);

        /*
         * What happens when we try to add same key to the map ?
         * key = "abc", value = 1
         * key = "abc", value = 2
         *
         * In the same node, the value is overwritten to the latest
         *
         * map will only have key = "abc" and value = 2
         */

        Integer firstPrimeNumber = map.get("First prime number");
        Integer secondPrimeNumber = map.get("Second prime number");
        Integer tfcondPrimeNumber = map.get("TFcond prime number");
        System.out.println(firstPrimeNumber + "\t" + secondPrimeNumber+ "\t" + tfcondPrimeNumber);
        /*
         * Whenever we start adding elements to hashmap, it will perform following operations
         * 1. Calculate hashcode of key, so here it will be hash("First prime number") which is 683617178.
         *    Hashcode will help us to store the key at a specific index in that array of node
         *    It will also help us in retrieval.
         * 2. What index ?
         *    index = hash(key) & (n-1)
         *    index = 683617178 & (16-1) = 10
         * So our key and value will be fetched from a node with index 10
         */

    }
}
