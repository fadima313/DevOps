package main;

import java.io.IOException;

import controller.LancementController;
import dao.UserDaoImpl;
import dao.HibernateUserDaoImpl;
import models.User;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UMSApplication extends Application {

    private Stage primaryStage;
    private AnchorPane lancement;

    private LancementController lancementController = null;
   
    private UserDaoImpl daoImpl;
    private HibernateUserDaoImpl hDaoImpl;
 
    private static UMSApplication instance = null;

    public static UMSApplication getInstance() {
        return instance;
    }

    public UserDaoImpl getDaoImpl() {
        if (daoImpl != null)
            return daoImpl;
        else {
            daoImpl = new UserDaoImpl();
        }
        return daoImpl;
    }

    public HibernateUserDaoImpl getHibernateDaoImpl() {
        if (hDaoImpl != null)
            return hDaoImpl;
        else {
            hDaoImpl = new HibernateUserDaoImpl();
        }
        return hDaoImpl;
    }

    @Override
    public void start(Stage primaryStage) {
        instance = this;

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Restaurant Management System");
        //initRootLayout();
        // showLancementController();
    }
    
    public void initRootLayout() {
        try {
        	
        	lancement = (AnchorPane) FXMLLoader.load(getClass()
        			.getClassLoader().getResource("../controller/Lancement.fxml"));
        	
            Scene scene = new Scene(lancement);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void showLancementController() {
        try {
        	// URL url = new File("src/com/resto/controller/Lancement.fxml").toURI().toURL();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../com/resto/controller/Lancement.fxml"));
            Parent newWindowRoot = loader.load();
            lancementController = loader.getController();

            Scene newWindowScene = new Scene(newWindowRoot);
            Stage newWindowStage = new Stage();
            newWindowStage.setTitle("Page de Lancement de l'application");
            newWindowStage.setScene(newWindowScene);

            newWindowStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public LancementController getLancementController() {
        return lancementController;
    }

    public void setLancementController(LancementController lancementController) {
        this.lancementController = lancementController;
    }

    public void showEditUserUI(User selectedUser) {
        // TODO: Afficher l'interface utilisateur pour la modification de l'utilisateur sélectionné
    }

	public void onLancementClick() {
		// TODO Auto-generated method stub
		
	}
}
