package com.example.stepappv2.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.stepappv2.R;
import com.example.stepappv2.databinding.FragmentHomeBinding;
import com.google.android.material.progressindicator.CircularProgressIndicator;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private int counter;
    private FragmentHomeBinding binding;
    private TextView stepCountsView;
    private CircularProgressIndicator progressBar;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        stepCountsView = (TextView) root.findViewById(R.id.counter);
        stepCountsView.setText("0");

        progressBar = (CircularProgressIndicator) root.findViewById(R.id.progressBar);
        progressBar.setMax(6000);
        progressBar.setProgress(0);

        // register on click events from button
        Button b = root.findViewById(R.id.start_button);
        b.setOnClickListener(this);
        // register on click events from button
        Button a = root.findViewById(R.id.count_buttom);
        a.setOnClickListener(this);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    // recive all onClick evenets
    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.start_button) {
            counter = 0;
            stepCountsView.setText(String.valueOf(counter));
            progressBar.setProgress(counter);
        }
        else if (view.getId() == R.id.count_buttom) {
            counter++;
            stepCountsView.setText(String.valueOf(counter));
            progressBar.setProgress(counter);
        }
    }


}