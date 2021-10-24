package ss6_ke_thua.bai_tap.point_moveablepoint;

public class MoveablePoint extends Point {
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    public MoveablePoint() {

    }

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        float[] temp = {xSpeed, ySpeed};
        return temp;
    }

    public MoveablePoint move() {
        float x = getX();
        float y = getY();
        x += xSpeed; // ? :
        y += ySpeed;
        setX(x);
        setY(y);
//        setX(getX() + this.xSpeed);
//        setY(getY() + this.ySpeed);
        System.out.println("đây là this: " + this); // obj hiện tại
        return this; //?
    }

    @Override
    public String toString() {
        return super.toString()
                + ","
                + "speed= "
                + "(" + xSpeed + "," + ySpeed + ")";
    }
}
