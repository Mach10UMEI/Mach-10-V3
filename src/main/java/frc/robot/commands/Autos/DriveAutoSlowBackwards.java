// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autos;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

import edu.wpi.first.wpilibj.Timer;

import java.lang.Math;

public class DriveAutoSlowBackwards extends CommandBase {
  /** Creates a new DriveAuto. */
  double startError, remError, l_distance, speed;

  public DriveAutoSlowBackwards(double distance) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.drive);
    
    l_distance = distance; 
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    RobotContainer.drive.brake_mode();

    startError = l_distance - RobotContainer.drive.get_drive_encoder(); //NEG FOR FORWARD POS FOR BACK
    remError = 0;
    speed = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    remError = (startError + RobotContainer.drive.get_drive_encoder());
    if(remError < 10){
      speed = 0.35;
    }else speed = 0.50;

    System.out.print("remError");
    System.out.println(remError);
    RobotContainer.drive.arcadeDrive(speed, 0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.drive.stop();
    // RobotContainer.drive.coast_mode();
    System.out.print("I AM HERE AND MADISON WILL BE VERY HAPPY IF THIS PRINTSSSSSSSSSSSSSSSS");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return ((Math.abs(remError) <= 2)); 
  }
}
