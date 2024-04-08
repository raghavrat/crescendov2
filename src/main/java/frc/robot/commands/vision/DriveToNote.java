package frc.robot.commands.vision;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.VisionSubsystem;
import frc.robot.subsystems.drive.Drive;

public class DriveToNote extends Command {

    VisionSubsystem vision;
    Drive drive;
    public DriveToNote(VisionSubsystem visionSubsystem, Drive drive) {
        this.vision = visionSubsystem;
        this.drive = drive;
    }

    @Override
    public void initialize() {
        super.initialize();
    }

    @Override
    public void execute() {
        double tx = vision.getLimelightNote().getEntry("tx").getDouble(0);
        double ty = vision.getLimelightNote().getEntry("ty").getDouble(0);
        ChassisSpeeds speeds = new ChassisSpeeds ((ty-31)*0.08-0.25, 0.0, tx*0.08);
        drive.runVelocity(speeds);
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
    }

    @Override
    public boolean isFinished() {
        return super.isFinished();
    }
}
