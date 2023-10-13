package org.ecos.logic.components;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.ecos.logic.components.adapter.OnSeekBarChangeAdapter;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggleButton;
    private CheckBox checkBox;
    private SeekBar seekBar;
    private TextView textView4;
    private Switch aSwitch;
    private RadioButton radioButtonOne;
    private RadioButton radioButtonTwo;
    private RadioGroup buttonGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assignBinding();
        this.seekBar.setOnSeekBarChangeListener(this.onSeekBarChangeListener);
        this.aSwitch.setOnCheckedChangeListener(this.onCheckedChangeListener);
        this.buttonGroup.setOnCheckedChangeListener(this.onCheckedChangeListener1);

    }

    private void assignBinding() {
        this.toggleButton = this.findViewById(R.id.toggleButton);
        this.checkBox = this.findViewById(R.id.checkBox);
        this.textView4 = this.findViewById(R.id.textView4);
        this.seekBar = this.findViewById(R.id.seekBar);
        this.aSwitch = this.findViewById(R.id.aSwitch);
        this.radioButtonOne = this.findViewById(R.id.radioButton);
        this.radioButtonTwo = this.findViewById(R.id.radioButton2);
        this.buttonGroup = this.findViewById(R.id.radioGroup);

    }

    public void toggleButtonOnClick(View view) {
        this.checkBox.setEnabled(!this.toggleButton.isChecked());
    }


    private final OnSeekBarChangeAdapter onSeekBarChangeListener = new OnSeekBarChangeAdapter(){
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            MainActivity.this.textView4.setText("" + progress);
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
        String text = "";
        if (radioButtonOne.isChecked()){
            text = "Se ha pulsado el primer radiobutton";
        }
        if (radioButtonTwo.isChecked()){
            text = "Se ha pulsado el segundo radiobutton";
        }
        Toast toast=Toast.makeText(getApplicationContext(), text,
                Toast.LENGTH_LONG);
        toast.show();
    };

}