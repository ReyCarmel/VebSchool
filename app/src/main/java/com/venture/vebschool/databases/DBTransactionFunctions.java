package com.venture.vebschool.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;


import com.venture.vebschool.Parent.MenuActivities.Assignment.AssignmentModel;
import com.venture.vebschool.Parent.MenuActivities.Event.EventModel;
import com.venture.vebschool.Parent.MenuActivities.Holiday.HolidayModel;
import com.venture.vebschool.Parent.MenuActivities.HomeWork.HomeworkModel;
import com.venture.vebschool.Parent.MenuActivities.Leave.LeaveModel;
import com.venture.vebschool.Parent.MenuActivities.News.NewsModel;
import com.venture.vebschool.Parent.model.ProfileModel;
import com.venture.vebschool.Parent.MenuActivities.Attendance.AttendanceModel;
import com.venture.vebschool.Parent.MenuActivities.Message.ContactModel;
import com.venture.vebschool.Parent.MenuActivities.TimeTable.TimetableModel;
import com.venture.vebschool.Parent.MenuActivities.Exam.ExamModel;
import com.venture.vebschool.Parent.MenuActivities.Mark.MarkModel;
import com.venture.vebschool.Parent.MenuActivities.Student.StudentModel;

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

            cv = new ContentValues();
            cv.put("admission_no", "123");
            cv.put("a_date", "11/10/2018");
            cv.put("status", "present");
            DB_InsertRow("tb_attendance", cv);

            cv = new ContentValues();
            cv.put("admission_no", "124");
            cv.put("a_date", "1/10/2018");
            cv.put("status", "absent");
            DB_InsertRow("tb_attendance", cv);
            insertMark();
            insertDate();
            insertContact();
            insertEvents();
            insertNews();
            insertHoliday();
            homeworkDetails();
            LeaveDetails();
            Assignment();
            Profile();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void insertMark() {
        try {
            ContentValues cv = new ContentValues();

            cv.put("subject", "English");
            cv.put("mark", "70");
            DB_InsertRow("tb_mark", cv);

            cv = new ContentValues();
            cv.put("subject", "Science");
            cv.put("mark", "70");
            DB_InsertRow("tb_mark", cv);

            cv = new ContentValues();
            cv.put("subject", "Mathematics");
            cv.put("mark", "87");
            DB_InsertRow("tb_mark", cv);

            cv = new ContentValues();
            cv.put("subject", "Hindi");
            cv.put("mark", "67");
            DB_InsertRow("tb_mark", cv);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertDate() {
        try {
            ContentValues cv = new ContentValues();

            cv.put("s_date", "14/06/2018");
            cv.put("end_date", "24/06/2018");
            cv.put("e_name", "Series 1");
            DB_InsertRow("tb_exam", cv);

            cv = new ContentValues();
            cv.put("s_date", "12/12/2018");
            cv.put("end_date", "20/12/2018");
            cv.put("e_name", "Series 2");
            DB_InsertRow("tb_exam", cv);

            cv = new ContentValues();
            cv.put("s_date", "12/06/2019");
            cv.put("end_date", "20/06/2019");
            cv.put("e_name", "Series 3");
            DB_InsertRow("tb_exam", cv);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void insertContact() {
        try {
            ContentValues cv = new ContentValues();
            cv.put("c_name", "Susan");
            cv.put("subject","Science");
            DB_InsertRow("tb_contact", cv);

            cv = new ContentValues();
            cv.put("c_name", "Justin");
            cv.put("subject","English");
            DB_InsertRow("tb_contact", cv);

            cv = new ContentValues();
            cv.put("c_name", "Priya");
            cv.put("subject","Mathematics");
            DB_InsertRow("tb_contact", cv);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertEvents() {
        try {
            ContentValues cv = new ContentValues();
            cv.put("e_event", "Onam Celebration");
            cv.put("e_date", "12/07/2019");
            cv.put("e_loc", "Lourdes Mount");
            cv.put("e_desc", "Happy Onam");
            DB_InsertRow("tb_event", cv);

            cv = new ContentValues();
            cv.put("e_event", "Ramzan");
            cv.put("e_date", "10/08/2019");
            cv.put("e_loc", "Mount Carmel Auditorium");
            cv.put("e_desc", "happy Ramzan");
            DB_InsertRow("tb_event", cv);

            cv = new ContentValues();
            cv.put("e_event", "Christmas Celebration");
            cv.put("e_date", "12/23/2019");
            cv.put("e_loc", "Lourdes Mount");
            cv.put("e_desc", "Happy Christmas");
            DB_InsertRow("tb_event", cv);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertNews() {
        try {
            ContentValues cv = new ContentValues();
            cv.put("title", "School,Colleges to reopen on June 6");
            cv.put("n_date", "28/05/2019");
            cv.put("n_content", "School reopening postponed to June 6 taking into account the festival of Ramzan that is expected to fall on June 4 or 5");
            DB_InsertRow("tb_news", cv);


        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void insertHoliday()
    {
        try{
            ContentValues cv=new ContentValues();
            cv.put("h_name","Gandhi Jyanthi");
            cv.put("h_date","02-October-2019");
            DB_InsertRow("tb_holiday",cv);

            cv=new ContentValues();
            cv.put("h_name","Mahanavami");
            cv.put("h_date","07-October-2019");
            DB_InsertRow("tb_holiday",cv);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void homeworkDetails()
    {
        try
        {
            ContentValues cv=new ContentValues();
            cv.put("title","Maths");
            cv.put("description","Linear Equation");
            cv.put("h_date","02-07-2019");
            cv.put("reference","Exercise 4.1");
            cv.put("attachment","abc");
            DB_InsertRow("tb_homework",cv);

            cv=new ContentValues();
            cv.put("title","Science");
            cv.put("description","work,energy and power");
            cv.put("h_date","02-07-2019");
            cv.put("reference","Exercise 3.2 ");
            cv.put("attachment","xyz");
            DB_InsertRow("tb_homework",cv);

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void LeaveDetails() {
        try {
            ContentValues cv=new ContentValues();
            cv.put("l_date","10/07/2019");
            cv.put("reason","Requested for 3 days leave due to fever");
            cv.put("status","Granted");
            cv.put("subject","Application for Leave of Absence");
            cv.put("description","Sir,\n" +
                    "\n" +
                    "With due respect, I would like to inform you that I could not attend school from the 10th to the 15th instant on account of fever");
            DB_InsertRow("tb_leave",cv);


            cv=new ContentValues();
            cv.put("l_date","18/08/2019");
            cv.put("reason","Requested for 2 days leave for outing");
            cv.put("status","Denied");
            cv.put("subject","Application for Leave of Absence");
            cv.put("description","Sir,\n" +
                    "\n" +
                    "With due respect, I would like to inform you that I could not attend school from the 18th and 19th because i am going to Goa with my friends");
            DB_InsertRow("tb_leave",cv);


        } catch (Exception e) {

        }

    }
    public static void Assignment()
    {
        try
        {
            ContentValues cv=new ContentValues();
            cv.put("date","10/08/2019");
            cv.put("subject","Mathematics");
            cv.put("title","Linear Equation in one Variable");
            cv.put("description","write 5 examples of linear equation in one variable");
            cv.put("reference","NCERT textbook page no 16");
            cv.put("student_id","123");
            DB_InsertRow("tb_assignment",cv);

            cv=new ContentValues();
            cv.put("date","12/08/2019");
            cv.put("subject","Chemistry");
            cv.put("title","Atomic mass and Molecular Mass");
            cv.put("description","Write down the atomic and molecular mass of 5 elements");
            cv.put("reference","NCERT textbook page no 37");
            cv.put("student_id","124");
            DB_InsertRow("tb_assignment",cv);

        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public static void Profile()
    {
        try
        {
            ContentValues cv=new ContentValues();

            cv.put("_name","Ramesh");
            cv.put("gender","Male");
            cv.put("email","ram@gmail.com");
            cv.put("address","Asha Bhavan");
            cv.put("phone","9847567456");
            DB_InsertRow("tb_profile",cv);
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
	public static ArrayList<ExamModel>getExam()
	{
		ArrayList<ExamModel> arrayList=new ArrayList<>();
		try
		{
			String sql="select * from tb_exam GROUP by tb_exam.e_name";
			DBResponseDataTypes.ReadResponse result=DB_ReadRowquery(sql);
			if (result.count>0)
			{
				for (int i=0;i<result.count;i++)
				{
				    arrayList.add(new ExamModel(result.responsedata.get(i).data.get("id"),
                            result.responsedata.get(i).data.get("e_name")));
				}
			}
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return arrayList;
	}

    public static ArrayList<String>getExamName()
    {
        ArrayList<String> arrayList=new ArrayList<>();
        try
        {
            String sql="select * from tb_exam GROUP by tb_exam.e_name";
            DBResponseDataTypes.ReadResponse result=DB_ReadRowquery(sql);
            if (result.count>0)
            {
                for (int i=0;i<result.count;i++)
                {
                    arrayList.add(result.responsedata.get(i).data.get("e_name"));
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

    public static ArrayList<ContactModel> getContact() {

		ArrayList<ContactModel> arrayList=new ArrayList<>();
		try
		{
			String sql="select * from tb_contact GROUP by tb_contact.c_name";
			DBResponseDataTypes.ReadResponse result=DB_ReadRowquery(sql);
			if (result.count>0)
			{
				for (int i=0;i<result.count;i++)
				{
					arrayList.add(new ContactModel(result.responsedata.get(i).data.get("id"),
					result.responsedata.get(i).data.get("c_name")));
				}
			}

		}catch (Exception e)
		{
		e.printStackTrace();
		}
		return arrayList;
    }

    public static ArrayList<ExamModel> getExamDate() {
		ArrayList<ExamModel> arrayList=new ArrayList<>();
		try{
			String sql="select * from tb_exam GROUP by tb_exam.s_date";
			DBResponseDataTypes.ReadResponse result=DB_ReadRowquery(sql);
			if (result.count>0){
				for (int i=0;i<result.count;i++)
				{
					arrayList.add(new ExamModel(result.responsedata.get(i).data.get("id"),
							result.responsedata.get(i).data.get("e_name"),
							result.responsedata.get(i).data.get("s_date")));
				}
			}

		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return arrayList;
    }

	public static ArrayList<EventModel> getEvents() {
		ArrayList<EventModel> arrayList=new ArrayList<>();
		try
		{
			String sql="select * from tb_event GROUP by tb_event.e_event";
			DBResponseDataTypes.ReadResponse result=DB_ReadRowquery(sql);
			if (result.count>0)
			{
				for (int i=0;i<result.count;i++)
				{
					arrayList.add(new EventModel(result.responsedata.get(i).data.get("id"),
							result.responsedata.get(i).data.get("e_event"),
							result.responsedata.get(i).data.get("e_date")));
				}
			}

		}catch (Exception e)
		{
			e.printStackTrace();
		}return arrayList;
	}

    public static ArrayList<NewsModel> getNews() {
		ArrayList<NewsModel> arrayList=new ArrayList<>();
		try{
			String sql="select * from tb_news";
			DBResponseDataTypes.ReadResponse result=DB_ReadRowquery(sql);
			if (result.count>0)
			{
				for (int i=0;i<result.count;i++)
				{
					arrayList.add(new NewsModel(result.responsedata.get(i).data.get("id"),
							result.responsedata.get(i).data.get("title"),
							result.responsedata.get(i).data.get("n_date"),
							result.responsedata.get(i).data.get("n_content")
							));
				}
			}
		}catch (Exception e)
		{
        e.printStackTrace();
		}
		return arrayList;
    }

	public static ArrayList<HolidayModel> getHoliday() {
        ArrayList<HolidayModel> arrayList=new ArrayList<>();
        try
        {
            String sql="select * from tb_holiday GROUP by tb_holiday.h_date";
            DBResponseDataTypes.ReadResponse result=DB_ReadRowquery(sql);
            if (result.count>0)
            {
                for (int i=0;i<result.count;i++)
                {
                    arrayList.add(new HolidayModel(result.responsedata.get(i).data.get("id"),
                            result.responsedata.get(i).data.get("h_name"),
                            result.responsedata.get(i).data.get("h_date")));
                }
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return arrayList;
	}

    public static ArrayList<ContactModel> getSubjects() {
        ArrayList<ContactModel> arrayList=new ArrayList<>();
        try {
            String sql="select * from tb_contact GROUP by tb_contact.subject";
            DBResponseDataTypes.ReadResponse result=DB_ReadRowquery(sql);
            if (result.count>0)
            {
                for(int i=0;i<result.count;i++)
                {
                    arrayList.add(new ContactModel(result.responsedata.get(i).data.get("id"),
                            result.responsedata.get(i).data.get("c_name"),
                            result.responsedata.get(i).data.get("subject")));
                }
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
       return arrayList;
    }

    public static ArrayList<HomeworkModel> getHomework() {
        ArrayList<HomeworkModel> arrayList=new ArrayList<>();
        try
        {
            String sql="select * from tb_homework GROUP by tb_homework.title";
            DBResponseDataTypes.ReadResponse result=DB_ReadRowquery(sql);
            if(result.count>0)
            {
                for (int i=0;i<result.count;i++)
                {
                    arrayList.add(new HomeworkModel(result.responsedata.get(i).data.get("id"),
                            result.responsedata.get(i).data.get("title"),
                            result.responsedata.get(i).data.get("description"),
                            result.responsedata.get(i).data.get("h_date")));
                }
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return arrayList;
    }
    public static ArrayList<HomeworkModel> getHomeworkData() {
        ArrayList<HomeworkModel> arrayList=new ArrayList<>();
        try
        {
            String sql="select tb_homework.title as title,tb_homework.description as description,tb_homework.reference as reference,tb_homework.attachment as attachment from tb_homework GROUP by tb_homework.title";
            DBResponseDataTypes.ReadResponse result=DB_ReadRowquery(sql);
            if(result.count>0)
            {
                for (int i=0;i<result.count;i++)
                {
                    arrayList.add(new HomeworkModel(result.responsedata.get(i).data.get("id"),
                            result.responsedata.get(i).data.get("title"),
                            result.responsedata.get(i).data.get("description"),
                            result.responsedata.get(i).data.get("reference"),
                            result.responsedata.get(i).data.get("attachment")));
                }
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return arrayList;
    }


    public static ArrayList<LeaveModel> getLeave() {
        ArrayList<LeaveModel> arrayList=new ArrayList<>();
        try
        {
            String sql="select tb_leave.l_date as l_date,tb_leave.reason as reason,tb_leave.status as status from tb_leave GROUP by tb_leave.l_date ";
            DBResponseDataTypes.ReadResponse result=DB_ReadRowquery(sql);
            if (result.count>0)
            {
                for (int i=0;i<result.count;i++)
                {
                    arrayList.add(new LeaveModel(result.responsedata.get(i).data.get("id"),
                            result.responsedata.get(i).data.get("l_date"),
                            result.responsedata.get(i).data.get("reason"),
                            result.responsedata.get(i).data.get("status")," "));
                }
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return arrayList;
    }


    public static ArrayList<AssignmentModel> getAssignment(String id) {
        ArrayList<AssignmentModel> arrayList = new ArrayList<>();
        try
        {
            String sql = "select id, tb_assignment.subject as subject,tb_assignment.title as title,tb_assignment.date" +
                    " as date from tb_assignment where student_id='"+id+"'GROUP by tb_assignment.date";
            DBResponseDataTypes.ReadResponse result=DB_ReadRowquery(sql);
            if (result.count>0)
            {
                for (int i=0;i<result.count;i++)
                {
                    arrayList.add(new AssignmentModel(result.responsedata.get(i).data.get("id"),
                            result.responsedata.get(i).data.get("subject"),
                            result.responsedata.get(i).data.get("title"),
                            result.responsedata.get(i).data.get("date")," "));
                }
            }
        }catch (Exception e)

        {
        e.printStackTrace();
        }
        return arrayList;
    }

    public static ArrayList<AssignmentModel> getAssignmentData(String id) {
        ArrayList<AssignmentModel> arrayList=new ArrayList<>();
        try{
            String sql="select id,title,description,reference from tb_assignment where id='" + id + "'";
            DBResponseDataTypes.ReadResponse result=DB_ReadRowquery(sql);
            if (result.count>0)
            {
                for (int i=0;i<result.count;i++)
                {
                    arrayList.add(new AssignmentModel(result.responsedata.get(i).data.get("id"),
                           result.responsedata.get(i).data.get("title"),
                            result.responsedata.get(i).data.get("description"),
                            result.responsedata.get(i).data.get("reference")));
                }
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static ArrayList<ProfileModel> getProfile(){
        ArrayList<ProfileModel> arrayList=new ArrayList<>();
        try
        {
            String sql="select * from tb_profile";
            DBResponseDataTypes.ReadResponse result=DB_ReadRowquery(sql);
            if(result.count>0)
            {
                for (int i=0;result.count<0;i++)
                {
                    arrayList.add(new ProfileModel(result.responsedata.get(i).data.get("id"),
                            result.responsedata.get(i).data.get("_name"),
                            result.responsedata.get(i).data.get("gender"),
                            result.responsedata.get(i).data.get("email"),
                            result.responsedata.get(i).data.get("address"),
                            result.responsedata.get(i).data.get("phone")));
                }
            }

        }catch (Exception e)
        {
        e.printStackTrace();
        }
        return arrayList;
    }

    public static ArrayList<AttendanceModel> getAttendance() {
        ArrayList<AttendanceModel> arrayList=new ArrayList<>();
        try
        {
            String sql="select a_date,status from tb_attendance GROUP by a_date";
            DBResponseDataTypes.ReadResponse result=DB_ReadRowquery(sql);
            if (result.count>0)
            {
                for (int i=0;i<result.count;i++)
                {
                    arrayList.add(new AttendanceModel(result.responsedata.get(i).data.get("id"),
                            result.responsedata.get(i).data.get("a_date"),
                            result.responsedata.get(i).data.get("status")));
                }
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static ArrayList<String> getSubjectsMark() {
        ArrayList<String> arrayList1=new ArrayList<>();
        try
        {
        String sql="select subject from tb_contact GROUP by subject";
        DBResponseDataTypes.ReadResponse result=DB_ReadRowquery(sql);
        if (result.count>0)
        {
            for (int i=0;i<result.count;i++)
            {
                arrayList1.add(result.responsedata.get(i).data.get("subject"));

            }
        }
        }catch (Exception e){
        e.printStackTrace();
        }
        return arrayList1;
    }

}
