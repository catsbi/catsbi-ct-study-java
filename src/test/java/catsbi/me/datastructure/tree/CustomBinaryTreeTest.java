package catsbi.me.datastructure.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CustomBinaryTreeTest {
    private List<Integer> integers;
    
    @BeforeEach
    void setUp() {
        integers = Arrays.asList(10, 15, 13, 11, 14, 18, 16, 19, 17, 7, 8, 6);
    }
    
    @Test
    void test() {
        final CustomBinaryTree<Integer> tree = new CustomBinaryTree<>();
        for (Integer integer : integers) {
            tree.insert(integer);
        }

        assertThat(tree.head.value).isEqualTo(10);
        assertThat(tree.head.left.value).isEqualTo(7);
        assertThat(tree.head.left.left.value).isEqualTo(6);
        assertThat(tree.head.left.right.value).isEqualTo(8);

        assertThat(tree.head.right.value).isEqualTo(15);
        assertThat(tree.head.right.left.value).isEqualTo(13);
        assertThat(tree.head.right.right.value).isEqualTo(18);

        assertThat(tree.head.right.right.left.value).isEqualTo(16);
        assertThat(tree.head.right.right.right.value).isEqualTo(19);
    }

}
