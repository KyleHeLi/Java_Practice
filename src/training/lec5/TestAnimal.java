package training.lec5;

import java.util.ArrayList;

public class TestAnimal {

    public static void main(String[] args) {
        Animal anAnimal = new Animal(4, true);
        anAnimal.sound();

        Cat aCat = new Cat();
        System.out.println(aCat.legs);
        System.out.println(aCat.color);
        System.out.println(aCat.hasTail);
        aCat.foo();
        aCat.sound();

        Dog aDog = new Dog(4, true, 5);
        System.out.println(aDog.smellRange);

        AbstractAnimal aCat2 = new Cat();
        AbstractAnimal aDog2 = new Dog(4, true, 2);

        Cat[] cats = new Cat[10];
        Dog[] dogs = new Dog[10];

        AbstractAnimal[] animals = new AbstractAnimal[20];
        animals[0] = aCat;
        animals[1] = aDog;
        System.out.println(anAnimal instanceof Animal);

        ArrayList<AbstractAnimal> animals2 = new ArrayList<AbstractAnimal>();
        animals2.add(aCat);
        animals2.add(aCat2);
        animals2.add(aDog);
        animals2.add(aDog2);

        System.out.println(aCat.color);
        System.out.println(((Cat) aCat2).color);
        System.out.println(((Dog) aDog2).smellRange);
        System.out.println(aCat2 instanceof Cat);
        System.out.println(aDog2 instanceof Dog);

        // anonymous instance
        AbstractAnimal animal = new AbstractAnimal(4, true) {
            @Override
            public void abstractMethod() {

            }
        };

        Movement m = new Movement() {
            @Override
            public void running() {

            }

            @Override
            public void jumping() {

            }
        };


        System.out.println(aCat2);
        System.out.println(aDog);


    }
}
