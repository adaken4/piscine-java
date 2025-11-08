// Instructions

// In the Star class, let's add a new constructor with the following arguments :

// the name

// the position x

// the position y

// the position z

// the magnitude
// It calls the constructor of the superclass CelestialObject.

// We will override hashCode and equals methods, using magnitude property.

// Finally, we override toString method. The returned String must have the following format : <name> shines at the <magnitude> magnitude

// Usage
// Here is a possible ExerciseRunner.java to test your function :

// public class ExerciseRunner {

//     public static void main(String[] args) {
//         Star star = new Star();
//         Star star2 = new Star();
//         Star proxima = new Star("Proxima", 18.389, 832.32, 218, 0.4);
        
//         System.out.println(star.toString());
//         System.out.println(proxima.toString());
//         System.out.println(star.equals(star2));
//         System.out.println(star.equals(proxima));
//     }
// }
// and its output :

// $ javac *.java -d build
// $ java -cp build ExerciseRunner 
// Soleil shines at the 0.000 magnitude
// Proxima shines at the 0.400 magnitude
// true
// false
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
