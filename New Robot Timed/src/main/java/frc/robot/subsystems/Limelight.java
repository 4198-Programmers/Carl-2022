package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Limelight extends SubsystemBase{
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry ta = table.getEntry("ta");
    NetworkTableEntry pipeline = table.getEntry("pipeline");
    NetworkTableEntry tv = table.getEntry("tv");

    public void setPipeline(double pipe){
        pipeline.setDouble(pipe);
    }
    public double getPipeline(){
        return pipeline.getDouble(-1);
    }
    public double xOffset(){
        return tx.getDouble(0);
    }
    public boolean hasTarget(){
        return tv.getBoolean(false);
    }
    @Override
    public void periodic() {
        SmartDashboard.putBoolean("Has Target", hasTarget());
    }
    
}
