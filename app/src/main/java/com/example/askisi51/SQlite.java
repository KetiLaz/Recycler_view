package com.example.askisi51;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SQlite extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "recipe";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_RECIPE = "recipe";

    private  static final String COLUMN_ID = "id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_DESCRIPTION = "description";
    private static final String COLUMN_IMAGE = "image";

    public static final String[] RECIPE_COLUMN = {COLUMN_ID, COLUMN_TITLE, COLUMN_DESCRIPTION, COLUMN_IMAGE};

    public SQlite(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " +TABLE_RECIPE+" (id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_TITLE +" TEXT NOT NULL, "
                + COLUMN_DESCRIPTION +" TEXT NOT NULL, "
                + COLUMN_IMAGE +" TEXT NOT NULL)");

        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, "Μουσακάς");
        values.put(COLUMN_DESCRIPTION, "Ο μουσακάς είναι ένα πιάτο από μαγειρεμένο κιμά, μελιτζάνες και πατάτες που συναντάται σε διάφορες μορφές σε όλα τα Βαλκάνια (Βουλγαρία, Ρουμανία), σε χώρες της Μέσης Ανατολής (Αίγυπτος, Λίβανος), της Κεντρικής Ευρώπης, στην Ελλάδα και στην Τουρκία.");
        values.put(COLUMN_IMAGE, "https://www.gastronomos.gr/wp-content/uploads/2016/01/pastitsio_o_vasilias_ton_zimarikon-610x762.jpg");
        sqLiteDatabase.insert(TABLE_RECIPE, null, values);

        values = new ContentValues();
        values.put(COLUMN_TITLE, "Παστίτσιο");
        values.put(COLUMN_DESCRIPTION, "Το παστίτσιο είναι έδεσμα με καταγωγή την Ιταλία. Βασικό συστατικό του είναι τα μακαρόνια και ο κιμάς. Ψήνεται στο φούρνο και σερβίρεται ζεστό σαν κυρίως πιάτο.");
        values.put(COLUMN_IMAGE, "https://www.icookgreek.com/wp-content/uploads/2021/10/moussakas.jpg");
        sqLiteDatabase.insert(TABLE_RECIPE, null, values);

        values = new ContentValues();
        values.put(COLUMN_TITLE, "Λαζανία");
        values.put(COLUMN_DESCRIPTION, "Με τον όρο λαζάνια, ή, σπανιότερα, λαζάνια ή λαγάνα, υποδεικνύει μια συγκεκριμένη μορφή ζύμης, που λαμβάνεται με κοπή σε μεγάλα τετράγωνα ή ορθογώνια του φύλλου ζύμης αυγών. Είναι η παλαιότερη μορφή ζυμαρικών που παράγεται στην Ιταλία.");
        values.put(COLUMN_IMAGE, "https://www.syntages.me/uploads/syntages_large/1_1461926331.jpg");
        sqLiteDatabase.insert(TABLE_RECIPE, null, values);

 }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
