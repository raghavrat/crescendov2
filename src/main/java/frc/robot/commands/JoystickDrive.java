package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Transform2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.drive.Drive;

import java.util.function.DoubleSupplier;

public class JoystickDrive extends Command {
    Drive drive;
    DoubleSupplier xSupplier;
    DoubleSupplier ySupplier;
    DoubleSupplier omegaSupplier;
    private double DEADBAND = 0.1;

    public  JoystickDrive(Drive drive, DoubleSupplier xSupplier, DoubleSupplier ySupplier, DoubleSupplier omegaSupplier) {
        addRequirements(drive);
        this.drive = drive;
        this.xSupplier = xSupplier;
        this.ySupplier = ySupplier;
        this.omegaSupplier = omegaSupplier;
    }

    @Override
    public void execute() {
        double linearMagnitude = MathUtil.applyDeadband(Math.hypot(xSupplier.getAsDouble(), -ySupplier.getAsDouble()), DEADBAND);
        Rotation2d linearDirection = new Rotation2d(xSupplier.getAsDouble(), -ySupplier.getAsDouble());
        double omega = MathUtil.applyDeadband(-omegaSupplier.getAsDouble(), DEADBAND);
        linearMagnitude = linearMagnitude * linearMagnitude;
        omega = Math.copySign(omega * omega, omega);
        Translation2d linearVelocity = new Pose2d(new Translation2d(), linearDirection).transformBy(new Transform2d(linearMagnitude, 0.0, new Rotation2d())).getTranslation();

        // Convert to field relative speeds & send command
        boolean isFlipped =
                DriverStation.getAlliance().isPresent() && DriverStation.getAlliance().get() == DriverStation.Alliance.Red;
        drive.runVelocity(
                ChassisSpeeds.fromFieldRelativeSpeeds(linearVelocity.getX() * drive.getMaxLinearSpeedMetersPerSec(), linearVelocity.getY() * drive.getMaxLinearSpeedMetersPerSec(), omega * drive.getMaxAngularSpeedRadPerSec(), isFlipped ? drive.getRotation().plus(new Rotation2d(Math.PI)) : drive.getRotation()));
    }
}
