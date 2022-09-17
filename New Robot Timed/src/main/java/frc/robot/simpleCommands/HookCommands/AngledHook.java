package frc.robot.simpleCommands.HookCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.AngledHooks;

public class AngledHook extends CommandBase{
    AngledHooks angledHooks;
    public interface hookSpeedRetriever{
        double getangledspeed();
    }
    hookSpeedRetriever angledhookSpeedRetriever;
    public AngledHook(AngledHooks angledHooks, hookSpeedRetriever angledhookSpeedRetriever){
        this.angledHooks = angledHooks;
        this.angledhookSpeedRetriever = angledhookSpeedRetriever;
        addRequirements(angledHooks);
    }
    @Override
    public void execute() {
        angledHooks.setAngledHookSpeed(-angledhookSpeedRetriever.getangledspeed());
        System.out.println(angledHooks.getAngledHookPosition());
    }
    @Override
    public void end(boolean interrupted) {
        angledHooks.setAngledHookSpeed(Constants.FREEZE);
    }
}