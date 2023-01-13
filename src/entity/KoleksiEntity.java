package entity;

public class KoleksiEntity {
    protected int idKoleksi;
    protected boolean status;

    public KoleksiEntity() {

    }

    public int getIdKoleksi() {
        return idKoleksi;
    }

    public void setIdKoleksi(int idKoleksi) {
        this.idKoleksi = idKoleksi;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
