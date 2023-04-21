package ru.geekbrains;

/**
    Создать классы Собака и Кот с наследованием от класса Животное.
    Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
    Результатом выполнения действия будет печать в консоль. (Например, dog1.run(150); -> 'Бобик пробежал 150 м.');
    У каждого животного есть ограничения на действия
    (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
    Добавить подсчет созданных котов, собак и животных.
*/

public class Sample01 {
    public static void main(String[] args) {

        Cat cat1 = new Cat("Персик", 10);
        Dog dog1 = new Dog("Шарик", 20, 30);
        Animal animal1 = new Animal("Лапы и хвост", 30, 20);
        Animal animal2 = new Animal("Лапы и хвост 2", 5, 15);

        System.out.printf("Общее кол-во котов: %d\n", Cat.getCounter());
        System.out.printf("Общее кол-во собак: %d\n", Dog.getCounter());
        System.out.printf("Общее кол-во животных: %d\n", Animal.getCounter());



    }
}

class Animal {

    protected String name;
    private int maxRun;
    private int maxSwim;

    private static int counter;


    public static int getCounter(){
        return counter;
    }

    {
        counter++;
    }

    public Animal() {

    }

    public Animal(String name) {
        this.name = name;
    }

    public Animal(String name, int maxRun, int maxSwim) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxSwim = maxSwim;

    }

    public void run(int distance){
        if (distance <= maxRun){
            System.out.printf("%s пробежал %d метров\n", name, distance);
        }
        else {
            System.out.printf("%s не смог пробежать %d метров\n", name, distance);
        }
    }

    public void swim(int distance){
        if (distance <= maxRun){
            System.out.printf("%s проплыл %d метров\n", name, distance);
        }
        else {
            System.out.printf("%s не смог проплыть %d метров\n", name, distance);
        }
    }

}

class Dog extends Animal{

    static int counter;

    public static int getCounter(){
        return counter;
    }

    {
        counter++;
    }

    public Dog(String name, int maxRun, int maxSwim) {
        super(name, maxRun, maxSwim);
    }
}

class Cat extends Animal{

    static int counter;

    public static int getCounter(){
        return counter;
    }

    {
        counter++;
    }

    public Cat(String name, int maxRun) {
        super(name, maxRun, 0);
    }


    @Override
    public void swim(int distance) {
        System.out.printf("Кот не умеет плавать.\n", name);
    }
}