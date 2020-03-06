package OOP;

public class Dog {
    private String name, owner;
    private int age;

    @Override
    public String toString(){
        return String.format("The dog's name: %s, owners name: %s, age: %d", this.name, this.owner, this.age);
    }

    public Dog( String name, String owner, int age){
        this.name = name; this.owner = owner; this.age = age;
    }

    public static void main(String[] args) {
        Dog dog = new Dog( "Barker", "John Parker", 4);

        System.out.println(dog/*Enélkül is működik; a fordító megkeresi az alapértelmezett,
        Stringet visszaadó fn-t: .toString() */);

    }
}
