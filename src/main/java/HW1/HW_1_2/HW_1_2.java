package HW1.HW_1_2;

public class HW_1_2 {
        /*
        Описание ошибок:
        1. Не объявлен класс Engine
        2. Класс Lorry наследуется от абстрактного класса, при этом не реализует методы абстрактного класса
        2. Класс Lorry использует Интерфейсы, но их подключение следует делать ключевым словом implement
        3. В классе LightWeightCar аннотация @Override перед методом move () избыточна, так как это
            реализация метода интефейса Moveable
        4. Класс Старт является protected, при более правильном подходе написания кода и разнесении Классов и интерфейсов
            в самостоятельные файлы может возникнуть проблема с доступом к этому классу

            все исправления помечены комментарием
         */
        interface Moveable {
            void move();
        }
        interface Stopable {
            void stop();
        }

        abstract class Car {
            public Engine engine;
            private String color;
            private String name;

            protected void start() {
                System.out.println("Car starting");
            }
            abstract void open();

            public Engine getEngine() {
                return engine;
            }
            public void setEngine(Engine engine) {
                this.engine = engine;
            }
            public String getColor() {
                return color;
            }
            public void setColor(String color) {
                this.color = color;
            }
            public String getName() {
                return name;
            }
            public void setName(String name) {
                this.name = name;
            }
        }
        class LightWeightCar extends Car implements Moveable {
            @Override
            void open() {
                System.out.println("Car is open");
            }
            // исправления todo
            public void move() {
                System.out.println("Car is moving");
            }
        }
            //исправления todo
        class Lorry extends Car implements Moveable, Stopable {
            public void move(){
                System.out.println("Car is moving");
            }
            public void stop(){
                System.out.println("Car is stop");
            }

            //исправления todo
            @Override
            void open() {
                System.out.println("Car Lorry is open");
            }
        }
        //исправления todo
        public class Engine {
        }

}
