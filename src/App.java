import controllers.AuthController;
import models.Library;
import views.LoginPage;

public class App extends AuthController {
    public static void main(String[] args) {
        AuthController authc = new AuthController();
        authc.initialStaff();
        Library.initialBuku();

        new LoginPage();

    }
}
