public class Main {

    public static void main(String[] args) {
        // Task 1
        System.out.println("ЗАДАЧА 1:");
        String firstName = "Ivan";
        String middleName = "Ivanovich";
        String lastName = "Ivanov";
        String fullName = firstName + " " + middleName + " " + lastName;
        System.out.println(fullName);
        System.out.println();

        // Task 2
        System.out.println("ЗАДАЧА 2:");
        String upperFullName = fullName.toUpperCase();
        System.out.println("Данные Ф. И. О. сотрудника для заполнения отчета — " + upperFullName);
        System.out.println();

        // Task 3
        System.out.println("ЗАДАЧА 3:");
        fullName = "Иванов Семён Семёнович";
        String changedFullName = fullName.replace("ё", "е");
        System.out.println(changedFullName);
        System.out.println();
    }
}
