package frc.robot.commands;
import frc.robot.subsystems.DriveTrain;
import frc.robot.commands.AutoCommand;
import frc.robot.Maths;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class AutoCommandTurn extends CommandBase{ 
    private DriveTrain driveTrain;
    private boolean complete = false;
    public AutoCommandTurn(DriveTrain driveTrain){
        this.driveTrain = driveTrain;
    }

    @Override
    public void execute() {
       
    
}
