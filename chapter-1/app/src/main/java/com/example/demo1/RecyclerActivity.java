package com.example.demo1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerActivity extends AppCompatActivity {
    private String[] names = { "caocao", "caomao", "guanyu","sunhanhua","xunyu"};
    private int[]  icons= { R.drawable.caocao,R.drawable.caomao,
            R.drawable.guanyu,R.drawable.sunhanhua, R.drawable.xunyu};
    private String[] introduces = {
            "猫，属于猫科动物，分家猫、野猫，是全世界家庭中较为广泛的宠物。",
            "西伯利亚雪橇犬，常见别名哈士奇，昵称为二哈。",
            "鸭的体型相对较小，颈短，一些属的嘴要大些。腿位于身体后方，因而步态蹒跚。",
            "鹿科是哺乳纲偶蹄目下的一科动物。体型大小不等，为有角的反刍类。",
            "虎，大型猫科动物；毛色浅黄或棕黄色，满有黑色横纹；头圆、耳短，耳背面黑色，中央有一白斑甚显著；四肢健壮有力；尾粗长，具黑色环纹，尾端黑色。"
    };
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(new Adapter());
//        onItemClickListener = new Adapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(int position) {
//
//            }
//        };
        onItemLongClickListener = new Adapter.OnItemLongClickListener() {
            @Override
            public void onItemLongClick(int position) {
                Toast.makeText(RecyclerActivity.this,names[position],Toast.LENGTH_SHORT).show();
            }
        };

    }
    class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            //将holder绑定到RecyclerView上
            View view = View.inflate(RecyclerActivity.this,R.layout.activity_items,null);
            return new ViewHolder(view);
        }

        @SuppressLint("RecyclerView")
        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            //绑定数据
            holder.icons.setImageResource(icons[position]);
            holder.names.setText(names[position]);
            holder.introduces.setText(introduces[position]);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(RecyclerActivity.this,names[position],Toast.LENGTH_SHORT).show();
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    if(onItemLongClickListener!=null){
                        onItemLongClickListener.onItemLongClick(position);
                    }
                    return true;
                }
            });

        }

        @Override
        public int getItemCount() {
            //返回数据个数
            return names.length;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            //绑定控件
            private ImageView icons;
            private TextView names;
            private TextView introduces;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                icons = itemView.findViewById(R.id.iv);
                names = itemView.findViewById(R.id.name);
                introduces = itemView.findViewById(R.id.introduce);
            }
        }
        //由于Recycle没有自带点击事件，所以为itemView实现点击事件，也就是为单个的item实现点击事件
        interface OnItemClickListener{
            void onItemClick(int position);
        }
        interface OnItemLongClickListener{
            void onItemLongClick(int position);
        }
    }
    private Adapter.OnItemLongClickListener onItemLongClickListener;
    private Adapter.OnItemClickListener onItemClickListener;

}
