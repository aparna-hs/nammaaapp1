package com.example.dbtest2;

import android.provider.BaseColumns;

public class DBacontract implements BaseColumns {
	private DBacontract()
	{
		
	}
	public static abstract class DBaEntry implements BaseColumns {
	    public static final String TABLE_NAME = "entry";
	    public static final String COLUMN_NAME_ENTRY_ID = "entryid";
	    public static final String COLUMN_NAME_TITLE = "title";
	    public static final String COLUMN_NAME_SUBTITLE = "subtitle";
	  }


}
