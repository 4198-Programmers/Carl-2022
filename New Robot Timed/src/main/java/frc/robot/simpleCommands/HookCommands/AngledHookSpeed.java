package frc.robot.simpleCommands.HookCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.AngledHooks;

public class AngledHookSpeed extends CommandBase{
    AngledHooks angledHooks;
    public interface hookSpeedRetriever{
        double getangledspeed();
    }
    hookSpeedRetriever angledhookSpeedRetriever;
    public AngledHookSpeed(AngledHooks angledHooks, hookSpeedRetriever angledhookSpeedRetriever){
        this.angledHooks = angledHooks;
        this.angledhookSpeedRetriever = angledhookSpeedRetriever;
        addRequirements(angledHooks);
    }
    @Override
    public void execute() {
        angledHooks.setAngledHookSpeed(angledhookSpeedRetriever.getangledspeed());
    }
}
