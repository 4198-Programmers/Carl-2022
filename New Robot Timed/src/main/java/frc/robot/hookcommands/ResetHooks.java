package frc.robot.hookcommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.AngleHooks;
import frc.robot.subsystems.VertHooks;

public class ResetHooks extends CommandBase {
    AngleHooks angleHooks;
    VertHooks vertHooks;
    boolean done;

    public ResetHooks(AngleHooks angleHooksSub, VertHooks vertHooksSub) {
        angleHooks = angleHooksSub;
        vertHooks = vertHooksSub;
        addRequirements(angleHooks, vertHooks);
    }

    @Override
    public void initialize() {
        done = false;
    }

    @Override
    public void execute() {
        angleHooks.resetAngleHooks();
        vertHooks.resetVertHooks();
        done = true;
    }

    @Override
    public boolean isFinished() {
        return done;
    }

}
