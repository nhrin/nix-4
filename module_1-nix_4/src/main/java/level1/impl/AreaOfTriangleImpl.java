package level1.impl;

import level1.AreaOfTriangle;

/**
 formula for calculating the area of a triangle

 S = √p(p−a)(p−b)(p−c);

 p = (a+b+c)/2;

 where a, b, c - side length of a triangle

 */

public class AreaOfTriangleImpl implements AreaOfTriangle {

    @Override
    public double areaOfTriangle (double ax, double ay, double bx, double by, double cx, double cy) {


        double ab = Math.sqrt(Math.pow(ax - bx, 2) + Math.pow(ay - by, 2));
        double bc = Math.sqrt(Math.pow(bx - bx, 2) + Math.pow(by - cy, 2));
        double ac = Math.sqrt(Math.pow(ax - cx, 2) + Math.pow(ay - cy, 2));

        double p = (ab + bc + ac) / 2;

       // System.out.println("AB = " + ab);
       // System.out.println("BC = " + bc);
       // System.out.println("AC = " + ac);

        return Math.sqrt(p * (p - ab) * (p - bc) * (p - ac));

    }
}
