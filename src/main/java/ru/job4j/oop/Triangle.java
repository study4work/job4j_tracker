package ru.job4j.oop;

import static java.lang.Math.sqrt;

public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }

    public double period(double a, double b, double c) {
        double rsl = (a+b+c)/2;
        return rsl;
    }


    public boolean exist(double ab, double ac, double bc) {
        boolean rsl = false;
        return ab + ac > bc && ab + bc > ac && bc + ac > ab;

    }

    public double area() {
        double rsl = -1;
        double ab = first.distance(second);
        double ac = first.distance(third);
        double bc = second.distance(third);
        double p = period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            rsl = sqrt(p*(p - ab)*(p - bc)*(p - ac));
        }
        return rsl;
    }
}