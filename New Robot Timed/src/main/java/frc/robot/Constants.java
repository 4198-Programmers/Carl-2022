package frc.robot;

public class Constants {
//Axis
public static final int UP_AND_DOWN_AXIS = 0;
public static final double SPIN_BUTTON_DEGREES = 1;
//Ports
    public static byte FRONT_RIGHT_MOTOR_PORT = 10;
    public static byte FRONT_LEFT_MOTOR_PORT = 1;
    public static byte BACK_RIGHT_MOTOR_PORT = 9;
    public static byte BACK_LEFT_MOTOR_PORT = 2;
    public static final int VERTICAL_RIGHT_HOOK_MOTOR_PORT = 8;
    public static final int VERTICAL_LEFT_HOOK_MOTOR_PORT = 6;
    public static final int ANGLED_HOOK_MOTOR_PORT = 5;
    public static final int FEEDER_MOTOR_PORT = 4;
    public static final int FLYWHEEL_MOTOR_PORT = 3;
    public static final int TUNNEL_MOTOR_ID = 7;
    
    public static final byte BALL_IN_SENSOR_PORT = 1;
    public static final byte BALL_OUT_SENSOR_PORT = 0;
//Joysticks
    public static final int LEFT_JOYSTICK_PORT = 0;
    public static final int MIDDLE_JOYSTICK_PORT = 1;
    public static final int RIGHT_JOYSTICK_PORT = 2;

    //Used in Equations
    /**Used to find distance traveled */
        public static final double WHEEL_DIAMTER = 5.875;
    /**The length from the top of the hub to the ground */
        public static final double TARGET_HEIGHT_TOP_TO_GROUND = 104;
    /**The length from the limelight to the ground */
        public static final double LIMELIGHT_HEIGHT_TO_GROUND = 25;
    /**The angle of the limelight compared to the ground */
        public static final double LIMELIGHT_ANGLE_FROM_GROUND = 65;
    /**The limit that the vertical hooks can't go past */
        public static final double VERTICAL_HOOK_TOP_LIMIT = -187;
        public static final double VERTICAL_HOOK_LOWER_LIMIT = 0;
    /** Used to find the distance as well as the speed */
        public static byte SPEED_MULTIPLIER = 1;
    /**Used to stop the angled hooks from going to opposite direction. */
        public static final double ANGLED_HOOK_UPPER_LIMIT = -97;
        public static final double ANGLED_HOOK_LOWER_LIMIT = 20;
    /**How far we want the bot to move in Auto */
        public static final double WANTED_AUTO_DISTANCE = 24;
    /**Need the middle wheel Circumference to calculate Spin180 */
        public static final double MIDDLE_CIRCLE_CIRCUMFERENCE = (Math.PI) * 23.5;
    //Constant Speeds
        public static final double FEEDER_INTAKE_SPEED = -1;
        public static final double TUNNEL_SPEED = 0.75;



//Targeting Offsets
    public static final double X_OFFSET_TARGETING_TO_THE_RIGHT = 3.75;
    public static final double X_OFFSET_TARGETING_TO_THE_LEFT = -3.75;
    public static final double X_OFFSET_TARGETING_TO_THE_RIGHT_SLIM = 3;
    public static final double X_OFFSET_TARGETING_TO_THE_LEFT_SLIM = -3;





//LeftJoystick
public static final int HUMAN_OVERRIDE_BUTTON = 2;
public static final int DEATH_SPIN_BUTTON = 11;

//Middle Joystick
    public static final int TARGETING_BUTTON = 1;
    public static final int ANGLED_OVERRIDE_BUTTON = 2; 
    public static final int DANCE_BUTTON = 9;   
    public static final int LIMELIGHT_ON_BUTTON = 11;
    public static final int LIMELIGHT_OFF_BUTTON = 12;
    


//Righ Joystick
    public static final int SHOOTING_BUTTON = 1;
    public static final int VERTICAL_OVERRIDE_BUTTON = 2;
    public static final int FEEDER_IN_BUTTON = 5;
    public static final int FEEDER_OUT_BUTTON = 3;
    public static final int TUNNEL_IN_BUTTON = 6;
    public static final int TUNNEL_OUT_BUTTON = 4;
    public static final double DANCE_SPIN = 0;
    public static final double DANCE_VERTICAL_HOOK_DISTANCE = 0;
    public static final double DANCE_ANGLED_HOOK_DISTANCE = 0;
    public static final double TAXI_AND_SHOOT_SPIN_DEGREES = 0;
    public static final int LEFT_AND_RIGHT_AXIS = 0;
}
