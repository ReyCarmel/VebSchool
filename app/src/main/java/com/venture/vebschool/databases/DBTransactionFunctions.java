package com.venture.vebschool.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;


import com.venture.vebschool.MenuActivities.TimetableModel;
import com.venture.vebschool.model.Exam;
import com.venture.vebschool.model.MarkModel;
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
            cv.put("email", "appu@gmail.com");
            cv.put("gender", "Female");
            cv.put("birthday", "12/23/1997");
            cv.put("phone_no", "1234567890");
            DB_InsertRow("tb_student", cv);

           cv = new ContentValues();
            cv.put("admission_no", "124");
            cv.put("name", "Meenu");
            cv.put("class", "10");
            cv.put("division", "A");
            cv.put("roll_no ", "17");
            cv.put("email", "meenu@gmail.com");
            cv.put("gender", "Female");
            cv.put("birthday", "01/2/2000");
            cv.put("phone_no", "9786453410");
            DB_InsertRow("tb_student", cv);

            cv=new ContentValues();
            cv.put("admission_no","123");
            cv.put("a_date","11/10/2018");
            cv.put("status","present");
			DB_InsertRow("tb_attendance", cv);

            cv=new ContentValues();
            cv.put("admission_no","124");
            cv.put("a_date","1/10/2018");
            cv.put("status","absent");
			DB_InsertRow("tb_attendance", cv);
			insertMark();
			insertDate();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public static void insertMark()
	{
		try {
			ContentValues cv = new ContentValues();
			cv.put("subject","English");
			cv.put("mark","70");
			DB_InsertRow("tb_mark",cv);

			cv=new ContentValues();
			cv.put("subject","Science");
			cv.put("mark","70");
			DB_InsertRow("tb_mark",cv);

			cv=new ContentValues();
			cv.put("subject","Mathematics");
			cv.put("mark","87");
			DB_InsertRow("tb_mark",cv);

			cv= new ContentValues();
			cv.put("subject","Hindi");
			cv.put("mark","67");
			DB_InsertRow("tb_mark",cv);


		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void insertDate()
	{
		try
		{	ContentValues cv=new ContentValues();

			cv.put("s_date","14/06/2018");
			cv.put("end_date","24/06/2018");
			cv.put("e_name","sem1");
			DB_InsertRow("tb_exam",cv);

			cv=new ContentValues();
			cv.put("s_date","12/12/2018");
			cv.put("end_date","20/12/2018");
			cv.put("e_name","sem2");
			DB_InsertRow("tb_exam",cv);

			cv=new ContentValues();
			cv.put("s_date","12/06/2019");
			cv.put("end_date","20/06/2019");
			cv.put("e_name","sem3");
			DB_InsertRow("tb_exam",cv);


		}catch (Exception e)
		{
			e.printStackTrace();
		}

	}

    public static  ArrayList<StudentModel>getStudentDetails()
    {
        ArrayList<StudentModel> arrayList=new ArrayList<StudentModel>();
        try {
            String Sql="select *from tb_student GROUP by tb_student.admission_no";
            DBResponseDataTypes.ReadResponse result = DB_ReadRowquery(Sql);
            if(result.count>0)
            {
                for(int i=0;i<result.count;i++)
                {
                    arrayList.add(new StudentModel(result.responsedata.get(i).data.get("id"),
                            result.responsedata.get(i).data.get("admission_no"),
                            result.responsedata.get(i).data.get("name"),
                            result.responsedata.get(i).data.get("class"),
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

    public static ArrayList<StudentModel>getSingleStudentDetails(String id)
    {
        ArrayList<StudentModel> arrayList = new ArrayList<StudentModel>();
        try
        {
            String query = "Select * from tb_student where id='" + id + "'";
            DBResponseDataTypes.ReadResponse result = DB_ReadRowquery(query);
            if (result.count > 0) {
                for (int i = 0; i < result.count; i++) {
                    arrayList.add(new StudentModel(result.responsedata.get(i).data.get("id"),
                            result.responsedata.get(i).data.get("admission_no"),
                            result.responsedata.get(i).data.get("name"),
                            result.responsedata.get(i).data.get("class"),
                            result.responsedata.get(i).data.get("division"),
                            result.responsedata.get(i).data.get("roll_no"),
                            result.responsedata.get(i).data.get("email"),
                            result.responsedata.get(i).data.get("gender"),
                            result.responsedata.get(i).data.get("birthday"),
                            result.responsedata.get(i).data.get("phone_no")));
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            return arrayList;
    }
    public static ArrayList<StudentModel>getAttendanceDetails()
	{
		ArrayList<StudentModel> arrayList=new ArrayList<>();
		try
		{
			String sql="Select tb_student.name as name,tb_student.email as email,tb_student.class as class,tb_attendance.status as status,tb_attendance.a_date as date from tb_student inner join tb_attendance on tb_student.admission_no=tb_attendance.admission_no group by tb_attendance.admission_no";
			DBResponseDataTypes.ReadResponse result=DB_ReadRowquery(sql);
			if (result.count>0)
			{
				for (int i=0;i<result.count;i++)
				{
					arrayList.add(new StudentModel(result.responsedata.get(i).data.get("id"),
					result.responsedata.get(i).data.get("name"),
					result.responsedata.get(i).data.get("email"),
					result.responsedata.get(i).data.get("class"),
					result.responsedata.get(i).data.get("status"),
							result.responsedata.get(i).data.get("date")));

				}
			}
		}
		catch (Exception e)
		{
		e.printStackTrace();
		}
		return arrayList;
	}

    public static ArrayList<StudentModel> getMark() {
	    ArrayList<StudentModel> arrayList=new ArrayList<>();
	    try
        {
            String sql="select *from tb_student GROUP by tb_student.admission_no";
            DBResponseDataTypes.ReadResponse result=DB_ReadRowquery(sql);
            if (result.count>0)
            {
                for (int i=0;i<result.count;i++)
                {
					arrayList.add(new StudentModel(result.responsedata.get(i).data.get("id"),
							result.responsedata.get(i).data.get("admission_no"),
							result.responsedata.get(i).data.get("name"),
							result.responsedata.get(i).data.get("class"),
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
    public  static ArrayList<MarkModel>getMarkSheet()
	{
		ArrayList<MarkModel> arrayList=new ArrayList();

		try

		{
			String sql="select * from tb_mark GROUP by tb_mark.subject";
			DBResponseDataTypes.ReadResponse result=DB_ReadRowquery(sql);
			if (result.count>0)
			{
				for (int i=0;i<result.count;i++)
				{
					arrayList.add(new MarkModel(result.responsedata.get(i).data.get("id"),
							result.responsedata.get(i).data.get("subject"),
							result.responsedata.get(i).data.get("mark")));
				}
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return arrayList;
		}
	public static ArrayList<Exam>getExam()
	{
		ArrayList<Exam> arrayList=new ArrayList<>();
		try
		{
			String sql="select * from tb_exam GROUP by tb_exam.e_name";
			DBResponseDataTypes.ReadResponse result=DB_ReadRowquery(sql);
			if (result.count>0)
			{
				for (int i=0;i<result.count;i++)
				{
					arrayList.add(new Exam(result.responsedata.get(i).data.get("id"),
							result.responsedata.get(i).data.get("s_date"),
							result.responsedata.get(i).data.get("end_date"),
							result.responsedata.get(i).data.get("e_name")));
				}
			}
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return arrayList;
	}


	public static ArrayList<TimetableModel> getTimetabele() {
		try
		{

		}catch (Exception e)
		{

		}
		return null;
	}
}
