package com.inftel.socialnetwork.services;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;

import com.inftel.socialnetwork.entity.Friends;

import java.util.List;

/**
 * Created by inftel10 on 23/3/15.
 */
public class GroupMembersAsyncTask extends AsyncTask <Void, Void, List<String>> {

    private List<Friends> friendList;
    private Activity activity;
    private ProgressDialog progressDialog;
    private String groupname;

    public GroupMembersAsyncTask(List<Friends> friendList, Activity activity, ProgressDialog progressDialog,String groupname){
        friendList=friendList;
        activity=activity;
        progressDialog=progressDialog;
    }

    @Override
    protected List<String> doInBackground(Void... params) {


        return null;
    }
}
