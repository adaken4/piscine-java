// Instructions

// Let's add some computation.

// Our objective is to compute the distance between celestial objects. As you may have guessed, the values x, y and z are the coordinates of the object. Their unit is AU (Astronomical Unit) which is 150 000 000 km.

// We will add two static and public methods :

// getDistanceBetween which takes two CelestialObject as parameters and returns a double corresponding to the distance between the two objects.

// getDistanceBetweenInKm which takes two CelestialObject as parameters and returns a double corresponding to the distance in km between the two objects.

// We add a public constant double property, named KM_IN_ONE_AU with the value of 150 000 000.

// Usage
// Here is a possible ExerciseRunner.java to test your function :

// public class ExerciseRunner {

//     public static void main(String[] args) {
//         CelestialObject defaultStar = new CelestialObject();
//         CelestialObject earth = new CelestialObject("Terre", 1.0, 2.0, 2.0);

//         System.out.println(CelestialObject.getDistanceBetween(defaultStar, earth));
//         System.out.println(CelestialObject.getDistanceBetweenInKm(defaultStar, earth));
//         System.out.println(CelestialObject.KM_IN_ONE_AU);
//     }
// }
// and its output :

// $ javac *.java -d build
// $ java -cp build ExerciseRunner
// 3.0
// 4.5E8
// 1.5E8
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
