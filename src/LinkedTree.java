public class LinkedTree<T> implements Tree<T>,Iterable<T>{
    private BinNode<T> rootNode;
    public LinkedTree() {
        rootNode = null;
    }
    public LinkedTree(T root) {
        rootNode = new BinNode<T>(root);
    }
    public LinkedTree (BinNode<T> leftChild, T racine, BinNode<T> rightChild) {
        rootNode = new BinNode<T>(leftChild,racine,rightChild);
    }

    @Override
    public boolean isEmpty() {
        return rootNode.getRoot() == null;
    }

    @Override
    public T root() {
        return rootNode.getRoot();
    }

    @Override
    public Tree<T> leftSubTree() {
        if(this.isEmpty()){
            return null;
        }
        return new LinkedTree<T>(
                this.rootNode.getLeftChild().getLeftChild(),
                this.rootNode.getLeftChild().getRoot(),
                this.rootNode.getLeftChild().getRightChild()
        );
    }

    @Override
    public Tree<T> rightSubTree() {
        if(this.isEmpty()){
            return null;
        }
        return new LinkedTree<T>(
                this.rootNode.getRightChild().getLeftChild(),
                this.rootNode.getRightChild().getRoot(),
                this.rootNode.getRightChild().getRightChild()
        );
    }

    @Override
    public BreadthFirstIterator<T> iterator() {
        return new BreadthFirstIterator<T>(this.rootNode);
    }

    public void showElement(){
        BreadthFirstIterator<T> myIterator = this.iterator();

        while (myIterator.hasNext()){
            System.out.print(myIterator.next()+" ");
        }
    }

    public int length(){
        int size = 0;
        BreadthFirstIterator<T> myIterator = this.iterator();

        while (myIterator.hasNext()){
            ++size;
            myIterator.next();
        }
        return size;
    }

    public int numberOfLeaf(){
        BreadthFirstIterator<T> myIterator = this.iterator();
        int numberOfLeaf = 0;
        while (myIterator.hasNext()){
           myIterator.next();
           if(myIterator.isLeaf())++numberOfLeaf;
        }
        return numberOfLeaf;
    }
}
