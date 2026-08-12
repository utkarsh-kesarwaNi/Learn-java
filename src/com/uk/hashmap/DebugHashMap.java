package com.uk.hashmap;

import java.util.HashMap;
import java.util.Map;

public class DebugHashMap {
    static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        /*
         * What happens behind the scenes when map is declared and instantiated?
         * It prepares an array of buckets (hash table) with a default initial capacity of 16 (Lazy Initialization, the allocation of the 16-bucket array happens inside the very FIRST put() call).
         * The default load factor is 0.75, meaning when 75% of capacity is occupied, it resizes.
         * With 12 elements, capacity is 16; adding a 13th element doubles the capacity to 32.
         *
         * WHAT IF WE PASS A CUSTOM CAPACITY? e.g., new HashMap<>(20)
         * HashMap capacity MUST be a power of 2.
         * It uses a bit-shifting method called `tableSizeFor(int cap)` which finds the next power of 2 greater than or equal to the given number.
         * For 20, the array size will actually be 32.
         *
         * During a resize, elements don't have their indices completely recalculated.
         * Because the size doubles (powers of 2), a mathematical trick ensures an element at
         * index 'j' will either stay at index 'j' or move to 'j + oldCapacity' in the new array.
         *
         * Both get and put provide constant-time O(1) performance ideally.
         * +----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+
         * | 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  | 10 | 11 | 12 | 13 | 14 | 15 |
         * +----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+
         * Each bucket initially points to a Node (Linked List).
         */

        map.put("First prime number", 2);
        /*
         * Whenever we start adding elements, it performs the following operations:
         * 1. Calculate the hash using Java 8's bit-shifting spread function:
         * int h = key.hashCode();
         * int hash = h ^ (h >>> 16);
         * (This XORs the higher 16 bits with the lower 16 bits to prevent collisions
         * when capacity is small). Let's assume final hash = 683617178.
         * 2. What index?
         * index = hash(key) & (n-1)
         * index = 683617178 & (16-1) = 10
         * So our key and value will be stored in a node at index 10.
         * * 3. Each node is a Linked List, containing 4 things:
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
         * Works the same way as above.
         * Assume hash("Second prime number") = 1020314646
         * index = hash(key) & (n-1) = 1020314646 & 15 = 6
         * Stored in a node at index 6:
         * +------------------------------+
         * |          Node<K, V>          |
         * +------------------------------+
         * | int hash : 1020314646        |
         * | K key : "Second prime number"|
         * | V value : 3                  |
         * | Node next : null             |
         * +------------------------------+
         *
         * What if the index is the same for two keys? (A Collision)
         * A Linked List is formed. The first node's 'next' pointer links to the new node.
         * * [Java 8+, Treeification]:
         * If a single bucket's Linked List grows to 8 nodes (TREEIFY_THRESHOLD) and the
         * overall map capacity is at least 64, HashMap transforms this long Linked List
         * into a Red-Black Tree. This upgrades worst-case search time from O(n) to O(log n).
         */

        map.put("TFcond prime number", 3);

        /*
         * Null keys:
         * HashMap allows one null key. The internal hash function explicitly returns 0
         * if the key is null, meaning it will ALWAYS be stored in bucket index 0.
         */
        map.put(null, 2);

        /*
         * What happens when we try to add the EXACT same key to the map?
         * key = "abc", value = 1
         * key = "abc", value = 2
         *
         * The map doesn't just blindly trust the hashcode. It checks three things:
         * 1. Hash check (Do they have the same hash integer?)
         * 2. Memory check (Are they the exact same object in memory? `==`)
         * 3. Value check (Do they have the exact same logical value? `.equals()`)
         * * if (existing.hash == new.hash && (existing.key == new.key || existing.key.equals(new.key)))
         *
         * If this evaluates to true, the value in the node is overwritten.
         * The map will only have key = "abc" and value = 2.
         */

        Integer firstPrimeNumber = map.get("First prime number");
        Integer secondPrimeNumber = map.get("Second prime number");
        Integer tfcondPrimeNumber = map.get("TFcond prime number");
        System.out.println(firstPrimeNumber + "\t" + secondPrimeNumber + "\t" + tfcondPrimeNumber);

        /*
         * Retrieval operations (get):
         * 1. Calculate the shifted hash of the key exactly like in put().
         * 2. Calculate the index: hash & (n-1).
         * 3. Go to that index in the array.
         * 4. Traverse the Linked List (or Red-Black Tree) located there.
         * 5. Use the `==` and `.equals()` checks to find the exact matching key.
         * 6. Return the value.
         */
    }
}