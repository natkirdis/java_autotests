package ru.stqa.pft.sandbox;

public class Rectangle {
  public double a;
  public double h;

  public Rectangle(double a, double h){
    this.a = a;
    this.h = h;
  }

  public double area(){
    return this.a * this.h;
  }
}
