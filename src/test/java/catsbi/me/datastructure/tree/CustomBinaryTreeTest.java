package catsbi.me.datastructure.tree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * 테스트에 사용하는 데이터 트리 구조는 다음과 같다.
 *
 *          10
 *        /   \
 *      /      \
 *    7        15
 *   / \      /  \
 * 6    8   13   18
 *              /  \
 *            16    19
 *              \
 *              17
 */
class CustomBinaryTreeTest {
    private static List<Integer> integers = Arrays.asList(10, 15, 13, 11, 14, 18, 16, 19, 17, 7, 8, 6);

    @DisplayName("하나의 노드가 2개의 branch를 갖는 이진 트리를 만든다. ")
    @ParameterizedTest
    @MethodSource("provideFilledBinaryTree")
    void insertIntegerBinaryTreeWithValidData(CustomBinaryTree<Integer> tree) {

        assertThat(tree.head.value).isEqualTo(10);
        assertThat(tree.head.left.value).isEqualTo(7);
        assertThat(tree.head.left.left.value).isEqualTo(6);
        assertThat(tree.head.left.right.value).isEqualTo(8);

        assertThat(tree.head.right.value).isEqualTo(15);
        assertThat(tree.head.right.left.value).isEqualTo(13);
        assertThat(tree.head.right.right.value).isEqualTo(18);

        assertThat(tree.head.right.right.left.value).isEqualTo(16);
        assertThat(tree.head.right.right.left.right.value).isEqualTo(17);
        assertThat(tree.head.right.right.right.value).isEqualTo(19);
    }

    @DisplayName("중복된 값을 입력하면 값은 입력되지 않고 false를 반환한다.")
    @Test
    void insertIntegerWithDuplicateData() {
        final CustomBinaryTree<Integer> tree = new CustomBinaryTree<>();

        assertThat(tree.insert(10)).isTrue();
        assertThat(tree.insert(10)).isFalse();
    }

    @ParameterizedTest
    @MethodSource("provideFilledBinaryTree")
    void searchNodeWithExistsData(CustomBinaryTree<Integer> tree) {
        final Node<Integer> findNode = tree.search(15).orElseThrow(NoSuchElementException::new);
        assertThat(findNode.value).isEqualTo(15);
        assertThat(findNode.left.value).isEqualTo(13);
        assertThat(findNode.right.value).isEqualTo(18);
    }

    @ParameterizedTest
    @MethodSource("provideFilledBinaryTree")
    void searchNodeWithNotExistsData(CustomBinaryTree<Integer> tree) {
        assertThat(tree.search(99)).isNotPresent();
    }

    @ParameterizedTest
    @MethodSource("provideFilledBinaryTree")
    void deleteNodeWithExistsData(CustomBinaryTree<Integer> tree) {
        tree.delete(15);

        assertThat(tree.head.right.right.value).isEqualTo(18);

    }

    public static Stream<Arguments> provideFilledBinaryTree() {
        final CustomBinaryTree<Integer> tree = new CustomBinaryTree<>();
        for (Integer integer : integers) {
            tree.insert(integer);
        }
        return Stream.of(Arguments.of(tree));
    }
}
