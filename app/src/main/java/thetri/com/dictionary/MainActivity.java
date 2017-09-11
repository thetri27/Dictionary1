package thetri.com.dictionary;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

import thetri.com.dictionary.adapters.WordAdapter;
import thetri.com.dictionary.until.DictionalModel;

public class MainActivity extends AppCompatActivity {
    public static final String fileDictionary="dictionary.txt";
    private List<DictionalModel> data;
    private RecyclerView rvWord;
    private WordAdapter wordAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rvWord=(RecyclerView)findViewById(R.id.rvWord);
        rvWord.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        data=new ArrayList<>();
        readFromAsset(getApplicationContext(),fileDictionary);
        wordAdapter=new WordAdapter();
        wordAdapter.setData(data);
        rvWord.setAdapter(wordAdapter);

    }
    private void readFromAsset(Context context, String filename){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open(filename)));
            String mLine;
            int i=0;
            while ((mLine= reader.readLine())!= null) {
                String[] lineData=mLine.split("-");
                data.add(new DictionalModel("" +i, lineData[0], lineData[1]));
                Log.d("word",""+lineData[0]);
                i++;

            }reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
