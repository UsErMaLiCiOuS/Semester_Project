package forfendsec.com.sgr;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;
import static java.lang.Integer.parseInt;

import forfendsec.com.sgr.Login;


/**
 * Created by root on 10/19/17.
 */

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;

    private static final String DATABASE_NAME = "sgr.db";

    //private static final String TABLE_CONTACTS = "contacts";
    //private static final String TABLE_MESSAGES = "messages";
    //private static final String TABLE_SIGNUP = "signup";
    private static final String TABLE_LOGIN = "login";
    private static final String TABLE_ECONOMY ="economy";
    private static final String TABLE_FIRSTCLASS ="firstclass";



    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    //private static final String KEY_PH_N0 = "phone_number";
    //private static final String KEY_SMS = "sms";

    //private static final String KEY_FIRSTNAME = "first_name";
    //private static final String KEY_LASTNAME = "last_name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";

    private static final String KEY_TRAIN_ID ="_train_id";
    private static final String KEY_TRAIN = "train";
    private static final String KEY_DESTINATION = "destination";
    private static final String KEY_SEAT = "seat";
    private static final String KEY_PRICE = "price";



    /*private static final String CREATE_TABLE_CONTACTS = "CREATE TABLE "
            + TABLE_CONTACTS + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME
            + " TEXT," + KEY_PH_N0 + " TEXT" + ")";


    private static final String CREATE_TABLE_MESSAGES = "CREATE TABLE "
            + TABLE_MESSAGES + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME
            + " TEXT," + KEY_PH_N0 + " TEXT," + KEY_SMS + " TEXT" + ")";


    private static final String CREATE_TABLE_SIGNUP = "CREATE TABLE "
            + TABLE_SIGNUP + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_FIRSTNAME
            + " TEXT," + KEY_LASTNAME + " TEXT," + KEY_EMAIL + " TEXT,"
            + KEY_PASSWORD + " TEXT" + ")";*/


    private static final String CREATE_TABLE_LOGIN = "CREATE TABLE "
            + TABLE_LOGIN + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT," + KEY_EMAIL + " TEXT,"
            + KEY_PASSWORD + " TEXT" + ")";


   private static final String CREATE_TABLE_ECONOMY = "CREATE TABLE "
            + TABLE_ECONOMY + "(" + KEY_TRAIN_ID + " INTEGER PRIMARY KEY," + KEY_TRAIN
            + " TEXT," + KEY_DESTINATION + " TEXT," + KEY_SEAT + " TEXT,"
            + KEY_PRICE + " TEXT" + ")";

    private static final String CREATE_TABLE_FIRSTCLASS = "CREATE TABLE "
            + TABLE_FIRSTCLASS + "(" + KEY_TRAIN_ID + " INTEGER PRIMARY KEY," + KEY_TRAIN
            + " TEXT," + KEY_DESTINATION + " TEXT," + KEY_SEAT + " TEXT,"
            + KEY_PRICE + " TEXT" + ")";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //sqLiteDatabase.execSQL(CREATE_TABLE_CONTACTS);
        //sqLiteDatabase.execSQL(CREATE_TABLE_MESSAGES);
        //sqLiteDatabase.execSQL(CREATE_TABLE_SIGNUP);
        sqLiteDatabase.execSQL(CREATE_TABLE_LOGIN);
        sqLiteDatabase.execSQL(CREATE_TABLE_ECONOMY);
        sqLiteDatabase.execSQL(CREATE_TABLE_FIRSTCLASS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        /*sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_MESSAGES);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_SIGNUP);*/
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_LOGIN);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_ECONOMY);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_FIRSTCLASS);


        onCreate(sqLiteDatabase);

    }

    /*public void addContact(Contacts contacts) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contacts.getName());
        values.put(KEY_PH_N0, contacts.getPhone_number());

        sqLiteDatabase.insert(TABLE_CONTACTS, null, values);
        sqLiteDatabase.close();
    }*/

    /*public void addMessage(Messages messages) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, messages.getName());
        values.put(KEY_PH_N0, messages.getPhone_number());
        values.put(KEY_SMS, messages.getSms());

        sqLiteDatabase.insert(TABLE_MESSAGES, null, values);
        sqLiteDatabase.close();
    }*/

    /*public void addSignUp(Signup signup) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        //values.put(KEY_FIRSTNAME, signup.getFirst_name());
        //values.put(KEY_LASTNAME, signup.getLast_name());
        values.put(KEY_EMAIL, signup.getEmail());
        values.put(KEY_PASSWORD, signup.getPassword());

        //sqLiteDatabase.insert(TABLE_SIGNUP, null, values);
        sqLiteDatabase.close();
    }*/

    public void addLogin(LoginModel loginModel) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, loginModel.getId());
        values.put(KEY_NAME, loginModel.getName());
        values.put(KEY_EMAIL, loginModel.getEmail());
        values.put(KEY_PASSWORD, loginModel.getPassword());

        sqLiteDatabase.insert(TABLE_LOGIN, null, values);
        sqLiteDatabase.close();
    }


    public void addEconomy(EconomyClassModel economyClassModel) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TRAIN_ID, economyClassModel.getId());
        values.put(KEY_TRAIN, economyClassModel.getTrain());
        values.put(KEY_DESTINATION, economyClassModel.getDestination());
        values.put(KEY_SEAT, economyClassModel.getSeats());
        values.put(KEY_PRICE, economyClassModel.getPrice());

        sqLiteDatabase.insert(TABLE_ECONOMY, null, values);
        sqLiteDatabase.close();
    }


    public void addFirstClass(FirstClassModel firstclassmodel) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TRAIN_ID, firstclassmodel.getId());
        values.put(KEY_TRAIN, firstclassmodel.getTrain());
        values.put(KEY_DESTINATION, firstclassmodel.getDestination());
        values.put(KEY_SEAT, firstclassmodel.getSeats());
        values.put(KEY_PRICE, firstclassmodel.getPrice());

        sqLiteDatabase.insert(TABLE_FIRSTCLASS, null, values);
        sqLiteDatabase.close();
    }


    /*public Contacts getContact(int id) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new String[]{KEY_ID, KEY_NAME, KEY_PH_N0}, KEY_ID + "+?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();


        Contacts contacts = new Contacts(parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));

        return contacts;
    }*/
    /*public Messages getMessage(int id) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_MESSAGES, new String[]{KEY_ID, KEY_NAME, KEY_PH_N0, KEY_SMS}, KEY_ID + "+?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();


        Messages messages = new Messages(parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3));

        return messages;
    }*/

    /*public Signup getSignUp(int id) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_SIGNUP, new String[]{KEY_ID, KEY_FIRSTNAME, KEY_LASTNAME, KEY_EMAIL, KEY_PASSWORD}, KEY_ID + "+?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();


        Signup signup = new Signup(parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));

        return signup;
    }*/


    public EconomyClassModel getEconomy(int id) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_ECONOMY, new String[]{KEY_TRAIN_ID, KEY_PRICE}, KEY_TRAIN_ID + "+?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();


        EconomyClassModel economyClassModel = new EconomyClassModel(parseInt(cursor.getString(0)),
                cursor.getString(1),cursor.getString(2), cursor.getString(3),cursor.getString(4));

        return economyClassModel;
    }

    public FirstClassModel getFirstClass(int id) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_FIRSTCLASS, new String[]{KEY_TRAIN_ID, KEY_PRICE}, KEY_TRAIN_ID + "+?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();


        FirstClassModel firstClassModel = new FirstClassModel(parseInt(cursor.getString(0)),
                cursor.getString(1),cursor.getString(2), cursor.getString(3),cursor.getString(4));

        return firstClassModel;
    }

    /*public List<Contacts> getAllContacts() {
        List<Contacts> contactsList = new ArrayList<Contacts>();

        String selectQuery = "SELECT * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Contacts contacts = new Contacts();
                contacts.setId(Integer.parseInt(cursor.getString(0)));
                contacts.setName(cursor.getString(1));
                contacts.setPhone_number(cursor.getString(2));

                contactsList.add(contacts);
            } while (cursor.moveToNext());
        }
        return contactsList;
    }*/

    /*public List<Messages> getAllMessages() {
        List<Messages> messagesList = new ArrayList<Messages>();

        String selectQuery = "SELECT * FROM " + TABLE_MESSAGES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Messages messages = new Messages();
                messages.setId(Integer.parseInt(cursor.getString(0)));
                messages.setName(cursor.getString(1));
                messages.setPhone_number(cursor.getString(2));
                messages.setSms(cursor.getString(3));

                messagesList.add(messages);
            } while (cursor.moveToNext());
        }
        return messagesList;
    }*/

    /*public List<Signup> getAllSignUp() {
        List<Signup> signupList = new ArrayList<Signup>();

        String selectQuery = "SELECT * FROM " + TABLE_SIGNUP;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Signup signup = new Signup();
                signup.setId(Integer.parseInt(cursor.getString(0)));
                signup.setFirst_name(cursor.getString(1));
                signup.setLast_name(cursor.getString(2));
                signup.setEmail(cursor.getString(3));
                signup.setPassword(cursor.getString(4));

                signupList.add(signup);
            } while (cursor.moveToNext());
        }
        return signupList;
    }*/

    public List<LoginModel> getAllLogin() {
        String[] columns = {
                KEY_ID,
                KEY_EMAIL,
                KEY_NAME,
                KEY_PASSWORD
        };

        String sortOrder =
                KEY_NAME + " ASC";
        List<LoginModel> loginModelList = new ArrayList<LoginModel>();

        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_ECONOMY;
        Cursor cursor = db.rawQuery(selectQuery, null);



        if (cursor.moveToFirst()) {
            do {
                LoginModel loginModel = new LoginModel();
                loginModel.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_ID))));
                loginModel.setName(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
                loginModel.setEmail(cursor.getString(cursor.getColumnIndex(KEY_EMAIL)));
                loginModel.setPassword(cursor.getString(cursor.getColumnIndex(KEY_PASSWORD)));

                loginModelList.add(loginModel);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return loginModelList;
    }

    public List<EconomyClassModel> getAllEconomy() {
            List<EconomyClassModel> economyClassModelList = new ArrayList<EconomyClassModel>();

            String selectQuery = "SELECT * FROM " + TABLE_ECONOMY;

            SQLiteDatabase db = this.getWritableDatabase();
             Cursor cursor = db.rawQuery(selectQuery, null);

            if (cursor.moveToFirst()) {
                do {
                    EconomyClassModel economyClassModel = new EconomyClassModel();
                    economyClassModel.setId(Integer.parseInt(cursor.getString(0)));
                    economyClassModel.setTrain(cursor.getString(1));
                    economyClassModel.setDestination(cursor.getString(2));
                    economyClassModel.setPrice(cursor.getString(3));
                    economyClassModel.setSeats(cursor.getString(4));

                    economyClassModelList.add(economyClassModel);
                } while (cursor.moveToNext());
            }
            return economyClassModelList;
        }


    public List<FirstClassModel> getAllFirstClass() {
        List<FirstClassModel> firstClassModelList = new ArrayList<FirstClassModel>();

        String selectQuery = "SELECT * FROM " + TABLE_FIRSTCLASS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                FirstClassModel firstClassModel = new FirstClassModel();
                firstClassModel.setId(Integer.parseInt(cursor.getString(0)));
                firstClassModel.setTrain(cursor.getString(1));
                firstClassModel.setDestination(cursor.getString(2));
                firstClassModel.setPrice(cursor.getString(3));
                firstClassModel.setSeats(cursor.getString(4));

                firstClassModelList.add(firstClassModel);
            } while (cursor.moveToNext());
        }
        return firstClassModelList;
    }

    /*public int getContactsCount() {
        String countQuery = "SELECT * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }*/

    /*public int getMessagesCount() {
        String countQuery = "SELECT * FROM " + TABLE_MESSAGES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }*/

    /*public int getSignUpCount() {
        String countQuery = "SELECT * FROM " + TABLE_SIGNUP;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }*/

    public int getLoginCount() {
        String countQuery = "SELECT * FROM " + TABLE_LOGIN;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }

    public int getEconomyCount() {
        String countQuery = "SELECT * FROM " + TABLE_ECONOMY;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }


    public int getFirstClassCount() {
        String countQuery = "SELECT * FROM " + TABLE_FIRSTCLASS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }

    /*public int updateContact(Contacts contacts) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contacts.getName());
        values.put(KEY_PH_N0, contacts.getPhone_number());

        return db.update(TABLE_CONTACTS, values, KEY_ID + "-?", new String[]{String.valueOf(contacts.getId())});
    }*/

    /*public int updateMessages(Messages messages) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, messages.getName());
        values.put(KEY_PH_N0, messages.getPhone_number());
        values.put(KEY_SMS, messages.getSms());

        return db.update(TABLE_MESSAGES, values, KEY_ID + "-?", new String[]{String.valueOf(messages.getId())});
    }*/

    /*public int updateSignUp(Signup signup) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_FIRSTNAME, signup.getFirst_name());
        values.put(KEY_LASTNAME, signup.getLast_name());
        values.put(KEY_EMAIL, signup.getEmail());
        values.put(KEY_PASSWORD, signup.getPassword());

        return db.update(TABLE_SIGNUP, values, KEY_ID + "-?", new String[]{String.valueOf(signup.getId())});
    }*/

    public void updateLogin(LoginModel loginModel) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, loginModel.getName());
        values.put(KEY_EMAIL, loginModel.getEmail());
        values.put(KEY_PASSWORD, loginModel.getPassword());

        db.update(TABLE_LOGIN, values, KEY_ID + " = ?", new String[]{String.valueOf(loginModel.getId())});
        db.close();
    }

    public int updateEconomy(EconomyClassModel economyClassModel) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TRAIN, economyClassModel.getTrain());
        values.put(KEY_DESTINATION, economyClassModel.getDestination());
        values.put(KEY_SEAT, economyClassModel.getSeats());
        values.put(KEY_PRICE, economyClassModel.getPrice());

        return db.update(TABLE_ECONOMY, values, KEY_TRAIN_ID + "-?", new String[]{String.valueOf(economyClassModel.getId())});
    }

    public int updateFirstClass(FirstClassModel firstClassModel) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TRAIN, firstClassModel.getTrain());
        values.put(KEY_DESTINATION, firstClassModel.getDestination());
        values.put(KEY_SEAT, firstClassModel.getSeats());
        values.put(KEY_PRICE, firstClassModel.getPrice());

        return db.update(TABLE_FIRSTCLASS, values, KEY_TRAIN_ID + "-?", new String[]{String.valueOf(firstClassModel.getId())});
    }

    public boolean checkUser(String email) {

        String[] columns = {
                KEY_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();

        String selection = KEY_EMAIL + " = ?";

        String[] selectionArgs = {email};

        Cursor cursor = db.query(TABLE_LOGIN, columns, selection, selectionArgs, null, null, null);


        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }




    public boolean checkTrains(String name, String destination, String price, String seats) {

        String[] columns = {
                KEY_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();

        String selection = KEY_TRAIN + " = ?," + " AND " + KEY_DESTINATION + " = ?," + " AND " + KEY_PRICE + " = ?," + " AND " + KEY_SEAT + " = ?";

        String[] selectionArgs = {name, destination, price, seats};

        Cursor cursor = db.query(TABLE_ECONOMY, columns, selection, selectionArgs, null, null, null);


        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }





    public boolean checkUser(String email, String password) {

        String[] columns = {
                KEY_ID
        };

        SQLiteDatabase db = this.getReadableDatabase();

        String selection = KEY_EMAIL + " = ?" + " AND " + KEY_PASSWORD + " = ?";

        String[] selectionArgs = {email, password};


        Cursor cursor = db.query(TABLE_LOGIN, columns, selection, selectionArgs, null, null, null);

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }





    /*public void deleteSignUp(Signup signup) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_SIGNUP, KEY_ID + "= ?", new String[]{String.valueOf(signup.getId())});

        db.close();
    }*/

    public void deleteLogin(LoginModel loginModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_LOGIN, KEY_ID + "= ?", new String[]{String.valueOf(loginModel.getId())});

        db.close();
    }

    public void deleteEconomy(EconomyClassModel economyClassModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ECONOMY, KEY_TRAIN_ID + "= ?", new String[]{String.valueOf(economyClassModel.getId())});

        db.close();
    }

    public void deleteFirstClass(FirstClassModel firstClassModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_FIRSTCLASS, KEY_TRAIN_ID + "= ?", new String[]{String.valueOf(firstClassModel.getId())});

        db.close();
    }

}


