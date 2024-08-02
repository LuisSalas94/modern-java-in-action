package org.fernando.salas.part13;

public class Monster implements Rotatable, Moveable, Resizable {
    @Override
    public void draw() {

    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public void setX(int x) {

    }

    @Override
    public void setY(int y) {

    }

    @Override
    public void moveHorizontally(int distance) {
        Moveable.super.moveHorizontally(distance);
    }

    @Override
    public void moveVertically(int distance) {
        Moveable.super.moveVertically(distance);
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void setWidth(int width) {

    }

    @Override
    public void setHeight(int height) {

    }

    @Override
    public void setAbsoluteSize(int width, int height) {

    }

    @Override
    public void setRelativeSize(int wFactor, int hFactor) {
        Resizable.super.setRelativeSize(wFactor, hFactor);
    }

    @Override
    public void setRotationAngle(int angleInDegrees) {

    }

    @Override
    public int getRotationAngle() {
        return 0;
    }

    @Override
    public void rotateBY(int angleInDegrees) {
        Rotatable.super.rotateBY(angleInDegrees);
    }

    public static void main(String[] args) {
        Monster monster = new Monster();
        monster.rotateBY(180);
        monster.moveVertically(10);
    }
}
