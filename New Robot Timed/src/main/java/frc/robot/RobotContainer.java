package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.hookcommands.AngleStop;
import frc.robot.hookcommands.AngledHookJoystick;
import frc.robot.hookcommands.HookStop;
import frc.robot.hookcommands.MoveCloserToNinetyDegrees;
import frc.robot.hookcommands.MoveCloserToZeroDegrees;
import frc.robot.hookcommands.PullVertHooksIn;
import frc.robot.hookcommands.ReachVertHooksUp;
import frc.robot.simplecommands.BuildIsMean;
import frc.robot.simplecommands.DoNotMove;
import frc.robot.simplecommands.IntakeStop;
import frc.robot.simplecommands.PickLimelightMode;
import frc.robot.simplecommands.PrintBallStatus;
import frc.robot.simplecommands.ResetWheels;
//import frc.robot.simplecommands.RedFollower;
import frc.robot.simplecommands.SetFlySpeed;
import frc.robot.simplecommands.SetIntakeSpeedIn;
import frc.robot.simplecommands.SetIntakeSpeedOut;
import frc.robot.simplecommands.SetInternalMoveSpeedIn;
import frc.robot.simplecommands.SetInternalMoveSpeedOut;
import frc.robot.simplecommands.SpitBalls;
import frc.robot.simplecommands.StableHooks;
import frc.robot.simplecommands.StableIntestines;
import frc.robot.simplecommands.StopFly;
import frc.robot.simplecommands.Targeting;
import frc.robot.simplecommands.TaxiTarmac;
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
  DriveTrain vroomVroom = new DriveTrain();
  FlyAndSensors pewPew = new FlyAndSensors();
  VertHooks vertHooks = new VertHooks();
  AngleHooks angleHooks = new AngleHooks();
  Limelight vision = new Limelight();
  Tunnel tunnelSub = new Tunnel();
  Intake intakeSub = new Intake();
  // UsbCamera ballFinder = CameraServer.startAutomaticCapture();

  // ungrouped commands
  // RealizeBall realizeBall = new RealizeBall(ballFinder);
  DoNotMove doNotMove = new DoNotMove(vroomVroom, pewPew);
  AngledHookJoystick angledHookJoystick = new AngledHookJoystick(angleHooks, rightStick);
  ReachVertHooksUp reachVertHooksUp = new ReachVertHooksUp(vertHooks);
  PullVertHooksIn pullVertHooksIn = new PullVertHooksIn(vertHooks);
  MoveCloserToNinetyDegrees moveCloserToNinetyDegrees = new MoveCloserToNinetyDegrees(angleHooks);
  MoveCloserToZeroDegrees moveCloserToZeroDegrees = new MoveCloserToZeroDegrees(angleHooks);
  Targeting targeting = new Targeting(vroomVroom, vision);
  SetFlySpeed setFlySpeed = new SetFlySpeed(pewPew, midStick);
  SetIntakeSpeedIn setIntakeSpeedIn = new SetIntakeSpeedIn(intakeSub);
  SetIntakeSpeedOut setIntakeSpeedOut = new SetIntakeSpeedOut(intakeSub);
  SetInternalMoveSpeedIn setInternalMoveSpeedIn = new SetInternalMoveSpeedIn(tunnelSub);
  SetInternalMoveSpeedOut setInternalMoveSpeedOut = new SetInternalMoveSpeedOut(tunnelSub);
  SpitBalls spitBalls = new SpitBalls(intakeSub,tunnelSub);
  PickLimelightMode setLimelightModeOff = new PickLimelightMode(vision, Constants.LIMELIGHT_OFF_PIPELINE_MODE);
  PickLimelightMode setLimelightModeOn = new PickLimelightMode(vision, Constants.LIMELIGHT_FULL_ON_PIPELINE_MODE);
  StableHooks stableHooks = new StableHooks(vertHooks, angleHooks);
  StableIntestines stableIntestines = new StableIntestines(pewPew, tunnelSub, intakeSub);
  PrintBallStatus tummyCheck = new PrintBallStatus(pewPew);
  BuildIsMean meanie = new BuildIsMean(vroomVroom);
  StopFly stopFly = new StopFly(pewPew);
  IntakeStop intakeStop = new IntakeStop(intakeSub);
  TunnelStop tunnelStop = new TunnelStop(tunnelSub);
  HookStop hookStop = new HookStop(vertHooks);
  AngleStop angleStop = new AngleStop(angleHooks);

  // command groups
  Command limelightTargeting = (new PickLimelightMode(vision, Constants.LIMELIGHT_FULL_ON_PIPELINE_MODE))
      .andThen(new Targeting(vroomVroom, vision));

  RunCommand driveSticks = new RunCommand(
      () -> vroomVroom.greenLight(midStick.getRawAxis(0), (-1) * leftStick.getRawAxis(1)), vroomVroom);

  Command taxiAndShoot = (new ResetWheels(vroomVroom))
      .andThen((new TaxiTarmac(vroomVroom)
          .alongWith(new SetFlySpeed(pewPew, midStick))))
      .andThen(new Targeting(vroomVroom, vision))
      .andThen(new SetInternalMoveSpeedOut(tunnelSub))
      .andThen(new DoNotMove(vroomVroom, pewPew));
  // Command getOnFirstRung =
  // reachVertHooksUpFRGROUP.andThen(taxiTarmacFRGROUP).andThen(pullVertHooksInFRGROUP);
  // Command moveToNextRung =
  // moveCloserToZeroDegreesTNRGROUP.andThen(moveCloserToNinetyDegreesTNRGROUP)
  // .andThen(reachVertHooksUpTNRGROUP).andThen(pullVertHooksInTNRGROUP);
  Command shooting = ((new SetFlySpeed(pewPew, midStick))
      .andThen(new SetInternalMoveSpeedOut(tunnelSub)));

  Command taxi = (new ResetWheels(vroomVroom))
      .andThen(new TaxiTarmac(vroomVroom));

  // buttons
  JoystickButton overrideButton = new JoystickButton(leftStick, Constants.HUMAN_OVERRIDE_BUTTON);
  JoystickButton verticalHookUpBTN = new JoystickButton(rightStick, Constants.VERT_HOOK_UP_BUTTON);
  JoystickButton verticalHookDownBTN = new JoystickButton(rightStick, Constants.VERT_HOOK_DOWN_BUTTON);
  JoystickButton angledHookUpBTN = new JoystickButton(rightStick, Constants.ANGLE_HOOK_UP_BUTTON);
  JoystickButton angledHookDownBTN = new JoystickButton(rightStick, Constants.ANGLE_HOOK_DOWN_BUTTON);
  JoystickButton intakeInBTN = new JoystickButton(rightStick, Constants.INTAKE_IN_BUTTON);
  JoystickButton intakeOutBTN = new JoystickButton(rightStick, Constants.INTAKE_OUT_BUTTON);
  JoystickButton flywheelSpinUpBTN = new JoystickButton(rightStick, Constants.FLYWHEEL_BUTTON);
  JoystickButton internalFeederInBTN = new JoystickButton(rightStick, Constants.INTERNAL_MOVER_FORWARDS_BUTTON);
  JoystickButton internalFeederOutBTN = new JoystickButton(rightStick, Constants.INTERNAL_MOVER_BACKWARDS_BUTTON);
  JoystickButton spitBTN = new JoystickButton(leftStick, Constants.FORCE_SPIT_BUTTON);
  JoystickButton shootingBTN = new JoystickButton(rightStick, Constants.QUOTE_AUTO_UNQUOTE_SHOOTING_BUTTON);
  JoystickButton limelightOffBTN = new JoystickButton(midStick, Constants.LIMELIGHT_OFF_BUTTON);
  JoystickButton limelightOnBTN = new JoystickButton(midStick, Constants.LIMELIGHT_ON_BUTTON);
  JoystickButton limelightOnThenTargetBTN = new JoystickButton(midStick, Constants.TARGETING_LIMELIGHT_SIMULTANEOUS);
  JoystickButton tummyCheckBTN = new JoystickButton(leftStick, Constants.BALL_STATUS_BUTTON);
  JoystickButton rudeBTN = new JoystickButton(leftStick, Constants.CRUEL_BUTTON);

  // other
  private final SendableChooser<Command> m_chooser = new SendableChooser<>();

  public void initialize() {
    configureButtonBindings();
    begin();
    vroomVroom.setDefaultCommand(driveSticks);
    vertHooks.setDefaultCommand(stableHooks);
    angleHooks.setDefaultCommand(stableHooks);
    pewPew.setDefaultCommand(stableIntestines);

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
    // overrideButton.whileHeld(angledHookJoystick);
    verticalHookUpBTN.whileHeld(reachVertHooksUp);
    verticalHookDownBTN.whileHeld(pullVertHooksIn);
    angledHookUpBTN.whileHeld(moveCloserToNinetyDegrees);
    angledHookDownBTN.whileHeld(moveCloserToZeroDegrees);
    flywheelSpinUpBTN.whileHeld(setFlySpeed);
    intakeInBTN.whileHeld(setIntakeSpeedIn);
    intakeOutBTN.whileHeld(setIntakeSpeedOut);
    internalFeederInBTN.whileHeld(setInternalMoveSpeedIn);
    internalFeederOutBTN.whileHeld(setInternalMoveSpeedOut);

    verticalHookUpBTN.whenReleased(hookStop);
    verticalHookDownBTN.whenReleased(hookStop);
    angledHookUpBTN.whenReleased(angleStop);
    angledHookDownBTN.whenReleased(angleStop);
    flywheelSpinUpBTN.whenReleased(stopFly);
    intakeInBTN.whenReleased(intakeStop);
    intakeOutBTN.whenReleased(intakeStop);
    internalFeederInBTN.whenReleased(tunnelStop);
    internalFeederOutBTN.whenReleased(tunnelStop);

    spitBTN.whenHeld(spitBalls);

    limelightOffBTN.whenPressed(setLimelightModeOff);
    limelightOnBTN.whenPressed(setLimelightModeOn);

    tummyCheckBTN.whenHeld(tummyCheck);
    overrideButton.and(rudeBTN).whileActiveOnce(meanie);
    overrideButton.and(shootingBTN).whileActiveContinuous(shooting);
    limelightOnThenTargetBTN.whenHeld(limelightTargeting);

  }

  private void begin() {
    m_chooser.setDefaultOption("Default- Frozen", doNotMove);
    m_chooser.addOption("Taxi + Shoot One", taxiAndShoot);
    m_chooser.addOption("Taxi", taxi);
    SmartDashboard.putData("Auto choices", m_chooser);
    SmartDashboard.putNumber("Distance", vision.distanceToTarget());
    SmartDashboard.putNumber("Fly Speed", pewPew.getFlySpeed());
  }

  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }

}
