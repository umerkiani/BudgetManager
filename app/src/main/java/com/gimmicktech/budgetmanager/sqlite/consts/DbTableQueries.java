package com.gimmicktech.budgetmanager.sqlite.consts;

/**
 * Created by UmerKiani on 1/11/2016.
 */
public class DbTableQueries {

    private static final String TABLE_USER = "CREATE TABLE User (  userId integer  PRIMARY KEY, " +
            " userName varchar (100)NOT NULL,  mDescription TEXT,  mThumbnail varchar (100),  mediaUrl varchar (256),  isFavourite integer , updatedOn varchar(20) , isYoutube integer DEFAULT 0);";

}
