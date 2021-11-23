package catsbi.me.datastructure.hashtable;

/**
 * Chaining 기법을 사용한 해시테이블
 *
 * @param <K> Key 타입 제네릭 매개변수
 * @param <V> Value 타입 제네릭 매개변수
 */
public class ChainingHashTable<K, V> {
    private static class Slot<K, V> {
        private final K key;
        private V value;
        private Slot<K, V> next;

        public Slot(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int DEFAULT_CAPACITY = 16;
    private Slot<K, V>[] hashTable;

    public ChainingHashTable() {
        this(DEFAULT_CAPACITY);
    }

    public ChainingHashTable(Integer capacity) {
        this.hashTable = new Slot[capacity];
    }

    private int hashFunc(K key) {
        final int hashCode = key.hashCode();
        return Math.abs(hashCode % this.hashTable.length);
    }

    public void put(K key, V value) {
        final int address = this.hashFunc(key);

        if (this.hashTable[address] != null) {
            Slot<K, V> findSlot = this.hashTable[address];
            Slot<K, V> prevSlot = this.hashTable[address];

            while (findSlot != null) {
                if (findSlot.key.equals(key)) {
                    findSlot.value = value;
                    return;
                } else {
                    prevSlot = findSlot;
                    findSlot = findSlot.next;
                }
            }

            prevSlot.next = new Slot<>(key, value);
            return;

        }

        this.hashTable[address] = new Slot<>(key, value);
    }

    public V get(K key) {
        final int address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            Slot<K, V> findSlot = this.hashTable[address];

            while (findSlot != null) {
                if (findSlot.key.equals(key)) {
                    return findSlot.value;
                } else {
                    findSlot = findSlot.next;
                }
            }
        }

        return null;
    }
}
