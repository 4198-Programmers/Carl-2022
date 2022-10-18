package frc.robot;

import java.util.function.Consumer;
import java.util.function.Supplier;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.ProfiledPIDCommand;
import edu.wpi.first.wpilibj2.command.SwerveControllerCommand;

public class SwerveDrive extends CommandBase{
public SwerveDrive(Trajectory trajectory, Supplier pose, SwerveDriveKinematics kinematics, PIDController xController, PIDController yController, ProfiledPIDController thetaController, Supplier desiredRotation, Consumer outputModuleStates, SwerveDriveBase swerveDriveBase){

}
}
