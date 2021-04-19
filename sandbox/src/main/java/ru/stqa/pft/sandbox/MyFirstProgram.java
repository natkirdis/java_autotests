package ru.stqa.pft.sandbox;

public class MyFirstProgram {
  public static void main(String[] args) {
    int i = 5;
    int p = i + 33;
    System.out.println("Hello world!");

    Square s = new Square(5);
    System.out.println(s.area());

    Rectangle r = new Rectangle(5, 2);
    System.out.println(r.area());
  }
}