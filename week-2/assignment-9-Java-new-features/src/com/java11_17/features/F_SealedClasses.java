package com.java11_17.features;

//https://rollbar.com/blog/what-are-sealed-classes-in-java/

sealed class  Animal permits Dog, Cat{
    void sound(){
        System.out.println();
    }
}
non-sealed class Dog extends Animal{
    @Override
    void sound() {
        super.sound();
        System.out.println("dog is barking in a sealed place ");
    }
}
 class CostlyDog extends Dog{
    @Override
    void sound(){
        super.sound();
        System.out.println("this extends the dog class");
    }
}
final class Cat extends Animal{
void sound(){
    super.sound();
    System.out.println("cat is meowing finnaly ");
}
}
class Human{
public void sound(){
    System.out.println("the human is talking nonsense and cannot inherit the sound of Animal");
}
}
public class F_SealedClasses {
    public static void main(String[] args) {
    Animal a1 = new Dog();
    a1.sound();
        Animal a2 = new Cat();
        a2.sound();
        Human h = new Human();
        h.sound();

    }
}
