package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PincherPneumatic extends SubsystemBase {

    private Solenoid pincerSolenoid = new Solenoid(null, 0);

    public PincherPneumatic() {
    }

    public void pincerSolenoidActivate(boolean togglemode) {
        pincerSolenoid.set(togglemode);
    }

}
