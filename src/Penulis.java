public class Penulis {
    // Attribut Class Penulis
    String namaPenulis;
    String emailPenulis;

    public Penulis(String namaPenulis, String emailPenulis) {
        this.namaPenulis = namaPenulis;
        this.emailPenulis = emailPenulis;
    }

    // Method
    public void dataPenulis() {
        System.out.println("Nama Penulis    :" + namaPenulis);
        System.out.println("Email Penulis :" + emailPenulis);

    }
}
