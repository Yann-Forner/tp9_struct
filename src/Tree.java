public interface Tree<T> {
    boolean isEmpty();
    T root();
    Tree<T> leftSubTree();
    Tree<T> rightSubTree();
}
