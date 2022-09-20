package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.simpleCommands.AutoDrive;
import frc.robot.simpleCommands.Drive;
import frc.robot.simpleCommands.TurnLimeLightOff;
import frc.robot.simpleCommands.TurnToTarget;
import frc.robot.simpleCommands.resetDriveposition;
import frc.robot.simpleCommands.HookCommands.AngledHook;
import frc.robot.simpleCommands.HookCommands.VerticalHooksDown;
import frc.robot.simpleCommands.HookCommands.VerticalHooksUp;
import frc.robot.simpleCommands.ShooterSystem.ForwardIntake;
import frc.robot.simpleCommands.ShooterSystem.ForwardTunnel;
import frc.robot.simpleCommands.ShooterSystem.ReverseIntake;
import frc.robot.simpleCommands.ShooterSystem.ReverseTunnel;
import frc.robot.simpleCommands.ShooterSystem.SetFlyWheelSpeed;
import frc.robot.subsystems.AngledHooks;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.FlyWheel;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Tunnel;
import frc.robot.subsystems.VerticalHooks;


public class RobotContainer {
Joystick middleJoystick = new Joystick(1);
Joystick leftJoystick = new Joystick(0);
Joystick rightJoystick = new Joystick(2);

  // subsystems
DriveTrain drivetrain = new DriveTrain();
Intake intake = new Intake();
Tunnel tunnel = new Tunnel();
FlyWheel flyWheel = new FlyWheel();
AngledHooks angledHooks = new AngledHooks();
VerticalHooks verticalHooks = new VerticalHooks();
Limelight limelight = new Limelight();
  // ungrouped commands
ForwardIntake forwardIntake = new ForwardIntake(intake);
ReverseIntake reverseIntake = new ReverseIntake(intake);
ForwardTunnel forwardTunnel = new ForwardTunnel(tunnel);
ReverseTunnel reverseTunnel = new ReverseTunnel(tunnel);
SetFlyWheelSpeed setFlyWheel = new SetFlyWheelSpeed(flyWheel);
AngledHook angledHook = new AngledHook(angledHooks, ()->rightJoystick.getRawAxis(0));
VerticalHooksUp verticalHooksUp = new VerticalHooksUp(verticalHooks);
VerticalHooksDown verticalHooksDown = new VerticalHooksDown(verticalHooks);
TurnToTarget turnToTarget = new TurnToTarget(drivetrain, limelight);
  // command groups
Command turnLeft = new resetDriveposition(drivetrain).andThen(new AutoDrive(drivetrain, Maths.rotationConversion(180), -0.5, 0));
Command turnRight = new resetDriveposition(drivetrain).andThen(new AutoDrive(drivetrain, Maths.rotationConversion(180), 0.5, 0));

  //Buttons
    //RightJoystickButtons
JoystickButton flyWheelButton = new JoystickButton(rightJoystick, Constants.FLYWHEEL_BUTTON);
JoystickButton angledButton = new JoystickButton(rightJoystick, Constants.ANGLED_BUTTON);
JoystickButton intakeInButton = new JoystickButton(rightJoystick, Constants.INTAKE_IN_BUTTON);
JoystickButton tunnelInButton = new JoystickButton(rightJoystick, Constants.INTERNAL_MOVER_FORWARDS_BUTTON);
JoystickButton intakeOutButton = new JoystickButton(rightJoystick, Constants.INTAKE_OUT_BUTTON);
JoystickButton tunnelOutButton = new JoystickButton(rightJoystick, Constants.INTERNAL_MOVER_BACKWARDS_BUTTON);
JoystickButton verticalDownButton = new JoystickButton(rightJoystick, Constants.VERT_HOOK_DOWN_BUTTON);
JoystickButton verticalUpButton = new JoystickButton(rightJoystick, Constants.VERT_HOOK_UP_BUTTON);
    //MiddleJoystickButtons
JoystickButton limelightTargetingButton = new JoystickButton(middleJoystick, Constants.LIMELIGHT_TARGETING_BUTTON);
    //LeftJoystickButtons
JoystickButton testButton = new JoystickButton(leftJoystick, Constants.TEST_BUTTON);
JoystickButton limelightoffButton = new JoystickButton(leftJoystick, 7);
JoystickButton limelightOnButton = new JoystickButton(leftJoystick, 8);
  // others
  private final SendableChooser<Command> m_chooser = new SendableChooser<>();

  public void initialize() {
    configureButtonBindings();
    begin();
    drivetrain.setDefaultCommand(new Drive( ()->middleJoystick.getRawAxis(0), 
                                            ()->leftJoystick.getRawAxis(1), 
                                            drivetrain));
    verticalHooks.resetvertposition();
    angledHooks.resetangledposition();
  }

  private void configureButtonBindings() {
intakeInButton.whenHeld(forwardIntake);
intakeOutButton.whenHeld(reverseIntake);
tunnelInButton.whenHeld(forwardTunnel);
tunnelOutButton.whenHeld(reverseTunnel);
flyWheelButton.whenHeld(setFlyWheel);
angledButton.whenHeld(new AngledHook(angledHooks, ()->rightJoystick.getRawAxis(1)));
verticalUpButton.whenHeld(verticalHooksUp);
verticalDownButton.whenHeld(verticalHooksDown);
limelightTargetingButton.whenHeld(turnToTarget);


testButton.whenPressed(turnRight);
limelightoffButton.whenPressed(new TurnLimeLightOff(limelight, Constants.LIMELIGHT_OFF_PIPELINE_MODE));
limelightOnButton.whenPressed(new TurnLimeLightOff(limelight, Constants.LIMELIGHT_FULL_ON_PIPELINE_MODE));
}

  private void begin() {
  }

  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }

}
