package OOP;

abstract class Animal {
    protected String animClass;
    protected String species;

    public String getAnimClass() {
        return this.animClass;
    }

    public String getSpecies() {
        return this.species;
    }

    public Animal(String animClass, String species) {
        this.animClass = animClass;
        this.species = species;
    }
}

abstract class Vertebrate extends Animal {
    public Vertebrate(String animClass, String species) {
        super(animClass, species);
    }
    //public Vertebrate(){ super("gerinces","");}
}

class Mammal extends Vertebrate {
    public Mammal(String species) {
        super("emlős",species);
    }
}

class Bird extends Vertebrate {
    public Bird(String species) {
        super("madár",species);
     }
}

class Fish extends Vertebrate {
    public Fish(String species) {
        super("hal",species);
     }
}

public class Animals {
    public static void main(String[] args) {
        Animal[] animals = new Animal[3];
        animals[0] = new Mammal("kutya");
        animals[1] = new Bird("kanári");
        animals[2] = new Fish("harcsa");
        for (Animal a : animals) {
            System.out.println(" A " + a.getSpecies() + " egy " + a.getAnimClass());
            if (a instanceof Mammal) {
                System.out.println(a.getSpecies() + " is a mammal");
            }
            if (a instanceof Bird) {
                System.out.println(a.getSpecies() + " is a bird");
            }
            if (a instanceof Fish) {
                System.out.println(a.getSpecies() + " is a fish");
            }
        }
    }
}
