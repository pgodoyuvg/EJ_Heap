import java.util.ArrayList;

public class Heap {
    private ArrayList<Integer> heap;

    public Heap() {
        heap = new ArrayList<>();
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private void siftUp(int i) {
        while (i > 0 && heap.get(parent(i)) > heap.get(i)) {
            swap(parent(i), i);
            i = parent(i);
        }
    }

    private void siftDown(int i) {
        int minIndex = i;
        int l = leftChild(i);
        if (l < heap.size() && heap.get(l) < heap.get(minIndex)) {
            minIndex = l;
        }
        int r = rightChild(i);
        if (r < heap.size() && heap.get(r) < heap.get(minIndex)) {
            minIndex = r;
        }
        if (i != minIndex) {
            swap(i, minIndex);
            siftDown(minIndex);
        }
    }

    public void insert(int priority, T value) {
        //heap.add(value);
        var branchRoute = route(priority, value);
        var newNode = insert(root, branchRoute, priority, value);
        //int i = heap.size() - 1;
        siftUp(newNode);
        //siftDown(0);
    }

    private String route(int priority, T value) {
        var size = heap.size(); // 9
        var position = size + 1; // 10
        var binary = position.toBinaryString(); // 1010
        var branchRoute = binary.substring(1); // 010

        return branchRoute;
    }

    private Node<T> insert(Node<T> root, string branchRoute, int priority, T value) {
        var nextNode = branchRoute[0]; // 0 - 1 - 0
        if (branchRoute.length > 0) {
            var node = nextNode == '0' ? root.getLeft() : root.getRight();
            return insert(node, branchRoute.substring(1), priority, value);
        }

        heap.setSize(heap.getSize() + 1);
        var newNode = new Node<T>(priority, value, root);
        // prioridad, valor, nodo actual para asignar el padre 
        if (nextNode == '0') {    
            node.setLeft(newNode);
            return newNode;
        } 

        node.setRight(newNode);
        return newNode;
    }

    public boolean isHeapInvariant() {
        for (int i = 0; i < heap.size(); i++) {
            int left = leftChild(i);
            int right = rightChild(i);
            if (left < heap.size() && heap.get(left) < heap.get(i)) {
                return false;
            }
            if (right < heap.size() && heap.get(right) < heap.get(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isOrderInvariant() {
        for (int i = 1; i < heap.size(); i++) {
            if (heap.get(i) < heap.get(parent(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return heap.toString();
    }
}
