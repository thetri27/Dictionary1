package thetri.com.dictionary.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import thetri.com.dictionary.R;
import thetri.com.dictionary.until.DictionalModel;

/**
 * Created by DELL on 9/11/2017.
 */

public class WordAdapter  extends RecyclerView.Adapter<WordAdapter.ViewHolder> {
    public List<DictionalModel> data;

    public WordAdapter(){

    }
    public void setData(List<DictionalModel> data){
        this.data=data;
        notifyDataSetChanged();
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View wordView=inflater.inflate(R.layout.word_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(wordView,context);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        DictionalModel dictionalModel=data.get(position);
        holder.wordText.setText(dictionalModel.getWord());
        Log.d("word",""+dictionalModel.getWord()+","+dictionalModel.getDefinition());
    }


    @Override
    public int getItemCount() {
        return 0;
    }
    public  class ViewHolder extends RecyclerView.ViewHolder{
        public Context context;
        public TextView wordText;
        public ViewHolder(View itemView, Context context) {
            super(itemView);
            this.context=context;
            wordText=(TextView)itemView.findViewById(R.id.wordText);
        }
    }
}
