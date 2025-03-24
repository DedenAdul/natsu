/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tugasmodul3_2;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;


/**
 * FXML Controller class
 *
 * @author MyBook Z Series
 */
public class MasterDataController implements Initializable{
    // Dashboard
    @FXML
    private Button btnDashboard;
    @FXML
    private Button buttonLogout;
    @FXML
    private Button btnMasterData;

    @FXML
    private void handleButtonDashboard(ActionEvent event) throws Exception {
        Main main = new Main();
        main.changeScene("Dashboard.fxml");
    }

    @FXML
    private void handleButtonLogoutAction(ActionEvent event) throws Exception {
        Main main = new Main();
        main.changeScene("Main.fxml");
    }
    
    @FXML
    private void handleButtonMasterAction(ActionEvent event) throws Exception {        
        Main main = new Main();
        main.changeScene("MasterData.fxml");
}


    // untuk bagian CRUD Kota
    
    private Kota selectedKota;
    
    
    @FXML private Button btnAddKota;
    @FXML private Button btnDeleteKota;
    @FXML private Button btnUpdateKota;
    
    @FXML private TextField txtNamaKota;

    
    
    @FXML
    private TableColumn<Kota, String> colNamaKota;
    
     @FXML
    private TableColumn<Kota, Integer> colIdKota;

    
    @FXML
    private TableView<Kota> tblKota;
    
    
    private void loadDataKota() {
        
        ObservableList<Kota> kotaList = KotaDAO.getKota();
        
        tblKota.setItems(kotaList);
        cmbKota.setItems(kotaList);
    }
    
    
    
    
    private void clearFields(){
        txtNamaKota.clear();
        selectedKota = null;
        
        txtNamaOrganisasi.clear();
        selectedOrganisasi = null;
    
        
        txtNamaAnggota.clear();
        txtAlamat.clear();
        txtTelepon.clear();
        dpTanggalDaftar.setValue(null);
        groupJenisKelamin.selectToggle(null);
        cmbKota.setValue(null);
        txtEmail.clear();
        cmbOrganisasi.setValue(null);
        selectedAnggota = null;
    }
    
