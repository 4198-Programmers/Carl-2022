package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.command.DoNotMove;
import frc.robot.command.HumanControl;
import frc.robot.command.ReachHooksUp;
import frc.robot.command.TaxiAndShoot;
import frc.robot.command.TaxiTarmac;

public class Robot extends TimedRobot {
  private Command autoSelected;
  private final SendableChooser<Command> m_chooser = new SendableChooser<>();

  Joystick leftStick = new Joystick(Constants.LEFT_STICK_PORT);
  Joystick midStick = new Joystick(Constants.MID_STICK_PORT);
  Joystick rightStick = new Joystick(Constants.RIGHT_STICK_PORT);

  //subsystems
  DriveTrain vroomVroom = new DriveTrain();
  ShooterPathMovement pewPew = new ShooterPathMovement();
  Hooks climber = new Hooks();

  //commands
  DoNotMove doNotMove = new DoNotMove(vroomVroom, pewPew);
  TaxiAndShoot taxiAndShoot = new TaxiAndShoot(vroomVroom, pewPew);
  TaxiTarmac taxiTarmac = new TaxiTarmac(vroomVroom);
  HumanControl humanControl = new HumanControl(climber, rightStick);
  ReachHooksUp reachHooksUp = new ReachHooksUp(climber);

  //buttons
  JoystickButton humanTakesControl = new JoystickButton(rightStick, Constants.HUMAN_OVERRIDE_BUTTON);
  JoystickButton verticalHookUp = new JoystickButton(rightStick, Constants.VERT_HOOK_UP_BUTTON);
  JoystickButton verticalHookDown = new JoystickButton(rightStick, Constants.VERT_HOOK_DOWN_BUTTON);
  JoystickButton angledHookUp = new JoystickButton(rightStick, Constants.ANGLE_HOOK_UP_BUTTON);
  JoystickButton angledHookDown = new JoystickButton(rightStick, Constants.ANGLE_HOOK_UP_BUTTON);

  private Robot(){
    configureButtonBindings();
  }

  private void configureButtonBindings()
  {
    humanTakesControl.whenHeld(humanControl);
    verticalHookUp.whenHeld(reachHooksUp);
  }


  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", doNotMove);
    m_chooser.addOption("Taxi + Shoot One", taxiAndShoot);
    m_chooser.addOption("Taxi", taxiTarmac);
    SmartDashboard.putData("Auto choices", m_chooser);
  }



  @Override
  public void robotPeriodic() {
  }

 

  @Override
  public void autonomousInit() {
    autoSelected = m_chooser.getSelected();
    autoSelected.initialize();

  }



  @Override
  public void autonomousPeriodic() {
    autoSelected.execute();

  }



  @Override
  public void teleopInit() {

    

  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    vroomVroom.greenLight(leftStick.getRawAxis(0), rightStick.getRawAxis(0));

  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  // @Override 
  // public void simulationInit() {}
  
}
