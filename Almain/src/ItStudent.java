/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nedal Adel
 */
    
public class ItStudent extends student{
    
    private double grade;
    double mid;
    double project;
    double finall;
    
    
    @Override
    public double getGrade() {
        return (this.mid*0.3) + (this.project*0.3) + (this.finall*0.4);
    }
    
    public void setGrade(double mid, double project, double finall) {
         this.mid = mid;
         this.project = project;
         this.finall = finall;
    }
}



