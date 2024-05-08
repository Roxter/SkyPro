public class Main {

    public static void main(String[] args) {
        // Task 1
        System.out.println("ЗАДАЧА 1:");
        Author author_1 = new Author("Mark", "Tven");
        Book book_1 = new Book("Tom Soyer Adventures", author_1, 1876);
        Author author_2 = new Author("William", "Shakespeare");
        Book book_2 = new Book("Sonet", author_2, 1619);
        book_2.setYear(1609);
        System.out.println();
    }
}
