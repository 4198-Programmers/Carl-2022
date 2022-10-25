package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.CvSink;
import edu.wpi.first.cscore.CvSource;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.RunCommand;
//import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.hookcommands.AngleStop;
import frc.robot.hookcommands.AngledHookJoystick;
import frc.robot.hookcommands.AutoAngleHooksIn;
import frc.robot.hookcommands.HookStop;
import frc.robot.hookcommands.MoveCloserToNinetyDegrees;
import frc.robot.hookcommands.MoveCloserToZeroDegrees;
import frc.robot.hookcommands.PullVertHooksIn;
import frc.robot.hookcommands.ReachVertHooksUp;
import frc.robot.hookcommands.ResetHooks;
import frc.robot.hookcommands.VertHookJoystick;
import frc.robot.simplecommands.DoNotMove;
import frc.robot.simplecommands.InSensorCheck;
import frc.robot.simplecommands.IntakeFeeder;
import frc.robot.simplecommands.IntakeStop;
import frc.robot.simplecommands.LowLoft;
// import frc.robot.simplecommands.OutSensorCheck;
import frc.robot.simplecommands.PickLimelightMode;
import frc.robot.simplecommands.ResetWheels;
import frc.robot.simplecommands.SensorStopInternals;
//import frc.robot.simplecommands.RedFollower;
import frc.robot.simplecommands.SetFlySpeed;
import frc.robot.simplecommands.SetIntakeSpeedIn;
import frc.robot.simplecommands.SetIntakeSpeedOut;
import frc.robot.simplecommands.SetInternalMoveSpeedIn;
import frc.robot.simplecommands.SetInternalMoveSpeedOut;
import frc.robot.simplecommands.Spin;
import frc.robot.simplecommands.AutoSpinLeft;
import frc.robot.simplecommands.AutoSpinRight;
import frc.robot.simplecommands.SpitBalls;
import frc.robot.simplecommands.StableHooks;
import frc.robot.simplecommands.StableInternals;
import frc.robot.simplecommands.StopFly;
import frc.robot.simplecommands.Targeting;
import frc.robot.simplecommands.AutoForwards;
import frc.robot.simplecommands.AutoBackwards;
import frc.robot.simplecommands.AutoCurveCarver;
import frc.robot.simplecommands.TimedInternalMoveIn;
import frc.robot.simplecommands.TimedInternalMoveOut;
import frc.robot.simplecommands.TunnelStop;
import frc.robot.subsystems.AngleHooks;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.VertHooks;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Tunnel;
import frc.robot.subsystems.FlyAndSensors;
import frc.robot.subsystems.Intake;

public class RobotContainer {
  Joystick leftStick = new Joystick(Constants.LEFT_STICK_PORT);
  Joystick midStick = new Joystick(Constants.MID_STICK_PORT);
  Joystick rightStick = new Joystick(Constants.RIGHT_STICK_PORT);

  // subsystems
  DriveTrain driveTrainSub = new DriveTrain();
  FlyAndSensors flyAndSensorsSub = new FlyAndSensors();
  VertHooks vertHooksSub = new VertHooks();
  AngleHooks angleHooksSub = new AngleHooks();
  Limelight limelightSub = new Limelight();
  Tunnel tunnelSub = new Tunnel();
  Intake intakeSub = new Intake();

  UsbCamera floorCamera = CameraServer.startAutomaticCapture();
  CvSink cvSink = CameraServer.getVideo();
  CvSource stream = CameraServer.putVideo("Intake View", 1280, 720);

