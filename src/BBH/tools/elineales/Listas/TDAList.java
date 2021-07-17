package BBH.tools.elineales.Listas;

public interface TDAList <T> {
	boolean isEmptyList();
	int length();
	void destroyList();
	int search(T x);
	int search(String x);
	void insertLast(T x);
	void insertFirst(T x);
	void remove(T x);
	String toString();
}
