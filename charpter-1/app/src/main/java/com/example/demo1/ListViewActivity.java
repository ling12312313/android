package com.example.demo1;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class ListViewActivity extends AppCompatActivity {
    protected String wujiang[]= {"神曹操","神荀彧","谋关羽","孙寒华"};
    protected String prices[] ={150+"",102+"",96+"",66+""};
    protected int icons[]={R.drawable.caocao,R.drawable.xunyu,R.drawable.guanyu,R.drawable.sunhanhua};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        ListView listView = findViewById(R.id.list_view);
        Adapter adapter = new Adapter();
        listView.setAdapter(adapter);
        //单击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListViewActivity.this, wujiang[i]+"价格"+prices[i], Toast.LENGTH_SHORT).show();
            }
        });
        //长按事件
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
               Toast.makeText(ListViewActivity.this
               , wujiang[i],Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
    class Adapter extends BaseAdapter{

        @Override
        public int getCount() {
            return wujiang.length ;
        }

        @Override
        public Object getItem(int i) {
            return wujiang[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i,View converView,ViewGroup viewGroup){
           VH holder;
            if (converView==null){
                converView = View.inflate(ListViewActivity.this, R.layout.activity_adapter,null);
                holder = new VH();
                holder.iv_icons = converView.findViewById(R.id.iv);
                holder.wuJiang = converView.findViewById(R.id.wuJiang);
                holder.prices = converView.findViewById(R.id.tv_price);
                converView.setTag(holder);
            }
            else {
               holder = (VH) converView.getTag();
            }
            holder.iv_icons.setImageResource(icons[i]);
            holder.wuJiang.setText(wujiang[i]);
            holder.prices.setText(prices[i]);
            return converView;
        }
    }
    class VH{
        ImageView iv_icons;
        TextView wuJiang;
        TextView prices;
    }
}
