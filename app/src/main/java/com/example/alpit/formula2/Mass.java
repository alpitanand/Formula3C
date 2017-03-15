package com.example.alpit.formula2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Mass extends Fragment {


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v = inflater.inflate(R.layout.activity_mass, container, false);
        Button button = (Button) v.findViewById(R.id.convert);
        final EditText editText = (EditText) v.findViewById(R.id.kilogram);
        final EditText editText2 = (EditText) v.findViewById(R.id.grams);
        final EditText editText3 = (EditText) v.findViewById(R.id.ounce);
        final EditText editText4 = (EditText) v.findViewById(R.id.pounds);
        final EditText editText5 = (EditText) v.findViewById(R.id.miligram);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editText.getText().toString().equals("")) {
                    String s = editText.getText().toString();
                    Double d = Double.parseDouble(s) * 1000;
                    editText2.setText(d.toString());
                    Double c = Double.parseDouble(s) * 35.274;
                    editText3.setText(c.toString());
                    Double f = Double.parseDouble(s) * 2.20462;
                    editText4.setText(f.toString());
                    Double r = Double.parseDouble(s) * Math.pow(10, 6);
                    editText5.setText(r.toString());
                } else if (!editText2.getText().toString().equals("")) {
                    String s = editText2.getText().toString();
                    Double d = Double.parseDouble(s) / 1000;
                    editText.setText(d.toString());
                    Double c = Double.parseDouble(s) * 0.035274;
                    editText3.setText(c.toString());
                    Double f = Double.parseDouble(s) * 0.00220462;
                    editText4.setText(f.toString());
                    Double r = Double.parseDouble(s) * 1000;
                    editText5.setText(r.toString());

                } else if (!editText3.getText().toString().equals("")) {
                    String s = editText3.getText().toString();
                    Double d = Double.parseDouble(s) * 0.0283495;
                    editText.setText(d.toString());
                    Double c = Double.parseDouble(s) * 453.592;
                    editText2.setText(c.toString());
                    Double f = Double.parseDouble(s) * 0.0625;
                    editText4.setText(f.toString());
                    Double r = Double.parseDouble(s) * 28349.5;
                    editText5.setText(r.toString());

                } else if (!editText4.getText().toString().equals("")) {
                    String s = editText4.getText().toString();
                    Double d = Double.parseDouble(s) * 0.453592;
                    editText.setText(d.toString());
                    Double m = Double.parseDouble(s) * 453.592;
                    editText2.setText(m.toString());
                    Double b = Double.parseDouble(s) * 16;
                    editText3.setText(b.toString());
                    Double r = Double.parseDouble(s) * 453592;
                    editText5.setText(r.toString());

                } else if (!editText5.getText().toString().equals("")) {
                    String s = editText5.getText().toString();
                    Double d = Double.parseDouble(s) * Math.pow(10, -6);
                    editText.setText(d.toString());
                    Double r = Double.parseDouble(s) * 0.001;
                    editText2.setText(r.toString());
                    Double e = Double.parseDouble(s) * 3.5274 * Math.pow(10, -5);
                    editText3.setText(e.toString());
                    Double t = Double.parseDouble(s) * 2.2046 * Math.pow(10, -6);
                    editText4.setText(t.toString());


                }
            }
        });
        Button button1 = (Button) v.findViewById(R.id.reset);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
                editText2.setText("");
                editText3.setText("");
                editText4.setText("");
                editText5.setText("");

            }
        });


        return v;
    }
}


