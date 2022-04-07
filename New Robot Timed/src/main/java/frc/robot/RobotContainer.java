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
import frc.robot.commands.WaitingCommands.WaitForBallToBeShot;
import frc.robot.commands.WaitingCommands.WaitForBallToLeaveIntake;
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
  Command sideBallAutoWithTunnelSensor = (new DriveForSpecificDistance(driveTrain, -2))
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

  Command middleBallAutoWithTunnelSensor = (new DriveForSpecificDistance(driveTrain, -2))
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

      Command sideBallAuto = (new DriveForSpecificDistance(driveTrain, -2))
      .andThen(new SetDrivePosition(driveTrain, 0))
      .andThen((new DriveForSpecificDistance(driveTrain, 45))
      .alongWith((new SetTunnelSpeed(tunnel, Constants.TUNNEL_SPEED))
      .raceWith(new WaitForBallToLeaveIntake(sensors)))
      .alongWith((new SetIntakeSpeed(intake, Constants.INTAKE_SPEED))
      .raceWith(new WaitForBallInSensor(sensors))
      .raceWith(new WaitCommand(2))))
      .andThen(new SetDrivePosition(driveTrain, 0))
      .andThen(new Spin(driveTrain, 180))
      .andThen(new Target(limelight, driveTrain))
      .andThen(new SetDrivePosition(driveTrain, 0))
      .andThen((new DriveForSpecificDistance(driveTrain, 73))
      .alongWith(new AutoFlyWheelSpeed(flyWheel, Constants.FLY_WHEEL_SPEED)))
      .andThen((new SetTunnelSpeed(tunnel, Constants.TUNNEL_SPEED))
      .raceWith(new WaitForBallToBeShot(sensors)))
      .andThen((new AutoFlyWheelSpeed(flyWheel, Constants.FLY_WHEEL_SPEED))
      .alongWith(new WaitForFlyWheel(flyWheel, Constants.FLY_WHEEL_SPEED))
      .alongWith((new SetTunnelSpeed(tunnel, -Constants.TUNNEL_SPEED))
      .raceWith(new WaitForBallInSensor(sensors))))
      .andThen((new SetTunnelSpeed(tunnel, Constants.TUNNEL_SPEED))
      .raceWith(new WaitForBallToBeShot(sensors)))
      .andThen(new AutoFlyWheelSpeed(flyWheel, 0));

      Command middleBallAuto = (new DriveForSpecificDistance(driveTrain, -2))
      .andThen(new SetDrivePosition(driveTrain, 0))
      .andThen((new Turn(driveTrain, 90))
      .alongWith((new SetTunnelSpeed(tunnel, Constants.TUNNEL_SPEED))
      .raceWith(new WaitForBallToLeaveIntake(sensors)))
      .alongWith((new SetIntakeSpeed(intake, Constants.INTAKE_SPEED))
      .raceWith(new WaitForBallInSensor(sensors))
      .raceWith(new WaitCommand(2))))
      .andThen(new SetDrivePosition(driveTrain, 0))
      .andThen((new Turn(driveTrain, -270))
      .alongWith(new AutoFlyWheelSpeed(flyWheel, Constants.FLY_WHEEL_SPEED))
      .alongWith(new SetTunnelSpeed(tunnel, -Constants.TUNNEL_SPEED)))
      .andThen((new SetTunnelSpeed(tunnel, Constants.TUNNEL_SPEED))
      .raceWith(new WaitForBallToBeShot(sensors)))
      .andThen((new AutoFlyWheelSpeed(flyWheel, Constants.FLY_WHEEL_SPEED))
      .alongWith(new SetTunnelSpeed(tunnel, -Constants.TUNNEL_SPEED)))
      .andThen((new SetTunnelSpeed(tunnel, Constants.TUNNEL_SPEED))
      .raceWith(new WaitForBallToBeShot(sensors)))
      .andThen(new AutoFlyWheelSpeed(flyWheel, 0));

  // MakeButtons
  JoystickButton humanOverRideButton = new JoystickButton(leftStick, Constants.HUMAN_OVERRIDE_BUTTON);
  JoystickButton targetingButton = new JoystickButton(leftStick, Constants.TARGETING_BUTTON);
  JoystickButton shoootingButton = new JoystickButton(rightStick, Constants.SHOOTER_BUTTON);
  JoystickButton limelightOnButton = new JoystickButton(middleStick, Constants.LIMELIGHT_ON_BUTTON);
  JoystickButton limelightOffButton = new JoystickButton(middleStick, Constants.LIMELIGHT_OFF_BUTTON);
  JoystickButton angledOverRideButton = new JoystickButton(middleStick, Constants.ANGLED_OVERRIDE_BUTTON);
  JoystickButton verticalOverRideButton = new JoystickButton(rightStick, Constants.VERTICAL_OVERRIDE_BUTTON);
  JoystickButton intakeInButton = new JoystickButton(rightStick, Constants.INTAKE_IN_BUTTON);
  JoystickButton intakeOutButton = new JoystickButton(rightStick, Constants.INTAKE_OUT_BUTTON);
  JoystickButton tunnelInButton = new JoystickButton(rightStick, Constants.TUNNEL_IN_BUTTON);
  JoystickButton tunnelOutButton = new JoystickButton(rightStick, Constants.TUNNEL_OUT_BUTTON);
  JoystickButton spitBalls = new JoystickButton(rightStick, Constants.SPIT_BALLS_BUTTON);
  // other
  private final SendableChooser<Command> m_chooser = new SendableChooser<>();

  public RobotContainer() {

  }

  public void initialize() {
    configureButtonBindings();
    begin();

  }

  private void configureButtonBindings() {
    targetingButton.whileHeld(new Target(limelight, driveTrain));
    shoootingButton
        .whileHeld(new SetFlyWheelSpeed(flyWheel, () -> middleStick.getRawAxis(Constants.THROTTLE_AXIS),
            Constants.FLY_WHEEL_SPEED));
    limelightOnButton.whenPressed(new ChooseLimeLightMode(limelight, LimelightMode.forceOn));
    limelightOffButton.whenPressed(new ChooseLimeLightMode(limelight, LimelightMode.forceOff));
    angledOverRideButton
        .whileHeld(new MoveAngledHooks(() -> middleStick.getRawAxis(Constants.UP_DOWN_AXIS), angledHooks));
    angledOverRideButton.whenInactive(new Drive(driveTrain, () -> leftStick.getRawAxis(Constants.UP_DOWN_AXIS),
        () -> middleStick.getRawAxis(Constants.LEFT_RIGHT_AXIS)));
    verticalOverRideButton
        .whileHeld(new MoveVerticalHooks(() -> rightStick.getRawAxis(Constants.UP_DOWN_AXIS), verticalHooks));
    shoootingButton.and(humanOverRideButton)
        .whileActiveContinuous(new AutoFlyWheelSpeed(flyWheel, Constants.LOW_LOFT_SPEED));
    intakeInButton.whileHeld(new SetIntakeSpeed(intake, Constants.INTAKE_SPEED));
    intakeOutButton.whileHeld(new SetIntakeSpeed(intake, -Constants.INTAKE_SPEED));
    tunnelInButton.whileHeld(new SetTunnelSpeed(tunnel, Constants.TUNNEL_SPEED));
    tunnelOutButton.whileHeld(new SetTunnelSpeed(tunnel, -Constants.TUNNEL_SPEED));
    spitBalls.whileHeld((new SetTunnelSpeed(tunnel, -Constants.TUNNEL_SPEED))
        .alongWith(new SetIntakeSpeed(intake, -Constants.INTAKE_SPEED)));
  }

  private void begin() {
    SmartDashboard.putData("Auto choices", m_chooser);
    m_chooser.addOption("Middle Ball Auto", middleBallAutoWithTunnelSensor);
    m_chooser.setDefaultOption("Side Ball Auto", sideBallAutoWithTunnelSensor);
  }

  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }

}