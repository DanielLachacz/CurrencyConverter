package com.example.daniellachacz.currencyconverter2.view;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.daniellachacz.currencyconverter2.R;
import com.example.daniellachacz.currencyconverter2.databinding.ActivityMainBinding;
import com.example.daniellachacz.currencyconverter2.viewmodel.MainViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        final MainViewModel mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        activityMainBinding.setMainViewModel(mainViewModel);

        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.currencies, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Spinner spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.currencies2, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);

        activityMainBinding.setMainActivityInterface(mainViewModel::setCurrencies);

        mainViewModel.getRate().observe(this, observer);

    }

    final Observer<Double> observer = new Observer<Double>() {
        @Override
        public void onChanged(Double aDouble) {
            if (activityMainBinding.editText1.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Set any number", Toast.LENGTH_SHORT).show();
            }
            else {
                Double multiplication = Double.valueOf(activityMainBinding.editText1.getText().toString());
                Double result = aDouble * multiplication;
                activityMainBinding.textView3.setText(String.valueOf(result));
            }
        }
    };

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (adapterView.getId() == R.id.spinner1) {
            activityMainBinding.textView1.setText(adapterView.getItemAtPosition(i).toString());
        }
        else if (adapterView.getId() == R.id.spinner2) {
            activityMainBinding.textView2.setText(adapterView.getItemAtPosition(i).toString());
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
