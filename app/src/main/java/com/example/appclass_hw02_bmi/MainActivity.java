package com.example.appclass_hw02_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editWeigth;
    EditText editHeigth;
    TextView textBMI;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editWeigth = findViewById(R.id.editWeight);
        editHeigth = findViewById(R.id.editHeight);
        textBMI = findViewById(R.id.TextBMI);
        textResult = findViewById(R.id.TextResult);
        TextView textUrl = (TextView) findViewById(R.id.textViewUrl);
        textUrl.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void BtnCalOnclick(View view) {
        String sWeigth = editWeigth.getText().toString();
        String sHeigth = editHeigth.getText().toString();
        float weigth = 0;
        float height = 0;
        float BMI = 0;
        try {
            weigth = Float.parseFloat(sWeigth);
            height = Float.parseFloat(sHeigth);
        } catch (NumberFormatException e) {
            weigth = 0;
            height = 0;
            Toast.makeText(this, "請輸入數字即可", Toast.LENGTH_SHORT).show();
            return;
        }
        //Jon Brower Minnoch 重量635KG //世界最高者-Robert Pershing Wadlow 272cm
        if (weigth > 0 && height > 0) {
            if (height > 272) {
                Toast.makeText(this, "Robert Pershing Wadlow?", Toast.LENGTH_SHORT).show();
            }
            if (weigth > 635) {
                Toast.makeText(this, "Jon Brower Minnoch?", Toast.LENGTH_SHORT).show();
            }
            BMI = weigth / (height / 100) / (height / 100);
            textBMI.setText("BMI：" + BMI);
            result(BMI);
        } else {
            Toast.makeText(this, "請正常輸入", Toast.LENGTH_SHORT).show();
        }
    }

    void result(float BMI) {
        if (BMI < 18.5) {
            textResult.setText("體重過輕");
        }
        if (18.5 <= BMI && BMI < 24) {
            textResult.setText("健康體位 ");
        }
        if (24 <= BMI && BMI < 27) {
            textResult.setText("過重");
        }
        if (27 <= BMI && BMI < 30) {
            textResult.setText("輕度肥胖");
        }
        if (30 <= BMI && BMI < 35) {
            textResult.setText("中度肥胖");
        }
        if (35 <= BMI) {
            textResult.setText("重度肥胖");
        }
    }
    public void Url(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://health99.hpa.gov.tw/OnlinkHealth/Onlink_BMI.aspx"));
        startActivity(intent);
    }
}
