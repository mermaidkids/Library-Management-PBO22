import controllers.AuthController;
import models.Library;
import views.LoginPage;
import views.LoginFrame;
// import views.home.DashboardFrame;

public class App {
    public static void main(String[] args) {

        AuthController auth = new AuthController();
        auth.initialStaff();
        Library.initialBuku();

        // new DashboardFrame().setVisible(true);

        // new LoginPage();
        new LoginFrame().setVisible(true);

    }
}
