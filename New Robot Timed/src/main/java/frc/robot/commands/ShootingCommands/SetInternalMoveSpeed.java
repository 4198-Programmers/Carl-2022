// package frc.robot.commands.ShootingCommands;

// import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.Constants;
// import frc.robot.subsystems.Shooter;

// public class SetInternalMoveSpeed extends CommandBase{
//     Shooter shooter;
//     public SetInternalMoveSpeed(Shooter shooterArg){
//         shooter = shooterArg;
//         addRequirements(shooter);
//     }
//     protected double wantedInternalMotorSpeed(){
//         return Constants.WANTED_INTERNAL_MOTOR_SPEED;
//     }
//     @Override
//     public void execute() {
//         shooter.internalMotorSpeed(wantedInternalMotorSpeed());
//     }
//     @Override
//     public boolean isFinished() {
//         double speed = Constants.INTERNAL_MOTOR_SPEED;
//         final double tolerance = 0.01;
//         double expectedInternalMotorSpeed = wantedInternalMotorSpeed();
//         return(speed > expectedInternalMotorSpeed - tolerance && speed < expectedInternalMotorSpeed + tolerance);
//     }
// }
