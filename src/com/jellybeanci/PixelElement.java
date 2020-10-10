package com.jellybeanci;

public class PixelElement
{

    private double r;
    private double g;
    private double b;

    public PixelElement(double red, double green, double blue)
    {
        this.r = red;
        this.g = green;
        this.b = blue;
    }

    public double getBrightness()
    {
        return Math.sqrt(r * r * 0.241 + g * g * 0.691 + b * b * 0.068);
    }
}
