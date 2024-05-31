/*Задание 1:
Создать классы Собака и Кот с наследованием от класса Животное.

Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия. Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');

У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).

Добавить подсчет созданных котов, собак и животных.

Расширить задачу, добавив для котов возможность кушать из миски, выполнив следующие пункты:

+ Сделать так, чтобы в миске с едой не могло получиться отрицательного количества еды
(например, в миске 10 еды, а кот пытается покушать 15-20).

Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
Если коту удалось покушать (хватило еды), сытость = true.

Считаем, что если коту мало еды в миске, то он её просто не трогает,
то есть не может быть наполовину сыт (это сделано для упрощения логики программы).

Создать массив котов и миску с едой, попросить всех котов покушать из этой
миски и потом вывести информацию о сытости котов в консоль.

Добавить метод, с помощью которого можно было бы добавлять еду в миску.*/
public class Animal {
    int run;
    int swim;
    public Animal (int run, int swim) {
        this.run = run;
        this.swim = swim;
    }
    public void animalRun() {
        System.out.println("Животное может бегать" + run + "метров.");
    }
    public void animalSwim() {
        System.out.println("Животное может плавать" + swim + "метров.");
    }

    public static void main(String[] args) {
        Dog dogZhuchka = new Dog("Zhychka", 150, 11 );
        dogZhuchka.active();
        System.out.println("Колличество созданных собак: " + Dog.getDogCount());
        Cat catSliva = new Cat("Sliva", 50, 5 );
        catSliva.active();
        System.out.println("Колличество созданных котов: " + Cat.getCatCount());
        System.out.println("Колличество созданных животных: " + (Dog.getDogCount() + Cat.getCatCount()));


        boolean charge = catSliva.catFood(15, 5);
        System.out.println(charge);

        Cat cats[] = new Cat[2];
        cats[0] = new Cat("Vaska", 100, 2);
        cats[1] = new Cat("Rizhik", 250, 2);

        int bowls = 15;
        int catEat = 10;

        for (int i = 0; i < cats.length; i++ ) {
            System.out.println("Кот " + cats[i].getName() + " ест");

            if (cats[i].catFood(bowls,catEat)) {
                bowls -= catEat;
                System.out.println("В Миске осталось " + bowls + " еды");
                System.out.println("Кот сыт");
            } else {
                System.out.println("Надо добавить еды");
                bowls = cats[i].addFood(bowls, 5);
                System.out.println("Добавлено 5 еды");

                if (cats[i].catFood(bowls,catEat)) {
                    bowls -= catEat;
                    System.out.println("В Миске осталось " + bowls + " еды");
                    System.out.println("Кот сыт");
                } else {
            System.out.println("Кот " + cats[i].getName() + " голодный");
        }
            }
    }
}
}
class Dog extends Animal {
    private String name;
    private static int dogCount = 0;
    public Dog(String name, int run, int swim) {
        super(run, swim);
        this.name = name;
        dogCount++;
    }
    public static int getDogCount() {
        return dogCount;
    }
    public void active() {
        if (run < 500 && run > 0) {
            System.out.println("Собака " + name + " пробежала " + run + " метров.");
        } else {
            System.out.println("Собака отдыхает");
        }
        if (swim < 10 && swim > 0) {
            System.out.println("Собака " + name + " проплыла " + swim + " метров.");
        } else {
            System.out.println("Собака сидит на суше");
        }
    }
}
class Cat extends Animal {
    private String name;
    private static int catCount = 0;
    private int food;
    private int eat;

    public Cat(String name, int run, int swim) {
        super(run, swim);
        this.name = name;
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }
    public void active() {
        if (run < 200 && run > 0) {
            System.out.println("Кот " + name + " пробежала " + run + " метров.");
        } else {
            System.out.println("Кот отдыхает");
        }
        if (swim != 0) {
            System.out.println("Кот " + name + " не умеет плавать.");
        } else {
            System.out.println("Кот сидит на месте.");
        }
    }
    public boolean catFood(int food, int eat) {
        if (food >= eat) {
            return true;
        } else {
            System.out. println("В миску надо добавить " + (eat - food) + " еды.");
            return false;
        }
    }
    public String getName() {
        return name;
    }
    public int addFood(int currentFood, int bonusFood) {
        currentFood += bonusFood;
        return currentFood;
        }
    }
