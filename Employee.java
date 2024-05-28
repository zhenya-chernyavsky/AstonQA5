/*1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
Конструктор класса должен заполнять эти поля при создании объекта.
Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.*/
public class Employee {
    public static void main(String[] args) {
        Employee user = new Employee("Ivanov V.Y.", "teacher", "ivanteach@gmail.com",
                "445532424", 100000, 35);
        System.out.println("Задача 1");
        user.info();
        System.out.println("Задача 2");
        five();
        System.out.println("Задача 3");
        Park.TimeWork halicopter = new Park().new TimeWork("Spoon, ", "9:00 - 20:00, ", 100);
        Park.TimeWork halicopter1 = new Park().new TimeWork("Snake, ", "9:00 - 10:00, ", 500);
        halicopter.info();
        halicopter1.info();
    }
    private String name;
    private String position;
    private String email;
    private String telephone;
    private int salary;
    private int age;

    public Employee(String name, String position, String email, String telephone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.telephone = telephone;
        this.salary = salary;
        this.age = age;
    }

    public void info() {
        System.out.println("name:" + name + "; position:" + position + "; email:" + email +
                "; telephone:" + telephone + "; salary:" + salary + "; age:" + age);
    }

    /*2. Создать массив из 5 сотрудников.
    Пример:
    // вначале объявляем массив объектов
    Person[] persArray = new Person[5];
    // потом для каждой ячейки массива задаем объект
    persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
    persArray[1] = new Person(...);
    ...persArray[4] = new Person(...);*/
    public static void five() {
        Employee[] person = new Employee[5];
        person[0] = new Employee("Petia Petrov", "Teacher", "petia@gmail.com", "80291265312",
                25000, 25);
        person[1] = new Employee("Etia Etrov", "Master", "etia@gmail.com", "8029233312",
                30000, 30);
        person[2] = new Employee("Vetia Vetrov", "Doctor", "vetia@gmail.com", "80441264212",
                35000, 35);
        person[3] = new Employee("Dima Petrov", "Engineer", "petia@gmail.com", "80441263312",
                40000, 40);
        person[4] = new Employee("Yra Maximov", "Model", "yra@gmail.com", "80331265312",
                45000, 45);
        for (int i = 0; i < person.length; i++) {
            person[i].info();
        }
    }
}

    /*3. Создать класс Park с внутренним классом, с помощью объектов которого можно хранить информацию об
    аттракционах, времени их работы и стоимости.*/
    class Park {
        public class TimeWork{
        private String attraction;
        private String time;
        private int price;

        public TimeWork (String attraction, String time, int price) {
            this.attraction = attraction;
            this.time = time;
            this.price = price;
        }

        public void info() {
            System.out.println("Attraction: " + attraction + "time: " + time + "price: " + price);
        }
    }
}
