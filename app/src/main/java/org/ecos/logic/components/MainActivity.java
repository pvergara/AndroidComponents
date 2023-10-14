package org.ecos.logic.components;

import static java.text.MessageFormat.format;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import org.ecos.logic.components.adapter.OnSeekBarChangeAdapter;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBoxThree;
    private Button theButton;
    private ToggleButton toggleButton;
    private CheckBox checkBox;
    private CheckBox checkBoxTwo;
    private SeekBar seekBar;
    private TextView textView4;
    private Switch aSwitch;
    private RadioButton radioButtonOne;
    private RadioButton radioButtonTwo;
    private RadioGroup buttonGroup;
    private Button buttonWithImage;
    public int counter = 0;
    private TextView textView3;
    private RatingBar ratingBar;
    private EditText editText;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        assignBinding();
        assignListeners();

    }

    private void assignListeners() {
        this.seekBar.setOnSeekBarChangeListener(this.onSeekBarChangeListener);
        this.aSwitch.setOnCheckedChangeListener(this.onCheckedChangeListener);
        this.buttonGroup.setOnCheckedChangeListener(this.onCheckedChangeListener1);
        this.buttonWithImage.setOnClickListener(this.onClickListener);
        this.theButton.setOnClickListener(this.theOnClickListener);

    }

    private void assignBinding() {
        this.toggleButton = this.findViewById(R.id.toggleButton);
        this.checkBox = this.findViewById(R.id.checkBox);
        this.checkBoxTwo = this.findViewById(R.id.checkBox2);
        this.checkBoxThree = this.findViewById(R.id.checkBox3);
        this.textView4 = this.findViewById(R.id.textView4);
        this.seekBar = this.findViewById(R.id.seekBar);
        this.aSwitch = this.findViewById(R.id.aSwitch);
        this.radioButtonOne = this.findViewById(R.id.radioButton);
        this.radioButtonTwo = this.findViewById(R.id.radioButton2);
        this.buttonGroup = this.findViewById(R.id.radioGroup);
        this.buttonWithImage = this.findViewById(R.id.button2);
        this.textView3 = this.findViewById(R.id.textView3);
        this.theButton = this.findViewById(R.id.button);
        this.ratingBar = this.findViewById(R.id.ratingBar);
        this.editText = this.findViewById(R.id.editText);


    }
    public void toggleButtonOnClick(View view) {
        this.checkBox.setEnabled(!this.toggleButton.isChecked());
    }
    private final OnSeekBarChangeAdapter onSeekBarChangeListener = new OnSeekBarChangeAdapter(){
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            MainActivity.this.textView4.setText(format("{0}", progress));
        }
    };

    private final CompoundButton.OnCheckedChangeListener onCheckedChangeListener = (buttonView, isChecked) -> {
        if (isChecked) {
            this.aSwitch.setText(this.aSwitch.getTextOn());
        } else {
            this.aSwitch.setText(this.aSwitch.getTextOff());
        }
    };

    private final RadioGroup.OnCheckedChangeListener onCheckedChangeListener1 = (group, checkedId) -> {
        String text;
        if (radioButtonOne.isChecked()){
            text = "Se ha pulsado el primer radiobutton";
            Toast.makeText(getApplicationContext(), text,Toast.LENGTH_LONG).show();
        }
        if (radioButtonTwo.isChecked()){
            text = "Se ha pulsado el segundo radiobutton";
            Toast.makeText(getApplicationContext(), text,Toast.LENGTH_LONG).show();
        }
    };

    private final View.OnClickListener onClickListener = view -> {
        this.counter++;
        if (this.checkBoxTwo.isChecked()){
            this.counter -= 2;
        }
        this.textView3.setText(format("{0}", this.counter));
    };

    private final View.OnClickListener theOnClickListener = view -> {
        this.textView3.setText("ImageButton and a button with an image");
        this.toggleButton.setChecked(false);
        if (!this.checkBox.isEnabled()) this.checkBox.setEnabled(true);
        this.checkBox.setChecked(false);
        this.checkBoxTwo.setChecked(false);
        this.checkBoxThree.setChecked(false);
        this.radioButtonOne.setChecked(false);
        this.radioButtonTwo.setChecked(false);
        this.aSwitch.setChecked(false);
        this.seekBar.setProgress(0);
        this.ratingBar.setProgress(0);
        this.editText.setText("");

    };



}