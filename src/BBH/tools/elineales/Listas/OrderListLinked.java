package BBH.tools.elineales.Listas;

public class OrderListLinked<T extends Comparable<T>> extends ListLinked<T>{
    private Node<T> first;
    private int count;

    public OrderListLinked() {
        this.first = null;
        this.count = 0;
    }

    @Override
    public boolean isEmptyList() {
        return this.first == null;
    }

    @Override
    public int length() {
        return this.count;
    }

    public void insertOrder(T x) {
        Node<T> head = this.first;
        Node<T> current = null;

        while(head != null && head.getData().compareTo(x)<0) {
            current = head;
            head = head.getNext();
        }
        Node<T> nuevo = new Node<T>(x);
        if (current == null) {
            nuevo.setNext(this.first);
            this.first = nuevo;
        }
        else {
            nuevo.setNext(head);
            current.setNext(nuevo);
        }
        count++;
    }

    public boolean searchN(T x) {
        Node<T> aux = this.first;
        while (aux != null && aux.getData().compareTo(x)<0)
            aux = aux.getNext();
        if (aux != null)
            return aux.getData().equals(x);
        return false;
    }

    public int searchOrder(T x) {
        Node<T> aux = this.first;
        for(int i=0; aux != null; aux = aux.getNext(), i++)
            if(aux.getData().equals(x)) {
                return i;
            }
        return -1;
    }

    public void removeOrder(T x) {
        int pos = this.searchOrder(x);
        Node<T> head = this.first;
        Node<T> current = null;

        if (pos != -1) {
            Node<T> atNode = getNodeAtOrder(pos);
            if (atNode == this.first) {
                current = this.first;
                this.first = this.first.getNext();
                current = null;
            } else {
                while(head.getNext() != atNode) {
                    head = head.getNext();
                }
                current = head.getNext();
                head.setNext(current.getNext());
                current = null;
            }
            this.count--;
        } else {
            System.out.println("Elemento no encontrado");
        }
    }

    private Node<T> getNodeAtOrder(int pos){
        Node<T> aux = this.first;
        int x = 0;
        while(aux != null) {
            if(x == pos) break;
            x++;
            aux = aux.getNext();
        }
        return aux;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Node<T> aux = this.first;
        for (int i=0; aux != null; aux = aux.getNext(), i++)
            str.append("[").append(i).append("]").append("\t").append(aux.getData()).append("\n");
        return str.toString();
    }


}
