public class Main {

    public static void main(String[] args) {
        // Task 1
        System.out.println("INIT DATA OF TASK 1...");
        Author author_1 = new Author("Mark", "Tven");
        Book book_1 = new Book("Tom Soyer Adventures", author_1, 1876);
        Author author_2 = new Author("Mark", "Tven");
        Book book_2 = new Book("Tom Soyer Adventures", author_2, 1876);
        Author author_3 = new Author("William", "Shakespeare");
        Book book_3 = new Book("Sonet", author_3, 1619);
        Author author_4 = new Author("William", "Shakespeare");
        Book book_4 = new Book("Sonet", author_4, 1619);

        // Check input data and methods of task 1
        System.out.println("INPUT DATA INITIALIZED. \nCHECK INPUT DATA AND METHODS OF TASK 1...");
        System.out.println("Book 1 description:\n\t" + book_1.toString());
        System.out.println("Book 2 description:\n\t" + book_2.toString());
        System.out.println("Book 3 description:\n\t" + book_3.toString());
        System.out.println("Book 4 description:\n\t" + book_4.toString());
        System.out.println("Book 2 equals Book 1:\n\t" + book_2.equals(book_1));
        book_2.setYear(1609);
        System.out.println("Book 2 description after change year:\n\t" + book_2.toString());
        System.out.println("Book 2 equals Book 1 after change year:\n\t" + book_2.equals(book_1));
        System.out.println("Book 2 equals Book 3:\n\t" + book_2.equals(book_3));
        System.out.println("Book 2 hashcode:\n\t" + book_2.hashCode());
        System.out.println("Author 1 equals Author 2:\n\t" + author_1.equals(author_2));
        System.out.println("Author 2 equals Author 3:\n\t" + author_2.equals(author_3));
        System.out.println();
    }

}
