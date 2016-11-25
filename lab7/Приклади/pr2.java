import java.util.*;

class CatsAndDogs {
  public static void main(String[] args) {
    List cats = new ArrayList();
    for(int i = 0; i < 7; i++)
      cats.add(new Cat(i));
    // Not a problem to add a dog to cats:
    cats.add(new Dog(7));
    for(int i = 0; i < cats.size(); i++)
      ((Cat)cats.get(i)).id();
      // Dog is detected only at run time 
  }
} 

 class Cat {
  private int catNumber;
  public Cat(int i) { catNumber = i; }
  public void id() {
    System.out.println("Cat #" + catNumber);
  }
} ///:~

//: c11:Dog.java
 class Dog {
  private int dogNumber;
  public Dog(int i) { dogNumber = i; }
  public void id() {
    System.out.println("Dog #" + dogNumber);
  }
} ///:~

//: c11:CatsAndDogs.java
// Simple container example.
// {ThrowsException}

