package rdc.practicaltest01var08;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var08MainActivity extends AppCompatActivity {

    public String MainText = "";
    public int corecte = 0;
    public int incorect = 0;
    public int incercari = 0;
    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private final static int SECOND_ACTIVITY_CODE = 1;

    protected void onSaveInstanceState(Bundle savedInstaceState){

        savedInstaceState.putString("corecte_saved", String.valueOf(corecte));
        savedInstaceState.putString("incorecte_saved", String.valueOf(incorect));
        savedInstaceState.putString("incercari_saved", String.valueOf(incercari));
    }
    private class ButtonClickListener implements Button.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.topLeft_b:
                    MainText += "Top Left ";
                    break;
                case R.id.topRight_b:
                    MainText += "Top Right ";
                    break;
                case R.id.botLeft_b:
                    MainText += "Bottom Left ";
                    break;
                case R.id.BotRight_b:
                    MainText += "Bottom Right ";
                    break;
                case R.id.center_button:
                    MainText += "Center ";
                    break;
                case R.id.goto_activity2:
                    incercari++;
                    EditText text_screen = (EditText)findViewById(R.id.Display_text);
                    String to_send = text_screen.getText().toString();
                    Intent intent = new Intent("android.intent.action.PracticalTest01Var08SecondaryActivity");
                    intent.putExtra("text_screen1",to_send);
                    startActivityForResult(intent,SECOND_ACTIVITY_CODE);
                    MainText = "";

                    break;
            }

            EditText text_to_display = (EditText)findViewById(R.id.Display_text);
            text_to_display.setText(MainText);

        }
    }


            @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var08_main);

        Button topLeft = (Button)findViewById(R.id.topLeft_b);
        Button topRight = (Button)findViewById(R.id.topRight_b);
        Button botLeft = (Button)findViewById(R.id.botLeft_b);
        Button botRight = (Button)findViewById(R.id.BotRight_b);
        Button Center = (Button)findViewById(R.id.center_button);
                Button NavigateTo2 = (Button)findViewById(R.id.goto_activity2);

        topLeft.setOnClickListener(buttonClickListener);
        topRight.setOnClickListener(buttonClickListener);
        botLeft.setOnClickListener(buttonClickListener);
        botRight.setOnClickListener(buttonClickListener);
        Center.setOnClickListener(buttonClickListener);
                NavigateTo2.setOnClickListener(buttonClickListener);

            }

    @Override
    protected  void onRestoreInstanceState(Bundle savedInstanceState){

        EditText textDisplay = (EditText)findViewById(R.id.Display_text);
        String corecte_string = "0";
        String incorecte_string = "0";
        String incercari_string = "0";

        if (savedInstanceState != null) {
             corecte_string = savedInstanceState.getString("corecte_saved");
             incorecte_string = savedInstanceState.getString("incorecte_saved");
             incercari_string = savedInstanceState.getString("incercari_saved");
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        Toast.makeText(this,String.valueOf(resultCode), Toast.LENGTH_LONG).show();
    }
}
