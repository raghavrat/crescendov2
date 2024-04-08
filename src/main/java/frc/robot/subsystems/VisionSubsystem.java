package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class VisionSubsystem extends SubsystemBase {

    NetworkTable limelight;
    NetworkTable limelightNote;
    public VisionSubsystem() {}

    public NetworkTable getTagLimelight() {
        return limelight;
    }
    public NetworkTable getLimelightNote() {
        return limelightNote;
    }

    @Override
    public void periodic() {
        limelight = NetworkTableInstance.getDefault().getTable("limelight");
        limelightNote = NetworkTableInstance.getDefault().getTable("limelight-note");
    }
}
