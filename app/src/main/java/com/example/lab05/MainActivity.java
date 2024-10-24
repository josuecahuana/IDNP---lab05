package com.example.lab05;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonFragment1 = findViewById(R.id.button_fragment1);
        Button buttonFragment2 = findViewById(R.id.button_fragment2);

        buttonFragment1.setOnClickListener(view -> {
            Fragment fragment1 = new Fragment1();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment1)
                    .commit();
        });

        buttonFragment2.setOnClickListener(view -> {
            Fragment fragment2 = new Fragment2();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment2)
                    .commit();
        });

    }

    private void loadFragment(Fragment fragment) {
        // Reemplazar el FrameLayout con el fragmento seleccionado
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
