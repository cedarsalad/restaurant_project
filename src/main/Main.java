package main;

import controllers.ClientController;
import controllers.LoginController;
import models.ClientModel;
import models.UserModel;

public class Main {

	public static void main(String[] args) {
		//new Menu();
		//new AddStudentView();
		//new EditStudentView();
		//new ListStudentsView();
		
		//StudentModel model = new StudentModel();
		//StudentBean student = new StudentBean();
		
		/*model.addNewStudent("Fayez H", "01/04/1989", "fayez@gmail.com", "Sexology");
		Object[][] test = model.getAllStudents();
		for(int i=0; i<test.length-1; i++) {
			System.out.println(test[i][0] + " " + test[i][1] + " " + test[i][4]);
		}*/
		//System.out.println(student);
		
		UserModel userModel = new UserModel();
		LoginController loginController = new LoginController(userModel);
	}

}
