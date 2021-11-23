package catsbi.me.datastructure.hashtable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ChainingHashTableTest {
    private Map<String, String> dataMap;
    private String[] values;

    @BeforeEach
    void setUp() {
        dataMap = new HashMap<>();
        dataMap.put("DaveLee", "01011112222");
        dataMap.put("fun-coding", "01022223333");
        dataMap.put("David", "01033334444");
        dataMap.put("Dave", "01044445555");

        values = new String[]{"test1", "test2", "test3", "test4", "test5"};
    }

    @DisplayName("유효한 키와 값을 저장 및 검색할 수 있다. ")
    @Test
    void putAndGetWithValidData() {
        final ChainingHashTable<String, String> table = new ChainingHashTable<>();
        for (Map.Entry<String, String> entry : dataMap.entrySet()) {
            table.put(entry.getKey(), entry.getValue());
        }

        for (String key : dataMap.keySet()) {
            assertThat(table.get(key)).isEqualTo(dataMap.get(key));
        }
    }

    @DisplayName("동일한 키에 값을 저장하면 덮어쓰기가 된다.")
    @Test
    void putOverwriteWithDuplicateKey() {
        final String key = "key";
        final ChainingHashTable<String, String> table = new ChainingHashTable<>();

        for (String value : values) {
            table.put(key, value);
        }

        assertThat(table.get(key)).isEqualTo(values[values.length - 1]);
    }


}
