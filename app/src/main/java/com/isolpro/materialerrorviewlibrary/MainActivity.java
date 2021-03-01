package com.isolpro.materialerrorviewlibrary;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.isolpro.library.materialerrorview.MaterialErrorView;

public class MainActivity extends AppCompatActivity {

  private MaterialErrorView mev;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mev = findViewById(R.id.mev);

    mev.setActionCallback(o ->
      Toast.makeText(this, "Performing the action!", Toast.LENGTH_SHORT).show()
    );
  }
}