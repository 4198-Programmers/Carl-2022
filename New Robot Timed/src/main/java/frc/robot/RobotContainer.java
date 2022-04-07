package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.DriveTrainCommands.Drive;
import frc.robot.commands.DriveTrainCommands.DriveForSpecificDistance;
import frc.robot.commands.DriveTrainCommands.SetDrivePosition;
import frc.robot.commands.DriveTrainCommands.Spin;
import frc.robot.commands.DriveTrainCommands.Turn;
import frc.robot.commands.HookCommands.MoveAngledHooks;
import frc.robot.commands.HookCommands.MoveVerticalHooks;
import frc.robot.commands.LimelightCommands.ChooseLimeLightMode;
import frc.robot.commands.LimelightCommands.Target;
import frc.robot.commands.ShooterSystemCommands.AutoFlyWheelSpeed;
import frc.robot.commands.ShooterSystemCommands.SetFlyWheelSpeed;
import frc.robot.commands.ShooterSystemCommands.SetIntakeSpeed;
import frc.robot.commands.ShooterSystemCommands.SetTunnelSpeed;
import frc.robot.commands.WaitingCommands.WaitForBallAtShooter;
import frc.robot.commands.WaitingCommands.WaitForBallInSensor;
import frc.robot.commands.WaitingCommands.WaitForFlyWheel;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Sensors;
import frc.robot.subsystems.Hooks.AngledHooks;
import frc.robot.subsystems.Hooks.VerticalHooks;
import frc.robot.subsystems.Limelight.LimelightMode;
import frc.robot.subsystems.ShooterSystem.FlyWheel;
import frc.robot.subsystems.ShooterSystem.Intake;
import frc.robot.subsystems.ShooterSystem.Tunnel;

public class RobotContainer {
  Joystick leftStick = new Joystick(Constants.LEFT_JOYSTICK_PORT);
  Joystick middleStick = new Joystick(Constants.MIDDLE_JOYSTICK_PORT);
  Joystick rightStick = new Joystick(Constants.RIGHT_JOYSTICK_PORT);
  // subsystems
  // Hooks
  AngledHooks angledHooks;
  VerticalHooks verticalHooks;
  // ShooterSystem
  FlyWheel flyWheel;
  Intake intake;
  Tunnel tunnel;
  DriveTrain driveTrain;
  Limelight limelight;
  Sensors sensors;
  // commands
  Command sideBallAuto = (new DriveForSpecificDistance(driveTrain, -2))
    .andThen(new SetDrivePosition(driveTrain, 0))
    .andThen((new DriveForSpecificDistance(driveTrain, 45))
    .alongWith((new SetTunnelSpeed(tunnel, Constants.TUNNEL_SPEED)
    .raceWith(new WaitForBallAtShooter(sensors))))
    .alongWith((new SetIntakeSpeed(intake, Constants.INTAKE_SPEED))
    .raceWith((new WaitForBallInSensor(sensors)))
    .raceWith(new WaitCommand(2))))
    .andThen(new SetDrivePosition(driveTrain, 0))
    .andThen(new Spin(driveTrain, 180))
    .andThen(new Target(limelight, driveTrain))
    .andThen(new SetDrivePosition(driveTrain, 0))
    .andThen(new DriveForSpecificDistance(driveTrain, 73))
    .andThen((new AutoFlyWheelSpeed(flyWheel, Constants.FLY_WHEEL_SPEED)))
    .andThen(new WaitForFlyWheel(flyWheel, Constants.FLY_WHEEL_SPEED))
    .andThen((new SetTunnelSpeed(tunnel, Constants.TUNNEL_SPEED))
    .raceWith(new WaitForBallAtShooter(sensors))
    .andThen(new AutoFlyWheelSpeed(flyWheel, Constants.FLY_WHEEL_SPEED)))
    .andThen(new WaitForFlyWheel(flyWheel, Constants.FLY_WHEEL_SPEED))
    .andThen((new SetTunnelSpeed(tunnel, Constants.TUNNEL_SPEED))
    .raceWith(new WaitForBallAtShooter(sensors)))
    .andThen(new AutoFlyWheelSpeed(flyWheel, 0));
    
