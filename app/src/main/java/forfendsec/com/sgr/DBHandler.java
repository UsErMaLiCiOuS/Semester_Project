package forfendsec.com.sgr;

/**
 * Created by root on 11/1/17.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;
import static java.lang.Integer.parseInt;

/**
 * Created by root on 10/19/17.
 */

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "contactManager";

    private static final String TABLE_CONTACTS = "contacts";
    private static final String TABLE_MESSAGES = "messages";
    private static final String TABLE_SIGNUP = "signup";
    private static final String TABLE_LOGIN = "login";
    private static final String TABLE_ECONOMY ="economy";


    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PH_N0 = "phone_number";
    private static final String KEY_SMS = "sms";

    private static final String KEY_FIRSTNAME = "first_name";
    private static final String KEY_LASTNAME = "last_name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";

    private static final String KEY_TRAIN_ID ="_train_id";
    private static final String KEY_TRAIN = "train";
    private static final String KEY_DESTINATION = "destination";
    private static final String KEY_SEAT = "seat";
    private static final String KEY_PRICE = "price";



    private static final String CREATE_TABLE_CONTACTS = "CREATE TABLE "
            + TABLE_CONTACTS + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME
            + " TEXT," + KEY_PH_N0 + " TEXT" + ")";


    private static final String CREATE_TABLE_MESSAGES = "CREATE TABLE "
            + TABLE_MESSAGES + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME
            + " TEXT," + KEY_PH_N0 + " TEXT," + KEY_SMS + " TEXT" + ")";


    private static final String CREATE_TABLE_SIGNUP = "CREATE TABLE "
            + TABLE_SIGNUP + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_FIRSTNAME
            + " TEXT," + KEY_LASTNAME + " TEXT," + KEY_EMAIL + " TEXT,"
            + KEY_PASSWORD + " TEXT" + ")";


    private static final String CREATE_TABLE_LOGIN = "CREATE TABLE "
            + TABLE_LOGIN + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_PASSWORD + " TEXT" + ")";


    private static final String CREATE_TABLE_ECONOMY = "CREATE TABLE "
            + TABLE_ECONOMY + "(" + KEY_TRAIN_ID + " INTEGER PRIMARY KEY," + KEY_TRAIN
            + " TEXT," + KEY_DESTINATION + " TEXT," + KEY_SEAT + " TEXT,"
            + KEY_PRICE + " TEXT" + ")";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(CREATE_TABLE_CONTACTS);
        sqLiteDatabase.execSQL(CREATE_TABLE_MESSAGES);
        sqLiteDatabase.execSQL(CREATE_TABLE_SIGNUP);
        sqLiteDatabase.execSQL(CREATE_TABLE_LOGIN);
        sqLiteDatabase.execSQL(CREATE_TABLE_ECONOMY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_MESSAGES);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_SIGNUP);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_LOGIN);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_ECONOMY);

        onCreate(sqLiteDatabase);
    }

    public void addContact(Contacts contacts) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contacts.getName());
        values.put(KEY_PH_N0, contacts.getPhone_number());

        sqLiteDatabase.insert(TABLE_CONTACTS, null, values);
        sqLiteDatabase.close();
    }

    public void addMessage(Messages messages) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, messages.getName());
        values.put(KEY_PH_N0, messages.getPhone_number());
        values.put(KEY_SMS, messages.getSms());

        sqLiteDatabase.insert(TABLE_MESSAGES, null, values);
        sqLiteDatabase.close();
    }

    public void addSignUp(Signup signup) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_FIRSTNAME, signup.getFirst_name());
        values.put(KEY_LASTNAME, signup.getLast_name());
        values.put(KEY_EMAIL, signup.getEmail());
        values.put(KEY_PASSWORD, signup.getPassword());

        sqLiteDatabase.insert(TABLE_SIGNUP, null, values);
        sqLiteDatabase.close();
    }

    public void addLogin(Login login) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, login.getId());
        values.put(KEY_PASSWORD, login.getPassword());

        sqLiteDatabase.insert(TABLE_LOGIN, null, values);
        sqLiteDatabase.close();
    }


    public void addEconomy(Economy economy) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TRAIN_ID, economy.getId());
        values.put(KEY_TRAIN, economy.getTrain());
        values.put(KEY_DESTINATION, economy.getDestination());
        values.put(KEY_SEAT, economy.getSeats());
        values.put(KEY_PRICE, economy.getPrice());

        sqLiteDatabase.insert(TABLE_ECONOMY, null, values);
        sqLiteDatabase.close();
    }
    public Contacts getContact(int id) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new String[]{KEY_ID, KEY_NAME, KEY_PH_N0}, KEY_ID + "+?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();


        Contacts contacts = new Contacts(parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));

        return contacts;
    }
    public Messages getMessage(int id) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_MESSAGES, new String[]{KEY_ID, KEY_NAME, KEY_PH_N0, KEY_SMS}, KEY_ID + "+?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();


        Messages messages = new Messages(parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3));

        return messages;
    }

    public Signup getSignUp(int id) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_SIGNUP, new String[]{KEY_ID, KEY_FIRSTNAME, KEY_LASTNAME, KEY_EMAIL, KEY_PASSWORD}, KEY_ID + "+?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();


        Signup signup = new Signup(parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));

        return signup;
    }

    public Login getLogin(int id) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_LOGIN, new String[]{KEY_ID, KEY_PASSWORD}, KEY_ID + "+?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();


        Login login = new Login(parseInt(cursor.getString(0)),
                cursor.getString(1));

        return login;
    }

    public Economy getEconomy(int id) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_ECONOMY, new String[]{KEY_TRAIN_ID, KEY_PRICE}, KEY_TRAIN_ID + "+?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();


        Economy economy = new Economy(parseInt(cursor.getString(0)),
                cursor.getString(1),cursor.getString(2), cursor.getString(3),cursor.getString(4));

        return economy;
    }

    public List<Contacts> getAllContacts() {
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
    }

    public List<Messages> getAllMessages() {
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
    }

    public List<Signup> getAllSignUp() {
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
    }

    public List<Login> getAllLogin() {
        List<Login> loginList = new ArrayList<Login>();

        String selectQuery = "SELECT * FROM " + TABLE_LOGIN;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Login login = new Login();
                login.setId(Integer.parseInt(cursor.getString(0)));
                login.setPassword(cursor.getString(1));


                loginList.add(login);
            } while (cursor.moveToNext());
        }
        return loginList;
    }

    public List<Economy> getAllEconomy() {
        List<Economy> economyList = new ArrayList<Economy>();

        String selectQuery = "SELECT * FROM " + TABLE_ECONOMY;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Economy economy = new Economy();
                economy.setId(Integer.parseInt(cursor.getString(0)));
                economy.setTrain(cursor.getString(1));
                economy.setDestination(cursor.getString(2));
                economy.setSeats(cursor.getString(3));
                economy.setPrice(cursor.getString(4));

                economyList.add(economy);
            } while (cursor.moveToNext());
        }
        return economyList;
    }

    public int getContactsCount() {
        String countQuery = "SELECT * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }

    public int getMessagesCount() {
        String countQuery = "SELECT * FROM " + TABLE_MESSAGES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }

    public int getSignUpCount() {
        String countQuery = "SELECT * FROM " + TABLE_SIGNUP;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }

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

    public int updateContact(Contacts contacts) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contacts.getName());
        values.put(KEY_PH_N0, contacts.getPhone_number());

        return db.update(TABLE_CONTACTS, values, KEY_ID + "-?", new String[]{String.valueOf(contacts.getId())});
    }

    public int updateMessages(Messages messages) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, messages.getName());
        values.put(KEY_PH_N0, messages.getPhone_number());
        values.put(KEY_SMS, messages.getSms());

        return db.update(TABLE_MESSAGES, values, KEY_ID + "-?", new String[]{String.valueOf(messages.getId())});
    }

    public int updateSignUp(Signup signup) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_FIRSTNAME, signup.getFirst_name());
        values.put(KEY_LASTNAME, signup.getLast_name());
        values.put(KEY_EMAIL, signup.getEmail());
        values.put(KEY_PASSWORD, signup.getPassword());

        return db.update(TABLE_SIGNUP, values, KEY_ID + "-?", new String[]{String.valueOf(signup.getId())});
    }

    public int updateLogin(Login login) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, login.getId());
        values.put(KEY_PASSWORD, login.getPassword());

        return db.update(TABLE_LOGIN, values, KEY_ID + "-?", new String[]{String.valueOf(login.getId())});
    }

    public int updateEconomy(Economy economy) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TRAIN, economy.getTrain());
        values.put(KEY_DESTINATION, economy.getDestination());
        values.put(KEY_SEAT, economy.getSeats());
        values.put(KEY_PRICE, economy.getPrice());

        return db.update(TABLE_ECONOMY, values, KEY_TRAIN_ID + "-?", new String[]{String.valueOf(economy.getId())});
    }

    public void deleteContact(Contacts contacts) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + "= ?", new String[]{String.valueOf(contacts.getId())});

        db.close();
    }

    public void deleteMessages(Messages messages) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_MESSAGES, KEY_ID + "= ?", new String[]{String.valueOf(messages.getId())});

        db.close();
    }

    public void deleteSignUp(Signup signup) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_SIGNUP, KEY_ID + "= ?", new String[]{String.valueOf(signup.getId())});

        db.close();
    }

    public void deleteLogin(Login login) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_LOGIN, KEY_ID + "= ?", new String[]{String.valueOf(login.getId())});

        db.close();
    }

    public void deleteEconomy(Economy economy) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ECONOMY, KEY_TRAIN_ID + "= ?", new String[]{String.valueOf(economy.getId())});

        db.close();
    }

}


