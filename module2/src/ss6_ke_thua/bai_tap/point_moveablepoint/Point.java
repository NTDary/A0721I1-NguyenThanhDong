package ss6_ke_thua.bai_tap.point_moveablepoint;

public class Point {
    private float x = 0.0f;
    private float y = 0.0f;

    public Point() {

    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float[] getXY() {
        float[] temp = new float[2];
        temp[0] = this.x;
        temp[1] = this.y;
        return temp;
    }

    @Override
    public String toString() {
        return "(" + getX()+ "," + getY() + ")";
    }
}
