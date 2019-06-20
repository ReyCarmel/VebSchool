package com.venture.vebschool.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;


import com.venture.vebschool.model.StudentModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class DBTransactionFunctions {
	private Context context;

	public DBTransactionFunctions(Context context) {
		this.context = context;
		//this.bus=bus;
		//bus.register(this);

		DatabaseUtil.init(this.context, "VebSchool", 1, null);
	}

	//used for section handling instead of this we can use shared preferene

	public static boolean insertConfigValues() {
		ContentValues cv;
		try {

			cv = new ContentValues();
			cv.put("configName", "user_name");
			cv.put("configValue", "");
			DBTransactionFunctions.DB_InsertRow("tb_configuration", cv);

			cv = new ContentValues();
			cv.put("configName", "name");
			cv.put("configValue", "");
			DBTransactionFunctions.DB_InsertRow("tb_configuration", cv);

			cv = new ContentValues();
			cv.put("configName", "userid");
			cv.put("configValue", "");
			DBTransactionFunctions.DB_InsertRow("tb_configuration", cv);
			cv = new ContentValues();
			cv.put("configName", "password");
			cv.put("configValue", "");
			DBTransactionFunctions.DB_InsertRow("tb_configuration", cv);
			cv = new ContentValues();
			cv.put("configName", "login_status");
			cv.put("configValue", "");
			DBTransactionFunctions.DB_InsertRow("tb_configuration", cv);
			cv = new ContentValues();
			cv.put("configName", "user_type");
			cv.put("configValue", "");
			DBTransactionFunctions.DB_InsertRow("tb_configuration", cv);
			cv = new ContentValues();
			cv.put("configName", "inserterd");
			cv.put("configValue", "");
			DBTransactionFunctions.DB_InsertRow("tb_configuration", cv);
			cv = new ContentValues();
			cv.put("configName", "gender");
			cv.put("configValue", "");
			DBTransactionFunctions.DB_InsertRow("tb_configuration", cv);

			cv = new ContentValues();
			cv.put("configName", "category");
			cv.put("configValue", "");
			DBTransactionFunctions.DB_InsertRow("tb_configuration", cv);


		} catch (Exception e) {
			System.out.print(e);
		}
		return true;
	}

//Sql method to insert data to a table

	public static long DB_InsertRow(String _tableName, ContentValues _cv) {
		SQLiteDatabase db = null;
		SQLiteStatement stmt = null;
		DBResponseDataTypes.InserResponse insertresponse = new DBResponseDataTypes.InserResponse();
		Cursor cr = null;
		try {
			try {
				DBResponseDataWrapper.InsertResponseData data = new DBResponseDataWrapper.InsertResponseData();
				db = DatabaseUtil.getDatabaseInstance();
				data.data = db.insert(_tableName, null, _cv);
				insertresponse.responsedata = data;
			} catch (Exception e) {
				e.printStackTrace();
			}

		} finally {
			DatabaseUtil.closeResource(db, stmt, cr);
		}
		return insertresponse.responsedata.data;
	}

	//sql method to replace data

	public static long DB_InsertorReplaceRow(String _tableName, ContentValues _cv) {
		SQLiteDatabase db = null;
		SQLiteStatement stmt = null;
		DBResponseDataTypes.InserResponse insertresponse = new DBResponseDataTypes.InserResponse();
		Cursor cr = null;
		try {
			try {
				DBResponseDataWrapper.InsertResponseData data = new DBResponseDataWrapper.InsertResponseData();
				db = DatabaseUtil.getDatabaseInstance();
				data.data = db.replace(_tableName, null, _cv);
				insertresponse.responsedata = data;
			} catch (Exception e) {
				e.printStackTrace();
			}

		} finally {
			DatabaseUtil.closeResource(db, stmt, cr);
		}
		return insertresponse.responsedata.data;
	}

	//sql method to clear the table

	public static void DB_ClearTable(String _tableName) {
		SQLiteDatabase db = null;
		SQLiteStatement stmt = null;
		Cursor cr = null;
		try {
			try {
				db = DatabaseUtil.getDatabaseInstance();

				db.delete(_tableName, null, null);


			} catch (Exception e) {
				e.printStackTrace();
			}

		} finally {
			DatabaseUtil.closeResource(db, stmt, cr);
		}
	}

	//sql method to delete

	public static void DB_DeleteRow(String _tableName, String _whereClause, String[] _whereArgs) {
		SQLiteDatabase db = null;
		SQLiteStatement stmt = null;
		Cursor cr = null;
		try {
			try {
				db = DatabaseUtil.getDatabaseInstance();

				db.delete(_tableName, _whereClause, _whereArgs);


			} catch (Exception e) {
				// TODO Auto-generated catc6h block
				e.printStackTrace();
			}

		} finally {
			DatabaseUtil.closeResource(db, stmt, cr);
		}
	}

//sql method to update data

	public static int DB_UpdateRow(String _tableName, ContentValues _cv, String _whereClause, String[] _whereArgs) {
		SQLiteDatabase db = null;
		SQLiteStatement stmt = null;
		DBResponseDataTypes.UpdateResponse updateresponse = new DBResponseDataTypes.UpdateResponse();
		Cursor cr = null;
		try {
			try {
				DBResponseDataWrapper.UpdateResponseData data = new DBResponseDataWrapper.UpdateResponseData();
				db = DatabaseUtil.getDatabaseInstance();

				data.data = db.update(_tableName, _cv, _whereClause, _whereArgs);
				updateresponse.responsedata = data;
			} catch (Exception e) {
				// TODO Auto-generated catc6h block
				e.printStackTrace();
			}

		} finally {
			DatabaseUtil.closeResource(db, stmt, cr);
		}
		return updateresponse.responsedata.data;
	}

	/**
	 * If _whereClause= null and _whereArgs=null Read all Rows in Db
	 **/
//used to read data from table
	public static DBResponseDataTypes.ReadResponse DB_ReadRow(String _tableName,
															  String[] _SelectColumn,
															  String _whereClause,
															  String[] _whereArgs,
															  String _groupBy,
															  String _having,
															  String _orderBy) {
		SQLiteDatabase db = null;
		SQLiteStatement stmt = null;
		Cursor cr = null;
		DBResponseDataTypes.ReadResponse readResponse = null;
		DBResponseDataWrapper.ReadResponseData readdata = null;
		try {
			try {
				readResponse = new DBResponseDataTypes.ReadResponse();
				db = DatabaseUtil.getDatabaseInstance();

				cr = db.query(_tableName, _SelectColumn, _whereClause, _whereArgs, _groupBy, _having, _orderBy);
				readResponse.count = cr.getCount();
				if (cr.getCount() > 0) {
					cr.moveToFirst();

					while (cr.isAfterLast() == false) {
						readdata = new DBResponseDataWrapper.ReadResponseData();
						for (int i = 0; i < cr.getColumnCount(); i++)
							readdata.data.put(cr.getColumnName(i), cr.getString(i) + "");

						readResponse.responsedata.add(readdata);
						cr.moveToNext();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} finally {
			DatabaseUtil.closeResource(db, stmt, cr);
		}
		return readResponse;
	}

	//read data using sql
	public static DBResponseDataTypes.ReadResponse DB_ReadRowquery(String sqlquery) {
		SQLiteDatabase db = null;
		SQLiteStatement stmt = null;
		Cursor cr = null;
		DBResponseDataTypes.ReadResponse readResponse = null;
		DBResponseDataWrapper.ReadResponseData readdata = null;
		try {
			try {
				readResponse = new DBResponseDataTypes.ReadResponse();
				db = DatabaseUtil.getDatabaseInstance();

				cr = db.rawQuery(sqlquery, null);
				readResponse.count = cr.getCount();
				if (cr.getCount() > 0) {
					cr.moveToFirst();

					while (cr.isAfterLast() == false) {
						readdata = new DBResponseDataWrapper.ReadResponseData();
						for (int i = 0; i < cr.getColumnCount(); i++)
							readdata.data.put(cr.getColumnName(i), cr.getString(i) + "");

						readResponse.responsedata.add(readdata);
						cr.moveToNext();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} finally {
			DatabaseUtil.closeResource(db, stmt, cr);
		}
		return readResponse;
	}


	public static String getConfigvalue(String name) {
		SQLiteDatabase db = null;
		Cursor cursor = null;
		String tempdata = "";
		try {
			db = DatabaseUtil.getDatabaseInstance();
			cursor = db.rawQuery("SELECT * FROM tb_configuration where configName = '" + name + "'", null);
			cursor.moveToFirst();
			tempdata = String.valueOf(cursor.getString(cursor.getColumnIndex("configValue")));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeResource(db, null, cursor);
		}

		return tempdata;
	}

// to update config table or section table

	public static void updateConfigvalues(String configname, String value) {
		SQLiteDatabase db = null;
		try {
			db = DatabaseUtil.getDatabaseInstance();
			ContentValues cv = new ContentValues();
			cv.put("configValue", value);
			DBResponseDataWrapper.UpdateResponseData data = new DBResponseDataWrapper.UpdateResponseData();
			data.data = db.update("tb_configuration", cv, "configName=?", new String[]{configname});

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeResource(db, null, null);
		}
	}


	public static JSONArray getDataForSync(String table, String codition, String value) {
		SQLiteDatabase db = null;
		Cursor cursor1 = null;
		JSONArray json = new JSONArray();
		try {
			db = DatabaseUtil.getDatabaseInstance();
			cursor1 = db.rawQuery("SELECT * from " + table + " where " + codition + " =" + value + "", null);
			cursor1.moveToFirst();
			if (cursor1.getCount() > 0) {
				while (cursor1.isAfterLast() == false) {
					JSONObject ja = new JSONObject();
					for (int i = 0; i < cursor1.getColumnCount(); i++)
						ja.put(cursor1.getColumnName(i), cursor1.getString(i));
					json.put(ja);
					cursor1.moveToNext();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return json;
	}

	public static void insertData() {
        try {


            ContentValues cv = new ContentValues();
            cv.put("admission_no", "123");
            cv.put("name", "Asha");
            cv.put("class", "9");
            cv.put("division", "A");
            cv.put("roll_no ", "4");
            cv.put("email", "appu");
            cv.put("gender", "Female");
            cv.put("birthday", "12/23/1997");
            cv.put("phone_no", "123456");
            DB_InsertRow("tb_student", cv);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public static  ArrayList<StudentModel>getStudentDetails()
    {
        ArrayList<StudentModel> arrayList=new ArrayList<StudentModel>();
        try {
            String Sql="Select * from tb_student";
            DBResponseDataTypes.ReadResponse result = DB_ReadRowquery(Sql);
            if(result.count>0)
            {
                for(int i=0;i<result.count;i++)
                {
                    arrayList.add(new StudentModel(result.responsedata.get(i).data.get("id"),
                            result.responsedata.get(i).data.get("admission_no"),
                            result.responsedata.get(i).data.get("name"),
                            result.responsedata.get(i).data.get("s_class"),
                            result.responsedata.get(i).data.get("division"),
                            result.responsedata.get(i).data.get("roll_no"),
                            result.responsedata.get(i).data.get("email"),
                            result.responsedata.get(i).data.get("gender"),
                            result.responsedata.get(i).data.get("birthday"),
                            result.responsedata.get(i).data.get("phone_no")));
                }

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return arrayList;
    }

}