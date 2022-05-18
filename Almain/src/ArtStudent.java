/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nedal Adel
 */
    
public class ArtStudent extends student{
  
    private double grade;
    double mid;
    double report;
    double finall;
    
    
    @Override
    public double getGrade() {
        return (this.mid*0.4) + (this.report*0.1) + (this.finall*0.5);
    }
    
    public void setGrade(double mid, double report, double finall) {
         this.mid = mid;
         this.report = report;
         this.finall = finall;
    }
}


