package com.example.tencentmap;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private TagFlowLayout tag_flow;
    private List<String> list=new ArrayList<String>();
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        tag_flow = (TagFlowLayout) findViewById(R.id.tag_flow);

        list.add("hahahaha");
        list.add("hahahaha1");
        list.add("hahahaha2");
        list.add("hahahaha3");

        final LayoutInflater inflater=LayoutInflater.from(this);

        tag_flow.setAdapter(new TagAdapter<String>(list) {
            @Override
            public View getView(FlowLayout parent, int position, String o) {
                textView = (TextView) inflater.inflate(R.layout.tv,tag_flow,false);
                textView.setText(o);

                return textView;
            }
        });

        tag_flow.setOnSelectListener(new TagFlowLayout.OnSelectListener() {
            @Override
            public void onSelected(Set<Integer> selectPosSet) {

            }
        });
        tag_flow.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
             //
                //  textView.setBackground(getResources().getDrawable(R.drawable.text_color_size));
                return true;
            }
        });
    }
}