    private void showAlert(String title, String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    private void selectKota(Kota kota){
        if (kota != null){
            selectedKota = kota;
            txtNamaKota.setText(kota.getNama());
        }
    }
    
    @FXML
    private void addKota() {
        String nama = txtNamaKota.getText();

        
        if (nama.isEmpty() ){
            showAlert("Input Error", "Field tidak boleh kosong!");
            return;
        }
        

        Kota newKota = new Kota(nama);
        KotaDAO.addKota(newKota);
        loadDataKota();
        clearFields();
    }
    
    @FXML
    private void updateKota() {
        if (selectedKota == null) {
            showAlert("Selection Error", "Tidak ada user yang dipilih!");
            return;
        }
        
        String nama = txtNamaKota.getText();

        
        if (nama.isEmpty() ){
            showAlert("Input Error", "Field tidak boleh kosong!");
            return;
        }
        
        selectedKota.setNama(nama);

        
        KotaDAO.updateKota(selectedKota);
        loadDataKota();
        clearFields();
    }
    
    @FXML
    private void deleteKota(){
        if (selectedKota == null){
            showAlert("Selection Error", "Tidak ada user yang dipilih!");
            return;
        }
        
        KotaDAO.deleteKota(selectedKota.getNama());
        loadDataKota();
        clearFields();
    }
    
    
    // ini untuk bagian CRUD Organisasi
    private Organisasi selectedOrganisasi;
    
    @FXML private TextField txtNamaOrganisasi;
    @FXML private RadioButton rdoJenisOrganisasi1;
    @FXML private RadioButton rdoJenisOrganisasi2;
    @FXML private RadioButton rdoJenisOrganisasi3;

    // Ini adalah properties Toggle Group dari kedua RadioButton
    @FXML private ToggleGroup groupJenisOrganisasi;
    
    @FXML private Button btnAddOrganisasi;
    @FXML private Button btnDeleteOrganisasi;
    @FXML private Button btnUpdateOrganisasi;
   
    
    @FXML
    private TableColumn<Organisasi, Integer> colIdOrganisasi;
    
    @FXML
    private TableColumn<Organisasi, String> colNamaOrganisasi;
    
    @FXML
    private TableColumn<Organisasi, String> colJenisOrganisasi;
   
    @FXML
    private TableView<Organisasi> tblOrganisasi;
    
    private void loadDataOrganisasi() {
        
        OrganisasiDAO organisasiDAO = new OrganisasiDAO();
        ObservableList<Organisasi> organisasiList = FXCollections.observableArrayList(organisasiDAO.getOrganisasi());
        
        //ObservableList<Organisasi> organisasiList = OrganisasiDAO.getOrganisasi();
        
        
        tblOrganisasi.setItems(organisasiList);
        cmbOrganisasi.setItems(organisasiList);
    }
    
    private void selectOrganisasi(Organisasi organisasi){
        if (organisasi != null){
            selectedOrganisasi = organisasi;
            txtNamaOrganisasi.setText(organisasi.getNama());
        }
    }
    
    @FXML
    private void addOrganisasi() {
        String nama = txtNamaOrganisasi.getText();
        String jenis = ((RadioButton) groupJenisOrganisasi.getSelectedToggle()).getText();
        
        if (nama.isEmpty() ){
            showAlert("Input Error", "Field tidak boleh kosong!");
            return;
        }
        

        Organisasi newOrganisasi = new Organisasi(nama, jenis);
        OrganisasiDAO.addOrganisasi(newOrganisasi);
        loadDataOrganisasi();
        clearFields();
    }
    
    @FXML
    private void updateOrganisasi() {
        if (selectedOrganisasi == null) {
            showAlert("Selection Error", "Tidak ada user yang dipilih!");
            return;
        }
        
        String nama = txtNamaOrganisasi.getText();
        String jenis = ((RadioButton) groupJenisOrganisasi.getSelectedToggle()).getText();

        
        if (nama.isEmpty() ){
            showAlert("Input Error", "Field tidak boleh kosong!");
            return;
        }
        
        selectedOrganisasi.setNama(nama);
        selectedOrganisasi.setJenis(jenis);

        
        OrganisasiDAO.updateOrganisasi(selectedOrganisasi);
        loadDataOrganisasi();
        clearFields();
    }
    
    @FXML
    private void deleteOrganisasi(){
        if (selectedOrganisasi == null){
            showAlert("Selection Error", "Tidak ada user yang dipilih!");
            return;
        }
        
        OrganisasiDAO.deleteOrganisasi(selectedOrganisasi.getNama());
        loadDataOrganisasi();
        clearFields();
    }
    
        @Override
    public void initialize(URL url, ResourceBundle rb) {
        colIdKota.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNamaKota.setCellValueFactory(new PropertyValueFactory<>("nama"));
        loadDataKota();

        colIdOrganisasi.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNamaOrganisasi.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colJenisOrganisasi.setCellValueFactory(new PropertyValueFactory<>("jenis"));
        loadDataOrganisasi();
        
        colIdAnggota.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNamaAnggota.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colJenisKelamin.setCellValueFactory(new PropertyValueFactory<>("jenisKelamin"));
        colOrganisasi.setCellValueFactory(new PropertyValueFactory<>("NamaOrganisasi"));
        loadDataAnggota();

        // Menambahkan event listener ke tabel kota
        tblKota.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> selectKota(newValue)
        );

        // Menambahkan event listener ke tabel organisasi
        tblOrganisasi.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> selectOrganisasi(newValue)
        );
                
