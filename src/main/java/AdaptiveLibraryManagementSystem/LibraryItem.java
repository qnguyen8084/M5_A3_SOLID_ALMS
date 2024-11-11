/*
 * Quy Nguyen
 * Dhruv Shah
 * CS635
 * Adaptive Library Management System
 * LibraryItem.java
 * Sun, Sep 29 2024
 */

package AdaptiveLibraryManagementSystem;

// Abstract class representing a library item.
// It contains common attributes and methods for different types of items such as books and magazines.
public abstract class LibraryItem {
    private final String title; // Title of the library item (book, magazine, etc.)
    private final String itemType; // Type of the item (e.g., book, magazine)
    protected static final String BOOK = "book"; // Constant for the item type "book"
    protected static final String MAGAZINE = "magazine"; // Constant for the item type "magazine"

    private boolean available = true; // Availability status of the item (true = available, false = unavailable)

    // Constructor for a library item with the item type and title. Default availability is true.
    public LibraryItem(String itemType, String title) {
        this.itemType = itemType;
        this.title = title;
    }

    // Constructor for a library item with the item type, title, and availability status.
    public LibraryItem(String itemType, String title, boolean isAvailable) {
        this.itemType = itemType;
        this.title = title;
        this.available = isAvailable;
    }

    // Getter for the title of the library item.
    public String getTitle() {
        return title;
    }

    // Getter to check if the item is available.
    public boolean isAvailable() {
        return available;
    }

    // Setter to update the availability of the item.
    public void setAvailable(boolean isAvailable) {
        this.available = isAvailable;
    }
}

// Interface defining common behaviors for items in the library.
interface LibraryItemInterface {
    int getId(); // Method to get the ID of the library item.
    String getCreator(); // Method to get the creator (e.g., author for books, journalist for magazines) of the item.
}

// Class representing a book in the library.
class Book extends LibraryItem implements LibraryItemInterface {
    private int bookId; // ID of the book
    private final String author; // Author of the book

    // Constructor for a book with title and author. The book is available by default.
    public Book(String title, String author) {
        super(BOOK, title);
        this.author = author;
    }

    // Constructor for a book with ID, title, author, and availability status.
    public Book(int bookId, String title, String author, boolean isAvailable) {
        super(BOOK, title, isAvailable);
        this.bookId = bookId;
        this.author = author;
    }

    // Implementation of the getId() method from the LibraryItemInterface.
    @Override
    public int getId() {
        return bookId;
    }

    // Implementation of the getCreator() method from the LibraryItemInterface.
    @Override
    public String getCreator() {
        return author;
    }
}

// Class representing a magazine in the library.
class Magazine extends LibraryItem implements LibraryItemInterface {
    private int magazineId; // ID of the magazine
    private final String journalist; // Journalist associated with the magazine

    // Constructor for a magazine with title and journalist. The magazine is available by default.
    public Magazine(String title, String journalist) {
        super(MAGAZINE, title);
        this.journalist = journalist;
    }

    // Constructor for a magazine with ID, title, journalist, and availability status.
    public Magazine(int magazineId, String title, String journalist, boolean isAvailable) {
        super(MAGAZINE, title, isAvailable);
        this.magazineId = magazineId;
        this.journalist = journalist;
    }

    // Implementation of the getId() method from the LibraryItemInterface.
    @Override
    public int getId() {
        return magazineId;
    }

    // Implementation of the getCreator() method from the LibraryItemInterface.
    @Override
    public String getCreator() {
        return journalist;
    }
}