  // ungrouped commands
  // RealizeBall realizeBall = new RealizeBall(floorCamera);
  DoNotMove doNotMove = new DoNotMove(driveTrainSub, flyAndSensorsSub);
  StableHooks stableHooks = new StableHooks(vertHooksSub, angleHooksSub);
  StableInternals StableInternals = new StableInternals(flyAndSensorsSub, tunnelSub, intakeSub);
  StopFly stopFly = new StopFly(flyAndSensorsSub);
  HookStop hookStop = new HookStop(vertHooksSub);
  AngleStop angleStop = new AngleStop(angleHooksSub);
  TunnelStop tunnelStop = new TunnelStop(tunnelSub);
  IntakeStop intakeStop = new IntakeStop(intakeSub);
  AngledHookJoystick angledHookJoystick = new AngledHookJoystick(angleHooksSub, midStick, driveTrainSub);
  VertHookJoystick vertHookJoystick = new VertHookJoystick(vertHooksSub, rightStick);
  ReachVertHooksUp reachVertHooksUp = new ReachVertHooksUp(vertHooksSub, rightStick);
  PullVertHooksIn pullVertHooksIn = new PullVertHooksIn(vertHooksSub, rightStick);
  MoveCloserToNinetyDegrees moveCloserToNinetyDegrees = new MoveCloserToNinetyDegrees(angleHooksSub);
  MoveCloserToZeroDegrees moveCloserToZeroDegrees = new MoveCloserToZeroDegrees(angleHooksSub);
  SetFlySpeed setFlySpeed = new SetFlySpeed(flyAndSensorsSub, limelightSub, false, 0, midStick);
  SetIntakeSpeedIn setIntakeSpeedIn = new SetIntakeSpeedIn(intakeSub);
  SetIntakeSpeedOut setIntakeSpeedOut = new SetIntakeSpeedOut(intakeSub);
  SetInternalMoveSpeedIn setInternalMoveSpeedIn = new SetInternalMoveSpeedIn(tunnelSub);
  SetInternalMoveSpeedOut setInternalMoveSpeedOut = new SetInternalMoveSpeedOut(tunnelSub);
  IntakeFeeder intakeFeeder = new IntakeFeeder(intakeSub, tunnelSub, flyAndSensorsSub);
  PickLimelightMode setLimelightModeOff = new PickLimelightMode(limelightSub, Constants.LIMELIGHT_OFF_PIPELINE_MODE);
  PickLimelightMode setLimelightModeOn = new PickLimelightMode(limelightSub,
      Constants.LIMELIGHT_FULL_ON_PIPELINE_MODE);
  ResetHooks resetHooks = new ResetHooks(angleHooksSub, vertHooksSub);
  LowLoft lowLoft = new LowLoft(flyAndSensorsSub);
  Targeting targeting = new Targeting(driveTrainSub, limelightSub);
  SpitBalls spitBalls = new SpitBalls(intakeSub, tunnelSub);
  
  // command groups
  Command limelightTargeting = (new Targeting(driveTrainSub, limelightSub))
      .andThen(new WaitCommand(1))
      .andThen(new PickLimelightMode(limelightSub, Constants.LIMELIGHT_FULL_ON_PIPELINE_MODE));

  RunCommand driveSticks = new RunCommand(
      () -> driveTrainSub.greenLight(midStick.getRawAxis(0), (-1) * leftStick.getRawAxis(1)),
      driveTrainSub);

  Command taxiSides = (new ResetWheels(driveTrainSub))
      .andThen(new AutoForwards(driveTrainSub, 50));

  Command shooting = new SetFlySpeed(flyAndSensorsSub, limelightSub, true, 500, midStick)
      .andThen(new SetInternalMoveSpeedIn(tunnelSub))
      .andThen(new SetFlySpeed(flyAndSensorsSub, limelightSub, true, 250, midStick))
      .andThen(new TunnelStop(tunnelSub))
      .andThen(new SetFlySpeed(flyAndSensorsSub, limelightSub, true, 500, midStick))
      .andThen(new SetInternalMoveSpeedIn(tunnelSub));

