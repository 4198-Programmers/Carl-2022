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
import frc.robot.Commands.ChooseLimelightMode;
import frc.robot.Commands.DanceAngledHooks;
import frc.robot.Commands.DanceVerticalHooks;
import frc.robot.Commands.DoNotDrive;
import frc.robot.Commands.Drive;
import frc.robot.Commands.FeederIn;
import frc.robot.Commands.FeederOut;
import frc.robot.Commands.DriveForCertainDistance;
import frc.robot.Commands.SetFlySpeed;
import frc.robot.Commands.WaitForBallToLeaveBot;
import frc.robot.Commands.WaitForFlyWheelSpeed;
import frc.robot.Commands.Spin;
import frc.robot.Commands.StopFlyWheel;
import frc.robot.Commands.Targeting;
import frc.robot.Commands.MoveBalltoShooter;
import frc.robot.Commands.TunnelOut;
import frc.robot.Commands.TunnelStop;
import frc.robot.Commands.MoveVerticalHooks;
import frc.robot.Subsystems.AngledHooks;
import frc.robot.Subsystems.DriveTrain;
import frc.robot.Subsystems.FeederSub;
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
  FeederSub feederSub;
  TunnelSub tunnelSub;
  Sensors sensors;
  // commands
  Drive drive = new Drive(driveTrain, () -> leftJoystick.getRawAxis(Constants.UP_AND_DOWN_AXIS),
      () -> middleJoystick.getRawAxis(Constants.LEFT_AND_RIGHT_AXIS));
  Targeting targeting = new Targeting(limelight, driveTrain);
  DoNotDrive doNotDrive = new DoNotDrive(driveTrain);
  DriveForCertainDistance offTarmac = new DriveForCertainDistance(driveTrain, Constants.WANTED_AUTO_DISTANCE);
  ChooseLimelightMode limelightModeOn = new ChooseLimelightMode(limelight, LimelightMode.forceOn);
  ChooseLimelightMode limelightModeOff = new ChooseLimelightMode(limelight, LimelightMode.forceOff);
  Command taxiAndShoot = (new DriveForCertainDistance(driveTrain, Constants.WANTED_AUTO_DISTANCE))
      .alongWith((new MoveBallFromFeed(tunnelSub)), (new FeederIn(feederSub)))
      .andThen((new SetFlySpeed(shooterSystem)))
      .andThen(new WaitForFlyWheelSpeed(shooterSystem, limelight))
      .andThen(new MoveBalltoShooter(tunnelSub))
      .andThen((new WaitForBallToLeaveBot()))
      .andThen(new WaitForFlyWheelSpeed(shooterSystem, limelight))
      .andThen(new MoveBalltoShooter(tunnelSub))
      .alongWith((new WaitForBallToLeaveBot()))
      .andThen((new TunnelStop(tunnelSub)))
      .andThen(new StopFlyWheel(shooterSystem));
  Command shootWithTargeting = (new Targeting(limelight, driveTrain))
      .andThen(new WaitForBallToLeaveBot());
  Command dance = (new DriveForCertainDistance(driveTrain, Constants.DANCE_DRIVE_DISTANCE))
      .andThen(new Spin(driveTrain, Constants.DANCE_SPIN))
      .alongWith(new DanceVerticalHooks(verticalHooks, Constants.DANCE_VERTICAL_HOOK_DISTANCE),
          (new DanceAngledHooks(angledHooks, Constants.DANCE_ANGLED_HOOK_DISTANCE)))
      .andThen(new Targeting(limelight, driveTrain));
  Command autoShoot = (new Targeting(limelight, driveTrain))
      .andThen(new SetFlySpeed(shooterSystem))
      .alongWith(new WaitForFlyWheelSpeed(shooterSystem, limelight))
      .alongWith(new WaitForBallToLeaveBot())
      .alongWith(new MoveBallFromFeed(tunnelSub));
  Command fourBallAuto = taxiAndShoot
      .andThen(new Spin(driveTrain, Constants.FOUR_BALL_AUTO_DEGREES))
      .andThen(new DriveForCertainDistance(driveTrain, Constants.WANTED_DISTANCE_FOR_FOUR_BALL_AUTO))
      .alongWith(new FeederIn(feederSub))
      .andThen(new MoveBallFromFeed(tunnelSub))
      .andThen(new FeederIn(feederSub))
      .andThen(new Targeting(limelight, driveTrain))
      .andThen(new SetFlySpeed(shooterSystem))
      .andThen(new WaitForFlyWheelSpeed(shooterSystem, limelight))
      .andThen(new MoveBalltoShooter(tunnelSub))
      .andThen(new WaitForBallToLeaveBot())
      .andThen(new WaitForFlyWheelSpeed(shooterSystem, limelight))
      .andThen(new MoveBalltoShooter(tunnelSub))
      .andThen(new WaitForBallToLeaveBot())
      .andThen(new StopFlyWheel(shooterSystem))
      .alongWith(new TunnelStop(tunnelSub));
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

  // other
  private final SendableChooser<Command> m_chooser = new SendableChooser<>();

  public RobotContainer() {
    configureButtonBindings();
    begin();
    // driveTrain.setDefaultCommand(new Drive(driveTrain, () ->
    // leftJoystick.getRawAxis(Constants.UP_AND_DOWN_AXIS), () ->
    // middleJoystick.getRawAxis(Constants.LEFT_AND_RIGHT_AXIS)));

  }

  private void configureButtonBindings() {
    targetingButton.whenHeld(new Targeting(limelight, driveTrain));
    targetingButton.whenReleased(new ChooseLimelightMode(limelight, LimelightMode.forceOff));

    shootingButton.whenHeld(new SetFlySpeed(shooterSystem), false);
    shootingButton.and(humanOverRideButton).whileActiveContinuous(new SetFlySpeed(shooterSystem));

    limelightOnButton.whenPressed(new ChooseLimelightMode(limelight, LimelightMode.forceOn));
    limelightOffButton.whenPressed(new ChooseLimelightMode(limelight, LimelightMode.forceOff));

    feederInButton.whenHeld(new FeederIn(feederSub), false);
    feederOutButton.whenHeld(new FeederOut(feederSub), false);

    tunnelInButton.whenHeld(new MoveBalltoShooter(tunnelSub), false);
    tunnelOutButton.whenHeld(new TunnelOut(tunnelSub), false);

    danceButton.and(humanOverRideButton).whileActiveContinuous(dance);

    angledOverRideButton.whenHeld(new MoveAngledHooks(angledHooks,
        () -> rightJoystick.getRawAxis(Constants.UP_AND_DOWN_AXIS)), false);
    angledOverRideButton.whenInactive(new Drive(driveTrain,
        () -> leftJoystick.getRawAxis(Constants.UP_AND_DOWN_AXIS),
        () -> middleJoystick.getRawAxis(Constants.LEFT_AND_RIGHT_AXIS)));

    verticalOverRideButton.whenHeld(new MoveVerticalHooks(verticalHooks,
        () -> middleJoystick.getRawAxis(Constants.UP_AND_DOWN_AXIS)), false);

    deathSpinButton.and(humanOverRideButton).whileActiveContinuous(new Spin(driveTrain, Constants.SPIN_BUTTON_DEGREES));
  }

  private void begin() {
    m_chooser.addOption("Auto-Do not Move", doNotDrive);
    m_chooser.setDefaultOption("Taxi and Shoot Two Balls", taxiAndShoot);
    m_chooser.addOption("Taxi", offTarmac);
    m_chooser.addOption("Four Ball Auto", fourBallAuto);
  }

  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }

}