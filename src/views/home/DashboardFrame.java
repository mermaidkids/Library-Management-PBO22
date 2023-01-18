package views.home;

import controllers.*;
import entity.*;
import models.Library;
import models.Staff;
import views.*;
import java.awt.Font;
import java.util.ArrayList;

import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
// import javax.swing.event.MouseInputAdapter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class DashboardFrame extends MainFrame {

    private JLabel iconLabel;
    private JLabel titleLabel, subTitleLabel;
    private JButton lihatBtn, tambahBtn, editBtn, hapusBtn;
    private JButton refreshBtn;
    private JButton bukuBtn, cariStaffBtn, logoutBtn;

    protected JTable bukuTable;
    private JScrollPane scrollPane;

    private JTextField selectedField = new JTextField();

    private DashboardController _dashboardC = new DashboardController();
    // private AuthController auth = new AuthController();
    private StaffEntity staff;

    public DashboardFrame() {
        super("Dashboard", 800, 600);

        staff = Staff.getStaffLogged();
    }

    @Override
    protected void component() {
        ImageIcon imgLoad = loadImage("src/assets/elibrary.png", 55, 55);
        iconLabel = new JLabel(imgLoad);
        boundedAdd(iconLabel, 34, 40, 55, 55);

        titleLabel = new JLabel("WELCOME");
        setFontSize(titleLabel, 15);
        setFontStyle(titleLabel, Font.BOLD);
        boundedAdd(titleLabel, 102, 53, 73, 20);

        subTitleLabel = new JLabel(staff.getNamaStaff());
        setFontSize(subTitleLabel, 20);
        setFontStyle(subTitleLabel, Font.BOLD);
        boundedAdd(subTitleLabel, 102, 68, 200, 27);

        bukuBtn = new JButton("Buku");
        bukuBtn.setBackground(color("#D9D9D9"));
        bukuBtn.setForeground(color("#000000"));
        boundedAdd(bukuBtn, 0, 138, 103, 31);

        cariStaffBtn = new JButton("Cari Staff");
        cariStaffBtn.setBackground(color("#115797"));
        cariStaffBtn.setForeground(color("#FFFFFF"));
        boundedAdd(cariStaffBtn, 0, 169, 103, 31);

        refreshBtn = new JButton("Refresh");
        refreshBtn.setForeground(color("#00FF88"));
        refreshBtn.setBorder(new LineBorder(color("#00FF88"), 2, true));
        refreshBtn.setContentAreaFilled(false);
        refreshBtn.setFocusPainted(false);
        boundedAdd(refreshBtn, 690, 69, 80, 28);

        lihatBtn = new JButton("Lihat");
        lihatBtn.setBackground(color("#00FF88"));
        lihatBtn.setForeground(color("#FFFFFF"));
        lihatBtn.setFocusPainted(false);
        boundedAdd(lihatBtn, 690, 107, 80, 28);

        tambahBtn = new JButton("Tambah");
        tambahBtn.setBackground(color("#0080FF"));
        tambahBtn.setForeground(color("#FFFFFF"));
        tambahBtn.setFocusPainted(false);
        boundedAdd(tambahBtn, 600, 107, 80, 28);

        editBtn = new JButton("Edit");
        editBtn.setBackground(color("#FFD500"));
        editBtn.setForeground(color("#FFFFFF"));
        editBtn.setFocusPainted(false);
        boundedAdd(editBtn, 510, 107, 80, 28);

        hapusBtn = new JButton("Hapus");
        hapusBtn.setBackground(color("#FF0000"));
        hapusBtn.setForeground(color("#FFFFFF"));
        hapusBtn.setFocusPainted(false);
        boundedAdd(hapusBtn, 420, 107, 80, 28);

        // Tabel
        bukuTable = new JTable();
        TableModel model = createTableModel();
        bukuTable.setModel(model);

        // Scroll Table
        scrollPane = new JScrollPane(bukuTable);
        boundedAdd(scrollPane, 109, 138, 671, 434);

        logoutBtn = new JButton("LOGOUT");
        logoutBtn.setBackground(color("#E50404"));
        logoutBtn.setForeground(color("#FFFFFF"));
        logoutBtn.setFocusPainted(false);
        boundedAdd(logoutBtn, 14, 552, 76, 18);
    }

    @Override
    protected void event() {
        bukuTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = bukuTable.getSelectedRow();
                String selectedId = bukuTable.getValueAt(i, 0).toString();
                selectedField.setText(selectedId);
            }
        });

        refreshBtn.addActionListener((e) -> {
            bukuTable.setModel(createTableModel());
        });

        tambahBtn.addActionListener((event -> {
            new TambahBukuFrame().setVisible(true);
        }));

        editBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = bukuTable.getSelectedRow() + 1;
                BukuEntity buku = Library.findBukuById(i);
                if (buku != null) {
                    new EditFrame(buku).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Data Masih Kosong", "Informasi",
                            JOptionPane.INFORMATION_MESSAGE);
                }

            }

        });
        // editBtn.addActionListener((event -> {
        // new EditFrame().setVisible(true);
        // }));

        hapusBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = bukuTable.getSelectedRow();
                _dashboardC.delete(i);
                JOptionPane.showMessageDialog(null, "Hapus Buku berhasil", "Information",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        cariStaffBtn.addActionListener((event -> {
            new CariStaffFrame().setVisible(true);
        }));

        logoutBtn.addActionListener((event -> {
            new LogoutFrame().setVisible(true);
            dispose();
        }));
    }

    private TableModel createTableModel() {
        DefaultTableModel dataTable = new DefaultTableModel();

        Object[] column = {
                "ID",
                "Judul Buku",
                "Jumlah hal",
                "Genre",
                "Tanggal Terbit",
                "Penulis",
                "Penerbit",

        };
        dataTable.setColumnIdentifiers(column);

        ArrayList<BukuEntity> bukuList = _dashboardC.bukuList();

        for (BukuEntity buku : bukuList) {

            Object[] data = new String[] {
                    String.valueOf(buku.getIdKoleksi()),
                    buku.getJudulBuku(),
                    String.valueOf(buku.getJmlHalaman()),
                    buku.getGenreBuku(),
                    buku.getTanggalTerbit(),
                    buku.getNamaPenulis(),
                    buku.getNamaPenerbit()
            };

            dataTable.addRow(data);
        }
        return dataTable;
    }

}
