Create table tb_configuration(configName text,configValue text);
Create table tb_student(id integer PRIMARY KEY AUTOINCREMENT,admission_no text,name text,class text,division text,roll_no text,email text,gender text,birthday text,phone_no text);
Create  table tb_attendance(id integer PRIMARY KEY AUTOINCREMENT,admission_no text,a_date text,status text);
Create table tb_mark(id integer PRIMARY KEY AUTOINCREMENT,subject text,mark text);
Create table tb_exam(id integer PRIMARY KEY AUTOINCREMENT,s_date text,end_date text,e_name text);

