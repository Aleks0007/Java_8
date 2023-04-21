package ru.geekbrains;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Sample02 {

    private static Random random = new Random();

    static Employee generateEmployee() {
        String[] names = new String[]{"Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман"};
        String[] surnames = new String[]{"Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов"};
    
        int salary = random.nextInt(200, 300);
        int index = random.nextInt(30, 50);
        int age = random.nextInt(18, 65);
    
        int employeeType = random.nextInt(2);
        if (employeeType == 0) {
            return new Worker(names[random.nextInt(10)], surnames[random.nextInt(10)], salary * index, age);
        } else {
            return new Freelancer(names[random.nextInt(10)], surnames[random.nextInt(10)], salary * index, age);
        }
    }
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        for (int i = 0; i < employees.length; i++)
            employees[i] = generateEmployee();

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        Arrays.sort(employees, new AgeComparator());

        System.out.printf("\n*** Отсортированный массив сотрудников ***\n\n");

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}

class AgeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}

abstract class Employee implements Comparable<Employee> {
    protected String name;
    protected String surName;
    protected double salary;
    protected int age;

    public Employee(String name, String surName, double salary, int age) {
        this.name = name;
        this.surName = surName;
        this.salary = salary;
        this.age = age;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return String.format("Сотрудник: %s %s; Возраст: %d; Среднемесячная заработная плата: %.2f", name, surName, age, salary);
    }

    @Override
    public int compareTo(Employee o) {
        return Double.compare(o.calculateSalary(), calculateSalary());
    }

    public int getAge() {
        return age;
    }
}

class Worker extends Employee {
    public Worker(String name, String surName, double salary, int age) {
        super(name, surName, salary, age);
    }

    @Override
    public double calculateSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s; Рабочий; Возраст: %d; Среднемесячная заработная плата (фиксированная месячная оплата): %.2f (руб.)", name, surName, age, salary);
    }
}

class Freelancer extends Employee {
    public Freelancer(String name, String surName, double salary, int age) {
        super(name, surName, salary, age);
    }

    @Override
    public double calculateSalary() {
        return 20 * 5 * salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s; Фрилансер; Возраст: %d; Среднемесячная заработная плата (процент от фиксированной месячной оплаты): %.2f (руб.)", name, surName, age, calculateSalary());
    }
}