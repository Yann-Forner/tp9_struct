import java.util.ArrayDeque;
import java.util.Iterator;

public class BreadthFirstIterator<T> implements Iterator {
    private ArrayDeque<BinNode<T>> file;
    private boolean isLeaf = false;
    public BreadthFirstIterator(BinNode<T> node) {
        file = new ArrayDeque<>();
        file.offer(node);
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    @Override
    public boolean hasNext() {
        return !file.isEmpty();
    }

    @Override
    public T next() {
        BinNode<T> temp = file.poll();
        if(temp.getLeftChild() == null && temp.getRightChild() == null)isLeaf = true;
        else isLeaf = false;
        if(temp.getLeftChild()!= null){
            file.offer(temp.getLeftChild());
        }
        if(temp.getRightChild()!=null){
            file.offer(temp.getRightChild());
        }
        
        return temp.getRoot();
    }
}
