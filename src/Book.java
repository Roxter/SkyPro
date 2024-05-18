public class Book {
    private String name;
    private Author author;
    private int year;

    Book(String name, Author author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author.toString() + '\'' +
                ", year='" + year + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Book b2 = (Book) obj;
        return name.equals(b2.name) &&
                author.getName().equals(b2.author.getName()) &&
                author.getSurname().equals(b2.author.getSurname()) &&
                year == b2.year;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name + author.getName() + author.getSurname() + year);
    }
}