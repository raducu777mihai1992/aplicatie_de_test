package rdc.practicaltest01var08;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var08SecondaryActivity extends AppCompatActivity {
    public static int corecte = 0;
    public static int incorecte = 0;
    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements Button.OnClickListener {

        @Override
        public void onClick(View view) {
                switch (view.getId()){
                    case R.id.Verify_button:
                        corecte++;
                        setResult(corecte, new Intent());
                        finish();
                        break;
                    case R.id.Cancel_button:
                        incorecte++;
                        setResult(incorecte, new Intent());
                        finish();
                        break;
                }

        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var08_secondary);

        TextView text2 = (TextView)findViewById(R.id.Display_activity2);
        Intent intent = getIntent();

        if(intent != null){
            String text = intent.getStringExtra("text_screen1");
            if(text != null)
                text2.setText(text);
        }

        Button b_cancel , b_ok;
        b_cancel = (Button)findViewById(R.id.Cancel_button);
        b_ok     = (Button)findViewById(R.id.Verify_button);
        b_cancel.setOnClickListener(buttonClickListener);
        b_ok.setOnClickListener(buttonClickListener);

    }
}
