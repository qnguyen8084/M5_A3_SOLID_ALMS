package AdaptiveLibraryManagementSystem;

public interface Transactions<T> {
    void add(T obj);
    void remove(int id);
    void search(String searchTerm);
    void list();
}

interface Addable<T> {
    void add(T obj);
}

interface Removable {
    void remove(int id);
}

interface Searchable {
    void search(String searchTerm);
}

interface Listable {
    void list();
}