        loadDataAnggota();
        tblAnggota.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> selectAnggota(newValue)
        );
    }
    
        // ini untuk Bagian CRUD Anggota
    
        private Anggota selectedAnggota;

    @FXML private TextField txtNamaAnggota;
    @FXML private TextField txtAlamat;
    @FXML private TextField txtTelepon;
    @FXML private DatePicker dpTanggalDaftar;
    @FXML private RadioButton rdoJenisKelaminL;
    @FXML private RadioButton rdoJenisKelaminP;
    @FXML private RadioButton rdoJenisAng1;
    @FXML private RadioButton rdoJenisAng2;
    @FXML private RadioButton rdoJenisAng3;
    @FXML private ComboBox<Kota> cmbKota;
    @FXML private TextField txtEmail;
    @FXML private ComboBox<Organisasi> cmbOrganisasi;

    @FXML private ToggleGroup groupJenisKelamin;
    @FXML private Button btnAddAnggota;
    @FXML private Button btnDeleteAnggota;
    @FXML private Button btnUpdateAnggota;

    @FXML private TableColumn<Anggota, Integer> colIdAnggota;
    @FXML private TableColumn<Anggota, String> colNamaAnggota;
    @FXML private TableColumn<Anggota, String> colJenisKelamin;
    @FXML private TableColumn<Anggota, String> colOrganisasi;
    @FXML private TableView<Anggota> tblAnggota;

    @FXML
    private void loadDataAnggota() {
        ObservableList<Anggota> anggotaList = FXCollections.observableArrayList(AnggotaDAO.getAnggota());
        tblAnggota.setItems(anggotaList);
    }

    @FXML
    private void selectAnggota(Anggota anggota) {
        if (anggota != null) {
            selectedAnggota = anggota;
            txtNamaAnggota.setText(anggota.getNama());
            txtAlamat.setText(anggota.getAlamat());
            txtTelepon.setText(anggota.gettelepon());
            dpTanggalDaftar.setValue(LocalDate.parse(anggota.gettanggalDaftar()));

            if (anggota.getJenisKelamin().equalsIgnoreCase("L")) {
                rdoJenisKelaminL.setSelected(true);
            } else {
                rdoJenisKelaminP.setSelected(true);
            }

            cmbKota.setValue(new Kota(anggota.getidKota(), ""));
            txtEmail.setText(anggota.getemail());
            cmbOrganisasi.setValue(new Organisasi(anggota.getIdOrganisasi(), "", ""));
        }
    }

    @FXML
    private void addAnggota() {
        String nama = txtNamaAnggota.getText();
        String alamat = txtAlamat.getText();
        String telepon = txtTelepon.getText();
        String tanggalDaftar = (dpTanggalDaftar.getValue() != null) ? dpTanggalDaftar.getValue().toString() : "";
        String jenisKelamin = (groupJenisKelamin.getSelectedToggle() != null) ? 
                      ((RadioButton) groupJenisKelamin.getSelectedToggle()).getText().substring(0, 1) : "";
        int idKota = getSelectedIdKota();
        String email = txtEmail.getText();
        int idOrganisasi = getSelectedIdOrganisasi();

        if (nama.isEmpty() || alamat.isEmpty() || telepon.isEmpty() || email.isEmpty() || tanggalDaftar.isEmpty() || jenisKelamin.isEmpty()) {
            showAlert("Input Error", "FielSd tidak boleh kosong!");
            return;
        }

        Anggota newAnggota = new Anggota(nama, "", alamat, telepon, tanggalDaftar, jenisKelamin, idKota, email, idOrganisasi, "");
        AnggotaDAO.addAnggota(newAnggota);
        loadDataAnggota();
        clearFields();
    }

    @FXML
    private void updateAnggota() {
        if (selectedAnggota == null) {
            showAlert("Selection Error", "Tidak ada anggota yang dipilih!");
            return;
        }

        selectedAnggota.setNama(txtNamaAnggota.getText());
        selectedAnggota.setalamat(txtAlamat.getText());
        selectedAnggota.settelepon(txtTelepon.getText());
        selectedAnggota.settanggalDaftar(dpTanggalDaftar.getValue().toString());
        selectedAnggota.setjenisKelamin(((RadioButton) groupJenisKelamin.getSelectedToggle()).getText());
        selectedAnggota.setidKota(getSelectedIdKota());
        selectedAnggota.setemail(txtEmail.getText());
        selectedAnggota.setidOrganisasi(getSelectedIdOrganisasi());

        AnggotaDAO.updateAnggota(selectedAnggota);
        loadDataAnggota();
        clearFields();
    }

    @FXML
    private void deleteAnggota() {
        if (selectedAnggota == null) {
            showAlert("Selection Error", "Tidak ada anggota yang dipilih!");
            return;
        }
        AnggotaDAO.deleteAnggota(selectedAnggota.getId());
        loadDataAnggota();
        clearFields();
    }

        @FXML
        public int getSelectedIdKota() {
        Kota selectedKota = cmbKota.getSelectionModel().getSelectedItem();
        return (selectedKota != null) ? selectedKota.getId() : -1;
    }

        @FXML
        public int getSelectedIdOrganisasi() {
        Organisasi selectedOrganisasi = cmbOrganisasi.getSelectionModel().getSelectedItem();
        return (selectedOrganisasi != null) ? selectedOrganisasi.getId() : -1;
        }
}
     
    /**
     * Initializes the controller class.
     */
    
   
