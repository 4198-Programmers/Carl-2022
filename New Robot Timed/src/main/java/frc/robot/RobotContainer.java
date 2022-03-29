package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.command.AngledHookMove;
import frc.robot.command.ChooseLimelightMode;
import frc.robot.command.Drive;
import frc.robot.command.DriveForDeterminedDistance;
import frc.robot.command.MoveBallFromIntake;
import frc.robot.command.SetFlyWheelSpeed;
import frc.robot.command.SetFlyWheelSpeedWithThrottle;
import frc.robot.command.SetIntakeSpeed;
import frc.robot.command.SetTunnelSpeed;
import frc.robot.command.Spin;
import frc.robot.command.StopFlyWheel;
import frc.robot.command.Target;
import frc.robot.command.VerticalHooksMove;
import frc.robot.command.WaitForBallToBeSeenByIntakeSensor;
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
  Spin spin = new Spin(driveTrain, Constants.AUTO_ROTATION);
  Target target = new Target(limelight, driveTrain);
  VerticalHooksMove verticalHooksMove = new VerticalHooksMove(verticalHooks,
      () -> rightJoystick.getRawAxis(Constants.UP_DOWN_AXIS));
  WaitForBallToShoot waitForBallToShoot = new WaitForBallToShoot(sensors);
  WaitForFlyWheel waitForFlyWheel = new WaitForFlyWheel(shooterSystem, limelight);

 Command autonomousPeriodTwoBall = (new DriveForDeterminedDistance(driveTrain, Constants.AUTO_DRIVE_DISTANCE))
  .alongWith(new SetIntakeSpeed(shooterSystem, Constants.INTAKE_SPEED))
  .alongWith(new WaitForBallToBeSeenByIntakeSensor(shooterSystem, sensors))
  .andThen(new MoveBallFromIntake(shooterSystem, sensors, Constants.TUNNEL_SPEED))
  .alongWith(new Spin(driveTrain, Constants.ONE_EIGHTY_DEGREES))
  .andThen(new SetFlyWheelSpeed(shooterSystem, limelight))
  .alongWith(new WaitForFlyWheel(shooterSystem, limelight))
  .andThen(new SetTunnelSpeed(shooterSystem, Constants.TUNNEL_SPEED))
  .alongWith(new WaitForBallToShoot(sensors))
  .andThen(new StopFlyWheel(shooterSystem))
  .alongWith(new SetTunnelSpeed(shooterSystem, 0));

  Command autonomousPeriodFourBall = (new DriveForDeterminedDistance(driveTrain, Constants.AUTO_DRIVE_DISTANCE))
  .alongWith(new SetIntakeSpeed(shooterSystem, Constants.INTAKE_SPEED))
  .alongWith(new WaitForBallToBeSeenByIntakeSensor(shooterSystem, sensors))
  .andThen(new MoveBallFromIntake(shooterSystem, sensors, Constants.TUNNEL_SPEED))
  .andThen(new SetIntakeSpeed(shooterSystem, 0))
  .andThen(new Spin(driveTrain, Constants.ONE_EIGHTY_DEGREES))
  .andThen(new SetFlyWheelSpeed(shooterSystem, limelight))
  .alongWith(new WaitForFlyWheel(shooterSystem, limelight))
  .andThen(new SetTunnelSpeed(shooterSystem, Constants.TUNNEL_SPEED))
  .alongWith(new WaitForBallToShoot(sensors))
  .andThen(new StopFlyWheel(shooterSystem))
  .alongWith(new SetTunnelSpeed(shooterSystem, 0))
  .andThen(new Spin(driveTrain, Constants.AUTO_ROTATION_AFTER_SHOT))
  .andThen(new DriveForDeterminedDistance(driveTrain, Constants.AUTO_DRIVE_DISTANCE_AFTER_SHOT))
  .alongWith(new SetIntakeSpeed(shooterSystem, Constants.INTAKE_SPEED))
  .alongWith(new WaitForBallToBeSeenByIntakeSensor(shooterSystem, sensors))
  .andThen(new MoveBallFromIntake(shooterSystem, sensors, Constants.TUNNEL_SPEED))
  .andThen(new SetFlyWheelSpeed(shooterSystem, limelight))
  .alongWith(new WaitForFlyWheel(shooterSystem, limelight))
  .andThen(new SetTunnelSpeed(shooterSystem, Constants.TUNNEL_SPEED))
  .andThen(new WaitForBallToShoot(sensors))
  .andThen(new StopFlyWheel(shooterSystem))
  .alongWith(new SetTunnelSpeed(shooterSystem, 0));
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
    angledOverRideButton.whenInactive(new Drive(driveTrain, 
      ()-> leftJoystick.getRawAxis(Constants.UP_DOWN_AXIS), 
      () -> middleJoystick.getRawAxis(Constants.LEFT_RIGHT_AXIS)));
    verticalOverRideButton.whenHeld(new VerticalHooksMove(verticalHooks, () -> rightJoystick.getRawAxis(Constants.UP_DOWN_AXIS)));
    
  }

  private void begin() {
    SmartDashboard.putData("Auto choices", m_chooser);
    m_chooser.addOption("Two Ball Auto", autonomousPeriodTwoBall);
    m_chooser.addOption("Four Ball Auto", autonomousPeriodFourBall);
  }

  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }

}
