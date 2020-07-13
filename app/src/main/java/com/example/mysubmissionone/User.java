package com.example.mysubmissionone;


import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private int avatar;
    private String name, age;
    private String description, follower, following, company, location, repository;

    protected User(Parcel in) {
        avatar = in.readInt();
        name = in.readString();
        age = in.readString();
        description = in.readString();
        follower = in.readString();
        following = in.readString();
        company = in.readString();
        location = in.readString();
        repository = in.readString();
    }

    public User() {

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(avatar);
        dest.writeString(name);
        dest.writeString(age);
        dest.writeString(description);
        dest.writeString(follower);
        dest.writeString(following);
        dest.writeString(company);
        dest.writeString(location);
        dest.writeString(repository);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return "Name " + name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return "Age " + age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFollower() {
        return "Follower " + follower;
    }

    public void setFollower(String follower) {
        this.follower = follower;
    }

    public String getFollowing() {
        return "Following " + following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany() {
        return "Company " + company;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return "Location " + location;
    }

    public void setRepository(String repository) {
        this.repository = repository;
    }

    public String getRepository() {
        return "Repo " + repository;
    }
}
