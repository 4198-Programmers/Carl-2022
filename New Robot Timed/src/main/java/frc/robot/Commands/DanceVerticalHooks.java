package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.VerticalHooks;

public class DanceVerticalHooks extends CommandBase{
    VerticalHooks verticalHooks;
    double distance;
    public DanceVerticalHooks(VerticalHooks verticalHooks, double distance){
        this.verticalHooks = verticalHooks;
        this.distance = distance;
        addRequirements(verticalHooks);
    }
    @Override
    public void initialize() {
        verticalHooks.resetPosition();
    }
    @Override
    public void execute() {
        if(verticalHooks.getPosition() <= distance){
            verticalHooks.moveHooks(0.15);
        }
        else if(verticalHooks.getPosition() >= distance){
              verticalHooks.stop();  
        }
    }
    @Override
    public boolean isFinished() {
        return(verticalHooks.getPosition() >= distance);
    }
}