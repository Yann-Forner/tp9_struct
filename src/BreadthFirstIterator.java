import java.util.ArrayDeque;
import java.util.Iterator;

public class BreadthFirstIterator<T> implements Iterator {
    private ArrayDeque<BinNode<T>> file;

    public BreadthFirstIterator(BinNode<T> node) {
        file = new ArrayDeque<>();
        file.offer(node);
    }

    @Override
    public boolean hasNext() {
        return !file.isEmpty();
    }

    @Override
    public T next() {
        BinNode<T> temp = file.poll();

        if(temp.getLeftChild()!= null){
            file.offer(temp.getLeftChild());
        }
        if(temp.getRightChild()!=null){
            file.offer(temp.getRightChild());
        }
        
        return temp.getRoot();
    }
}
