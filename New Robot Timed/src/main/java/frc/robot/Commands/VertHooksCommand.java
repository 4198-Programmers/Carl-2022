package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.VerticalHooks;

public class VertHooksCommand extends CommandBase {

    public interface speedRetriever{

        double getspeed();
    }
    
    speedRetriever aRetriever;
    VerticalHooks verticalHooks;

    public VertHooksCommand(speedRetriever aRetriever, VerticalHooks verticalHooks){

        this.aRetriever = aRetriever;
        this.verticalHooks = verticalHooks;

        addRequirements(verticalHooks);

    }

    @Override
    public void execute() {

        verticalHooks.verticalHookMove(aRetriever.getspeed());

    }

}
