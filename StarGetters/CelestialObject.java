// Instructions

// Now, we will update the accessibility of the properties.

// In order to still have access to them, we need to implement getters and
// setters for each property:

// getX and setX for the x property
// getY and setY for the y property
// getZ and setZ for the z property
// getName and setName for the name property

// Usage
// Here is a possible ExerciseRunner.java to test your function :

// public class ExerciseRunner {

//     public static void main(String[] args) {
//         CelestialObject defaultStar = new CelestialObject();
//         System.out.println(defaultStar.getX());
//         System.out.println(defaultStar.getY());
//         System.out.println(defaultStar.getZ());
//         System.out.println(defaultStar.getName());

//         defaultStar.setName("Terre");
//         defaultStar.setX(0.43);
//         defaultStar.setY(0.98);
//         defaultStar.setZ(1.43);
//         System.out.println(defaultStar.getX());
//         System.out.println(defaultStar.getY());
//         System.out.println(defaultStar.getZ());
//         System.out.println(defaultStar.getName());
//     }
// }
// and its output :

// $ javac *.java -d build
// $ java -cp build ExerciseRunner
// 0.0
// 0.0
// 0.0
// Soleil
// 0.43
// 0.98
// 1.43
// Terre
// $

public class CelestialObject {
    private double x;
    private double y;
    private double z;
    private String name;

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