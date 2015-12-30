package jp.ac.it_college.std.s14010.tetris;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Ranking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        loadBestScore();
    }

    private void loadBestScore() {
        TextView ScoreView1 = (TextView)findViewById(R.id.score1);
        TextView ScoreView2 = (TextView)findViewById(R.id.score2);
        TextView ScoreView3 = (TextView)findViewById(R.id.score3);
        TextView ScoreView4 = (TextView)findViewById(R.id.score4);
        TextView ScoreView5 = (TextView)findViewById(R.id.score5);

        InputStream in;
        String lineBuffer;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(0);
        arrayList.add(0);
        arrayList.add(0);
        arrayList.add(0);
        arrayList.add(0);

        try {
            in = openFileInput("Ranking.txt");

            BufferedReader reader= new BufferedReader(new InputStreamReader(in,"UTF-8"));
            while( (lineBuffer = reader.readLine()) != null ){
                Log.d("FileAccess", lineBuffer);
                int chenge = Integer.valueOf(lineBuffer);
                arrayList.add(chenge);
            }
            Collections.sort(arrayList);
            Collections.reverse(arrayList);
            ScoreView1.setText(String.valueOf(arrayList.get(0)));
            ScoreView2.setText(String.valueOf(arrayList.get(1)));
            ScoreView3.setText(String.valueOf(arrayList.get(2)));
            ScoreView4.setText(String.valueOf(arrayList.get(3)));
            ScoreView5.setText(String.valueOf(arrayList.get(4)));

            OutputStream out;
            try {
                out = openFileOutput("ranking.txt",MODE_PRIVATE|MODE_APPEND);
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(out,"UTF-8"));

                writer.append(String.valueOf(arrayList.get(0)));
                writer.append("\n");
                writer.append(String.valueOf(arrayList.get(1)));
                writer.append("\n");
                writer.append(String.valueOf(arrayList.get(2)));
                writer.append("\n");
                writer.append(String.valueOf(arrayList.get(3)));
                writer.append("\n");
                writer.append(String.valueOf(arrayList.get(4)));
                writer.append("\n");
                writer.close();
            } catch (IOException e) {
                // TODO 自動生成された catch ブロック
                e.printStackTrace();
            }


        } catch (IOException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }

    }
}
