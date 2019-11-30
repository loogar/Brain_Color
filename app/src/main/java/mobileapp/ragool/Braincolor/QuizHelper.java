package mobileapp.ragool.Braincolor;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class QuizHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;

    private static final String DATABASE_NAME = "braincolor";

    private static final String TABLE_QUEST = "quiz";
    private static final String KEY_ID = "qid";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer";
    private static final String KEY_OPTA = "opta";
    private static final String KEY_OPTB = "optb";
    private static final String KEY_OPTC = "optc";
    private static final String KEY_OPTD = "optd";

    private SQLiteDatabase datab;

    public QuizHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        datab = db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT, " + KEY_OPTD + " TEXT)";
        db.execSQL(sql);
        addQuestion();

    }

    private void addQuestion() {
        Question q1 = new Question("For how long is a dog pregnant ?", "9 Weeks", "9 Months", "9 Days", "3 Months", "9 Weeks");
        this.addQuestion(q1);

        Question q2 = new Question("The spherical shape of a drop is due to _____ ?", "Gravity", "Air Pressure", "Surface Tension", "Density", "Surface Tension");
        this.addQuestion(q2);

        Question q3 = new Question("Earth is protected from Ultra voilet radiation by _____ ?", "Clouds", "Oxygen", "Ozone", "CO", "Ozone");
        this.addQuestion(q3);

        Question q4 = new Question("What is Capital of Venezuela ?", "Caracas", "Valencia", "Maracaibo", "Maturin", "Caracas");
        this.addQuestion(q4);

        Question q5 = new Question("Solid carbon dioxide is known as _____ ?", "Carbonate", "Carbonic", "Coal", "Dry ice", "Dry ice");
        this.addQuestion(q5);

        Question q6 = new Question("How many states are in USA ?", "50", "51", "36", "52", "50");
        this.addQuestion(q6);

        Question q7 = new Question("Which is the Biggest Museum ?", "The Louvre", "National Gallery", "British Museum", "Pergamon Museum", "British Museum");
        this.addQuestion(q7);

        Question q8 = new Question("Which is the coldest planet in the solar system? ", "Mars", "Jupiter", "Neptune", "Earth", "Neptune");
        this.addQuestion(q8);

        Question q9 = new Question("How many bones are there in human skull ?", "22", "13", "8", "16", "22");
        this.addQuestion(q9);

        Question q10 = new Question("Device used for measure radiation ?", "Radiometer", "Geiger Muller Counter", "Altimeter", "Spectrometer", "Geiger Muller Counter");
        this.addQuestion(q10);

        Question q11 = new Question("In internet terminology IP means ?", "Internet Protocol", "Internet Party", "Integrated Protocol", "International Protocol", "Internet Protocol");
        this.addQuestion(q11);

        Question q12 = new Question("What is capital of Mexico ?", "Mexico City", "Puerto Vallarta", "Acapulco", "Taxco", "Mexico City");
        this.addQuestion(q12);

        Question q13 = new Question("How many bones are there in human skeleton ?", "200", "196", "206", "301", "206");
        this.addQuestion(q13);

        Question q14 = new Question("Longest river in the world ?", "Nile", "Amazon", "Yangtze", "Congo", "Amazon");
        this.addQuestion(q14);

        Question q15 = new Question("Largest lake in the world ?", "Huron", "Michigan", "Superior", "Erie", "Superior");
        this.addQuestion(q15);

        Question q16 = new Question("What is the capital of New Zealand ?", "Wellington", "Auckland", "Nelson", "Dunedin", "Wellington");
        this.addQuestion(q16);

        Question q17 = new Question("When apollo 11 landed on the moon ?", "1972", "1968", "1969", "1967", "1969");
        this.addQuestion(q17);

        Question q18 = new Question("How many ounces in a kilo ?", "35.72", "35.74", "35.27", "34.68", "35.27");
        this.addQuestion(q18);

        Question q19 = new Question("How many players on a cricket team ?", "6 players", "13 players", "11 players", "14 players", "11 players");
        this.addQuestion(q19);

        Question q20 = new Question("How many players on a football team ?", "11 players", "12 players", "7 players", "15 players", "11 players");
        this.addQuestion(q20);

        Question q21 = new Question("How many liters in a gallon ?", "3.785", "3.685", "4.000", "3.975", "3.785");
        this.addQuestion(q21);

        Question q22 = new Question("How many rings on the Olympic flag ?", "Four", "Six", "Five", "Seven", "Five");
        this.addQuestion(q22);

        Question q23 = new Question("What colour is Prawns' blood ?", "Red", "Green", "Blue", "No Blood", "Blue");
        this.addQuestion(q23);

        Question q24 = new Question("Where in your body is your patella ?", "Head", "Shoulder", "Knee", "Arm", "Knee");
        this.addQuestion(q24);

        Question q25 = new Question("Who was the first man in space ?", "Neil Armstrong", "David Scott", "Yuri Gagarin", "Edvin Aldrin", "Yuri Gagarin");
        this.addQuestion(q25);

        Question q26 = new Question("Which mammal lays eggs ?", "Bat", "Duck billed platypus", "Dolphin", "Whale", "Duck billed platypus");
        this.addQuestion(q26);

        Question q27 = new Question("Who invented the television ?", "Alexander Graham Bell", "Thomas Alva Eddison", "John Logie Baird", "Guglielmo Marconi", "John Logie Baird");
        this.addQuestion(q27);

        Question q28 = new Question("Whose nose grew when he told a lie ?", "Red Riding Hood", "Robin Hood", "Pinocchio", "Snow White", "Pinocchio");
        this.addQuestion(q28);

        Question q29 = new Question("If you had pogonophobia what would you be afraid of ?", "Bears", "Beards", "Black", "Vehicles", "Beards");
        this.addQuestion(q29);

        Question q30 = new Question("What in business terms is the IMF ?", "International Money Fund", "International Monetary Fund", "Internet Money Fund", "International Money Foundation", "International Monetary Fund");
        this.addQuestion(q30);

        Question q31 = new Question("Which company is owned by Bill Gates ?", "Microsoft", "Google", "Facebook", "Apple", "Microsoft");
        this.addQuestion(q31);

        Question q32 = new Question("What was the first James Bond book ?", "Goldfinger", "Dr. No", "Casino Royal", "Devil May Cry", "Casino Royal");
        this.addQuestion(q32);

        Question q33 = new Question("How did Alfred Nobel make his money ?", "He invented Dynamite", "He sold Gold", "He won the Nobel", "He was an actor", "He invented Dynamite");
        this.addQuestion(q33);

        Question q34 = new Question("Who discovered radium ?", "John Radium", "The Curies", "Albert Einstein", "Muller", "The Curies");
        this.addQuestion(q34);

        Question q35 = new Question("Triskadeccaphobia is the fear of what ?", "Elephants", "Number 13", "Thundering", "Rain", "Number 13");
        this.addQuestion(q35);

        Question q36 = new Question("What type of acid is used in car batteries ?", "Sulphuric", "Nitric", "Hydrogen Chloride", "Ethanoic", "Sulphuric");
        this.addQuestion(q36);

        Question q37 = new Question("It's a flock of sheep what's a group of owls called ?", "Flock of Owls", "Parliament of Owls", "Gang of Owls", "Class of Owls", "Parliament of Owls");
        this.addQuestion(q37);

        Question q38 = new Question("What is classified by the A B O system ?", "Blood", "Animals", "Bottles", "Water", "Blood");
        this.addQuestion(q38);

        Question q39 = new Question("What was the first James Bond film ?", "Goldfinger", "Dr. No", "Casino Royal", "Devil May Cry", "Dr. No");
        this.addQuestion(q39);

        Question q40 = new Question("What is the largest state in the USA ?", "Alaska", "California", "Hawaii", "Florida", "Alaska");
        this.addQuestion(q40);

        Question q41 = new Question("Hippophagic society members support what ?", "Eating horsemeat", "Protecting Hippopotamus", "Drinking Hippos' milk", "Hunting Hippopotamus", "Eating horsemeat");
        this.addQuestion(q41);

        Question q42 = new Question("What is 6 inches bigger in Summer ?", "Eiffel tower", "Burj Khalifa", "Christ the Redeemer", "Big Ben", "Eiffel tower");
        this.addQuestion(q42);

        Question q43 = new Question("Which sea on Earth has no beaches ?", "Arab Sea", "Red Sea", "Caspian Sea", "Sargasso sea", "Sargasso sea");
        this.addQuestion(q43);

        Question q44 = new Question("Which country has the smallest birth rate ?", "Somalia", "Egypt", "Vatican", "Japan", "Vatican");
        this.addQuestion(q44);

        Question q45 = new Question("Which country was the first to introduce old age pensions ?", "USA", "England", "Germany", "India", "Germany");
        this.addQuestion(q45);

        Question q46 = new Question("What does a galactophagist drink ?", "Vodka", "Milk", "Water", "Beer", "Milk");
        this.addQuestion(q46);

        Question q47 = new Question("Scotopic people can do what ?", "See in the dark", "Never sleep", "Impervious to cold", "feel no Pain", "See in the dark");
        this.addQuestion(q47);

        Question q48 = new Question("Who invented popcorn ?", "Chinese", "American Indians", "Indians", "Australians", "American Indians");
        this.addQuestion(q48);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);

        onCreate(db);
    }


    public void addQuestion(Question quest) {

        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        values.put(KEY_OPTD, quest.getOPTD());


        datab.insert(TABLE_QUEST, null, values);
    }

    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();

        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        datab = this.getReadableDatabase();
        Cursor cursor = datab.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quest.setOPTD(cursor.getString(6));

                quesList.add(quest);
            } while (cursor.moveToNext());
        }

        return quesList;
    }

    public int getProfilesCount() {
        String countQuery = "SELECT  * FROM " + TABLE_QUEST;
        datab = this.getReadableDatabase();
        Cursor cursor = datab.rawQuery(countQuery, null);
        int cnt = cursor.getCount();
        cursor.close();
        return cnt;
    }

}
