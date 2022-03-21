package frc.robot;

public class Maths {


    public static double rotationConversion(double distanceInInches){
        double circumference = (Math.PI * (Constants.WHEEL_DIAMETER));
        double rotations = (distanceInInches / circumference);
        return rotations;
    }
    public static double distanceFromTarget(double YAngle){
        double D = Constants.TARGET_HEIGHT_TOP_TO_GROUND;
        double h = Constants.LIMELIGHT_HEIGHT_TO_GROUND;
        double LLangle = Constants.LIMELGIHT_ANGLE_FROM_GROUND;
        double totalAngle = Math.tan(Math.toRadians((LLangle + YAngle)));
        double distance = (D/h) / totalAngle;
        return distance;
    }

        public static double wantedFlyWheelSpeed(double Distance){
            double invest = Distance;
            double a = 0.0001888428;
            double b = -0.00228743;
            double c = 0.710835;

            return (-((a*(invest * invest)) + (b*invest) + c));      
}
    
}
