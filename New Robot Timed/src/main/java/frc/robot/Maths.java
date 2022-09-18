package frc.robot;

public final class Maths {

    public static double rotationConversion(double distanceInInches) {
        double circumference = (Math.PI * (Constants.WHEEL_DIAMTER));
        double rotations = ((distanceInInches / circumference));
        return rotations;
    }

    public static double distanceFromTarget(double YAngle) {
        double D = Constants.TARGET_HEIGHT_TOP_TO_GROUND;
        double h = Constants.LIMELIGHT_HEIGHT_TO_GROUND;
        double LLangle = Constants.LIMELIGHT_ANGLE_FROM_GROUND;
        double totalAngle = Math.tan(Math.toRadians(LLangle + YAngle));

        double distance = (D - h) / (totalAngle);

        return distance;
    }

    public static double flyWheelSpeedByDistance(double Distance, boolean target) {
        // double invTest = Distance;
        // double a = 0.000188428;
        // double b = -0.00228743;
        // double c = 0.710835 * 1.04;

        // return (-((a * (invTest * invTest)) + (b * invTest) + c));
        // if(target){
        double x = Distance;
        double a = 0.579371831414;
        double pow = 0.00961944776679;

        return (-1 * a * (Math.exp(pow * x)));
        // }
        // else{
        // return 0.25;
        // }
    }

    public static double spinDistanceByDegree(double Degrees) {
        double circleDistance = (Degrees / 360) * Constants.MIDDLE_CIRCLE_CIRCUMFERENCE;
        double wheelCircumference = (Math.PI * (Constants.WHEEL_DIAMTER));
        double totalRotations = ((circleDistance / wheelCircumference));
        return totalRotations;
    }
}