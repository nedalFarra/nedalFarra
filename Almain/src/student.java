/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nedal Adel
 */
    
public class  student {

    private int id;
    private String name;
    private String major;
    private double grade;

    student stdGroub[] = new student[5];

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String sort() {
        String text ="";
        student temp[] = new student[5];
        for (int i = 0; i < stdGroub.length; i++) {
            temp[i] = stdGroub[i];
        }
        for (int i = 0; i < temp.length - 1; i++) {
            for (int j = i + 1; j < temp.length; j++) {
                if (temp[i].getGrade() > temp[j].getGrade()) {
                    student t = temp[i];
                    temp[i] = temp[j];
                    temp[j] = t;
                }
            }
        }
        for (int i = 0; i < temp.length; i++) {
             stdGroub[i] = temp[i];
        }
        text+="[ ";
        for (int i = 0; i < stdGroub.length; i++) {
            if (i == stdGroub.length - 1) {
                text+=stdGroub[i].getGrade()+"";
            } else {
               text+=stdGroub[i].getGrade() + ", ";
            }
        }
        text+=" ]";
        return text;
    }

}


