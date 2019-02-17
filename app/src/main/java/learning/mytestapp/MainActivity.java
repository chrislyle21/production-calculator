package learning.mytestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = " ";
    public static final String formatErrorMessage = "ERROR....\nYou MUST enter a number\n" +
            "in every field";
    public static String message;

    private boolean error;
    private int num;
    ProdCal cal = new ProdCal();
    DecimalFormat df = new DecimalFormat("###.#");
    DecimalFormat df1 = new DecimalFormat("###");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public int getNum() {
        return this.num;
    }

    public void setNum(int aNum) {
        this.num = aNum;
    }

    public int toInt(String aString) {
        this.setNum(0);
        try {
            this.setNum(Integer.parseInt(aString));
        } catch (NumberFormatException anException) {
            error = true;
        }
        if (!(error)) {
            this.setNum(Integer.parseInt(aString));
        }
        return this.getNum();
    }

    /**
     * Called when the user taps the Send button
     */
    public void sendProfileLength() {
        EditText editText = findViewById(R.id.editText);
        message = editText.getText().toString();
        if (message.equals("6.5")) {
            cal.setProfileLength(Double.parseDouble(message));
        }
        else {
            this.setNum(this.toInt(message));
            cal.setProfileLength(this.getNum());
        }
    }

    public void sendProduction() {
        EditText editText2 = findViewById(R.id.editText5);
        message = editText2.getText().toString();
        this.setNum(this.toInt(message));
        cal.setProduction(this.getNum());

    }

    public void sendPrevCount() {
        EditText editText3 = findViewById(R.id.editText3);
        message = editText3.getText().toString();
        this.setNum(this.toInt(message));
        cal.setPrevCount(this.getNum());
    }

    public void sendLastCount() {
        EditText editText4 = findViewById(R.id.editText4);
        message = editText4.getText().toString();
        this.setNum(this.toInt(message));
        cal.setLastCount(this.getNum());
    }
    public void sendnumberOfStillages() {
         EditText editText5 = findViewById(R.id.editText2);
         message = editText5.getText().toString();
         this.setNum(this.toInt(message));
         cal.setNumberOfStillages(this.getNum());
    }

    public void sendFields() {
        this.sendProfileLength();
        this.sendProduction();
        this.sendPrevCount();
        this.sendLastCount();
        this.sendnumberOfStillages();
    }

    public void printResults(View view) {
        this.sendFields();
        if (error) {
            Intent intent = new Intent(this, DisplayMessageActivity.class);
            intent.putExtra(EXTRA_MESSAGE, formatErrorMessage);
            startActivity(intent);
        }
        else if (!(cal.getProfileLength() == 6.0 || cal.getProfileLength() == 6.5)) {

            Intent intent = new Intent(this, DisplayMessageActivity.class);
            String mess1 = "Profile length MUST equal 6 or 6.5!\nYou have entered "
                    + cal.getProfileLength() + "m per length!";
            intent.putExtra(EXTRA_MESSAGE, mess1);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, DisplayMessageActivity.class);
            String mess1 = "Profile length: " + cal.getProfileLength() + " metres\n"
                    + "Lengths produced: " + df.format(cal.calculate() / cal.getProfileLength()) + " bars\n" + "Total production: " + df.format(cal.calculate())
                    + " metres";
            intent.putExtra(EXTRA_MESSAGE, mess1);
            startActivity(intent);
        }
    }

}



