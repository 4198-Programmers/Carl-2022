package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.command.AngledHookMove;
import frc.robot.command.ChooseLimelightMode;
import frc.robot.command.Drive;
import frc.robot.command.MoveBallFromIntake;
import frc.robot.command.SetFlyWheelSpeed;
import frc.robot.command.SetFlyWheelSpeedWithThrottle;
import frc.robot.command.SetIntakeSpeed;
import frc.robot.command.SetTunnelSpeed;
import frc.robot.command.Target;
import frc.robot.command.VerticalHooksMove;
import frc.robot.command.WaitForBallToShoot;
import frc.robot.command.WaitForFlyWheel;
import frc.robot.subsystems.AngledHooks;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Sensors;
import frc.robot.subsystems.ShooterSystem;
import frc.robot.subsystems.VerticalHooks;
import frc.robot.subsystems.Limelight.LimelightMode;

public class RobotContainer {
  Joystick leftJoystick = new Joystick(Constants.LEFT_JOYSTICK_PORT);
  Joystick rightJoystick = new Joystick(Constants.RIGHT_JOYSTICK_PORT);
  Joystick middleJoystick = new Joystick(Constants.MIDDLE_JOYSTICK_PORT);
  // subsystems
  AngledHooks angledHooks;
  DriveTrain driveTrain;
  Limelight limelight;
  Sensors sensors;
  ShooterSystem shooterSystem;
  VerticalHooks verticalHooks;
  // commands
  AngledHookMove angledHookMove = new AngledHookMove(angledHooks,
      () -> middleJoystick.getRawAxis(Constants.UP_DOWN_AXIS));
  ChooseLimelightMode forceOn = new ChooseLimelightMode(limelight, LimelightMode.forceOn);
  ChooseLimelightMode forceOff = new ChooseLimelightMode(limelight, LimelightMode.forceOff);
  Drive drive = new Drive(driveTrain, () -> leftJoystick.getRawAxis(Constants.UP_DOWN_AXIS),
      () -> middleJoystick.getRawAxis(Constants.LEFT_RIGHT_AXIS));
  MoveBallFromIntake moveBallFromIntake = new MoveBallFromIntake(shooterSystem, sensors, Constants.TUNNEL_SPEED);
  SetFlyWheelSpeed setFlyWheelSpeed = new SetFlyWheelSpeed(shooterSystem, limelight);
  SetFlyWheelSpeedWithThrottle setFlyWheelSpeedWithThrottle = new SetFlyWheelSpeedWithThrottle(shooterSystem,
      () -> middleJoystick.getRawAxis(Constants.THROTTLE_AXIS));
  SetTunnelSpeed setTunnelSpeed = new SetTunnelSpeed(shooterSystem, Constants.TUNNEL_SPEED);
  Target target = new Target(limelight, driveTrain);
  VerticalHooksMove verticalHooksMove = new VerticalHooksMove(verticalHooks,
      () -> rightJoystick.getRawAxis(Constants.UP_DOWN_AXIS));
  WaitForBallToShoot waitForBallToShoot = new WaitForBallToShoot(sensors);
  WaitForFlyWheel waitForFlyWheel = new WaitForFlyWheel(shooterSystem, limelight);
  // buttons
  JoystickButton humanOverRide = new JoystickButton(leftJoystick, Constants.HUMAN_OVERRIDE_BUTTON);
  JoystickButton limelightOnButton = new JoystickButton(middleJoystick, Constants.LIMELIGHT_ON_BUTTON);
  JoystickButton limelightoffButton = new JoystickButton(middleJoystick, Constants.LIMELIGHT_OFF_BUTTON);
  JoystickButton tunnelInButton = new JoystickButton(rightJoystick, Constants.TUNNEL_IN_BUTTON);
  JoystickButton tunnelOutButton = new JoystickButton(rightJoystick, Constants.TUNNEL_OUT_BUTTON);
  JoystickButton intakeInButton = new JoystickButton(rightJoystick, Constants.INTAKE_IN_BUTTON);
  JoystickButton intakeOutButton = new JoystickButton(rightJoystick, Constants.INTAKE_OUT_BUTTON);
  JoystickButton angledOverRideButton = new JoystickButton(middleJoystick, Constants.ANGLED_OVERRIDE_BUTTON);
  JoystickButton verticalOverRideButton =  new JoystickButton(rightJoystick, Constants.VERTICAL_OVERRIDE_BUTTON);
  
  // other
  private final SendableChooser<Command> m_chooser = new SendableChooser<>();

  public RobotContainer() {

  }

  public void initialize() {
    configureButtonBindings();
    begin();

  }

  private void configureButtonBindings() {
    limelightOnButton.whenPressed(new ChooseLimelightMode(limelight, LimelightMode.forceOn));
    limelightoffButton.whenPressed(new ChooseLimelightMode(limelight, LimelightMode.forceOff));
    tunnelInButton.whenHeld(new SetTunnelSpeed(shooterSystem, Constants.TUNNEL_SPEED));
    tunnelOutButton.whenHeld(new SetTunnelSpeed(shooterSystem, -Constants.TUNNEL_SPEED));
    intakeInButton.whenHeld(new SetIntakeSpeed(shooterSystem, Constants.INTAKE_SPEED));
    intakeOutButton.whenHeld(new SetIntakeSpeed(shooterSystem, -Constants.INTAKE_SPEED));
    angledOverRideButton.whenHeld(new AngledHookMove(angledHooks, () -> middleJoystick.getRawAxis(Constants.UP_DOWN_AXIS)));
    verticalOverRideButton.whenHeld(new VerticalHooksMove(verticalHooks, () -> rightJoystick.getRawAxis(Constants.UP_DOWN_AXIS)));
    
  }

  private void begin() {
    SmartDashboard.putData("Auto choices", m_chooser);
  }

  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }

}
