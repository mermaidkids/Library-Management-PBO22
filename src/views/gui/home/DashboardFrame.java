package views.gui.home;

import controllers.*;
import entity.*;
import models.Library;
import models.Staff;
import views.gui.*;

import java.awt.Font;
import java.util.ArrayList;

import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class DashboardFrame extends MainFrame {

    private JLabel iconLabel;
    private JLabel titleLabel, subTitleLabel;
    private JButton lihatBtn, tambahBtn, editBtn, cariBukuBtn, hapusBtn;
    private JButton refreshBtn;
    private JButton bukuBtn, cariStaffBtn, logoutBtn;

    protected JTable bukuTable;
    private JScrollPane scrollPane;

    private JTextField selectedField = new JTextField();

    private DashboardController _dashboardC = new DashboardController();

    private StaffEntity staff;

    public DashboardFrame() {
        super("Dashboard", 800, 600);

        staff = Staff.getStaffLogged();
    }

    @Override
    protected void component() {
        ImageIcon imgLoad = loadImage("src/assets/elibrary.png", 55, 55);
        iconLabel = new JLabel(imgLoad);
        boundedAdd(iconLabel, 27, 14, 70, 89);

        titleLabel = new JLabel("WELCOME");
        setFontSize(titleLabel, 14);
        setFontStyle(titleLabel, Font.BOLD);
        boundedAdd(titleLabel, 137, 41, 74, 17);

        subTitleLabel = new JLabel(staff.getNamaStaff());
        setFontSize(subTitleLabel, 14);
        setFontStyle(subTitleLabel, Font.BOLD);
        boundedAdd(subTitleLabel, 145, 64, 205, 17);

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
        boundedAdd(refreshBtn, 579, 105, 79, 25);

        lihatBtn = new JButton("Lihat");
        lihatBtn.setBackground(color("#00FF88"));
        lihatBtn.setForeground(color("#FFFFFF"));
        lihatBtn.setFocusPainted(false);
        boundedAdd(lihatBtn, 690, 138, 86, 22);

        tambahBtn = new JButton("Tambah");
        tambahBtn.setBackground(color("#0080FF"));
        tambahBtn.setForeground(color("#FFFFFF"));
        tambahBtn.setFocusPainted(false);
        boundedAdd(tambahBtn, 690, 172, 86, 22);

        editBtn = new JButton("Edit");
        editBtn.setBackground(color("#FFD500"));
        editBtn.setForeground(color("#FFFFFF"));
        editBtn.setFocusPainted(false);
        boundedAdd(editBtn, 690, 206, 86, 22);

        cariBukuBtn = new JButton("Cari Buku");
        cariBukuBtn.setBackground(color("#EDF10D"));
        cariBukuBtn.setForeground(color("#FFFFFF"));
        cariBukuBtn.setFocusPainted(false);
        boundedAdd(cariBukuBtn, 690, 240, 86, 22);

        hapusBtn = new JButton("Hapus");
        hapusBtn.setBackground(color("#FF0000"));
        hapusBtn.setForeground(color("#FFFFFF"));
        hapusBtn.setFocusPainted(false);
        boundedAdd(hapusBtn, 690, 274, 86, 22);

        // Tabel
        bukuTable = new JTable();
        TableModel model = createTableModel();
        bukuTable.setModel(model);

        // Scroll Table
        scrollPane = new JScrollPane(bukuTable);
        boundedAdd(scrollPane, 109, 138, 549, 434);

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

        lihatBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = bukuTable.getSelectedRow() + 1;
                BukuEntity buku = Library.findBukuById(i);
                if (buku != null) {
                    new LihatBukuFrame(buku).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Data Masih Kosong", "Informasi",
                            JOptionPane.INFORMATION_MESSAGE);
                }

            }
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

        cariBukuBtn.addActionListener((event -> {
            new CariBukuFrame().setVisible(true);
        }));

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
            int jawab = JOptionPane.showOptionDialog(this,
                    "Ingin Keluar?",
                    "Keluar",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, null, null);

            if (jawab == JOptionPane.YES_OPTION) {
                new LoginFrame().setVisible(true);
                dispose();
            }
        }));
    }

    private TableModel createTableModel() {
        DefaultTableModel dataTable = new DefaultTableModel();

        Object[] column = {
                "ID",
                "Judul Buku",
                "Genre",
                "Penulis",
                "Penerbit",

        };
        dataTable.setColumnIdentifiers(column);

        ArrayList<BukuEntity> bukuList = _dashboardC.bukuList();

        for (BukuEntity buku : bukuList) {

            Object[] data = new String[] {
                    String.valueOf(buku.getIdKoleksi()),
                    buku.getJudulBuku(),
                    buku.getGenreBuku(),
                    buku.getNamaPenulis(),
                    buku.getNamaPenerbit()
            };

            dataTable.addRow(data);
        }
        return dataTable;
    }

}
