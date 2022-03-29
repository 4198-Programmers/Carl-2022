package frc.robot.command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.VerticalHooks;

public class VerticalHooksMove extends CommandBase{
    public interface HooksReciever{
        double getHookSpeed();
    }
    VerticalHooks verticalHooks;
    HooksReciever hooksReciever;
    public VerticalHooksMove(VerticalHooks verticalHooks, HooksReciever hooksReciever){
        this.verticalHooks = verticalHooks;
        this.hooksReciever = hooksReciever;
        addRequirements(verticalHooks);
    }
    @Override
    public void execute() {
        if()
    }

}
