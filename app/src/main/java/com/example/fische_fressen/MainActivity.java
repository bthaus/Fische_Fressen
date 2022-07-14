package com.example.fische_fressen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import com.example.fische_fressen.databinding.ActivityMainBinding;
import com.example.fische_fressen.utils.Global;
import com.example.fische_fressen.utils.MenuMusicService;

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.OutputStreamWriter;

//todo:
//Persistenz von Username (und eventuellen anderen globalen Variablen, zb später : id)
//on start: verbindung zum server herstellen (hier bekommt man schon die unique id)
//create game
//join game
//evt. menü ~
//Spielanleitung copy pasten
//leave game button (exit button)
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initGlobalProps();
        binding.displayUserName.setText(Global.getUserName());

        binding.startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: Lobby später dazwischenschalten (Eigene Assets für Lobby-Schrift fehlen leider :/ )
                selectDifficulty();
            }
        });
        binding.optionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterName();
            }
        });
        binding.tutorialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTutorial();
            }
        });
        binding.statistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // startActivity(new Intent(view.getContext(), StatisticScreen.class));
                startActivity(new Intent(view.getContext(), StatisticOverviewActivity.class));
            }
        });

    }

    public void selectDifficulty() {
        startActivity(new Intent(this, DifficultyActivity.class));
    }

    public void enterName() {
        //TODO: Dialog für Namensauswahl
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Name auswählen: ");

        // Set up the input
        final EditText input = new EditText(this);
        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Global.userName = input.getText().toString();
                saveGlobalProps(input.getText().toString());
                // binding.displayUserName.setText(GlobalVariables.getUserName());
                initGlobalProps(); //Aktualisieren der entsprechenden Views
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }

    public void startTutorial() {
        startActivity(new Intent(this, TutorialActivity.class));
    }

    public void toLobby(View view) {
        startActivity(new Intent(this, LobbyActivity.class));
    }

    //Username und später eventuelle andere persistente Daten werden in einem kleinem File gespeichert
    private void saveGlobalProps(String username) {
        try {
            OutputStreamWriter osw = new OutputStreamWriter(getApplicationContext().openFileOutput("data.json", Context.MODE_PRIVATE));
            JSONObject object = new JSONObject();
            object.put("username", username);
            osw.write(object.toString());
            osw.close();
        } catch (Exception e) {
        }
    }

    private void initGlobalProps() {
        File file = new File(getApplicationContext().getFilesDir(), "data.json");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            StringBuilder content = new StringBuilder();
            while (br.ready()) {
                String line = br.readLine();
                content.append(line);
            }
            br.close();
            JSONObject json = new JSONObject(content.toString());
            Global.setUserName(json.getString("username"));
            binding.displayUserName.setText(Global.getUserName());
        } catch (Exception e) {
            Log.i("FILE READ ERROR", e.toString());
            Global.setUserName("NEW_USER");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Global.playing = false;
    }
    @Override
    public void onPause() {
        super.onPause();
    }


}