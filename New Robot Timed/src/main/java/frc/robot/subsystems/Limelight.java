package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Limelight extends SubsystemBase{
    public enum limelightMode{
        forceOn(1),
        forceOff(2),
        invalid(-1);

        double mode;

        private limelightMode(double mode){
            this.mode = mode;
        }
        double getLimelightMode(){
            return mode;
        }
    }
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry ta = table.getEntry("ta");
    NetworkTableEntry pipeline = table.getEntry("pipeline");

    
}
