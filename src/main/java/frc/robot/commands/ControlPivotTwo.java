// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class ControlPivotTwo extends CommandBase {


  double softLimitFull1 = -3.0;
  double SoftLimitFull2 = -235.0;

  double softLimitLimit1 = -3.0;
  double softLimitLimit2 = -2.0;
  double softLimitLimit3 = -2.0;
  double softLimitLimit4 = -2.0;
  
  /** Creates a new ControlPivotTwo. */
  public ControlPivotTwo() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.pivotTwo);
    // addRequirements(RobotContainer.extend);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      double speed = RobotContainer.getRightY(RobotContainer.OpController);
    // ADJUSTING LENGTH VALUES MUST CHANGE OF EXTEND ENCODER

      //THIS IS WHERE YOU COMMENT OUT (JSYK DANTE)
      if(RobotContainer.extend.get_extend_encoder()<=-10.0){
        speed=0;
      }else 
      
      if(RobotContainer.pivotTwo.get_second_pivot_encoder() >= -1.0 && speed>0.0){
        speed = 0.0;
      }else if(RobotContainer.pivotTwo.get_second_pivot_encoder() <= -380 && speed<0.0){
        speed = 0.0;
      }
      //-1 to -237 for round tubes
      RobotContainer.pivotTwo.move_pivot_two(speed*0.90);
    //System.out.println(RobotContainer.pivotTwo.get_second_pivot_encoder());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
