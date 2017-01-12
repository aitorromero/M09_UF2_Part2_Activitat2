package M09_UF2_Part2_Activitat2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Ellipse2D;

public class Ball extends Ellipse2D.Double {

    private double dx;
    private double dy;
    private double speed = 1;
    private Color color;

    public Ball() {
    }

    public Ball(double x, double y, double diameter) {
        super(x, y, diameter, diameter);
    }

    public Ball(double x, double y, double diameter, double dx, double dy) {
        super(x, y, diameter, diameter);
        this.dx = dx;
        this.dy = dy;
    }

    public Ball(double x, double y, double diameter, double speed,
            double angleInDegree, Color color) {
        super(x, y, diameter, diameter);

        this.speed = speed;
        this.dx = Math.cos(Math.toRadians(angleInDegree));
        this.dy = Math.sin(Math.toRadians(angleInDegree));
        this.color = color;
    }

    public double getDiameter() {
        return this.width;
    }

    public void setDiameter(double radius) {
        this.width = radius;
        this.height = radius;
    }

    public void setDirectionAngle(double angleInDegree) {
        this.dx = Math.cos(Math.toRadians(angleInDegree));
        this.dy = Math.sin(Math.toRadians(angleInDegree));
    }

    public double getDirectionAngle() {
        return Math.toDegrees(Math.atan2(-dy, dx));
    }

    /**
     * @retorna dx
     */
    public double getDx() {
        return dx;
    }

    /**
     * set de dx
     */
    public void setDx(double dx) {
        this.dx = dx;
    }

    /**
     * @retorna dy
     */
    public double getDy() {
        return dy;
    }

    /**
     * set dy
     */
    public void setDy(double dy) {
        this.dy = dy;
    }

    /**
     * @retorna speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * set speed
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    /**
     * @retorna color
     */
    public Color getColor() {
        return color;
    }

    /**
     * set color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    public void move(Dimension worldDimension) {
        x += dx * speed;
        y += dy * speed;

        if (getX() < 0) {
            dx = -dx;
            x = 0;
        } else if (getX() + getDiameter() > worldDimension.getWidth()) {
            dx = -dx;
            x = worldDimension.getWidth() - getDiameter();
        }
// control de limits
        if (getY() < 0) {
            dy = -dy;
            y = 0;
        } else if (getY() + getDiameter() > worldDimension.getHeight()) {
            dy = -dy;
            y = worldDimension.getHeight() - getDiameter();
        }
    }
}
