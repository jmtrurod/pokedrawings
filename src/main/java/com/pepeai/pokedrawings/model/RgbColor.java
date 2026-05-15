package com.pepeai.pokedrawings.model;

public class RgbColor {
    private final int red;
    private final int green;
    private final int blue;

    public RgbColor(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RgbColor rgbColor = (RgbColor) o;
        return red == rgbColor.red &&
               green == rgbColor.green &&
               blue == rgbColor.blue;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(red, green, blue);
    }

    @Override
    public String toString() {
        return "RgbColor{" +
               "red=" + red +
               ", green=" + green +
               ", blue=" + blue +
               '}';
    }
}
