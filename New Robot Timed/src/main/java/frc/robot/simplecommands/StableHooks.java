package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.AngleHooks;
import frc.robot.subsystems.VertHooks;

/** {@link StableHooks} Sets both Vertical Hooks and Angled Hooks speeds to 0 */
public class StableHooks extends CommandBase {
    VertHooks vertHooks;
    AngleHooks angleHooks;

    /** {@link StableHooks} Sets both Vertical Hooks and Angled Hooks speeds to 0 */
    public StableHooks(VertHooks vertHookArg, AngleHooks angleHooksArg) {
        vertHooks = vertHookArg;
        angleHooks = angleHooksArg;
        addRequirements(vertHooks, angleHooks);
    }

    @Override
    public void execute() {
        angleHooks.moveAngledHooks(0);
        vertHooks.moveVertHooks(0);
    }
}