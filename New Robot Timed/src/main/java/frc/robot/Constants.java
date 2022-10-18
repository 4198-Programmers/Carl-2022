package frc.robot;


public class Constants {
    public static final byte LEFT_STICK_PORT = 0;
    public static final byte MID_STICK_PORT = 1;
    public static final byte RIGHT_STICK_PORT = 2;

    public static final double FRONT_LEFT_X_LOCATION = 0;
    public static final double FRONT_LEFT_Y_LOCATION = 0;
    public static final double FRONT_RIGHT_X_LOCATION = 0;
    public static final double FRONT_RIGHT_Y_LOCATION = 0;
    public static final double BACK_LEFT_X_LOCATION = 0;
    public static final double BACK_LEFT_Y_LOCATION = 0;
    public static final double BACK_RIGHT_X_LOCATION = 0;
    public static final double BACK_RIGHT_Y_LOCATION = 0;
    public static final int FRONT_LEFT_TURNING_MOTOR_ID = 0;
    public static final int FRONT_RIGHT_TURNING_MOTOR_ID = 0;
    public static final int BACK_LEFT_TURNING_MOTOR_ID = 0;
    public static final int BACK_RIGHT_TURNING_MOTOR_ID = 0;
    public static final int FRONT_LEFT_MOTOR_ID = 0;
    public static final int FRONT_RIGHT_MOTOR_ID = 0;
    public static final int BACK_LEFT_MOTOR_ID = 0;
    public static final int BACK_RIGHT_MOTOR_ID = 0;
    public static final double LENGTH = 0;
    public static final double WIDTH = 0;
    public static final int DRIVE_MOTOR = 0;
    public static final int TURNING_MOTOR = 0;
    public static final double kp = 0;
    public static final double ki = 0;
    public static final double kd = 0;
    public static final String absoluteEncoderPort = null;
    public static final class ModuleConstants{
        public static final double kWheelDiameterMeters = 0; //get units in inches and then convert to meters using Units.inchesToMeter(in);
        public static final double kDriveMotorGearRatio = 0;//get gear ratio
        public static final double kTurningMotorGearRatio = 0; //get gear ratio
        public static final double kDriveEncoderRot2Meter = kDriveMotorGearRatio * Math.PI * kWheelDiameterMeters;
        public static final double kTurningEncoderRot2Rad = kTurningMotorGearRatio *2* Math.PI;
        public static final double kDriveEncoderRPM2MeterPerSec = kDriveEncoderRot2Meter/60;
        public static final double kTurningEncoderRPM2RadPerSec = kTurningEncoderRot2Rad/60;
        public static final double kPTurning = 0;
        public static final String absoluteEncoderId = null;

    }
}