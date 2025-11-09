import java.util.Objects;

public class CelestialObject {
    private String name;
    private double x;
    private double y;
    private double z;
    private int mass;

    public static final double KM_IN_ONE_AU = 150_000_000;

    public CelestialObject() {
        this.name = "Soleil";
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.mass = 0;
    }

    public CelestialObject(String name, double x, double y, double z, int mass) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
        this.mass = mass;
    }

    public String getName() { return name; }
    public double getX() { return x; }
    public double getY() { return y; }
    public double getZ() { return z; }

    public void setName(String name) { this.name = name; }
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    public void setZ(double z) { this.z = z; }
    
    public int getMass() { return mass; }
    public void setMass(int mass) { this.mass = mass; }

    public static double getDistanceBetween(CelestialObject a, CelestialObject b) {
        double dx = b.x - a.x;
        double dy = b.y - a.y;
        double dz = b.z - a.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public static double getDistanceBetweenInKm(CelestialObject a, CelestialObject b) {
        return getDistanceBetween(a, b) * KM_IN_ONE_AU;
    }

    @Override
    public String toString() {
        return String.format("%s is positioned at (%.3f, %.3f, %.3f)", name, x, y, z);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof CelestialObject)) return false;
        CelestialObject other = (CelestialObject) object;
        return Double.compare(other.x, x) == 0 &&
               Double.compare(other.y, y) == 0 &&
               Double.compare(other.z, z) == 0 &&
               Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, x, y, z);
    }
}
