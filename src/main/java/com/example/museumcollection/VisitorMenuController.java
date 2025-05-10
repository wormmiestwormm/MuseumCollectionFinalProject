package com.example.museumcollection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

import java.io.IOException;


public class MenuController extends VisitorMenu{
    @FXML

    private Text areaOfStudy;

    @FXML
    private Text collectionText;

    @FXML
    private TextField searchBar;

    private Stage stage;

    private Scene scene;

    private Parent root;

    PublicCollection pC = new PublicCollection();

    @FXML
    protected void onArchaeologySelection(ActionEvent event) throws IOException {
        pC.copyFullCollection(1);
        areaOfStudy.setText("Archaeology Collection:");
        collectionText.setText(pC.getPublicCollectionFX());
    }
    @FXML
    protected void onGeologySelection(ActionEvent event) throws IOException {
        pC.copyFullCollection(2);
        areaOfStudy.setText("Geology Collection:");
        collectionText.setText(pC.getPublicCollectionFX());
    }
    @FXML
    protected void onPaleontologySelection(ActionEvent event) throws IOException {
        pC.copyFullCollection(3);
        areaOfStudy.setText("Paleontology Collection:");
        collectionText.setText(pC.getPublicCollectionFX());
    }

    @FXML
    protected void onSortAZSelection() throws IOException
    {
        pC.sortCollectionAZ();
        collectionText.setText(pC.getPublicCollectionFX());
    }
    @FXML
    protected void onSortZASelection() throws IOException
    {
        pC.sortCollectionZA();
        collectionText.setText(pC.getPublicCollectionFX());
    }
    @FXML
    protected void onSortDateSelection() throws IOException
    {
        pC.sortCollectionDate();
        collectionText.setText(pC.getPublicCollectionFX());
    }
    @FXML
    protected void onSortRegionSelection() throws IOException
    {
        pC.sortCollectionRegion();
        collectionText.setText(pC.getPublicCollectionFX());
    }

    @FXML
    protected void search () throws IOException
    {
        pC.filterCollection(searchBar.getText());
        collectionText.setText(pC.getPublicCollectionFX());
    }

    @FXML
    protected void onViewSelection () throws IOException
    {
        collectionText.setText(pC.getPublicCollectionFX());
    }
}