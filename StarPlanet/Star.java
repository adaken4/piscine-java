// Instructions

// Create a new class Planet in a file named Planet.java.

// This class inherits CelestialObject.
// It has one private property : centerStar of type Star.

// There are two constructors :

// One with no parameters, which calls the superclass constructor with no parameters. In this case, the centerStar property is initialised with the default Star constructor.

// The other with many parameters :

// name

// x

// y

// z

// centerStar which calls the superclass constructor with full parameters.

// We add a getter and a setter for the centerStar property (getCenterStar and setCenterStar).

// We override the hashCode and equals, using the centerStar property.

// Finally, we override toString method. The returned String must have the following format : <name> circles around <centerStar.name> at the <distanceWithCenterStar> AU. The distanceWithCenterStar is computed with the help of distanceBetween method taking as parameter the planet and its center star.##

// Here is a possible ExerciseRunner.java to test your function :

// public class ExerciseRunner {

//     public static void main(String[] args) {
//         Planet earth = new Planet();
//         Planet naboo = new Planet("Naboo", 17.4389, 8349.1, 8943.92, new Star("Betelgeuse", 128.23, -12.82, 32.328, 1289.3));

//         System.out.println(naboo.toString());
//         System.out.println(earth.toString());
//         System.out.println(naboo.getCenterStar().toString());
//     }
// }
// and its output :

// $ javac *.java -d build
// $ java -cp build ExerciseRunner
// Naboo circles around Betelgeuse at the 12220.902 AU
// Soleil circles around Soleil at the 0.000 AU
// Betelgeuse shines at the 1289.300 magnitude
// $

public class Star extends CelestialObject {
    private double magnitude;

    public Star() {
        super();
        this.magnitude = 0.0;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public Star(String name, double x, double y, double z, double magnitude) {
        super(name, x, y, z);
        this.magnitude = magnitude;
    }

    @Override
    public String toString() {
        return String.format("%s shines at the %.3f magnitude", getName(), magnitude);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Star star = (Star) obj;
        return Double.compare(star.magnitude, magnitude) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp = Double.doubleToLongBits(magnitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
