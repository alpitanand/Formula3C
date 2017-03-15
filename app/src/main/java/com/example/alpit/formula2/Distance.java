package com.example.alpit.formula2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Distance extends Fragment {


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v = inflater.inflate(R.layout.activity_distance, container, false);
        Button button = (Button) v.findViewById(R.id.button12);
        final EditText editText = (EditText) v.findViewById(R.id.edittext1);
        final EditText editText2 = (EditText) v.findViewById(R.id.edittext2);
        final EditText editText3 = (EditText) v.findViewById(R.id.edittext3);
        final EditText editText4 = (EditText) v.findViewById(R.id.edittext4);
        final EditText editText5 = (EditText) v.findViewById(R.id.edittext5);
        final EditText editText6 = (EditText) v.findViewById(R.id.edittext6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editText.getText().toString().equals("")) {
                    String s = editText.getText().toString();
                    Double d = Double.parseDouble(s) * 0.621371;
                    editText2.setText(d.toString());
                    Double c = Double.parseDouble(s) * 39370.1;
                    editText3.setText(c.toString());
                    Double f = Double.parseDouble(s) * 100000;
                    editText4.setText(f.toString());
                    Double r = Double.parseDouble(s) * 1000;
                    editText5.setText(r.toString());
                    Double m = Double.parseDouble(s) * 3280.84;
                    editText6.setText(m.toString());
                } else if (!editText2.getText().toString().equals("")) {
                    String s = editText2.getText().toString();
                    Double d = Double.parseDouble(s) / 0.621371;
                    editText.setText(d.toString());
                    Double c = Double.parseDouble(s) * 63360;
                    editText3.setText(c.toString());
                    Double f = Double.parseDouble(s) * 160934;
                    editText4.setText(f.toString());
                    Double r = Double.parseDouble(s) * 1609.34;
                    editText5.setText(r.toString());
                    Double m = Double.parseDouble(s) * 5280;
                    editText6.setText(m.toString());
                } else if (!editText3.getText().toString().equals("")) {
                    String s = editText3.getText().toString();
                    Double d = Double.parseDouble(s) * 2.45 * Math.pow(10, -5);
                    editText.setText(d.toString());
                    Double c = Double.parseDouble(s) * 1.5783 * Math.pow(10, -5);
                    editText2.setText(c.toString());
                    Double f = Double.parseDouble(s) * 2.54;
                    editText4.setText(f.toString());
                    Double r = Double.parseDouble(s) * 0.0254;
                    editText5.setText(r.toString());
                    Double m = Double.parseDouble(s) * 0.0833333;
                    editText6.setText(m.toString());
                } else if (!editText4.getText().toString().equals("")) {
                    String s = editText4.getText().toString();
                    Double d = Double.parseDouble(s) / 100000;
                    editText.setText(d.toString());
                    Double m = Double.parseDouble(s) / 160934;
                    editText2.setText(m.toString());
                    Double b = Double.parseDouble(s) / 2.54;
                    editText3.setText(b.toString());
                    Double r = Double.parseDouble(s) * 0.01;
                    editText5.setText(r.toString());
                    Double k = Double.parseDouble(s) * 0.0328084;
                    editText6.setText(k.toString());
                } else if (!editText5.getText().toString().equals("")) {
                    String s = editText5.getText().toString();
                    Double d = Double.parseDouble(s) * .001;
                    editText.setText(d.toString());
                    Double r = Double.parseDouble(s) * 0.000621371;
                    editText2.setText(r.toString());
                    Double e = Double.parseDouble(s) * 39.3701;
                    editText3.setText(e.toString());
                    Double t = Double.parseDouble(s) * 100;
                    editText4.setText(t.toString());
                    Double u = Double.parseDouble(s) * 3.28084;
                    editText6.setText(u.toString());

                } else if (!editText6.getText().toString().equals("")) {
                    String s = editText6.getText().toString();
                    Double d = Double.parseDouble(s) * 0.0003048;
                    editText.setText(d.toString());
                    Double m = Double.parseDouble(s) * 0.000189394;
                    editText2.setText(m.toString());
                    Double k = Double.parseDouble(s) * 12;
                    editText3.setText(k.toString());
                    Double t = Double.parseDouble(s) * 30.48;
                    editText4.setText(t.toString());
                    Double y = Double.parseDouble(s) * 0.3048;
                    editText5.setText(y.toString());


                }
            }
        });
        Button button1 = (Button) v.findViewById(R.id.button123);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
                editText2.setText("");
                editText3.setText("");
                editText4.setText("");
                editText5.setText("");
                editText6.setText("");
            }
        });

        return v;
    }


}