  Command midBallRightMacFourBall = (new ResetWheels(driveTrainSub))
      .andThen((new SetIntakeSpeedIn(intakeSub))
          .alongWith(new AutoBackwards(driveTrainSub, 2)))
      .andThen(new ResetWheels(driveTrainSub))
      .andThen(new AutoForwards(driveTrainSub, 45))
      .andThen(new TimedInternalMoveIn(tunnelSub, 250))
      .andThen(new InSensorCheck(flyAndSensorsSub, true)
          .raceWith(new WaitCommand(2)))
      .andThen((new IntakeStop(intakeSub))
          .alongWith(new ResetWheels(driveTrainSub)))
      .andThen((new AutoSpinLeft(driveTrainSub, 120))
          .alongWith(new TimedInternalMoveOut(tunnelSub, 100)))
      .andThen(new ResetWheels(driveTrainSub))
      .andThen(new AutoCurveCarver(driveTrainSub, 75, 125))
      .andThen(new ResetWheels(driveTrainSub))
      .andThen(new AutoForwards(driveTrainSub, 11))
      .andThen(new SetFlySpeed(flyAndSensorsSub, limelightSub, true, 750, midStick))
      .andThen(new SetIntakeSpeedIn(intakeSub))
      .andThen(new TimedInternalMoveIn(tunnelSub, 700))
      .andThen(new IntakeStop(intakeSub))
      .andThen(new TimedInternalMoveOut(tunnelSub, 250))
      .andThen(new SetFlySpeed(flyAndSensorsSub, limelightSub, true, 600, midStick))
      .andThen(new SetIntakeSpeedIn(intakeSub))
      .andThen(new TimedInternalMoveIn(tunnelSub, 1000))
      .andThen(new WaitCommand(1))
      .andThen(new SensorStopInternals(flyAndSensorsSub, tunnelSub, intakeSub))
      .andThen(new PickLimelightMode(limelightSub, Constants.LIMELIGHT_OFF_PIPELINE_MODE))
      .andThen(new ResetWheels(driveTrainSub))
      .andThen(new AutoBackwards(driveTrainSub, 15))
      .andThen(new ResetWheels(driveTrainSub))
      .andThen(new AutoSpinLeft(driveTrainSub, 90))
      .andThen(new ResetWheels(driveTrainSub))
      .andThen(new AutoForwards(driveTrainSub, 80));

  Command rightBallRightMacFourBall = (new ResetWheels(driveTrainSub))
      .andThen((new SetIntakeSpeedIn(intakeSub))
          .alongWith(new AutoBackwards(driveTrainSub, 2)))
      .andThen(new ResetWheels(driveTrainSub))
      .andThen(new AutoForwards(driveTrainSub, 45))
      .andThen(new TimedInternalMoveIn(tunnelSub, 250))
      .andThen((new InSensorCheck(flyAndSensorsSub, true))
          .raceWith(new WaitCommand(2)))
      .andThen(new IntakeStop(intakeSub))
      .andThen(new ResetWheels(driveTrainSub))
      .andThen(new Spin(driveTrainSub, 145))
      .andThen(new Targeting(driveTrainSub, limelightSub))
      .andThen(new ResetWheels(driveTrainSub))
      .andThen((new AutoForwards(driveTrainSub, 73))
          .alongWith(new PickLimelightMode(limelightSub,
              Constants.LIMELIGHT_OFF_PIPELINE_MODE)))
      .andThen(new SetFlySpeed(flyAndSensorsSub, limelightSub, true, 750, midStick))
      .andThen(new TimedInternalMoveIn(tunnelSub, 700))
      .andThen(new TimedInternalMoveOut(tunnelSub, 250))
      .andThen(new SetFlySpeed(flyAndSensorsSub, limelightSub, true, 750, midStick))
      .andThen(new TimedInternalMoveIn(tunnelSub, 700))
      .andThen(new WaitCommand(1))
      .andThen(new SensorStopInternals(flyAndSensorsSub, tunnelSub, intakeSub))
      .andThen(new ResetWheels(driveTrainSub))
      .andThen(new AutoBackwards(driveTrainSub, 15))
      .andThen(new ResetWheels(driveTrainSub))
      .andThen(new AutoSpinLeft(driveTrainSub, 90))
      .andThen(new ResetWheels(driveTrainSub))
      .andThen(new AutoForwards(driveTrainSub, 80));

