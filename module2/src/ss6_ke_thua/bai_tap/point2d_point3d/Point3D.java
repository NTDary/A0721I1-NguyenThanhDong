package ss6_ke_thua.bai_tap.point2d_point3d;

public class Point3D extends Point2D{
    private float z = 0.0f;

    public Point3D(){

    }
    public Point3D(float x, float y, float z){
        super(x,y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public void setXYZ(float x, float y, float z) {
       setXY(x,y);
       this.z = z;
    }
    public float[] getXYZ() {
        float[] temp = new float[3];
        temp[0] = getX();
        temp[1] = getY();
        temp[2] = getZ();
        return temp;
    }

    @Override
    public String toString() {
        return "("+getX()+","+getY()+","+getZ()+")";
    }
}
