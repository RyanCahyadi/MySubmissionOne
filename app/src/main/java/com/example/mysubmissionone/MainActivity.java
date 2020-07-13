package com.example.mysubmissionone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private UserAdapter adapter;
    private String[] dataName, dataAge, dataDescription, dataFollower, dataFollowing,
            dataCompany, dataLocation, dataRepository;
    private TypedArray dataAvatar;
    private ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Github Users");

        ListView listUser = findViewById(R.id.lv_user);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1,
//                dataName);
        adapter = new UserAdapter(this);
        listUser.setAdapter(adapter);

        prepare();
        addItem();

        listUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, users.get(i).getName(), Toast.LENGTH_SHORT).show();

                Intent moveDetailIntent = new Intent(MainActivity.this, DetailActivity.class);
                moveDetailIntent.putExtra(DetailActivity.EXTRA_USER, users.get(i));
                startActivity(moveDetailIntent);
            }
        });
    }

    private void prepare() {
        dataName    = getResources().getStringArray(R.array.data_name);
        dataAge     = getResources().getStringArray(R.array.data_age);
        dataAvatar  = getResources().obtainTypedArray(R.array.data_avatar);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataFollower = getResources().getStringArray(R.array.data_follower);
        dataFollowing = getResources().getStringArray(R.array.data_following);
        dataCompany = getResources().getStringArray(R.array.data_company);
        dataLocation = getResources().getStringArray(R.array.data_location);
        dataRepository = getResources().getStringArray(R.array.data_repository);
    }

    private void addItem() {
        users = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            User user = new User();

            user.setAvatar(dataAvatar.getResourceId(i, -1));
            user.setName(dataName[i]);
            user.setAge(dataAge[i]);
            user.setDescription(dataDescription[i]);
            user.setFollower(dataFollower[i]);
            user.setFollowing(dataFollowing[i]);
            user.setCompany(dataCompany[i]);
            user.setLocation(dataLocation[i]);
            user.setRepository(dataRepository[i]);
            users.add(user);
        }

        adapter.setUsers(users);
    }

}