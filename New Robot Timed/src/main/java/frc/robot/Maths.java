package frc.robot;

public final class Maths {
    
    public static double rotationConversion(double distanceInInches)
    {
        double circumference = (Math.PI*(Constants.WHEEL_DIAMTER));
        double rotations = distanceInInches/circumference;
        return rotations;
    }
    
}
