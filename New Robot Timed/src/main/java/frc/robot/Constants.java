package frc.robot;

public class Constants {

    // Axis
    public static final int UP_DOWN_AXIS = 1;
    public static final int LEFT_RIGHT_AXIS = 0;
    public static final int THROTTLE_AXIS = 3;

    // Ports
    public static final int LEFT_JOYSTICK_PORT = 0;
    public static final int MIDDLE_JOYSTICK_PORT = 1;
    public static final int RIGHT_JOYSTICK_PORT = 2;

    public static final int FRONT_RIGHT_MOTOR_PORT = 10;
    public static final int FRONT_LEFT_MOTOR_PORT = 1;

    public static final int BACK_RIGHT_MOTOR_PORT = 9;
    public static final int BACK_LEFT_MOTOR_PORT = 2;

    public static final int FLY_WHEEL_MOTOR_PORT = 3;

    public static final int TUNNEL_MOTOR_PORT = 7;

    public static final int INTAKE_MOTOR_PORT = 4;

    public static final int RIGHT_VERTICAL_HOOK_PORT = 8;
    public static final int LEFT_VERTICAL_HOOK_PORT = 6;

    public static final int ANGLED_HOOKS_PORT = 5;

    public static final int BALL_IN_SENSOR_PORT = 1;
    public static final int BALL_OUT_SENSOR_PORT = 0;
    // Constants
    public static final double MIDDLE_CIRCLE_CIRCUMFERENCE = (Math.PI) * 23.5;
    public static final double WHEEL_DIAMTER = 5.875;

    public static final double TARGET_HEIGHT_TOP_TO_GROUND = 104;
    public static final double LIMELIGHT_HEIGHT_TO_GROUND = 25;
    public static final double LIMELIGHT_ANGLE_FROM_GROUND = 65;

    public static final double VERTICAL_HOOK_UPPER_LIMIT = -187;
    public static final double VERTICAL_HOOK_LOWER_LIMIT = 0;

    public static final double ANGLED_HOOK_UPPER_LIMIT = -97;
    public static final double ANGLED_HOOK_LOWER_LIMIT = 20; // TODO update ANGLED_HOOK_LOWER_LIMIT

    public static final double WIDE_X_OFFSET = 3.75;
    public static final double SLIM_X_OFFSET = 3;
    public static final double SPEED_MULTIPLIER = 1;

    public static final double TUNNEL_SPEED = 0.75;
    public static final double INTAKE_SPEED = -1;

    public static final double AUTO_ROTATION = 0;
    public static final double AUTO_DRIVE_DISTANCE = 0;

    public static final double ONE_EIGHTY_DEGREES = 180;
    public static final double AUTO_ROTATION_AFTER_SHOT = 0;

    // Left Joystick
    public static final int HUMAN_OVERRIDE_BUTTON = 2;

    // Middle Joystick
    public static final int SHOOTER_BUTTON = 1;
    public static final int LIMELIGHT_ON_BUTTON = 11;
    public static final int LIMELIGHT_OFF_BUTTON = 12;
    public static final int ANGLED_OVERRIDE_BUTTON = 2;

    // Right Joystick
    public static final int VERTICAL_OVERRIDE_BUTTON = 2;
    public static final int INTAKE_OUT_BUTTON = 3;
    public static final int TUNNEL_OUT_BUTTON = 4;
    public static final int INTAKE_IN_BUTTON = 5;
    public static final int TUNNEL_IN_BUTTON = 6;
    public static final double AUTO_DRIVE_DISTANCE_AFTER_SHOT = 0;
}