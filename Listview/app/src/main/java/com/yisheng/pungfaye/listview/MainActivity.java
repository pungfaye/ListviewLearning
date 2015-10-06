package com.yisheng.pungfaye.listview;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends Activity {

    private static final String[] array = new String[]{
            "一","二","三","四","五",
            "六","七","八","九","十",
            "十一","十二","十三","十四","十五"};
    private ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView)findViewById(R.id.my_listview);
//  ArrayAdapter
//        lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,array));
//        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
//
//
//        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.d("fpeng","Long Click");
//                return false;
//            }
//        });

//  Simple Adapter
        ArrayList<HashMap<String, Object>> listItem = new ArrayList<>();

//        add data
        for(int i=0; i< 20; i++)
        {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("view", R.mipmap.ic_launcher);//加入图片
            map.put("up_tv", "第"+i+"行");
            map.put("down_tv", "这是第"+i+"行");
            listItem.add(map);
        }

        SimpleAdapter sa = new SimpleAdapter(
                this,
                listItem,
                R.layout.simple_adapter,
                new String[]{"view","up_tv","down_tv"},
                new int[]{R.id.view,R.id.up_tv,R.id.down_tv});

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("fpeng", "postition " + position + " id " + id);
                setTitle("第" + position + "行");
            }
        });

        lv.setAdapter(sa);

    }



//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
