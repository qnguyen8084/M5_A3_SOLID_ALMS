package AdaptiveLibraryManagementSystem;

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