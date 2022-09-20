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
        double x = Distance;
        double a = 0.579371831414;
        double pow = 0.00961944776679;

        return (-1 * a * (Math.exp(pow * x)));
    }

    public static double spinDistanceByDegree(double Degrees) {
        double circleDistance = ((2 * Degrees) / 360) * Constants.MIDDLE_CIRCLE_CIRCUMFERENCE;
        double wheelCircumference = (Math.PI * (Constants.WHEEL_DIAMTER));
        double totalRotations = ((circleDistance / wheelCircumference));
        return totalRotations;
    }
}