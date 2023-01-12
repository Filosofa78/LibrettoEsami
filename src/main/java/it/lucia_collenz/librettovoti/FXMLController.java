package it.lucia_collenz.librettovoti;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import it.lucia_collenz.librettovoti.model.Libretto;
import it.lucia_collenz.librettovoti.model.Voto;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class FXMLController {

    private Libretto model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Integer> cmbPunti;

    @FXML
    private TextField txtNome;

    @FXML
    private TextArea txtVoti;

    @FXML
    private Label lblStato;

    @FXML
    private TableView<Voto> tblLibretto;

    @FXML
    private TableColumn<Voto, String> colCorso;

    @FXML
    private TableColumn<Voto, String> colData;

    @FXML
    private TableColumn<Voto, Integer> colVoto;

    @FXML
    void handleNuovoVoto(ActionEvent event) {
        // 1. Acquisizione e controllo dati
        String nome = txtNome.getText();
        Integer punti = cmbPunti.getValue();

        if (nome.equals("") || punti == null) {
            lblStato.setText("ERRORE: occorre inserire nome e voto\n");
            return;
        }

        // 2. Esecuzione dell'operazione (si chiede al model di farla)
        boolean ok = model.add(new Voto(nome, punti, LocalDate.now()));

        // 3. Visualizzazione/aggiornamento del risultato
        if (ok) {
            //tblLibretto.setItems(FXCollections.observableArrayList(model.getVoti()));
            /*List<Voto> voti = model.getVoti();
            txtVoti.clear();
            txtVoti.appendText("Hai superato " + voti.size() + " esami\n");
            for (Voto v : voti) {
                txtVoti.appendText(v.toString() + "\n");
            }*/
            tblLibretto.setItems(FXCollections.observableArrayList(model.getVoti()));


            txtNome.clear();
            cmbPunti.setValue(null);
            lblStato.setText(null);
        } else {
            lblStato.setText("ERRORE: Esame già presente");
        }
    }

    public void setModel(Libretto model) {
        this.model = model;
        tblLibretto.setItems(FXCollections.observableArrayList(model.getVoti()));
        //List<Voto> voti = model.getVoti();
        /*txtVoti.clear();
        txtVoti.appendText("Hai superato " + voti.size() + " esami\n");
        for (Voto v : voti) {
            txtVoti.appendText(v.toString() + "\n");
        }*/
    }

    @FXML
    void initialize() {
        assert cmbPunti != null : "fx:id=\"cmbPunti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtVoti != null : "fx:id=\"txtVoti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lblStato != null : "fx:id=\"lblStato\" was not injected: check your FXML file 'Scene.fxml'.";

        cmbPunti.getItems().clear();

        for (int i = 18; i <= 30 ; i++) {
            cmbPunti.getItems().add(i);
        }

        colCorso.setCellValueFactory(new PropertyValueFactory<Voto, String>("nome"));
        colVoto.setCellValueFactory(new PropertyValueFactory<Voto, Integer>("punti"));
    }
}
