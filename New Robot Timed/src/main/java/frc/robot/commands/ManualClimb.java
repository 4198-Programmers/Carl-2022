// package frc.robot.commands;

// import edu.wpi.first.wpilibj.Joystick;
// import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.subsystems.Hooks;

// public class ManualClimb extends CommandBase{
//     Hooks hooks;
//     Joystick vert;
//     Joystick angled;
//     public ManualClimb(Joystick vert, Joystick angled, Hooks hooks){
//         this.vert = vert;
//         this.angled = angled;
//         this.hooks = hooks;
//         addRequirements(hooks);
//     }
//     @Override
//     public void execute() {
//        hooks.vertHookExtend(vert.getRawAxis(0));
//        hooks.angledHookMove(angled.getRawAxis(1));
//     }
// }
