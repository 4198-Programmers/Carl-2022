package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.command.DoNotMove;
import frc.robot.command.TaxiAndShoot;
import frc.robot.command.TaxiTarmac;
import frc.robot.command.hookcommands.AngledHookJoystick;
import frc.robot.command.hookcommands.MoveCloserToNinetyDegrees;
import frc.robot.command.hookcommands.MoveCloserToZeroDegrees;
import frc.robot.command.hookcommands.PullVertHooksIn;
import frc.robot.command.hookcommands.ReachVertHooksUp;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Hooks;
import frc.robot.subsystems.ShooterPathMovement;

public class RobotContainer {

    private final SendableChooser<Command> m_chooser = new SendableChooser<>();

    Joystick leftStick = new Joystick(Constants.LEFT_STICK_PORT);
    Joystick midStick = new Joystick(Constants.MID_STICK_PORT);
    Joystick rightStick = new Joystick(Constants.RIGHT_STICK_PORT);

    // subsystems
    DriveTrain vroomVroom = new DriveTrain();
    ShooterPathMovement pewPew = new ShooterPathMovement();
    Hooks climber = new Hooks();

    // commands
    DoNotMove doNotMove = new DoNotMove(vroomVroom, pewPew);
    TaxiAndShoot taxiAndShoot = new TaxiAndShoot(vroomVroom, pewPew);
    TaxiTarmac taxiTarmac = new TaxiTarmac(vroomVroom);
    AngledHookJoystick angledHookJoystick = new AngledHookJoystick(climber, rightStick);
    ReachVertHooksUp reachHooksUp = new ReachVertHooksUp(climber);
    PullVertHooksIn pullVertHooksIn = new PullVertHooksIn(climber);
    MoveCloserToZeroDegrees moveCloserToZeroDegrees = new MoveCloserToZeroDegrees(climber);
    MoveCloserToNinetyDegrees moveCloserToNinetyDegrees = new MoveCloserToNinetyDegrees(climber);

    // buttons
    JoystickButton overrideButton = new JoystickButton(rightStick, Constants.HUMAN_OVERRIDE_BUTTON);
<<<<<<< Updated upstream
    JoystickButton verticalHookUp = new JoystickButton(rightStick, Constants.VERT_HOOK_UP_BUTTON);
    JoystickButton verticalHookDown = new JoystickButton(rightStick, Constants.VERT_HOOK_DOWN_BUTTON);
    JoystickButton angledHookUp = new JoystickButton(rightStick, Constants.ANGLE_HOOK_UP_BUTTON);
    JoystickButton angledHookDown = new JoystickButton(rightStick, Constants.ANGLE_HOOK_DOWN_BUTTON);

    // other

    public RobotContainer() {
        configureButtonBindings();
        begin();
        vroomVroom.setDefaultCommand(new RunCommand(
                () -> vroomVroom.greenLight(leftStick.getRawAxis(0), rightStick.getRawAxis(0)), vroomVroom));
    }

    private void configureButtonBindings() {
        overrideButton.whenHeld(angledHookJoystick);
        overrideButton.and(verticalHookUp).whileActiveContinuous(reachHooksUp);
        overrideButton.and(verticalHookDown).whileActiveContinuous(pullVertHooksIn);
        overrideButton.and(angledHookUp).whileActiveContinuous(moveCloserToNinetyDegrees);
        overrideButton.and(angledHookDown).whileActiveContinuous(moveCloserToNinetyDegrees);
=======
    JoystickButton verticalHookUpBTN = new JoystickButton(rightStick, Constants.VERT_HOOK_UP_BUTTON);
    JoystickButton verticalHookDownBTN = new JoystickButton(rightStick, Constants.VERT_HOOK_DOWN_BUTTON);
    JoystickButton angledHookUpBTN = new JoystickButton(rightStick, Constants.ANGLE_HOOK_UP_BUTTON);
    JoystickButton angledHookDownBTN = new JoystickButton(rightStick, Constants.ANGLE_HOOK_UP_BUTTON);
    JoystickButton flyWheelBTN = new JoystickButton(rightStick, Constants.FLY_WHEEL_BUTTON);
    JoystickButton internalFeederInBTN = new JoystickButton(rightStick, Constants.INTERNAL_FEEDER_FORWARDS_BUTTON);
    JoystickButton internalFeederOutBTN = new JoystickButton(rightStick, Constants.INTAKE_FEEDER_BACKWARDS_BUTTON);
    JoystickButton intakeBTN = new JoystickButton(rightStick, Constants.INTAKE_MOTOR_BUTTON);
    JoystickButton outtakeBTN = new JoystickButton(rightStick, Constants.OUTTAKE_MOTOR_BUTTON);
    //other 
    private final SendableChooser<Command> m_chooser = new SendableChooser<>();
  
    public RobotContainer(){
      configureButtonBindings();
      begin();
      vroomVroom.setDefaultCommand(new RunCommand( () -> 
      vroomVroom.greenLight(leftStick.getRawAxis(0), rightStick.getRawAxis(0)), vroomVroom));
    }
  
    private void configureButtonBindings()
    {
      overrideButton.whileHeld(angledHookJoystick);
      overrideButton.and(verticalHookUpBTN).whileActiveContinuous(reachVertHooksUp);
      overrideButton.and(verticalHookDownBTN).whileActiveContinuous(pullVertHooksIn);
      overrideButton.and(angledHookUpBTN).whileActiveContinuous(moveCloserToNinetyDegrees);
      overrideButton.and(angledHookDownBTN).whileActiveContinuous(moveCloserToZeroDegrees);
      //fly wheel, intake, and internal motor
      overrideButton.and(flyWheelBTN).whileActiveContinuous(new RunCommand( () -> 
      pewPew.setFlySpeed(Constants.FLY_WHEEL_SPEED), pewPew ));

      overrideButton.and(internalFeederInBTN).whileActiveContinuous(new RunCommand( () ->
      pewPew.setMoverSpeed(Constants.INTAKE_INTERNAL_FEEDER_SPEED), pewPew ));

      overrideButton.and(internalFeederOutBTN).whileActiveContinuous(new RunCommand( () ->
      pewPew.setMoverSpeed(Constants.OUTTAKE_INTERNAL_FEEDER_SPEED), pewPew ));

      overrideButton.and(intakeBTN).whileActiveContinuous(new RunCommand( () -> 
      pewPew.setIntakeSpeed(Constants.INTAKE_MOTOR_SPEED), pewPew ));
    
      overrideButton.and(outtakeBTN).whileActiveContinuous(new RunCommand( () -> 
      pewPew.setIntakeSpeed(Constants.OUTTAKE_MOTOR_SPEED), pewPew ));
  
>>>>>>> Stashed changes
    }

    private void begin() {
        m_chooser.setDefaultOption("Default Auto", doNotMove);
        m_chooser.addOption("Taxi + Shoot One", taxiAndShoot);
        m_chooser.addOption("Taxi", taxiTarmac);
        SmartDashboard.putData("Auto choices", m_chooser);
    }

    public Command getAutonomousCommand() {
        return m_chooser.getSelected();
    }
}
