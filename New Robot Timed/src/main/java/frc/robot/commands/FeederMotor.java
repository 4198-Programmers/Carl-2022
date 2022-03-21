// package frc.robot.commands;

// import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.Constants;
// import frc.robot.subsystems.Shooter;

// public class FeederMotor extends CommandBase{
//     Shooter shooter;
//     public FeederMotor(Shooter shooterArg){
//         shooter = shooterArg;
//         addRequirements(shooter);
//     }
//     protected double wantedFeederSpeed(){
//         return Constants.WANTED_FEEDER_SPEED;
//     }
//     @Override
//     public void execute() {
//         shooter.feederSpeed(wantedFeederSpeed());
//     }
//     @Override
//     public boolean isFinished() {
//         double speed = Constants.FEEDER_SPEED;
//         final double tolerance = 0.01;
//         double expectedFeederSpeed = wantedFeederSpeed();
//         return(speed > expectedFeederSpeed - tolerance && speed < expectedFeederSpeed + tolerance);
//     }
// }
