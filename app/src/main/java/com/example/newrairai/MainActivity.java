package com.example.newrairai;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView myListView = (ListView) findViewById(R.id.myListView);

        // データを準備
        ArrayList<User> users = new ArrayList<>();

        int[] icons = {
                R.drawable.asa,
                R.drawable.tatata,
                R.drawable.iii,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher
        };

        String[] names = {
                "OCAT",
                "高槻市役所",
                "阪急茨木市駅",
                "Studio 610",
                "Studio ASH",
                "SOUL&MOTION",
                "KAMURO Dance Studio",
                "WREXX"
        };

        String[] locs = {
                "大阪市 浪速区 湊町 1-4-1",
                "高槻市 桃園町 2-1",
                "茨木市 永代町 1-5",
                "京都府 左京区",
                "梅田",
                "梅田",
                "谷町４丁目",
                "西中島南方"
        };

        for (int i = 0; i < icons.length; i++) {
            User user = new User();
            user.setIcon(BitmapFactory.decodeResource(
                    getResources(),
                    icons[i]
            ));
            user.setName(names[i]);
            user.setLoc(locs[i]);
            users.add(user);
        }


        // Adapter - ArrayAdapter
        UserAdapter adapter = new UserAdapter(this, 0, users);

        // ListViewに表示
        myListView.setAdapter(adapter);
// Event
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(
                    AdapterView<?> parent,
                    View view, // タップされたView
                    int position, // 何番目か
                    long id // View id
            ) {// ListView
                ListView listView = (ListView)parent;
                // 選択された項目
                String selectedItemStr = (String)listView.getItemAtPosition(position);
                // 第2引数
                Intent intent = new Intent(getApplicationContext(), ocatActivity.class);
                startActivity(intent);
            }

        });
    }

    public class UserAdapter extends ArrayAdapter<User> {

        private LayoutInflater layoutInflater;

        public UserAdapter(Context c, int id, ArrayList<User> users) {
            super(c, id, users);
            this.layoutInflater = (LayoutInflater) c.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE
            );
        }

        @Override
        public View getView(int pos, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = layoutInflater.inflate(
                        R.layout.list_item,
                        parent,
                        false
                );
            }
            User user = (User) getItem(pos);

            ((ImageView) convertView.findViewById(R.id.icon))
                    .setImageBitmap(user.getIcon());
            ((TextView) convertView.findViewById(R.id.name))
                    .setText(user.getName());
            ((TextView) convertView.findViewById(R.id.loc))
                    .setText(user.getLoc());

            return convertView;
        }
    }

    public class User {
        private Bitmap icon;
        private String name;

        public Bitmap getIcon() {
            return icon;
        }

        public void setIcon(Bitmap icon) {
            this.icon = icon;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLoc() {
            return loc;
        }

        public void setLoc(String loc) {
            this.loc = loc;
        }

        private String loc;
    }


}