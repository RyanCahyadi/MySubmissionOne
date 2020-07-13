package com.example.mysubmissionone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_USER = "extra_user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView tvUserObject = findViewById(R.id.tv_user_received);
        ImageView imgUserObject = findViewById(R.id.img_avatar_received);
        User user = getIntent().getParcelableExtra(EXTRA_USER);
        setTitle("Detail User");

        imgUserObject.setImageResource(user.getAvatar());
        String text = user.getName() + "\n" + user.getAge() + "\n" + user.getCompany()
                + "\n" + user.getLocation() + "\n" + user.getRepository() + "\n" + user.getFollower() + "  " + user.getFollowing();
        tvUserObject.setText(text);

    }
}