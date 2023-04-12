package _patterns.creational

/**
 * Lazy initialization is a design pattern in which an object is only created or initialized when it is actually needed,
 * rather than being created or initialized during the object's instantiation or during the application's startup.
 * This pattern can help improve performance and reduce resource usage, as objects are only created or initialized when
 *  they are actually required, and not unnecessarily in advance.
 * */

/**
 *
public class DatabaseHelper {
    private SQLiteDatabase database;

    public SQLiteDatabase getDatabase() {
        // Lazy initialization of database instance
        if (database == null) {
            // Perform expensive database initialization
            System.out.println("Initializing database...");
            database = SQLiteDatabase.openDatabase("my_database.db", null, SQLiteDatabase.CREATE_IF_NECESSARY);
         }
        return database;
    }

    public void performDatabaseOperation() {
        // Use the database object
        System.out.println("Performing database operation...");
        // ...
    }

}

public class Main {
    public static void main(String[] args) {
        DatabaseHelper dbHelper = new DatabaseHelper();

        // Database is not initialized yet
        System.out.println("Performing some other operations...");

        // Database is initialized only when needed
        dbHelper.performDatabaseOperation();
    }
}

 *
 *
 * */