package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    TextView showCountTextView;

    @SuppressLint("SetTextI18n")
    private void countMe(View view){

        String countString = showCountTextView.getText().toString();
        Integer counter = Integer.parseInt(countString);
        counter++;
        showCountTextView.setText(counter.toString());
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        View fragmentFirstLayout = inflater.inflate(R.layout.fragment_first, container, false);
        showCountTextView = fragmentFirstLayout.findViewById(R.id.textview_first);
        return fragmentFirstLayout;

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.toast_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast toast = Toast.makeText(getActivity(), "Hello Toast!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        view.findViewById(R.id.count_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                countMe(view);
            }
        });

        view.findViewById(R.id.random_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentCount = Integer.parseInt(showCountTextView.getText().toString());
                NavHostFragment.findNavController(FirstFragment.this).navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment(currentCount));
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}