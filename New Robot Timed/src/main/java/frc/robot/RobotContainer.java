package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Subsystems.Limelight;
import frc.robot.Subsystems.Sensors;
import frc.robot.Subsystems.ShooterSystem;
import frc.robot.Subsystems.TunnelSub;
import frc.robot.Commands.MoveAngledHooks;
import frc.robot.Commands.MoveBallFromFeed;
import frc.robot.Commands.AutoFlyWheelSpeed;
import frc.robot.Commands.ChooseLimelightMode;
import frc.robot.Commands.DoNotDrive;
import frc.robot.Commands.Drive;
import frc.robot.Commands.FeederIn;
import frc.robot.Commands.FeederOut;
import frc.robot.Commands.DriveForCertainDistance;
import frc.robot.Commands.SetFlySpeedWithLimelight;
import frc.robot.Commands.SetFlySpeedWithThrottle;
import frc.robot.Commands.WaitForBallToLeaveBot;
import frc.robot.Commands.WaitForFlyWheelSpeed;
import frc.robot.Commands.Spin;
import frc.robot.Commands.StopFlyWheel;
import frc.robot.Commands.Targeting;
import frc.robot.Commands.MoveBalltoShooter;
import frc.robot.Commands.SetTunnelSpeed;
import frc.robot.Commands.Turn;
import frc.robot.Commands.TurnForTenSeconds;
import frc.robot.Commands.WaitForBallToEnterIntake;
import frc.robot.Commands.MoveVerticalHooks;
import frc.robot.Subsystems.AngledHooks;
import frc.robot.Subsystems.DriveTrain;
import frc.robot.Subsystems.Intake;
import frc.robot.Subsystems.VerticalHooks;
import frc.robot.Subsystems.Limelight.LimelightMode;

public class RobotContainer {
  Joystick rightJoystick = new Joystick(Constants.RIGHT_JOYSTICK_PORT);
  Joystick middleJoystick = new Joystick(Constants.MIDDLE_JOYSTICK_PORT);
  Joystick leftJoystick = new Joystick(Constants.LEFT_JOYSTICK_PORT);

  // subsystems
  DriveTrain driveTrain;
  ShooterSystem shooterSystem;
  VerticalHooks verticalHooks;
  AngledHooks angledHooks;
  Limelight limelight;
  Intake intake;
  TunnelSub tunnelSub;
  Sensors sensors;
  // commands
  Drive drive = new Drive(driveTrain,
      () -> leftJoystick.getRawAxis(Constants.UP_AND_DOWN_AXIS),
      () -> middleJoystick.getRawAxis(Constants.LEFT_AND_RIGHT_AXIS));

  Command taxiAndShoot = (new DriveForCertainDistance(driveTrain, -2))
      .andThen(new DriveForCertainDistance(driveTrain, 45))
      .alongWith((new MoveBallFromFeed(tunnelSub)))
      .alongWith((new FeederIn(intake))
          .raceWith(new WaitForBallToEnterIntake(intake, sensors)))
      .andThen(new Turn(driveTrain, 180))
      .andThen(new DriveForCertainDistance(driveTrain, 50))
      .andThen(new AutoFlyWheelSpeed(shooterSystem, Constants.AUTO_FLY_WHEEL_SPEED))
      .alongWith(new WaitForFlyWheelSpeed(shooterSystem, limelight))
      .andThen(new MoveBalltoShooter(tunnelSub))
      .raceWith((new WaitForBallToLeaveBot()))
      .andThen(new AutoFlyWheelSpeed(shooterSystem, Constants.AUTO_FLY_WHEEL_SPEED))
      .alongWith(new WaitForFlyWheelSpeed(shooterSystem, limelight))
      .andThen((new MoveBalltoShooter(tunnelSub))
          .raceWith((new WaitForBallToLeaveBot())))
      .andThen(new StopFlyWheel(shooterSystem));
      
  // buttons
  JoystickButton targetingButton = new JoystickButton(middleJoystick, Constants.TARGETING_BUTTON);
  JoystickButton shootingButton = new JoystickButton(rightJoystick, Constants.SHOOTING_BUTTON);

