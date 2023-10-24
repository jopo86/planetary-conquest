package com.jopo.utils;

import com.badlogic.gdx.scenes.scene2d.Group;

public class MathUtils {

    private MathUtils() {}

    public static abstract class Shape {
        protected float x;
        protected float y;

        public void setX(float x) {
            this.x = x;
        }

        public void setY(float y) {
            this.y = y;
        }

        public void setPosition(float x, float y) {
            this.x = x;
            this.y = y;
        }

        public float getX() {
            return x;
        }

        public float getY() {
            return y;
        }
    }
    public static class Point extends Shape {

        public Point(float x, float y) {
            this.x = x;
            this.y = y;
        }
    }
    public static class Rectangle extends Shape {
        private float width;
        private float height;
        private float perimeter;
        private Point center;

        public Rectangle(float x, float y, float width, float height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            center = new Point(0f, 0f);
            updateCenter();
            updatePerimeter();
        }

        public float getWidth() {
            return width;
        }

        public float getHeight() {
            return height;
        }

        public float getPerimeter() {
            return perimeter;
        }

        public Point getCenter() {
            return center;
        }

        @Override
        public void setX(float x) {
            super.setX(x);
            updateCenter();
        }

        @Override
        public void setY(float y) {
            super.setY(y);
            updateCenter();
        }

        @Override
        public void setPosition(float x, float y) {
            super.setPosition(x, y);
            updateCenter();
        }

        public void setWidth(float width) {
            this.width = width;
            updatePerimeter();
            updateCenter();
        }

        public void setHeight(float height) {
            this.height = height;
            updatePerimeter();
            updateCenter();
        }

        private void updateCenter() {
            center.setPosition(x + width / 2, y + height / 2);
        }

        private void updatePerimeter() {
            perimeter = 2 * (width + height);
        }
    }
    public static class Circle extends Shape {
        private float radius;
        private float diameter;
        private float area;
        private float circumference;
        private Point center;

        public Circle(float x, float y, float radius) {
            this.x = x;
            this.y = y;
            this.radius = radius;
            center = new Point(0f, 0f);
            updateCenter();
            updateDiameter();
            updateArea();
            updateCircumference();
        }

        public float getRadius() {
            return radius;
        }

        public float getDiameter() {
            return diameter;
        }

        public float getArea() {
            return area;
        }

        public float getCircumference() {
            return circumference;
        }

        public Point getCenter() {
            return center;
        }

        @Override
        public void setX(float x) {
            super.setX(x);
            updateCenter();
        }

        @Override
        public void setY(float y) {
            super.setY(y);
            updateCenter();
        }

        @Override
        public void setPosition(float x, float y) {
            super.setPosition(x, y);
            updateCenter();
        }

        public void setRadius(float radius) {
            this.radius = radius;
            updateDiameter();
            updateCenter();
            updateArea();
            updateCircumference();
        }

        private void updateDiameter() {
            diameter = 2 * radius;
        }

        private void updateCenter() {
            center.setPosition(x + radius, y + radius);
        }

        private void updateArea() {
            area = (float)(Math.PI * (double)(radius * radius));
        }

        private void updateCircumference() {
            circumference = (float)(2.0 * Math.PI * (double)radius);
        }
    }

    public static float distance(Point a, Point b) {
        return (float)Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2));
    }
    public static float distance(Point pt, float x, float y) {
        return (float)Math.sqrt(Math.pow(x - pt.x, 2) + Math.pow(y - pt.y, 2));
    }
    public static float distance(float x1, float y1, float x2, float y2) {
        return (float)Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static boolean hit(Point pt, Rectangle rect) {
        return pt.x >= rect.x && pt.x <= rect.x + rect.width && pt.y >= rect.y && pt.y <= rect.y + rect.height;
    }
    public static boolean hit(Point pt, Circle circ) {
        return distance(pt, circ.center) <= circ.radius;
    }
    public static boolean hit(Rectangle rect1, Rectangle rect2) {
        return rect1.x + rect1.width >= rect2.x && rect1.x <= rect2.x + rect2.width && rect1.y + rect1.height >= rect2.y && rect1.y <= rect2.y + rect2.height;
    }
    public static boolean hit(Circle circ1, Circle circ2) {
        return distance(circ1.center, circ2.center) <= circ1.radius + circ2.radius;
    }
    public static boolean hit(Rectangle rect, Circle circ) {
        float testX = circ.center.x;
        float testY = circ.center.y;

        if (circ.center.x < rect.x) testX = rect.x;
        else if (circ.center.x > rect.x + rect.width) testX = rect.x + rect.width;

        if (circ.center.y < rect.y) testY = rect.y;
        else if (circ.center.y > rect.y + rect.height) testY = rect.y + rect.height;

        return (distance(circ.center, testX, testY) <= circ.radius);
    }

    public static int randInt(int start, int end) {
        return (int)(start + Math.random() * (end - start));
    }
    public static float randFloat(float start, float end) {
        return (float)(start + Math.random() * (end - start));
    }

    public static float degToRad(float deg) {
        return (float)(Math.PI / 180 * deg);
    }
    public static float radToDeg(float rad) {
        return (float)(180 / Math.PI * rad);
    }

    public static int clamp(int val, int min, int max) {
        return (val < min ? min : (Math.min(val, max)));
    }
    public static float clamp(float val, float min, float max) {
        return (val < min ? min : (Math.min(val, max)));
    }

    public static Point applyGroupTransform(Point pt, Group group) {
        return new Point(group.getX() + group.getScaleX() * pt.x, group.getY() + group.getScaleY() * pt.y);
    }
    public static Rectangle applyGroupTransform(Rectangle rect, Group group) {
        return new Rectangle(
                group.getX() + group.getScaleX() * rect.x,
                group.getY() + group.getScaleY() * rect.y,
                group.getScaleX() * rect.width,
                group.getScaleY() * rect.height
        );
    }
    public static Circle applyGroupTransform(Circle circ, Group group) {
        return new Circle(
                group.getX() + group.getScaleX() * circ.x,
                group.getY() + group.getScaleY() * circ.y,
                group.getScaleX() * circ.radius
        );
    }
}
