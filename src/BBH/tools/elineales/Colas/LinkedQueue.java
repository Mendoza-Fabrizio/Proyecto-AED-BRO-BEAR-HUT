package BBH.tools.elineales.Colas;

public class LinkedQueue<E> implements Queue<E> {
    private Node<E> front;
    private Node<E> back;

    public LinkedQueue() {
        this.front = null;
        this.back = null;
    }

    @Override
    public void enqueue(E x) {
        Node<E> nuevo = new Node<E>(x);
        if (this.isEmpty()){
            this.front = nuevo;
        } else {
            this.back.setNext(nuevo);
        }
        this.back = nuevo;
    }

    @Override
    public E dequeue() throws ExceptionIsEmpty {
        if (this.isEmpty())
            throw new ExceptionIsEmpty("Cannot remove from an empty queue...");
        E aux = this.front.getData();
        this.front = this.front.getNext();
        if (this.front == null)
            this.back = null;
        return aux;
    }

    @Override
    public E front() throws ExceptionIsEmpty {
        return null;
    }

    @Override
    public E back() throws ExceptionIsEmpty {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return this.front == null;
    }
}