  Command leftBallLeftMacFourBall = (new ResetWheels(driveTrainSub))
      .andThen((new SetIntakeSpeedIn(intakeSub))
          .alongWith(new AutoBackwards(driveTrainSub, 2)))
      .andThen(new ResetWheels(driveTrainSub))
      .andThen(new AutoForwards(driveTrainSub, 45))
      .andThen(new TimedInternalMoveIn(tunnelSub, 250))
      .andThen((new InSensorCheck(flyAndSensorsSub, true))
          .raceWith(new WaitCommand(2)))
      .andThen(new IntakeStop(intakeSub))
      .andThen(new ResetWheels(driveTrainSub))
      .andThen(new Spin(driveTrainSub, 145))
      .andThen(new Targeting(driveTrainSub, limelightSub))
      .andThen(new ResetWheels(driveTrainSub))
      .andThen((new AutoForwards(driveTrainSub, 73))
          .alongWith(new PickLimelightMode(limelightSub,
              Constants.LIMELIGHT_OFF_PIPELINE_MODE)))
      .andThen(new SetFlySpeed(flyAndSensorsSub, limelightSub, true, 750, midStick))
      .andThen(new TimedInternalMoveIn(tunnelSub, 700))
      .andThen(new SetFlySpeed(flyAndSensorsSub, limelightSub, true, 500, midStick))
      .andThen(new TimedInternalMoveOut(tunnelSub, 250))
      .andThen(new TimedInternalMoveIn(tunnelSub, 700))
      .andThen(new WaitCommand(1))
      .andThen(new SensorStopInternals(flyAndSensorsSub, tunnelSub, intakeSub))
      .andThen(new ResetWheels(driveTrainSub))
      .andThen(new AutoBackwards(driveTrainSub, 15))
      .andThen(new ResetWheels(driveTrainSub))
      .andThen(new AutoSpinRight(driveTrainSub, 120))
      .andThen(new ResetWheels(driveTrainSub))
      .andThen(new AutoForwards(driveTrainSub, 100));

  Command rightLeftBallShoot = (new ResetWheels(driveTrainSub))
      .andThen((new SetIntakeSpeedIn(intakeSub))
          .alongWith(new AutoBackwards(driveTrainSub, 2)))
      .andThen(new ResetWheels(driveTrainSub))
      .andThen(new AutoForwards(driveTrainSub, 48))
      .andThen(new TimedInternalMoveIn(tunnelSub, 250))
      .andThen((new InSensorCheck(flyAndSensorsSub, true))
          .raceWith(new WaitCommand(2)))
      .andThen(new IntakeStop(intakeSub))
      .andThen(new ResetWheels(driveTrainSub))
      .andThen(new Spin(driveTrainSub, 145))
      .andThen(new Targeting(driveTrainSub, limelightSub))
      .andThen(new ResetWheels(driveTrainSub))
      .andThen((new AutoForwards(driveTrainSub, 73))
          .alongWith(new PickLimelightMode(limelightSub, Constants.LIMELIGHT_OFF_PIPELINE_MODE)))
      .andThen(new SetFlySpeed(flyAndSensorsSub, limelightSub, true, 750, midStick))
      .andThen(new TimedInternalMoveIn(tunnelSub, 700))
      .andThen(new SetFlySpeed(flyAndSensorsSub, limelightSub, true, 500, midStick))
      .andThen(new TimedInternalMoveOut(tunnelSub, 250))
      .andThen(new TimedInternalMoveIn(tunnelSub, 700))
      .andThen(new WaitCommand(1))
      .andThen(new SensorStopInternals(flyAndSensorsSub, tunnelSub, intakeSub));

  Command taxiTwoBallShootMidBall = (new ResetWheels(driveTrainSub))
      .andThen((new SetIntakeSpeedIn(intakeSub))
          .alongWith(new AutoBackwards(driveTrainSub, 2)))
      .andThen(new ResetWheels(driveTrainSub))
      .andThen(new AutoForwards(driveTrainSub, 45))
      .andThen(new TimedInternalMoveIn(tunnelSub, 250))
      .andThen(new InSensorCheck(flyAndSensorsSub, true)
          .raceWith(new WaitCommand(2)))
      .andThen((new IntakeStop(intakeSub))
          .alongWith(new ResetWheels(driveTrainSub)))
      .andThen((new AutoSpinLeft(driveTrainSub, 120))
          .alongWith(new TimedInternalMoveOut(tunnelSub, 100)))
      .andThen(new ResetWheels(driveTrainSub))
      .andThen(new AutoCurveCarver(driveTrainSub, 75, 125))
      .andThen(new ResetWheels(driveTrainSub))
      .andThen(new AutoForwards(driveTrainSub, 11))
      .andThen(new SetFlySpeed(flyAndSensorsSub, limelightSub, true, 750, midStick))
      .andThen(new SetIntakeSpeedIn(intakeSub))
      .andThen(new TimedInternalMoveIn(tunnelSub, 700))
      .andThen(new IntakeStop(intakeSub))
      .andThen(new TimedInternalMoveOut(tunnelSub, 250))
      .andThen(new SetFlySpeed(flyAndSensorsSub, limelightSub, true, 600, midStick))
      .andThen(new SetIntakeSpeedIn(intakeSub))
      .andThen(new TimedInternalMoveIn(tunnelSub, 1000))
      .andThen(new WaitCommand(1))
      .andThen(new SensorStopInternals(flyAndSensorsSub, tunnelSub, intakeSub))
      .andThen(new PickLimelightMode(limelightSub, Constants.LIMELIGHT_OFF_PIPELINE_MODE));

Command autoClimb = (new AutoVertHooksOut(angleHooksSub, Constants.VERT_HOOK_UPPER_LIMIT)
)

