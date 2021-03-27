package service;

import level1.impl.AreaOfTriangleImpl;

import java.util.Scanner;

public class AreaOfTriangleService {
    static Scanner scanner = new Scanner(System.in);

    static void run () {
        System.out.println("Enter coordinates of first point A:");
        System.out.print("x=");
        int aX = scanner.nextInt();
        System.out.print("y=");
        int aY = scanner.nextInt();
        System.out.println("Enter coordinates of second point B:");
        System.out.print("x=");
        int bX = scanner.nextInt();
        System.out.print("y=");
        int bY = scanner.nextInt();
        System.out.println("Enter coordinates of third point C:");
        System.out.print("x=");
        int cX = scanner.nextInt();
        System.out.print("y=");
        int cY = scanner.nextInt();

        AreaOfTriangleImpl areaOfTriangle = new AreaOfTriangleImpl();

        System.out.println("Area of your tringle = " + areaOfTriangle.areaOfTriangle(aX, aY, bX, bY, cX, cY));

        System.out.println("* if you can see \"NaN\" it means that it is impossible to make a triangle from your points or area too small");
        scanner.close();
    }
}