  JoystickButton limelightOnButton = new JoystickButton(middleJoystick, Constants.LIMELIGHT_ON_BUTTON);
  JoystickButton limelightOffButton = new JoystickButton(middleJoystick, Constants.LIMELIGHT_OFF_BUTTON);

  JoystickButton feederInButton = new JoystickButton(rightJoystick, Constants.FEEDER_IN_BUTTON);
  JoystickButton feederOutButton = new JoystickButton(rightJoystick, Constants.FEEDER_OUT_BUTTON);

  JoystickButton tunnelInButton = new JoystickButton(rightJoystick, Constants.TUNNEL_IN_BUTTON);
  JoystickButton tunnelOutButton = new JoystickButton(rightJoystick, Constants.TUNNEL_OUT_BUTTON);

  JoystickButton danceButton = new JoystickButton(middleJoystick, Constants.DANCE_BUTTON);

  JoystickButton angledOverRideButton = new JoystickButton(middleJoystick, Constants.ANGLED_OVERRIDE_BUTTON);
  JoystickButton verticalOverRideButton = new JoystickButton(middleJoystick, Constants.VERTICAL_OVERRIDE_BUTTON);

  JoystickButton deathSpinButton = new JoystickButton(leftJoystick, Constants.DEATH_SPIN_BUTTON);
  JoystickButton humanOverRideButton = new JoystickButton(leftJoystick, Constants.HUMAN_OVERRIDE_BUTTON);

  JoystickButton turnForTenSecondsButton = new JoystickButton(middleJoystick, Constants.TURN_FOR_TEN_SECONDS_BUTTON);
  // other
  private final SendableChooser<Command> m_chooser = new SendableChooser<>();

  public RobotContainer() {
    configureButtonBindings();
    begin();
  }

  private void configureButtonBindings() {
    targetingButton.whenHeld(new Targeting(limelight, driveTrain));
    targetingButton.whenReleased(new ChooseLimelightMode(limelight, LimelightMode.forceOff));

    shootingButton.and(humanOverRideButton).whileActiveContinuous
      (new SetFlySpeedWithLimelight(shooterSystem), false);
      
    shootingButton.whenHeld(new SetFlySpeedWithThrottle(shooterSystem, 
      ()-> middleJoystick.getRawAxis(Constants.THROTTLE_AXIS)));

    limelightOnButton.whenPressed(new ChooseLimelightMode(limelight, LimelightMode.forceOn));
    limelightOffButton.whenPressed(new ChooseLimelightMode(limelight, LimelightMode.forceOff));

    feederInButton.whenHeld(new FeederIn(intake), false);
    feederOutButton.whenHeld(new FeederOut(intake), false);

    tunnelInButton.whenHeld(new MoveBalltoShooter(tunnelSub), false);
    tunnelOutButton.whenHeld(new SetTunnelSpeed(tunnelSub, Constants.TUNNEL_SPEED), false);

    turnForTenSecondsButton.whenPressed(new TurnForTenSeconds(driveTrain, Constants.TURN_SPEED, Constants.TURN_TURNING_SPEED, Constants.TURN_MILLISECONDS));

    angledOverRideButton.whenHeld(new MoveAngledHooks(angledHooks,
        () -> rightJoystick.getRawAxis(Constants.UP_AND_DOWN_AXIS)), false);

    angledOverRideButton.whenInactive(new Drive(driveTrain,
        () -> leftJoystick.getRawAxis(Constants.UP_AND_DOWN_AXIS),
        () -> middleJoystick.getRawAxis(Constants.LEFT_AND_RIGHT_AXIS)));

    verticalOverRideButton.whenHeld(new MoveVerticalHooks(verticalHooks,
        () -> middleJoystick.getRawAxis(Constants.UP_AND_DOWN_AXIS)), false);

    deathSpinButton.and(humanOverRideButton).whileActiveContinuous
        (new Spin(driveTrain, Constants.SPIN_BUTTON_DEGREES));
  }

  private void begin() {
    m_chooser.addOption("Auto-Do not Move", new DoNotDrive(driveTrain));
    m_chooser.setDefaultOption("Taxi and Shoot", taxiAndShoot);
    m_chooser.addOption("Taxi", new DriveForCertainDistance(driveTrain, Constants.WANTED_AUTO_DISTANCE));
  }

  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }
}