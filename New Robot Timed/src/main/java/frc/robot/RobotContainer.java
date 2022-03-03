package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ChooseLimelightMode;
import frc.robot.commands.Dance;
import frc.robot.commands.DeathSpin;
import frc.robot.commands.DoNotMove;
import frc.robot.commands.Drive;
import frc.robot.commands.ManualClimb;
// import frc.robot.commands.FeederMotor;
import frc.robot.commands.OffTarmac;
import frc.robot.commands.ResetDriveTrainPosition;
//import frc.robot.commands.ShootingCommands.SetInternalMoveSpeed;
//import frc.robot.commands.ShootingCommands.SpinUpFlyWheel;
import frc.robot.commands.ShootingCommands.Targeting;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Hooks;
//import frc.robot.subsystems.Hooks;
import frc.robot.subsystems.Limelight;
//import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Limelight.LimelightMode;

public class RobotContainer {
  Joystick leftStick = new Joystick(Constants.LEFT_STICK_PORT_ID);
  Joystick midStick = new Joystick(Constants.MID_STICK_PORT_ID);
  Joystick rightStick = new Joystick(Constants.RIGHT_STICK_PORT_ID);
  DriveTrain vroomVroom = new DriveTrain();
  Limelight vision = new Limelight();
  Hooks hooks = new Hooks();
  ManualClimb manualClimb = new ManualClimb(rightStick, rightStick, hooks);
  //Shooter shooter = new Shooter();
//  SpinUpFlyWheel spinUpFlyWheel =  new SpinUpFlyWheel(shooter);
//SpinUpFlyWheel spinUpFlyWheelTAS = new SpinUpFlyWheel(shooter);
//  SetInternalMoveSpeed setInternalMoveSpeed = new SetInternalMoveSpeed(shooter);
//SetInternalMoveSpeed setInternalMoveSpeedTAS = new SetInternalMoveSpeed(shooter);
//  FeederMotor feederMotor = new FeederMotor(shooter);
  ResetDriveTrainPosition resetDriveTrainPositionAuto = new ResetDriveTrainPosition(vroomVroom);
  ResetDriveTrainPosition resetDriveTrainPositionTAS = new ResetDriveTrainPosition(vroomVroom);
  ResetDriveTrainPosition resetDriveTrainPositionTAT = new ResetDriveTrainPosition(vroomVroom);
  DoNotMove doNotMoveTAS = new DoNotMove(vroomVroom);
  OffTarmac offTarmacAuto = new OffTarmac(vroomVroom);
  OffTarmac offTarmacTAS = new OffTarmac(vroomVroom);
  OffTarmac offTarmacTAT = new OffTarmac(vroomVroom);
  DeathSpin deathSpin = new DeathSpin(vroomVroom);
  //Command shoot = targetingS.alongWith(spinUpFlyWheel).andThen(setInternalMoveSpeed);
  ChooseLimelightMode turnLimelightLedModeOn = new ChooseLimelightMode(vision, LimelightMode.forceOn);
  ChooseLimelightMode turnLimelightLedModeOff = new ChooseLimelightMode(vision, LimelightMode.forceOff);
  Targeting targeting = new Targeting(vroomVroom, vision);
  Targeting targetingS = new Targeting(vroomVroom, vision);
  Targeting targetingTAT = new Targeting(vroomVroom, vision);
  Dance dance = new Dance(hooks);
  Command taxi = resetDriveTrainPositionAuto.andThen(offTarmacAuto);
  Command taxiandTarget = resetDriveTrainPositionTAT.andThen(offTarmacTAT).andThen(targetingTAT);
  //Command taxiAndShoot = resetDriveTrainPositionTAS.andThen(offTarmacTAS).alongWith(spinUpFlyWheelTAS).andThen(setInternalMoveSpeedTAS).andThen(doNotMoveTAS);
  //Drive drive = new Drive(leftStick.getRawAxis(1), midStick.getRawAxis(0), vroomVroom);
  ResetDriveTrainPosition resetDriveTrainPosition = new ResetDriveTrainPosition(vroomVroom);
  JoystickButton turnLimelightOnButton = new JoystickButton(rightStick, Constants.TURN_LIMELIGHT_ON_BUTTON);
  JoystickButton turnLimelightOffButton = new JoystickButton(rightStick, Constants.TURN_LIMELIGHT_OFF_BUTTON);
  JoystickButton targetTheHoop = new JoystickButton(rightStick, Constants.TARGET_BUTTON);
  JoystickButton turnLimeLightOnButton = new JoystickButton(rightStick, Constants.TURN_LIMELIGHT_ON_BUTTON);
  JoystickButton turnLimeLightOffButton = new JoystickButton(rightStick, Constants.TURN_LIMELIGHT_OFF_BUTTON);
  JoystickButton shootButton = new JoystickButton(midStick, Constants.SHOOT_BUTTON);
  JoystickButton feederButton = new JoystickButton(midStick, Constants.FEEDER_BUTTON);
  JoystickButton deathSpinButton = new JoystickButton(rightStick, Constants.DEATH_SPIN_BUTTON);
  JoystickButton danceButton = new JoystickButton(rightStick, Constants.DANCE_BUTTON);
  //private final SendableChooser<Command> m_chooser = new SendableChooser<>();
  public void initialize() {
    // Configure the button bindings
    configureButtonBindings();
    // vroomVroom.setDefaultCommand(new RunCommand(() -> vroomVroom.greenLight(midStick.getRawAxis(0), 
    // leftStick.getRawAxis(1)), vroomVroom));
    vroomVroom.setDefaultCommand(new Drive(midStick, leftStick, vroomVroom));
    //hooks.setDefaultCommand(new ManualClimb(rightStick, rightStick, hooks));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    turnLimelightOnButton.whenPressed(turnLimelightLedModeOn);
    turnLimelightOffButton.whenPressed(turnLimelightLedModeOff);
    targetTheHoop.whenActive(targetingS);
  //  shootButton.whenHeld(shoot);
    //feederButton.whenHeld(feederMotor);
    deathSpinButton.whileHeld(deathSpin);
    danceButton.whileHeld(dance);
    
  }


//Commands
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  // public void begin(){
  //   m_chooser.setDefaultOption("taxi", taxi);
  //   m_chooser.addOption("TaxiAndShoot", taxiAndShoot);
  //   m_chooser.addOption("TaxiAndTarget", taxiandTarget);
  // }

  public Command getAutonomousCommand(){
   // return m_chooser.getSelected();
   return taxi;
  }
}