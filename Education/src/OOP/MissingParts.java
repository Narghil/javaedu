package OOP;

/* not public*/ class Person {
    private String firstName, lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void goToSchool() {
        System.out.println(firstName + " " + lastName + " " + " is in the school.");
    }

    public void goToWork() {
        System.out.println(firstName + " " + lastName + " " + " is working.");
    }

    public void doGardening() {
        System.out.println(firstName + " " + lastName + " " + " is gardening.");
    }
}

public class MissingParts {

    private static boolean memberInAge(int age, int low, int high) {
        return (age >= low && age <= high);
    }

    private static Person[] filterByAge(Person[] family, int ageLow, int ageHigh) {
        int filteredMembers = 0;
        int filteredIdx = 0;
        Person[] filteredFamily;

        for (int i = 0; i < family.length; i++) {
            if (memberInAge(family[i].getAge(), ageLow, ageHigh)) {
                filteredMembers++;
            }
        }
        filteredFamily = new Person[filteredMembers];
        if (filteredMembers > 0) {
            for (int i = 0; i < family.length; i++) {
                if (memberInAge(family[i].getAge(), ageLow, ageHigh)) {
                    filteredFamily[filteredIdx] = family[i];
                    filteredIdx++;
                }
            }
        }

        return filteredFamily;
    }

    public static void main(String[] args) {
        Person[] doeFamily = new Person[5];

        doeFamily[0] = new Person("John", "Doe", 32);
        doeFamily[1] = new Person("Jane", "Doe", 9);
        doeFamily[2] = new Person("Alice", "Doe", 29);
        doeFamily[3] = new Person("Roger", "Doe", 41);
        doeFamily[4] = new Person("Margaret", "Doe", 63);

        Person[] array1 = MissingParts.filterByAge(doeFamily, 18, 60);
        Person[] array2 = MissingParts.filterByAge(doeFamily, 60, 100);
        Person[] array3 = MissingParts.filterByAge(doeFamily, 6, 18);

        for (Person p : array1) {
            p.goToWork();
        }

        for (Person p : array2) {
            p.doGardening();
        }

        for (Person p : array3) {
            p.goToSchool();
        }
    }
}
