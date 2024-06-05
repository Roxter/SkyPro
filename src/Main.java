public class Main {

    public static void main(String[] args) {
        Person person = new Person();
        person.name = "Lyapis";
        person.surname = "Trubetskoy";
        changePerson(person);
        System.out.println(person.toString());
    }

    private static void changePerson(Person person) {
        person = new Person();
        person.name = "Ilya";
        person.surname = "Lagutenko";
    }
}
