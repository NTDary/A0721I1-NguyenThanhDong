package ss6_ke_thua.bai_tap.point2d_point3d;

public class Point2D {
    private float x = 0.0f;
    private float y = 0.0f;

    public Point2D() {

    }

    public Point2D(float x, float y) {
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
        return "(" + this.x + "," + this.y + ")";
    }
}
