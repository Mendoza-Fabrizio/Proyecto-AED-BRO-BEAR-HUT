package BBH.tools.elineales.Colas;

public class Node<E> {
    private E data;
    private Node<E> next;

    public Node(E data) {
        this (data, null);
    }

    public Node(E data, Node<E> next){
        this.data = data;
        this.next = next;
    }

    public Node() { }

    public E getData() {
        return this.data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getNext() {
        return this.next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    // Function to returns the information stores in the node
    // Post condition: returns info
    @Override
    public String toString() {
        return this.data.toString();
    }
}

