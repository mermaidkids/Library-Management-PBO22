import models.Library;
import models.Staff;
import views.gui.LoginFrame;

public class App {
    public static void main(String[] args) {

        Staff.initialStaff();
        Library.initialBuku();

        new LoginFrame().setVisible(true);

    }
}
