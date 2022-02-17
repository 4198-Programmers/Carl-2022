package frc.robot;

public class Maths {
    public static double BadWheelMath(double inchesMeasureStuff) {
        double around = Math.PI * GUDNumbers.WHEEL_SIZE;
        double spinnies = (inchesMeasureStuff / around) * GUDNumbers.WHEEL_SIZE_CRISIS;
        return spinnies;
    }
}
