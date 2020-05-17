//package by.mishota.multithreading;
//
////public class Animal {
////    private String name;
////
////    public Animal(String name) {
////        this.name = name;
////    }
////
////    public String getName() {
////        return name;
////    }
////}
//
////class AnimalDB {
////    void getAnimal(int id) {
////    }
////
////    Animal saveAnimal(Animal animal) {
////    }
////}
//
////class Animals {
////    Animal[] animals = {new Animal("Lion"), new Animal("Mouse")};
////
////    public void animalSound(Animal[] animalSound) {
////        for (int i = 0; i < animalSound.length; i++) {
////            String sound;
////            switch (animalSound[i].toString()) {
////                case "Lion":
////                    sound= "roar";
////                case "Mouse":
////                    sound= "squeak";
////                default:
////                    sound= "";
////            }
////        }
////    }
////}
//
//interface Animal {
//    String makeSound();
//    int countPaws();
//}
//
//class Lion implements Animal {
//    @Override
//    public String makeSound() {
//        return "roar";
//    }
//
//    @Override
//    public int countPaws() {
//        return 4;
//    }
//}
//
//class Mouse implements Animal {
//    @Override
//    public String makeSound() {
//        return "squeak";
//    }
//
//    @Override
//    public int countPaws() {
//        return 4;
//    }
//}
//
//class Snake implements Animal {
//    @Override
//    public String makeSound() {
//        return "hiss";
//    }
//
//    @Override
//    public int countPaws() {
//        return 0;
//    }
//}
//
//class Animals {
//    Animal[] animals = {new Lion(), new Mouse(), new Snake()};
//
//    public void animalsSound(Animal[] animalsSound) {
//        for (int i = 0; i < animalsSound.length; i++) {
//            String sound = animalsSound[i].makeSound();
//        }
//    }
//}
//
////interface Shape{
////    void drawCircle();
////    void drawSquare();
////    void drawRectangle();
////    void drawTriangle();
////}
////
////class Circle implements Shape{
////    @Override
////    public void drawCircle() {/*drawing a circle*/}
////    @Override
////    public void drawSquare() {}
////    @Override
////    public void drawRectangle() {}
////    @Override
////    public void drawTriangle() {}
////}
////class Square implements Shape{
////    @Override
////    public void drawCircle() {}
////    @Override
////    public void drawSquare() { /*drawing a square*/}
////    @Override
////    public void drawRectangle() {}
////    @Override
////    public void drawTriangle() {}
////}
////class Rectangle implements Shape{
////    @Override
////    public void drawCircle() {}
////    @Override
////    public void drawSquare() {}
////    @Override
////    public void drawRectangle() {/*drawing a rectangle*/}
////    @Override
////    public void drawTriangle() {}
////}
////class Triangle implements Shape{
////    @Override
////    public void drawCircle() {}
////    @Override
////    public void drawSquare() {}
////    @Override
////    public void drawRectangle() {}
////    @Override
////    public void drawTriangle() {/*drawing a triangle*/}
////}
//
//interface Shape{
//    void draw();
//}
//interface Circle{
//    void drawCircle();
//}
//interface Square{
//    void drawSquare();
//}
//interface Rectangle{
//    void drawRectangle();
//}
//interface Triangle{
//    void drawTriangle();
//}
//
//class CircleImpl implements Circle{
//    @Override
//    public void drawCircle() {}
//}
//class SquareImpl implements Square{
//    @Override
//    public void drawSquare() {}
//}
//
//class Zoo{
//    private Animal[] animals;
//
//    public Zoo(Animal[] animals) {
//        this.animals = animals;
//    }
//}
//
