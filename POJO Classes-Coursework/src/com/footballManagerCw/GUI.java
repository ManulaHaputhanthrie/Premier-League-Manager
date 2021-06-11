package com.footballManagerCw;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GUI extends Application
{

    PremierLeagueManager plm = new PremierLeagueManager();

    ArrayList<FootballClub> clubList = new ArrayList<>();
    ArrayList<MatchDetails> matchDetails = new ArrayList<>();

    ObservableList<Object> clubs = FXCollections.observableArrayList();
    ObservableList<Object> matches = FXCollections.observableArrayList();
    ObservableList<Object> searching = FXCollections.observableArrayList();

    TextField textOfYear, textOfMonth, textOfDay;
    int matchYear, matchMonth, matchDay;

    TableView<Object> mtchDtlTbl;
    TableView<Object> pLTbl;
    Scene menuScn,clubStatsScn,mtchDetailsScn;

    public ObservableList<Object> getClubDetails()
    {

        try
        {
            FileInputStream fis = new FileInputStream("clubFile.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            clubList = (ArrayList<FootballClub>) ois.readObject();
            fis.close();
            ois.close();
        }
        catch (ClassNotFoundException cnfe)
        {
            cnfe.printStackTrace();
        }
        catch (IOException ioe)
        {
            System.out.println("");
        }
        catch(NullPointerException npe)
        {
            System.out.println("Not listed any club yet!");
        }

        clubs.clear();
        Comparator<FootballClub> sorting = Comparator.comparing(FootballClub::getNumOfPoints).thenComparing(FootballClub::getGoalDifference);
        clubList.sort(sorting);
        Collections.reverse(clubList);
        clubs.addAll(clubList);
        return clubs;

    }

    public ObservableList<Object> getMatchDetails()
    {
        try
        {
            FileInputStream fismd2 = new FileInputStream("matchDetails.ser");
            ObjectInputStream oismd2 = new ObjectInputStream(fismd2);
            matchDetails = (ArrayList<MatchDetails>) oismd2.readObject();
            fismd2.close();
            oismd2.close();
        }
        catch (ClassNotFoundException cnfe)
        {
            cnfe.printStackTrace();
        }
        catch (IOException ioe)
        {
            System.out.println("");
        }
        catch (NullPointerException npe)
        {
            System.out.println("Not listed any club yet!");
        }

        matches.clear();
        matches.addAll(matchDetails);
        return matches;
    }

    public ObservableList<Object> sortWins()
    {

        clubs.clear();
        Comparator<FootballClub> sortWins = Comparator.comparing(FootballClub::getNumOfWins);
        clubList.sort(sortWins.reversed());
        clubs.addAll(clubList);
        return clubs;

    }

    public ObservableList<Object> sortScoredGoals()
    {

        clubs.clear();
        Comparator<FootballClub> sortScoredGoals = Comparator.comparing(FootballClub::getNumOfGoalsScored);
        clubList.sort(sortScoredGoals.reversed());
        clubs.addAll(clubList);
        return clubs;

    }

    public ObservableList<Object> sortPoints()
    {

        clubs.clear();
        Comparator<FootballClub> sortPoints = Comparator.comparing(FootballClub::getNumOfPoints);
        clubList.sort(sortPoints.reversed());
        clubs.addAll(clubList);
        return clubs;

    }

    @Override

    public void start(Stage stage) throws Exception
    {
        stage.setTitle("Premier League Manager ");

        //Menu Window Creation

        AnchorPane ap1 = new AnchorPane();

        Label lbl_title = new Label("Welcome to the Premier League Manager");
        lbl_title.setLayoutX(100);
        lbl_title.setLayoutY(40);
        lbl_title.setStyle("-fx-alignment:center; -fx-font:bold 30px 'monospace';");

        Button btn_clubStats = new Button("Club Statistics");
        btn_clubStats.setLayoutX(325);
        btn_clubStats.setLayoutY(160);
        btn_clubStats.setStyle("-fx-min-width:210; -fx-min-height:65; -fx-background-radius:15; " +
                "-fx-background-color:lightseagreen; -fx-text-fill:white; -fx-font:bold 22px 'fantasy';");
        btn_clubStats.setOnMouseEntered(event -> btn_clubStats.setStyle("-fx-min-width:210; -fx-min-height:65;" +
                " -fx-background-radius:15; -fx-background-color:greenyellow; -fx-font:bold 22px 'fantasy';"));
        btn_clubStats.setOnMouseExited(event -> btn_clubStats.setStyle("-fx-min-width:210; -fx-min-height:65; " +
                "-fx-background-radius:15; -fx-background-color:lightseagreen; -fx-text-fill:white; -fx-font:bold 22px 'fantasy';"));
        btn_clubStats.setOnAction(event -> stage.setScene(clubStatsScn));

        Button btn_mtchDtls = new Button("Details of Matches");
        btn_mtchDtls.setLayoutX(320);
        btn_mtchDtls.setLayoutY(260);
        btn_mtchDtls.setStyle("-fx-min-width:210; -fx-min-height:65; -fx-background-radius:15;" +
                "-fx-background-color:lightseagreen; -fx-text-fill:white; -fx-font:bold 22px 'fantasy';");
        btn_mtchDtls.setOnMouseEntered(event -> btn_mtchDtls.setStyle("-fx-min-width:210; -fx-min-height:65;" +
                " -fx-background-radius:15; -fx-background-color:greenyellow; -fx-font:bold 22px 'fantasy';"));
        btn_mtchDtls.setOnMouseExited(event -> btn_mtchDtls.setStyle("-fx-min-width:210; -fx-min-height:65;" +
                " -fx-background-radius:15; -fx-background-color:lightseagreen;-fx-text-fill:white; -fx-font:bold 22px 'fantasy';"));
        btn_mtchDtls.setOnAction(event -> stage.setScene(mtchDetailsScn));

        Button btn_closeWindow = new Button("Close Window");
        btn_closeWindow.setLayoutX(580);
        btn_closeWindow.setLayoutY(400);
        btn_closeWindow.setStyle("-fx-min-width:150; -fx-min-height:40; -fx-background-radius:15;" +
                "-fx-background-color:tomato; -fx-text-fill:white; -fx-font:bold 18px 'fantasy';");
        btn_closeWindow.setOnMouseEntered(event -> btn_closeWindow.setStyle("-fx-min-width:150; -fx-min-height:40;" +
                " -fx-background-radius:15; -fx-background-color:salmon; -fx-font:bold 18px 'fantasy';"));
        btn_closeWindow.setOnMouseExited(event -> btn_closeWindow.setStyle("-fx-min-width:150; -fx-min-height:40;" +
                " -fx-background-radius:15; -fx-background-color:tomato;-fx-text-fill:white; -fx-font:bold 18px 'fantasy';"));
        btn_closeWindow.setOnAction(event -> stage.close());

        ap1.getChildren().addAll(lbl_title, btn_clubStats, btn_mtchDtls, btn_closeWindow);

        ap1.setStyle("-fx-background-color:wheat;");

        menuScn = new Scene(ap1, 850, 520);

        stage.setScene(menuScn);
        stage.show();


        //Club stats table creation

        AnchorPane ap2 = new AnchorPane();

        Label lbl_clubs = new Label("Stats Of Clubs");
        lbl_clubs.setLayoutX(400);
        lbl_clubs.setLayoutY(15);
        lbl_clubs.setStyle("-fx-alignment:center; -fx-font:bold 24px 'monospace';");

        TableColumn<Object, String> clmnClbName = new TableColumn<>("Club Name");
        clmnClbName.setCellValueFactory(new PropertyValueFactory<>("nameOfTheClub"));
        clmnClbName.setPrefWidth(150);

        TableColumn<Object, Integer> clmnMtches = new TableColumn<>("Played \nMatches");
        clmnMtches.setCellValueFactory(new PropertyValueFactory<>("numOfMatchesPlayed"));
        clmnMtches.setPrefWidth(100);

        TableColumn<Object, Integer> clmnWins = new TableColumn<>("Wins");
        clmnWins.setCellValueFactory(new PropertyValueFactory<>("numOfWins"));
        clmnWins.setPrefWidth(100);

        TableColumn<Object, Integer> clmnDraws = new TableColumn<>("Draws");
        clmnDraws.setCellValueFactory(new PropertyValueFactory<>("numOfDraws"));
        clmnDraws.setPrefWidth(100);

        TableColumn<Object, Integer> clmnDefeats = new TableColumn<>("Defeats");
        clmnDefeats.setCellValueFactory(new PropertyValueFactory<>("numOfDefeats"));
        clmnDefeats.setPrefWidth(100);

        TableColumn<Object, Integer> clmnScrdGls = new TableColumn<>("Scored Goals");
        clmnScrdGls.setCellValueFactory(new PropertyValueFactory<>("numOfGoalsScored"));
        clmnScrdGls.setPrefWidth(110);

        TableColumn<Object, Integer> clmnRcvdGls = new TableColumn<>("Received Goals");
        clmnRcvdGls.setCellValueFactory(new PropertyValueFactory<>("numOfGoalsReceived"));
        clmnRcvdGls.setPrefWidth(115);

        TableColumn<Object, Integer> clmnPoints = new TableColumn<>("Total Points");
        clmnPoints.setCellValueFactory(new PropertyValueFactory<>("numOfPoints"));
        clmnPoints.setPrefWidth(120);

        Button btn_sortingGoals = new Button("SortByScoredGoals");
        btn_sortingGoals.setLayoutX(980);
        btn_sortingGoals.setLayoutY(140);
        btn_sortingGoals.setStyle("-fx-min-width:150; -fx-min-height:35; -fx-background-radius:15; " +
                "-fx-background-color:steelblue; -fx-text-fill:white; -fx-font:bold 16px 'fantasy';");
        btn_sortingGoals.setOnMouseEntered(event -> btn_sortingGoals.setStyle("-fx-min-width:150; -fx-min-height:35;" +
                " -fx-background-radius:15; -fx-background-color:skyblue; -fx-font:bold 16px 'fantasy';"));
        btn_sortingGoals.setOnMouseExited(event -> btn_sortingGoals.setStyle("-fx-min-width:150; -fx-min-height:35; " +
                "-fx-background-radius:15; -fx-background-color:steelblue; -fx-text-fill:white; -fx-font:bold 16px 'fantasy';"));
        btn_sortingGoals.setOnAction(event -> sortScoredGoals());


        Button btn_sortingWins = new Button("SortByMatchWins");
        btn_sortingWins.setLayoutX(983);
        btn_sortingWins.setLayoutY(220);
        btn_sortingWins.setStyle("-fx-min-width:150; -fx-min-height:35; -fx-background-radius:15; " +
                "-fx-background-color:steelblue; -fx-text-fill:white; -fx-font:bold 16px 'fantasy';");
        btn_sortingWins.setOnMouseEntered(event -> btn_sortingWins.setStyle("-fx-min-width:150; -fx-min-height:35;" +
                " -fx-background-radius:15; -fx-background-color:skyblue; -fx-font:bold 16px 'fantasy';"));
        btn_sortingWins.setOnMouseExited(event -> btn_sortingWins.setStyle("-fx-min-width:150; -fx-min-height:35; " +
                "-fx-background-radius:15; -fx-background-color:steelblue; -fx-text-fill:white; -fx-font:bold 16px 'fantasy';"));
        btn_sortingWins.setOnAction(event -> sortWins());


        Button btn_sortingPoints = new Button("SortByPoints");
        btn_sortingPoints.setLayoutX(988);
        btn_sortingPoints.setLayoutY(300);
        btn_sortingPoints.setStyle("-fx-min-width:150; -fx-min-height:35; -fx-background-radius:15; " +
                "-fx-background-color:steelblue; -fx-text-fill:white; -fx-font:bold 16px 'fantasy';");
        btn_sortingPoints.setOnMouseEntered(event -> btn_sortingPoints.setStyle("-fx-min-width:150; -fx-min-height:35;" +
                " -fx-background-radius:15; -fx-background-color:skyblue; -fx-font:bold 16px 'fantasy';"));
        btn_sortingPoints.setOnMouseExited(event -> btn_sortingPoints.setStyle("-fx-min-width:150; -fx-min-height:35; " +
                "-fx-background-radius:15; -fx-background-color:steelblue; -fx-text-fill:white; -fx-font:bold 16px 'fantasy';"));
        btn_sortingPoints.setOnAction(event -> sortPoints());


        Button btn_back1 = new Button("< Back");
        btn_back1.setLayoutX(100);
        btn_back1.setLayoutY(470);
        btn_back1.setStyle("-fx-min-width:120; -fx-min-height:35; -fx-background-radius:15; " +
                "-fx-background-color:teal; -fx-text-fill:white; -fx-font:bold 16px 'fantasy';");
        btn_back1.setOnMouseEntered(event -> btn_back1.setStyle("-fx-min-width:120; -fx-min-height:35;" +
                " -fx-background-radius:15; -fx-background-color:mediumspringgreen; -fx-font:bold 16px 'fantasy';"));
        btn_back1.setOnMouseExited(event -> btn_back1.setStyle("-fx-min-width:120; -fx-min-height:35; " +
                "-fx-background-radius:15; -fx-background-color:teal; -fx-text-fill:white; -fx-font:bold 16px 'fantasy';"));
        btn_back1.setOnAction(event -> stage.setScene(menuScn));

        pLTbl = new TableView<>();
        pLTbl.setLayoutX(40);
        pLTbl.setLayoutY(45);
        pLTbl.setPrefSize(900,400);

        pLTbl.setItems(getClubDetails());
        pLTbl.getColumns().addAll(clmnClbName, clmnMtches, clmnWins,
                clmnDraws, clmnDefeats, clmnScrdGls, clmnRcvdGls, clmnPoints);

        ap2.getChildren().addAll(pLTbl, lbl_clubs, btn_sortingGoals, btn_sortingWins, btn_sortingPoints, btn_back1);

        ap2.setStyle("-fx-background-color:mistyrose;");

        clubStatsScn = new Scene(ap2, 1200, 530 );


        //Match History table creation

        AnchorPane ap3 = new AnchorPane();

        Label lbl_matches = new Label("Details of Matches");
        lbl_matches.setLayoutX(240);
        lbl_matches.setLayoutY(15);
        lbl_matches.setStyle("-fx-alignment:center; -fx-font:bold 24px 'monospace';");

        Label lbl_searchDate = new Label("Search By Date : ");
        lbl_searchDate.setLayoutX(420);
        lbl_searchDate.setLayoutY(510);
        lbl_searchDate.setStyle("-fx-alignment:center; -fx-font:bold 18px 'monospace';");

        textOfYear = new TextField();
        textOfYear.setLayoutX(420);
        textOfYear.setLayoutY(540);
        textOfYear.setMaxWidth(60);
        textOfYear.setPromptText("YYYY");

        Label lbl_slash1 = new Label("/");
        lbl_slash1.setLayoutX(487);
        lbl_slash1.setLayoutY(547);

        textOfMonth = new TextField();
        textOfMonth.setLayoutX(500);
        textOfMonth.setLayoutY(540);
        textOfMonth.setMaxWidth(45);
        textOfMonth.setPromptText("MM");

        Label lbl_slash2 = new Label("/");
        lbl_slash2.setLayoutX(553);
        lbl_slash2.setLayoutY(547);

        textOfDay = new TextField();
        textOfDay.setLayoutX(570);
        textOfDay.setLayoutY(540);
        textOfDay.setMaxWidth(45);
        textOfDay.setPromptText("DD");

        TableColumn<Object, String> clmnFrstTeam = new TableColumn<>("First Team");
        clmnFrstTeam.setCellValueFactory(new PropertyValueFactory<>("firstTeam"));
        clmnFrstTeam.setMinWidth(150);

        TableColumn<Object, String> clmnScndTeam = new TableColumn<>("Second Team");
        clmnScndTeam.setCellValueFactory(new PropertyValueFactory<>("secondTeam"));
        clmnScndTeam.setMinWidth(150);

        TableColumn<Object, Integer> clmnFrstTeamGls = new TableColumn<>("First Team \nGoals");
        clmnFrstTeamGls.setCellValueFactory(new PropertyValueFactory<>("goalsByFirstTeam"));
        clmnFrstTeamGls.setMinWidth(110);

        TableColumn<Object, Integer> clmnScndTeamGls = new TableColumn<>("Second Team \nGoals");
        clmnScndTeamGls.setCellValueFactory(new PropertyValueFactory<>("goalsBySecondTeam"));
        clmnScndTeamGls.setMinWidth(110);

        TableColumn<Object, String> clmnMtchDate = new TableColumn<>("Match Date");
        clmnMtchDate.setCellValueFactory(new PropertyValueFactory<>("matchDate"));
        clmnMtchDate.setMinWidth(140);

        Button btn_mtchGen = new Button("Generate Match");
        btn_mtchGen.setLayoutX(740);
        btn_mtchGen.setLayoutY(250);
        btn_mtchGen.setStyle("-fx-min-width:150; -fx-min-height:50; -fx-background-radius:15; " +
                "-fx-background-color:tomato; -fx-text-fill:white; -fx-font:bold 20px 'fantasy';");
        btn_mtchGen.setOnMouseEntered(event -> btn_mtchGen.setStyle("-fx-min-width:150; -fx-min-height:50;" +
                " -fx-background-radius:15; -fx-background-color:salmon; -fx-font:bold 20px 'fantasy';"));
        btn_mtchGen.setOnMouseExited(event -> btn_mtchGen.setStyle("-fx-min-width:150; -fx-min-height:50; " +
                "-fx-background-radius:15; -fx-background-color:tomato; -fx-text-fill:white; -fx-font:bold 20px 'fantasy';"));
        btn_mtchGen.setOnAction(event -> generatingRandMatch());


        Button btn_searchDate = new Button("Search Date");
        btn_searchDate.setLayoutX(700);
        btn_searchDate.setLayoutY(520);
        btn_searchDate.setStyle("-fx-min-width:150; -fx-min-height:35; -fx-background-radius:15; " +
                "-fx-background-color:steelblue; -fx-text-fill:white; -fx-font:bold 16px 'fantasy';");
        btn_searchDate.setOnMouseEntered(event -> btn_searchDate.setStyle("-fx-min-width:150; -fx-min-height:35;" +
                " -fx-background-radius:15; -fx-background-color:skyblue; -fx-font:bold 16px 'fantasy';"));
        btn_searchDate.setOnMouseExited(event -> btn_searchDate.setStyle("-fx-min-width:150; -fx-min-height:35; " +
                "-fx-background-radius:15; -fx-background-color:steelblue; -fx-text-fill:white; -fx-font:bold 16px 'fantasy';"));
        btn_searchDate.setOnAction(event -> dateSearch());


        Button btn_clearDate = new Button("Clear Date");
        btn_clearDate.setLayoutX(700);
        btn_clearDate.setLayoutY(580);
        btn_clearDate.setStyle("-fx-min-width:150; -fx-min-height:35; -fx-background-radius:15; " +
                "-fx-background-color:steelblue; -fx-text-fill:white; -fx-font:bold 16px 'fantasy';");
        btn_clearDate.setOnMouseEntered(event -> btn_clearDate.setStyle("-fx-min-width:150; -fx-min-height:35;" +
                " -fx-background-radius:15; -fx-background-color:skyblue; -fx-font:bold 16px 'fantasy';"));
        btn_clearDate.setOnMouseExited(event -> btn_clearDate.setStyle("-fx-min-width:150; -fx-min-height:35; " +
                "-fx-background-radius:15; -fx-background-color:steelblue; -fx-text-fill:white; -fx-font:bold 16px 'fantasy';"));
        btn_clearDate.setOnAction(event -> clearDate());


        Button btn_back2 = new Button("< Back");
        btn_back2.setLayoutX(100);
        btn_back2.setLayoutY(540);
        btn_back2.setStyle("-fx-min-width:120; -fx-min-height:35; -fx-background-radius:15; " +
                "-fx-background-color:teal; -fx-text-fill:white; -fx-font:bold 16px 'fantasy';");
        btn_back2.setOnMouseEntered(event -> btn_back2.setStyle("-fx-min-width:120; -fx-min-height:35;" +
                " -fx-background-radius:15; -fx-background-color:mediumspringgreen; -fx-font:bold 16px 'fantasy';"));
        btn_back2.setOnMouseExited(event -> btn_back2.setStyle("-fx-min-width:120; -fx-min-height:35; " +
                "-fx-background-radius:15; -fx-background-color:teal; -fx-text-fill:white; -fx-font:bold 16px 'fantasy';"));
        btn_back2.setOnAction(event -> stage.setScene(menuScn));

        mtchDtlTbl = new TableView<>();
        mtchDtlTbl.setLayoutX(40);
        mtchDtlTbl.setLayoutY(45);
        mtchDtlTbl.setPrefSize(670,450);

        mtchDtlTbl.setItems(getMatchDetails());
        mtchDtlTbl.getColumns().addAll(clmnFrstTeam, clmnScndTeam, clmnFrstTeamGls, clmnScndTeamGls, clmnMtchDate);

        ap3.getChildren().addAll(mtchDtlTbl, lbl_matches, lbl_searchDate, textOfYear, lbl_slash1,
                textOfMonth, lbl_slash2, textOfDay, btn_mtchGen, btn_searchDate, btn_clearDate, btn_back2);

        ap3.setStyle("-fx-background-color:mistyrose;");

        mtchDetailsScn = new Scene(ap3, 940, 650);

    }

    void generatingRandMatch()
    {

        plm.generatingRandMatch();
        getClubDetails();
        getMatchDetails();

    }

    public void dateSearch()
    {
        searching.clear();
        try
        {
            matchYear = Integer.parseInt(textOfYear.getText());
            matchMonth = Integer.parseInt(textOfMonth.getText());
            matchDay = Integer.parseInt(textOfDay.getText());
        }
        catch (Exception e)
        {
            System.out.println("\nPlease enter a date");
        }
        for (MatchDetails mD : matchDetails)
        {
            if (matchDay == mD.getMatchDate().getMatchDay() && matchMonth ==
                    mD.getMatchDate().getMatchMonth() && matchYear == mD.getMatchDate().getMatchYear())
            {
                searching.add(mD);
            }
        }

        mtchDtlTbl.setItems(searching);

    }

    public void clearDate()
    {

        mtchDtlTbl.setItems(getMatchDetails());
        textOfYear.setText("");
        textOfMonth.setText("");
        textOfDay.setText("");

    }

    public static void main(String args[])
    {
        launch(args);
    }

}