    Command middleBallAuto = (new DriveForSpecificDistance(driveTrain, -2))
    .andThen(new SetDrivePosition(driveTrain, 0))
    .andThen((new Turn(driveTrain, 90))
    .alongWith((new SetTunnelSpeed(tunnel, Constants.TUNNEL_SPEED))
    .raceWith(new WaitForBallAtShooter(sensors)))
    .andThen((new SetIntakeSpeed(intake, Constants.INTAKE_SPEED))
    .raceWith(new WaitForBallInSensor(sensors))))
    .andThen(new SetDrivePosition(driveTrain, 0))
    .andThen((new Turn(driveTrain, -180))
    .alongWith((new AutoFlyWheelSpeed(flyWheel, Constants.FLY_WHEEL_SPEED))))
    .alongWith(new WaitForFlyWheel(flyWheel, Constants.FLY_WHEEL_SPEED))
    .andThen((new SetTunnelSpeed(tunnel, Constants.TUNNEL_SPEED))
    .raceWith(new WaitForBallAtShooter(sensors)))
    .andThen((new SetTunnelSpeed(tunnel, -Constants.TUNNEL_SPEED))
    .raceWith(new WaitForBallInSensor(sensors))
    .alongWith(new AutoFlyWheelSpeed(flyWheel, Constants.FLY_WHEEL_SPEED)))
    .andThen((new SetTunnelSpeed(tunnel, Constants.TUNNEL_SPEED))
    .raceWith(new WaitForBallAtShooter(sensors)))
    .andThen(new AutoFlyWheelSpeed(flyWheel, 0));
    
      // MakeButtons
  JoystickButton targetingButton = new JoystickButton(leftStick, Constants.TARGETING_BUTTON);
  JoystickButton shoootingButton = new JoystickButton(middleStick, Constants.SHOOTER_BUTTON);
  JoystickButton limelightOnButton = new JoystickButton(middleStick, Constants.LIMELIGHT_ON_BUTTON);
  JoystickButton limelightOffButton = new JoystickButton(middleStick, Constants.LIMELIGHT_OFF_BUTTON);
  JoystickButton angledOverRideButton = new JoystickButton(middleStick, Constants.ANGLED_OVERRIDE_BUTTON);
  JoystickButton verticalOverRideButton = new JoystickButton(rightStick, Constants.VERTICAL_OVERRIDE_BUTTON);
  JoystickButton lowLoftButton = new JoystickButton(rightStick, Constants.LOW_LOFT_BUTTON);
  JoystickButton invertFlyWheelSpeed = new JoystickButton(rightStick, Constants.INVERT_FLY_WHEEL_SPEED_BUTTON);
  // other
  private final SendableChooser<Command> m_chooser = new SendableChooser<>();

  public RobotContainer() {

  }

  public void initialize() {
    configureButtonBindings();
    begin();

  }

  private void configureButtonBindings() {
    targetingButton.whenHeld(new Target(limelight, driveTrain));
    shoootingButton
        .whenHeld(new SetFlyWheelSpeed(flyWheel, () -> middleStick.getRawAxis(Constants.THROTTLE_AXIS), Constants.FLY_WHEEL_SPEED));
    limelightOnButton.whenPressed(new ChooseLimeLightMode(limelight, LimelightMode.forceOn));
    limelightOffButton.whenPressed(new ChooseLimeLightMode(limelight, LimelightMode.forceOff));
    angledOverRideButton
        .whenHeld(new MoveAngledHooks(() -> middleStick.getRawAxis(Constants.UP_DOWN_AXIS), angledHooks));
    angledOverRideButton.whenInactive(new Drive(driveTrain, () -> leftStick.getRawAxis(Constants.UP_DOWN_AXIS),
        () -> middleStick.getRawAxis(Constants.LEFT_RIGHT_AXIS)));
    verticalOverRideButton
        .whenHeld(new MoveVerticalHooks(() -> rightStick.getRawAxis(Constants.UP_DOWN_AXIS), verticalHooks));
      lowLoftButton.whenHeld(new SetFlyWheelSpeed(flyWheel, () -> middleStick.getRawAxis(Constants.THROTTLE_AXIS), Constants.LOW_LOFT_SPEED));
  }

  private void begin() {
    SmartDashboard.putData("Auto choices", m_chooser);
    m_chooser.addOption("Middle Ball Auto", middleBallAuto);
    m_chooser.setDefaultOption("Side Ball Auto", sideBallAuto);
  }

  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }

}