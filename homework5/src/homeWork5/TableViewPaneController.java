
package homeWork5;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class TableViewPaneController implements Initializable {

    
    @FXML
    private TextArea sqlQuery;
    @FXML
    private Button buttonResult;
    @FXML
    private TextField txtFieldID;
    @FXML
    private TextField txtFieldName;
    @FXML
    private TextField txtFieldMajor;
    @FXML
    private TextField txtFieldGrade;
    @FXML
    private TableColumn<Student, String> tcNameResult;
    @FXML
    private TableColumn<Student, Integer> tcID;
    @FXML
    private TableColumn<Student, String> tcName;
    @FXML
    private TableColumn<Student, String> tcMajor;
    @FXML
    private TableColumn<Student, Double> tcGrade;
    @FXML
    private Button buttonShow;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonUpdate;
    @FXML
    private Button buttonDelete;
    @FXML
    private Button buttonReset;
    @FXML
    private TableView<Student> tableView;
    @FXML
    private TableView<Student> resultQuery;
    
    Statement statement;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection =
               DriverManager.
                getConnection("jdbc:mysql://127.0.0.1:3306/students?serverTimezone=UTC",
                        "root", "");
            this.statement = connection.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        tcID.setCellValueFactory(new PropertyValueFactory("id"));
        tcName.setCellValueFactory(new PropertyValueFactory("name"));
        tcMajor.setCellValueFactory(new PropertyValueFactory("major"));
        tcGrade.setCellValueFactory(new PropertyValueFactory("grade"));
        tcNameResult.setCellValueFactory(new PropertyValueFactory("Student Names"));
        tableView.getSelectionModel().selectedItemProperty().addListener(
                event-> showSelectedStudents() );
        resultQuery.getSelectionModel().selectedItemProperty().addListener(
                event-> showSelectedStudents2() );
    }    
    
    @FXML
    private void buttonResultHandle(ActionEvent event) throws Exception{
        String sql = sqlQuery.getText();
        ResultSet rs = this.statement.executeQuery(sql);
        resultQuery.getItems().clear();
        while(rs.next()){
            String studentName = rs.getString("name");
            Student student = new Student();
            student.setName(rs.getString("name"));
            resultQuery.getItems().add(student);
            System.out.println(studentName);
        }
    }

    @FXML
    private void buttonShowHandle(ActionEvent event) throws Exception{
        ResultSet rs = this.statement.executeQuery("Select * From student");
        tableView.getItems().clear();
        while(rs.next()){
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setMajor(rs.getString("major"));
            student.setGrade(rs.getDouble("grade"));
            tableView.getItems().add(student);
        }
    }

    @FXML
    private void buttonAddHandle(ActionEvent event) throws Exception{
        Integer id = Integer.parseInt(txtFieldID.getText());
        String name = txtFieldName.getText();
        String major = txtFieldMajor.getText();
        Double grade = Double.parseDouble(txtFieldGrade.getText());
        String sql = "Insert Into student values(" + id + ",'" +name + "','" 
                + major + "'," + grade + ")";
        this.statement.executeUpdate(sql);
    }

    @FXML
    private void buttonDeleteHandle(ActionEvent event) throws SQLException {
        int id = Integer.parseInt(txtFieldID.getText());
        String sql = "DELETE FROM student WHERE id = " + id + ";";
        this.statement.executeUpdate(sql);
    }

    @FXML
    private void buttonResetHandle(ActionEvent event) {
        resetControls();
    }
    private void resetControls(){
        txtFieldID.setText("");
        txtFieldName.setText("");
        txtFieldMajor.setText("");
        txtFieldGrade.setText("");
        tableView.getItems().clear();
    }

    @FXML
    private void buttonUpdateHandle(ActionEvent event) throws Exception{
        Integer id = Integer.parseInt(txtFieldID.getText());
        String name = txtFieldName.getText();
        String major = txtFieldMajor.getText();
        Double grade = Double.parseDouble(txtFieldGrade.getText());
        String sql = "Update Student Set name='" + name + "', major='" + 
                major + "', grade=" + grade + " Where id=" +id;
        this.statement.executeUpdate(sql);
        
    }
    private void showSelectedStudents(){
        Student student = tableView.getSelectionModel().getSelectedItem();
        if(student != null){
        txtFieldID.setText(String.valueOf(student.getId()));
        txtFieldName.setText(student.getName());
        txtFieldMajor.setText(student.getMajor());
        txtFieldGrade.setText(String.valueOf(student.getGrade()));
        }

    }
    private void showSelectedStudents2(){
        Student student = resultQuery.getSelectionModel().getSelectedItem();
        if(student != null){
        tcNameResult.setText(student.getName());
        }
    }
}