  // Command taxiFourBall = (new ResetWheels(driveTrainSub))
  // .andThen((new SetIntakeSpeedIn(intakeSub))
  // .alongWith(new AutoBackwards(driveTrainSub, 2)))
  // .andThen(new ResetWheels(driveTrainSub))
  // .andThen((new AutoForwards(driveTrainSub, 60))
  // .alongWith(new TimedInternalMoveIn(tunnelSub, 250)))
  // .andThen(new InSensorCheck(flyAndSensorsSub, true)
  // .raceWith(new WaitCommand(2)))
  // .andThen((new IntakeStop(intakeSub))
  // .alongWith(new ResetWheels(driveTrainSub)))
  // .andThen((new AutoSpinRight(driveTrainSub, 180))
  // .alongWith(new TimedInternalMoveOut(tunnelSub, 100)))
  // .andThen(new PickLimelightMode(limelightSub,
  // Constants.LIMELIGHT_FULL_ON_PIPELINE_MODE))
  // .andThen(new Targeting(driveTrainSub, limelightSub))
  // .andThen(new SetFlySpeed(flyAndSensorsSub, limelightSub, true, 750, midStick))
  // .andThen(new SetIntakeSpeedIn(intakeSub))
  // .andThen(new TimedInternalMoveIn(tunnelSub, 700))
  // .andThen(new IntakeStop(intakeSub))
  // .andThen(new TimedInternalMoveOut(tunnelSub, 250))
  // .andThen(new SetFlySpeed(flyAndSensorsSub, limelightSub, true, 600, midStick))
  // .andThen(new SetIntakeSpeedIn(intakeSub))
  // .andThen(new TimedInternalMoveIn(tunnelSub, 1000))
  // .andThen(new WaitCommand(1))
  // .andThen(new SensorTummyStopAll(flyAndSensorsSub, tunnelSub, intakeSub))
  // .andThen(new PickLimelightMode(limelightSub,
  // Constants.LIMELIGHT_OFF_PIPELINE_MODE))
  // .andThen(new ResetWheels(driveTrainSub))
  // .andThen(new AutoSpinLeft(driveTrainSub, 155))
  // .andThen(new ResetWheels(driveTrainSub))
  // .andThen((new AutoForwardsFast(driveTrainSub, 140))
  // .alongWith((new SetIntakeSpeedIn(intakeSub))
  // .andThen(new InSensorCheck(flyAndSensorsSub, true))
  // .andThen(new SetInternalMoveSpeedIn(tunnelSub))
  // .andThen(new InSensorCheck(flyAndSensorsSub, false))
  // .andThen(new TunnelStop(tunnelSub))))
  // .andThen((new WaitCommand(10)));
  //
  // buttons
  JoystickButton overrideButton = new JoystickButton(leftStick, Constants.HUMAN_OVERRIDE_LBUTTON);
  JoystickButton verticalHookUpBTN = new JoystickButton(rightStick, Constants.VERT_HOOK_UP_RBUTTON);
  JoystickButton verticalHookDownBTN = new JoystickButton(rightStick, Constants.VERT_HOOK_DOWN_RBUTTON);
  JoystickButton intakeInBTN = new JoystickButton(rightStick, Constants.INTAKE_IN_RBUTTON);
  JoystickButton intakeOutBTN = new JoystickButton(rightStick, Constants.INTAKE_OUT_RBUTTON);
  JoystickButton flywheelSpinUpBTN = new JoystickButton(rightStick, Constants.FLYWHEEL_RBUTTON);
  JoystickButton internalFeederInBTN = new JoystickButton(rightStick, Constants.INTERNAL_MOVER_FORWARDS_RBUTTON);
  JoystickButton internalFeederOutBTN = new JoystickButton(rightStick,
      Constants.INTERNAL_MOVER_BACKWARDS_RBUTTON);
  JoystickButton spitBTN = new JoystickButton(rightStick, Constants.FORCE_SPIT_RBUTTON);
  JoystickButton shootingBTN = new JoystickButton(rightStick, Constants.QUOTE_AUTO_UNQUOTE_SHOOTING_RBUTTON);
  JoystickButton limelightOffBTN = new JoystickButton(midStick, Constants.LIMELIGHT_OFF_MBUTTON);
  JoystickButton limelightOnBTN = new JoystickButton(midStick, Constants.LIMELIGHT_ON_MBUTTON);
  JoystickButton limelightOnThenTargetBTN = new JoystickButton(midStick,
      Constants.TARGETING_LIMELIGHT_SIMULTANEOUSM);
  JoystickButton angleJoystickButton = new JoystickButton(midStick, Constants.ANGLE_JOYSTICK_MBUTTON);

