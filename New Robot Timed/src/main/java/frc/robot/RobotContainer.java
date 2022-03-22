package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.hookcommands.AngleStop;
import frc.robot.hookcommands.AngledHookJoystick;
import frc.robot.hookcommands.HookStop;
import frc.robot.hookcommands.MoveCloserToNinetyDegrees;
import frc.robot.hookcommands.MoveCloserToZeroDegrees;
import frc.robot.hookcommands.PullVertHooksIn;
import frc.robot.hookcommands.ReachVertHooksUp;
import frc.robot.hookcommands.ResetHooks;
import frc.robot.simplecommands.BuildIsMean;
import frc.robot.simplecommands.DoNotMove;
import frc.robot.simplecommands.InSensorCheck;
import frc.robot.simplecommands.IntakeFeeder;
import frc.robot.simplecommands.IntakeStop;
import frc.robot.simplecommands.PickLimelightMode;
import frc.robot.simplecommands.ResetWheels;
import frc.robot.simplecommands.SensorTummyStopAll;
//import frc.robot.simplecommands.RedFollower;
import frc.robot.simplecommands.SetFlySpeed;
import frc.robot.simplecommands.SetIntakeSpeedIn;
import frc.robot.simplecommands.SetIntakeSpeedOut;
import frc.robot.simplecommands.SetInternalMoveSpeedIn;
import frc.robot.simplecommands.SetInternalMoveSpeedOut;
import frc.robot.simplecommands.SpinAuto;
import frc.robot.simplecommands.SpitBalls;
import frc.robot.simplecommands.StableHooks;
import frc.robot.simplecommands.StableIntestines;
import frc.robot.simplecommands.StopFly;
import frc.robot.simplecommands.Targeting;
import frc.robot.simplecommands.TaxiOffTarmac;
import frc.robot.simplecommands.TaxiOnTarmac;
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
  DriveTrain vroomVroomSub = new DriveTrain();
  FlyAndSensors flyAndSensorsSub = new FlyAndSensors();
  VertHooks vertHooksSub = new VertHooks();
  AngleHooks angleHooksSub = new AngleHooks();
  Limelight visionSub = new Limelight();
  Tunnel tunnelSub = new Tunnel();
  Intake intakeSub = new Intake();
  // UsbCamera ballFinder = CameraServer.startAutomaticCapture();

  // ungrouped commands
  // RealizeBall realizeBall = new RealizeBall(ballFinder);
  DoNotMove doNotMove = new DoNotMove(vroomVroomSub, flyAndSensorsSub);
  AngledHookJoystick angledHookJoystick = new AngledHookJoystick(angleHooksSub, midStick, vroomVroomSub);
  ReachVertHooksUp reachVertHooksUp = new ReachVertHooksUp(vertHooksSub, rightStick);
  PullVertHooksIn pullVertHooksIn = new PullVertHooksIn(vertHooksSub, rightStick);
  MoveCloserToNinetyDegrees moveCloserToNinetyDegrees = new MoveCloserToNinetyDegrees(angleHooksSub);
  MoveCloserToZeroDegrees moveCloserToZeroDegrees = new MoveCloserToZeroDegrees(angleHooksSub);
  Targeting targeting = new Targeting(vroomVroomSub, visionSub);
  SetFlySpeed setFlySpeed = new SetFlySpeed(flyAndSensorsSub, midStick, visionSub, false, 0);
  SetIntakeSpeedIn setIntakeSpeedIn = new SetIntakeSpeedIn(intakeSub);
  SetIntakeSpeedOut setIntakeSpeedOut = new SetIntakeSpeedOut(intakeSub);
  SetInternalMoveSpeedIn setInternalMoveSpeedIn = new SetInternalMoveSpeedIn(tunnelSub);
  SetInternalMoveSpeedOut setInternalMoveSpeedOut = new SetInternalMoveSpeedOut(tunnelSub);
  SpitBalls spitBalls = new SpitBalls(intakeSub, tunnelSub);
  PickLimelightMode setLimelightModeOff = new PickLimelightMode(visionSub, Constants.LIMELIGHT_OFF_PIPELINE_MODE);
  PickLimelightMode setLimelightModeOn = new PickLimelightMode(visionSub, Constants.LIMELIGHT_FULL_ON_PIPELINE_MODE);
  StableHooks stableHooks = new StableHooks(vertHooksSub, angleHooksSub);
  StableIntestines stableIntestines = new StableIntestines(flyAndSensorsSub, tunnelSub, intakeSub);
  BuildIsMean meanie = new BuildIsMean(vroomVroomSub);
  StopFly stopFly = new StopFly(flyAndSensorsSub);
  IntakeStop intakeStop = new IntakeStop(intakeSub);
  TunnelStop tunnelStop = new TunnelStop(tunnelSub);
  HookStop hookStop = new HookStop(vertHooksSub);
  AngleStop angleStop = new AngleStop(angleHooksSub);
  ResetHooks resetHooks = new ResetHooks(angleHooksSub, vertHooksSub);
  IntakeFeeder intakeFeeder = new IntakeFeeder(intakeSub, tunnelSub, flyAndSensorsSub);

  // command groups
  Command limelightTargeting = (new PickLimelightMode(visionSub, Constants.LIMELIGHT_FULL_ON_PIPELINE_MODE))
      .andThen(new Targeting(vroomVroomSub, visionSub));

  RunCommand driveSticks = new RunCommand(
      () -> vroomVroomSub.greenLight(midStick.getRawAxis(0), (-1) * leftStick.getRawAxis(1)), vroomVroomSub);

  Command taxiAndShoot = (new ResetWheels(vroomVroomSub))
      .andThen(new TaxiOffTarmac(vroomVroomSub, 50))
      .andThen(new ResetWheels(vroomVroomSub))
      .andThen(new SpinAuto(vroomVroomSub, 180))
      .andThen(new SetFlySpeed(flyAndSensorsSub, midStick, visionSub, true, 250))
      .andThen(new Targeting(vroomVroomSub, visionSub))
      .andThen(new SetInternalMoveSpeedOut(tunnelSub))
      .andThen(new DoNotMove(vroomVroomSub, flyAndSensorsSub));

  Command shooting = (new PickLimelightMode(visionSub, Constants.LIMELIGHT_FULL_ON_PIPELINE_MODE))
      .andThen(new Targeting(vroomVroomSub, visionSub))
      .andThen(new SetFlySpeed(flyAndSensorsSub, midStick, visionSub, true, 150))
      .andThen(new SetInternalMoveSpeedOut(tunnelSub));

  Command taxiSides = (new ResetWheels(vroomVroomSub))
      .andThen(new TaxiOffTarmac(vroomVroomSub, 50));

  Command taxiMid = new ResetWheels(vroomVroomSub)
      .andThen(new TaxiOffTarmac(vroomVroomSub, 60));

  Command taxiTwoBallShootMidBall = (new ResetWheels(vroomVroomSub))
      .andThen((new SetIntakeSpeedIn(intakeSub))
          .alongWith(new TaxiOnTarmac(vroomVroomSub, 2)))
      .andThen(new ResetWheels(vroomVroomSub))
      .andThen(new TaxiOffTarmac(vroomVroomSub, 60))
      .andThen(new TimedInternalMoveIn(tunnelSub, 250))
      .andThen(new InSensorCheck(flyAndSensorsSub, true)
          .raceWith(new WaitCommand(2)))
      .andThen((new IntakeStop(intakeSub))
          .alongWith(new ResetWheels(vroomVroomSub)))
      .andThen((new SpinAuto(vroomVroomSub, 180))
          .alongWith(new TimedInternalMoveOut(tunnelSub, 100)))
      .andThen(new PickLimelightMode(visionSub, Constants.LIMELIGHT_FULL_ON_PIPELINE_MODE))
      .andThen(new Targeting(vroomVroomSub, visionSub))
      .andThen(new SetFlySpeed(flyAndSensorsSub, midStick, visionSub, true, 750))
      .andThen(new SetIntakeSpeedIn(intakeSub))
      .andThen(new TimedInternalMoveIn(tunnelSub, 700))
      .andThen(new IntakeStop(intakeSub))
      .andThen(new TimedInternalMoveOut(tunnelSub, 250))
      .andThen(new SetFlySpeed(flyAndSensorsSub, midStick, visionSub, true, 600))
      .andThen(new SetIntakeSpeedIn(intakeSub))
      .andThen(new TimedInternalMoveIn(tunnelSub, 1000))
      .andThen(new WaitCommand(1))
      .andThen(new SensorTummyStopAll(flyAndSensorsSub, tunnelSub, intakeSub))
      .andThen(new PickLimelightMode(visionSub, Constants.LIMELIGHT_OFF_PIPELINE_MODE));

  // buttons
  JoystickButton overrideButton = new JoystickButton(leftStick, Constants.HUMAN_OVERRIDE_BUTTON);
  JoystickButton verticalHookUpBTN = new JoystickButton(rightStick, Constants.VERT_HOOK_UP_BUTTON);
  JoystickButton verticalHookDownBTN = new JoystickButton(rightStick, Constants.VERT_HOOK_DOWN_BUTTON);
  // JoystickButton angledHookUpBTN = new JoystickButton(rightStick,
  // Constants.ANGLE_HOOK_UP_BUTTON);
  // JoystickButton angledHookDownBTN = new JoystickButton(rightStick,
  // Constants.ANGLE_HOOK_DOWN_BUTTON);
  JoystickButton intakeInBTN = new JoystickButton(rightStick, Constants.INTAKE_IN_BUTTON);
  JoystickButton intakeOutBTN = new JoystickButton(rightStick, Constants.INTAKE_OUT_BUTTON);
  JoystickButton flywheelSpinUpBTN = new JoystickButton(rightStick, Constants.FLYWHEEL_BUTTON);
  JoystickButton internalFeederInBTN = new JoystickButton(rightStick, Constants.INTERNAL_MOVER_FORWARDS_BUTTON);
  JoystickButton internalFeederOutBTN = new JoystickButton(rightStick, Constants.INTERNAL_MOVER_BACKWARDS_BUTTON);
  JoystickButton spitBTN = new JoystickButton(rightStick, Constants.FORCE_SPIT_BUTTON);
  JoystickButton shootingBTN = new JoystickButton(rightStick, Constants.QUOTE_AUTO_UNQUOTE_SHOOTING_BUTTON);
  JoystickButton limelightOffBTN = new JoystickButton(midStick, Constants.LIMELIGHT_OFF_BUTTON);
  JoystickButton limelightOnBTN = new JoystickButton(midStick, Constants.LIMELIGHT_ON_BUTTON);
  JoystickButton limelightOnThenTargetBTN = new JoystickButton(midStick, Constants.TARGETING_LIMELIGHT_SIMULTANEOUS);
  JoystickButton rudeBTN = new JoystickButton(leftStick, Constants.CRUEL_BUTTON);
  JoystickButton angleJoystickButton = new JoystickButton(midStick, Constants.ANGLE_JOYSTICK_BUTTON);

  // other
  private final SendableChooser<Command> m_chooser = new SendableChooser<>();

  public void initialize() {
    configureButtonBindings();
    begin();
    vroomVroomSub.setDefaultCommand(driveSticks);
    vertHooksSub.setDefaultCommand(stableHooks);
    angleHooksSub.setDefaultCommand(stableHooks);
    flyAndSensorsSub.setDefaultCommand(stableIntestines);
    resetHooks.execute();

    CommandScheduler.getInstance().onCommandExecute((command) -> {
      if (!command.getName().equals("RunCommand") && !command.getName().equals("StableHooks")
          && !command.getName().equals("StableIntestines")) {
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
    verticalHookUpBTN.whileHeld(reachVertHooksUp);
    verticalHookDownBTN.whileHeld(pullVertHooksIn);
    // angledHookUpBTN.whileHeld(moveCloserToNinetyDegrees);
    // angledHookDownBTN.whileHeld(moveCloserToZeroDegrees);
    flywheelSpinUpBTN.whileHeld(setFlySpeed);
    intakeInBTN.whileHeld(intakeFeeder);
    intakeOutBTN.whileHeld(setIntakeSpeedOut);
    internalFeederInBTN.whileHeld(setInternalMoveSpeedIn);
    internalFeederOutBTN.whileHeld(setInternalMoveSpeedOut);
    limelightOnThenTargetBTN.whileHeld(limelightTargeting);
    spitBTN.whenHeld(spitBalls);

    angleJoystickButton.whenReleased(angleStop);
    verticalHookUpBTN.whenReleased(hookStop);
    verticalHookDownBTN.whenReleased(hookStop);
    // angledHookUpBTN.whenReleased(angleStop);
    // angledHookDownBTN.whenReleased(angleStop);
    flywheelSpinUpBTN.whenReleased(stopFly);
    intakeInBTN.whenReleased(intakeStop);
    intakeOutBTN.whenReleased(intakeStop);
    internalFeederInBTN.whenReleased(tunnelStop);
    internalFeederOutBTN.whenReleased(tunnelStop);
    limelightOnThenTargetBTN.whenReleased(setLimelightModeOff);

    limelightOffBTN.whenPressed(setLimelightModeOff);
    limelightOnBTN.whenPressed(setLimelightModeOn);
    overrideButton.and(rudeBTN).whileActiveOnce(meanie);
    shootingBTN.whileHeld(shooting);

  }

  private void begin() {
    m_chooser.setDefaultOption("Default- Frozen", doNotMove);
    m_chooser.addOption("Only Taxi (R/L)", taxiSides);
    m_chooser.addOption("Only Taxi (Mid)", taxiMid);
    m_chooser.addOption("Taxi + Shoot One (R/M/L)", taxiAndShoot);
    m_chooser.addOption("Two Ball Auto (R/M/L)", taxiTwoBallShootMidBall);
    SmartDashboard.putData("Auto choices", m_chooser);

  }

  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }

}
