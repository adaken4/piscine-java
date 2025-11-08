// Instructions

// Now, let's add some useful methods to our class.

// First, toString method which returns a literal version of our class. The format is the following : <name> is positioned at (<x>, <y>, <z>). The printed double will have a precision of 3 decimals.

// Then, equals(Object object) method which will return true if all properties of the object in parameter are equal to the current object.

// As we have overriden equals method, we need to override hashCode method. This method returns an integer. If two objects are equal (using the equals method), then the results of their hashCode method should be equal.

// Usage
// Here is a possible ExerciseRunner.java to test your function :

// public class ExerciseRunner {

//     public static void main(String[] args) {
//         CelestialObject celestialObject = new CelestialObject();
//         CelestialObject earth = new CelestialObject("Terre", 1.0, 2.0, 2.0);
//         CelestialObject earth1 = new CelestialObject("Terre", 1.0, 2.0, 2.0);

//         System.out.println(earth.toString());
//         System.out.println(earth.equals(earth1));
//         System.out.println(earth.equals(celestialObject));

//         System.out.println(earth.hashCode());
//         System.out.println(celestialObject.hashCode());
//     }
// }
// and its output :

// $ javac *.java -d build
// $ java -cp build ExerciseRunner
// Terre is positioned at (1.000, 2.000, 2.000)
// true
// false
// 2129490293
// -1811995559
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
