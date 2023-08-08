import javafx.application.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.NoSuchElementException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main extends Application {
    // GUI components
    Label lblImage;
    Label lblMessage;
    TextField txtMessage;
    ImageView image;
    Button btn;



    // socket components
    String username;
    Socket client;
    ExecutorService es;
    BufferedInputStream readFromServer;
    PrintWriter writeToServer;

    public void connect() throws IOException {
        client = new Socket("127.0.0.1", 1234);
        client.setReceiveBufferSize(131072);
        es = Executors.newFixedThreadPool(2);
        readFromServer = new BufferedInputStream(client.getInputStream(),
                131072);
        writeToServer = new PrintWriter(client.getOutputStream(),
                true, StandardCharsets.UTF_8);

        writeToServer.println(username);
        // new thread: read from server and print to the screen
        es.execute(()->{
            while(true) {
                try {
                    byte[] sizeBytes = readFromServer.readNBytes(4);
                    int size = ByteBuffer.wrap(sizeBytes).getInt();
                    byte[] imageBytes = readFromServer.readNBytes(size);
                    image.setImage(new Image(new ByteArrayInputStream(imageBytes)));
                    image.setFitHeight(250);
                    image.setPreserveRatio(true);
                } catch (NoSuchElementException | IOException e) {
                    break;
                }
            }
        });
    }

    @Override
    public void start(Stage stage) {

        // SETUP THE PANE
        // The grid
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(5));
        grid.setHgap(5);
        grid.setVgap(5);

        // 1st row:

        lblImage = new Label("Image: ");

        image = new ImageView();
        image.setFitHeight(250);
        image.setPreserveRatio(true);


        grid.add(lblImage,0,0);
        GridPane.setHalignment(lblImage, HPos.RIGHT);
        GridPane.setValignment(lblImage, VPos.CENTER);

        grid.add(image,1,0);
        GridPane.setHalignment(image, HPos.LEFT);
        GridPane.setValignment(image, VPos.CENTER);

        // 2nd row:
        lblMessage = new Label("Request Image: ");
        txtMessage = new TextField();
        txtMessage.setPrefWidth(300);

        grid.add(lblMessage,0,1);
        GridPane.setHalignment(lblMessage, HPos.RIGHT);
        GridPane.setValignment(lblMessage, VPos.CENTER);

        grid.add(txtMessage,1,1);
        GridPane.setHalignment(txtMessage, HPos.LEFT);
        GridPane.setValignment(txtMessage, VPos.CENTER);

        // 3rd row
        btn = new Button("Send");
        btn.setOnAction(e->click());

        grid.add(btn, 1,2);
        GridPane.setHalignment(btn, HPos.RIGHT);
        GridPane.setHalignment(btn,HPos.CENTER);

        Scene scene = new Scene(grid);
        txtMessage.requestFocus();

        stage.setScene(scene);
        stage.setTitle("Image Viewer");
        stage.setX((Screen.getPrimary().getVisualBounds().getWidth()-400)/2);
        stage.setY((Screen.getPrimary().getVisualBounds().getHeight()-300)/2);
        stage.setWidth(500);
        stage.setHeight(450);

        stage.show();

        // enter username
        username = new MessageBoxInputText("Enter your username", "Username")
                .getResponse();
        // connect to the server
        try {
            connect();
        }
        catch (IOException e) {
            System.out.println("connection error");
        }
        // actions to close window
        stage.setOnCloseRequest(e->{
            writeToServer.println("quit");
            es.shutdownNow();
            try {
                client.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            stage.close();
        });
    }

    public void click() {
        String request = txtMessage.getText();
        writeToServer.println(request);
        if (request.equals("quit")) {
            es.shutdownNow();
            try {
                client.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.out.println("Bye Bye");
        }
        txtMessage.clear();
    }


    public static void main(String[] args) {
        launch(args);
    }
}