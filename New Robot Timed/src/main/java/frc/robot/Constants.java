package frc.robot;

public class Constants {
//Motor Ports
    public static byte FRONT_RIGHT_MOTOR_PORT = -0;
    public static byte FRONT_LEFT_MOTOR_PORT = -0;
    public static byte BACK_RIGHT_MOTOR_PORT = -0;
    public static byte BACK_LEFT_MOTOR_PORT = -0;
    public static final int VERTICAL_RIGHT_HOOK_MOTOR_PORT = 0;
    public static final int VERTICAL_LEFT_HOOK_MOTOR_PORT = 0;
    public static final int ANGLED_HOOK_MOTOR_PORT = 0;
    public static final int FEEDER_MOTOR_PORT = 0;
    public static final int FLYWHEEL_MOTOR_PORT = 0;
//Joysticks
    public static final int RIGHT_JOYSTICK_PORT = 0;
    public static final int MIDDLE_JOYSTICK_PORT = 0;
    public static final int LEFT_JOYSTICK_PORT = 0;

    //Used in Equations
    /**Used to find distance traveled */
        public static final double WHEEL_DIAMTER = 5.785;
    /**The length from the top of the hub to the ground */
        public static final double TARGET_HEIGHT_TOP_TO_GROUND = 0;
    /**The length from the limelight to the ground */
        public static final double LIMELIGHT_HEIGHT_TO_GROUND = 0;
    /**The angle of the limelight compared to the ground */
        public static final double LIMELIGHT_ANGLE_FROM_GROUND = 0;
    /**The limit that the vertical hooks can't go past */
        public static final double VERTICAL_HOOK_TOP_LIMIT = 0;
    /** Used to find the distance as well as the speed */
        public static byte SPEED_MULTIPLIER = -0;
    /**Used to stop the angled hooks from going to opposite direction. */
        public static final double ANGLED_HOOK_UPPER_LIMIT = 0;
    /**How far we want the bot to move in Auto */
        public static final double WANTED_AUTO_DISTANCE = 0;
    /**Need the middle wheel Circumference to calculate Spin180 */
        public static final double MIDDLE_CIRCLE_CIRCUMFERENCE = 0;
    //Constant Speeds
        public static final double FEEDER_INTAKE_SPEED = 0;
        public static final double TUNNEL_SPEED = 0;


//Targeting Offsets
    public static final double X_OFFSET_TARGETING_TO_THE_RIGHT = 0;
    public static final double X_OFFSET_TARGETING_TO_THE_LEFT = 0;
    public static final double X_OFFSET_TARGETING_TO_THE_RIGHT_SLIM = 0;
    public static final double X_OFFSET_TARGETING_TO_THE_LEFT_SLIM = 0;





//LeftJoystick

//Middle Joystick
    public static final int TARGETING_BUTTON = 1;
    public static final int ANGLED_OVERRIDE_BUTTON = 2; 
    public static final int DANCE_BUTTON = 9;   
    public static final int LIMELIGHT_ON_BUTTON = 11;
    public static final int LIMELIGHT_OFF_BUTTON = 12;
    


//Righ Joystick
    public static final int SHOOTING_BUTTON = 1;
    public static final int TUNNEL_MOTOR_ID = 0;
    public static final int FEEDER_IN_BUTTON = 0;
    public static final int FEEDER_OUT_BUTTON = 0;
    public static final int TUNNEL_IN_BUTTON = 0;
    public static final int TUNNEL_OUT_BUTTON = 0;
    public static final int VERTICAL_OVERRIDE_BUTTON = 2;
    public static final double VERTICAL_HOOK_LOWER_LIMIT = 0;
    public static final double ANGLED_HOOK_LOWER_LIMIT = 0;
}
