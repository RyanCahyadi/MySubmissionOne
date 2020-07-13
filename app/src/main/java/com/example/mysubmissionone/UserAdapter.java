package com.example.mysubmissionone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<User> users = new ArrayList<>();

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public UserAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_student, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);

        User user = (User) getItem(i);
        viewHolder.bind(user);
        return itemView;
    }

    public class ViewHolder {
        private TextView txtName, txtAge, txtDescription, txtFollower, txtFollowing;
        private CircleImageView imgAvatar;

        ViewHolder(View view) {
            txtName     = view.findViewById(R.id.txt_name);
            txtAge      = view.findViewById(R.id.txt_age);
            imgAvatar   = view.findViewById(R.id.img_avatar);
            txtDescription = view.findViewById(R.id.txt_description);
            txtFollower     = view.findViewById(R.id.txt_follower);
            txtFollowing     = view.findViewById(R.id.txt_following);
        }

        void bind(User user) {
            txtName.setText(user.getName());
            txtAge.setText(user.getAge());
            imgAvatar.setImageResource(user.getAvatar());
            txtDescription.setText(user.getDescription());
            txtFollower.setText(user.getFollower());
            txtFollowing.setText(user.getFollowing());
        }
    }
}