  // other
  private final SendableChooser<Command> m_chooser = new SendableChooser<>();

  public void initialize() {
    configureButtonBindings();
    begin();
    driveTrainSub.setDefaultCommand(driveSticks);
    vertHooksSub.setDefaultCommand(stableHooks);
    angleHooksSub.setDefaultCommand(stableHooks);
    flyAndSensorsSub.setDefaultCommand(StableInternals);
    resetHooks.execute();

    CommandScheduler.getInstance().onCommandExecute((command) -> {
      if (!command.getName().equals("RunCommand") && !command.getName().equals("StableHooks")
          && !command.getName().equals("StableInternals")) {
        System.out.println("running command " + command.getName());
      }
    });
    CommandScheduler.getInstance().onCommandFinish((command) -> {
      System.out.println("finished command " + command.getName());
    });
    CommandScheduler.getInstance().onCommandInterrupt((command) -> {
      System.out.println("interrupted command " + command.getName());
    });
  }

  private void configureButtonBindings() {
    angleJoystickButton.whenHeld(angledHookJoystick, false);
    angleJoystickButton.whenInactive(driveSticks);
    // verticalHookUpBTN.whileHeld(vertHookJoystick, false);
    // verticalHookDownBTN.whileHeld();
    flywheelSpinUpBTN.whileHeld(setFlySpeed);
    // flywheelSpinUpBTN.whenHeld(shooting);
    intakeInBTN.whileHeld(intakeFeeder);
    intakeOutBTN.whileHeld(setIntakeSpeedOut);
    internalFeederInBTN.whileHeld(setInternalMoveSpeedIn);
    internalFeederOutBTN.whileHeld(setInternalMoveSpeedOut);
    limelightOnThenTargetBTN.whenHeld(limelightTargeting);
    spitBTN.whileHeld(spitBalls);
    shootingBTN.whileHeld(vertHookJoystick, false);

    angleJoystickButton.whenReleased(angleStop);
    shootingBTN.whenReleased(hookStop);
    // verticalHookDownBTN.whenReleased(hookStop);
    flywheelSpinUpBTN.whenReleased(stopFly);
    intakeInBTN.whenReleased(intakeStop);
    intakeOutBTN.whenReleased(intakeStop);
    internalFeederInBTN.whenReleased(tunnelStop);
    internalFeederOutBTN.whenReleased(tunnelStop);
    limelightOnThenTargetBTN.whenReleased(setLimelightModeOff);

    limelightOffBTN.whenPressed(setLimelightModeOff);
    limelightOnBTN.whenPressed(setLimelightModeOn);
  }

  private void begin() {
    // m_chooser.setDefaultOption("Default- Frozen", doNotMove);
    m_chooser.addOption("Only Taxi (R/M/L)", taxiSides);
    m_chooser.addOption("Two Ball Auto (M)", taxiTwoBallShootMidBall);
    // m_chooser.addOption("Four Ball", taxiFourBall);
    m_chooser.setDefaultOption("Two Ball Auto (R/L)", rightLeftBallShoot);
    m_chooser.addOption("Four Ball Auto (L)", leftBallLeftMacFourBall);
    m_chooser.addOption("Four Ball Auto (M)", midBallRightMacFourBall);
    m_chooser.addOption("Four Ball Auto (R)", rightBallRightMacFourBall);
    Shuffleboard.getTab("User Access").add("Auto", m_chooser);
  }

  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }

}
