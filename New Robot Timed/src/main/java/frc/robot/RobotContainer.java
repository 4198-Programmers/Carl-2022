package frc.robot;
/* 
This is just a message for everyone.
Robot and Main do not get edited at all when programming.  Never touch the two.  If something in one of the two
is deleted, the program will never work.
Another note:
  Always use names that make sense.  If you are talking about the front left motor, maybe name it "FrontLMotor",
  If you are unsure if someone would understand, comment on it.  
  Make a comment(like this one) and explain what it means.

  Also make sure to keep things organized. You want to make sure that you can find everything easily.  Put things in
  folders to keep things that share characteristics together.  Or you can keep things seperated through comments and
  group constants together.

If you have any questions, do not be afraid to ask me.  I will help you figure it out and if I don't know, I will
figure it out with you.
*/
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;


public class RobotContainer {


  // subsystems
    //This is just where you would pass your subsystems to robot container.


  // ungrouped commands
    //This is the commands that you make in other files.
  


  // command groups
    //These are commands that you make here in RobotContainer.  I will explain that uses for these later.

  //Buttons
    //This is where you make your buttons.  You do not assign what the buttons do here, but you create them.
  
  
  // others
  private final SendableChooser<Command> m_chooser = new SendableChooser<>();
/**This is Robot Container Initialize. This initializes once when the robot starts up.*/
  public void initialize() {
    configureButtonBindings();
    begin();
  }
/**This is where you assign your buttons to commands.  You make the buttons earlier, but this is where you make the
 * buttons do something.
 */
  private void configureButtonBindings() {

}
/**Nothing goes in here. This just tells the robot to "begin". */
  private void begin() {
  }

  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }

}
