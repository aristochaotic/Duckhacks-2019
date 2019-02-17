package com.example.plswork.m_FireBase;

import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.example.plswork.Data.Concern;

public class FirebaseHelper {

    DatabaseReference db;
    Boolean saved=null;

    public FirebaseHelper(DatabaseReference db) {
        this.db = db;
    }

    //SAVE
    public Boolean save(Concern concern)
    {
        if(concern==null)
        {
            saved=false;
        }else
        {
            try
            {
                db.child("Concerns").setValue(concern);
                saved=true;

            }catch (DatabaseException e)
            {
                e.printStackTrace();
                saved=false;
            }
        }

        return saved;

    }
}