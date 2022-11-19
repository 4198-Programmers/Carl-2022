package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.AnglesHooks;

public class AngleHookCommand extends CommandBase {

    //interface, aka. abstract class has no body
    public interface speedRetriever{

        double getSpeed();
    }
    
    speedRetriever vRetriever;
    AnglesHooks anglesHooks;

    public AngleHookCommand(AnglesHooks anglesHooks, speedRetriever vRetriever){

        this.anglesHooks = anglesHooks;
        this.vRetriever = vRetriever;

        addRequirements(anglesHooks);

    }

    @Override
    public void execute() {
        
        anglesHooks.angleHooksMove(vRetriever.getSpeed());

    }
    
}
