// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autos;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class AutoLevel extends CommandBase {
  /** Creates a new AutoLevel. */
  public AutoLevel() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.gyro);
    addRequirements(RobotContainer.drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(RobotContainer.gyro.getRoll() <-3){
      RobotContainer.drive.arcadeDrive(-0.32, 0.0);
    }else if(RobotContainer.gyro.getRoll() > 3){
      RobotContainer.drive.arcadeDrive(0.32, 0.0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.drive.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
