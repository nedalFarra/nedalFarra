
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nedal Adel
 */
public class Almain {

    /**
     * @param args the command line arguments
     */
        
        public static void main(String[] args) throws FileNotFoundException, IOException {

        student s = new student();

        s.stdGroub[0] = new ItStudent();
        s.stdGroub[1] = new ItStudent();
        s.stdGroub[2] = new ArtStudent();
        s.stdGroub[3] = new ArtStudent();
        s.stdGroub[4] = new ArtStudent();

        ItStudent itS1 = new ItStudent();
        s.stdGroub[0] = itS1;
        itS1.setGrade(7.0, 6.0, 8.0);
        s.stdGroub[0].setGrade(itS1.getGrade());

        ItStudent itS2 = new ItStudent();
        s.stdGroub[1] = itS2;
        itS2.setGrade(6.0, 8.0, 8.0);
        s.stdGroub[1].setGrade(itS2.getGrade());

        ArtStudent artS1 = new ArtStudent();
        s.stdGroub[2] = artS1;
        artS1.setGrade(4.0, 6.0, 5.0);
        s.stdGroub[2].setGrade(artS1.getGrade());

        ArtStudent artS2 = new ArtStudent();
        s.stdGroub[3] = artS2;
        artS2.setGrade(7.0, 9.0, 8.0);
        s.stdGroub[3].setGrade(artS2.getGrade());

        ArtStudent artS3 = new ArtStudent();
        s.stdGroub[4] = artS3;
        artS3.setGrade(4.0, 5.0, 8.0);
        s.stdGroub[4].setGrade(artS3.getGrade());

        File file = new File("C:\\Users\\HP\\Documents\\NetBeansProjects\\Almain\\sorted Grade.txt");
        PrintWriter output = new PrintWriter(file);
        output.print(s.sort());
        output.close();

    }

}

