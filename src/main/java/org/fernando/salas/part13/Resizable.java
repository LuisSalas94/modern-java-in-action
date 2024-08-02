package org.fernando.salas.part13;

public interface Resizable extends Drawable {
    int getWidth();

    int getHeight();

    void setWidth(int width);

    void setHeight(int height);

    void setAbsoluteSize(int width, int height);

    //void setRelativeSize(int wFactor, int hFac);

}
