package AdaptiveLibraryManagementSystem;

interface Addable<T> {
    void add(T obj);
}

interface Removable {
    void remove(int id);
}
interface Listable {
    void list();
}

interface Searchable {
    void search(String searchTerm);
}

