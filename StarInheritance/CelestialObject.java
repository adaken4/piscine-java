// Instructions

// Create a new class Star in a file named Star.java.

// This class inherits from CelestialObject. We add a private double property magnitude, with public getter and setter.

// Usage
// Here is a possible ExerciseRunner.java to test your function :

// public class ExerciseRunner {

//     public static void main(String[] args) {
//         Star star = new Star();
        
//         System.out.println(star.getName());
//         System.out.println(star.getX());
//         System.out.println(star.getY());
//         System.out.println(star.getZ());
//         System.out.println(star.getMagnitude());
//     }
// }
// and its output :

// $ javac *.java -d build
// $ java -cp build ExerciseRunner 
// Soleil
// 0.0
// 0.0
// 0.0
// 0.0
// $ 

public class CelestialObject {
    private double x;
    private double y;
    private double z;
    private String name;

    public static final double KM_IN_ONE_AU = 150_000_000;

    public static double getDistanceBetween(CelestialObject obj1, CelestialObject obj2) {
        double deltaX = obj2.getX() - obj1.getX();
        double deltaY = obj2.getY() - obj1.getY();
        double deltaZ = obj2.getZ() - obj1.getZ();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);
    }

    public static double getDistanceBetweenInKm(CelestialObject obj1, CelestialObject obj2) {
        return getDistanceBetween(obj1, obj2) * KM_IN_ONE_AU;
    }

    public String toString() {
        return String.format("%s is positioned at (%.3f, %.3f, %.3f)", name, x, y, z);
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CelestialObject that = (CelestialObject) object;
        return Double.compare(that.x, x) == 0 &&
               Double.compare(that.y, y) == 0 &&
               Double.compare(that.z, z) == 0 &&
               (name != null ? name.equals(that.name) : that.name == null);
    }

    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(z);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public CelestialObject() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
        this.name = "Soleil";
    }

    public CelestialObject(String name, double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
