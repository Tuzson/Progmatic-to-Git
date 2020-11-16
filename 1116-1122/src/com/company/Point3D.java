package com.company;

public class Point3D extends Point2D {
   private double z;

    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public void origoX2() {
       x = x*2;
        y = y*2;
        z = z*2;

    }

    @Override
    public String toString() {
        return "Point3D{" +
                "z=" + z +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
