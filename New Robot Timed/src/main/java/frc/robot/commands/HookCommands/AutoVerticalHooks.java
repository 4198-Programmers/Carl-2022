package frc.robot.commands.HookCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hooks.VerticalHooks;

public class AutoVerticalHooks extends CommandBase{
    VerticalHooks verticalHooks;
    double speed;
    double distance;
    public AutoVerticalHooks(VerticalHooks verticalHooks, double speed, double distance){
        this.verticalHooks = verticalHooks;
        this.speed = speed;
        this.distance = distance;
        addRequirements(verticalHooks);
    }
    @Override
    public void execute() {
        verticalHooks.setSpeed(speed);
    }
    @Override
    public boolean isFinished() {
        return verticalHooks.getVerticalHookPostion() >= distance;
    }
    @Override
    public void end(boolean interrupted) {
        verticalHooks.setSpeed(0);
    }
}