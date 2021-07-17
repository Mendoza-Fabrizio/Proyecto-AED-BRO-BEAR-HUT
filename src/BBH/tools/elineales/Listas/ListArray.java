package BBH.tools.elineales.Listas;

public class ListArray<T> implements TDAList<T>{
    private T[] list;
    private int count;

    @SuppressWarnings("unchecked")
	public ListArray(int n){
        this.count = 0;
        this.list = (T[]) new Object[n];
    }

    public boolean isFull() {
        return (this.count == this.list.length);
    }

    @Override
    public boolean isEmptyList() {
        return (this.count == 0);
    }

    @Override
    public int length() {
        return this.count;
    }

    @Override
    public void destroyList() {
        this.count = 0;
    }

    @Override
    public int search(T x) {
        for (int i = 0; i < this.length(); i++){
            if (this.list[i].equals(x)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int search(String x) { return 0; }

    @Override
    public void insertLast(T x) {
        if (this.isFull())
            System.out.println("List is Full");
        else
            this.list[this.count++] = x;
    }

    @Override
    public void insertFirst(T x) {
        if(this.isFull())
            System.out.println("List is Full");
        else{
            for (int i = this.length()-1; i >= 0; i--){
                this.list[i+1] = this.list[i];
            }
            this.list[0] = x;
            this.count++;
        }
    }

    @Override
    public void remove(T x) {
        int pos = this.search(x);
        if ( pos != 1 ){
            for (int i = pos; i < this.length(); i++)
                this.list[i] = this.list[i+1];
            this.count--;
        } else {
            System.out.println("Item not found");
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < this.length(); i++)
            str.append("[").append(i).append("]").append("\t").append(this.list[i]).append("\n");
        return str.toString();
    }
}
