package frc.robot;

public class Maths {
    public static double DistanceTraveled(double distance) {
        double circumference = Math.PI * Constants.WHEEL_DIAMETER;
        double rotations = (distance / circumference);
        return rotations;
    }
}
