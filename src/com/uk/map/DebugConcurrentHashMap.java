package com.uk.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DebugConcurrentHashMap {
    static void main() {
        Map<String, Integer> chm = new ConcurrentHashMap<>();
        /*
         * What happens behind the scenes when hashmap is declared and instantiated ?
         * Similar to hashmap, it prepares an array of buckets (hash table or Node<K,V>[] table) with a default initial capacity of 16 (lazy Initialization, the allocation of the 16-bucket array happens the very FIRST put() call).
         * However, a crucial control variable(private transient volatile int sizeCtl) is introduced.
         * sizeCtl controls initialization and resizing and can have below states:
         * 1) 0: Default state
         * 2)-1: The table is actively being initialized by a thread
         * 3)-(1 + number_of_threads): The table is actively being resized
         * 4)>0: The threshold to trigger the next resize (capacity * 0.75)
         *
         *
         * Why no null keys or values ?
         * ConcurrentHashMap explicitly FORBIDS null keys and null values.
         * get(key) returns null, in a concurrent environment, you cannot distinguish whether the key is completely absent, or if the key is present but its value is null.
         * A standard HashMap solves this with `containsKey()`, but in a multithreaded map, the state could change between `containsKey()` and `get()`. Thus, nulls are banned.
         * */

        chm.put("Core 1", 100);
        /*
        * When put(.,.) is called the thread enters initTable(). It uses CAS(compare and swap) to set sizeCtl to -1.
        * If another thread tries to put simultaneously, it sees sizeCtl == -1 and yields(Thread.yeild()) instead of blocking, avoiding expensive context switches.
        *
        * Calculate hash
        * int h = key.hashCode();
        * int hash = (h ^ (h >>> 16)) & HASH_BITS;
        * (HASH_BITS is 0x7fffffff, which forces the hash to always be positive. Negative hashes are reserved for special internal nodes like ForwardingNodes).
        *
        * INSERTING INTO AN EMPTY BUCKET: index = hash & (16 - 1) = 5.
        * The thread checks if table[5] is null. Since it is, it DOES NOT ACQUIRE A LOCK. Instead, it uses a lock-free CAS operation (via VarHandle/Unsafe):
        *
        * boolean success = U.compareAndSetObject(table, offset_of_index_5, null, newNode);
          If success is true, the node is inserted. If false (another thread beat it), it loops back (spins) and tries again.
        *
        *  +----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+
           | 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  | 10 | 11 | 12 | 13 | 14 | 15 |
           +----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+
        *                                  |
-                                  +----------------+
-                                  | volatile val   | -> 100
-                                  | volatile next  | -> null
-                                  +----------------+
        *
        *
        * Handling collision
        */
        chm.put("Core Collision", 200);
        /*
        * If "Core Collision" also hashes to index 5. The thread looks at table[5] and sees it is NOT null (it holds "Core 1").
        * Now, it MUST synchronize. But it DOES NOT lock the whole map or a segment. It locks ONLY the specific Node object at the head of the bucket.
        *
        * Node<K,V> f = tableAt(table, 5);
        synchronized (f) {
            if (tableAt(table, 5) == f) {
                // traverse linked list and append or replace
            }
       }
         By using `synchronized(headNode)`, Java 8+ achieves phenomenal concurrency.
         If Thread A writes to bucket 5, and Thread B writes to bucket 12, they operate 100% in parallel with zero contention.
       */
        Integer val = chm.get("Core 1");
        /*
        * Inside the `Node<K,V>` class, the val and next pointers are declared volatile:
        *
        * static class Node<K,V> implements Map.Entry<K,V> {
            final int hash;
            final K key;
            volatile V val;             // Guarantees visibility of updates
            volatile Node<K,V> next;    // Guarantees visibility of structural changes
          }
        */
    }
}
