package frc.robot;

public class Maths {
    public static double rotationConversion(double distance) {
        double circumference = (Math.PI * (Constants.JAKE_WHEELS));
        double rotations = distance / circumference;
        return rotations;
        
    }

    public static double abs(double position) {
        return 0;
    } 
    
}
