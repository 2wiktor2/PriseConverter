package com.wiktor.mysuperpriceconverter.activity.fragments.converterFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wiktor.mysuperpriceconverter.R;

public class ConverterFragment extends Fragment implements View.OnClickListener {

    EditText editTextKurs;
    EditText editTextConvertibleNumber;
    TextView textViewResultOfExchange;
    Button buttonCalculate;

    Double kurs;
    Double number;
    Double exchangeResult;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_for_converting, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editTextKurs = getActivity().findViewById(R.id.et_exchange_kurs);
        editTextConvertibleNumber = getActivity().findViewById(R.id.et_convertible_number);
        textViewResultOfExchange = getActivity().findViewById(R.id.tv_result_of_exchange);
        buttonCalculate = getActivity().findViewById(R.id.b_calculate);

        buttonCalculate.setOnClickListener(this);

        // не показывать клавиатуру
        final InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


    @Override
    public void onClick(View v) {
        calculate();
    }

    public void getNumbers() {
        if (!editTextKurs.getText().toString().equals("") && !editTextKurs.getText().toString().equals("")) {
            kurs = Double.parseDouble(editTextKurs.getText().toString());
            number = Double.parseDouble(editTextConvertibleNumber.getText().toString());
        } else {
            Toast.makeText(getActivity(), "Введите числа", Toast.LENGTH_SHORT).show();
        }

    }

    public void calculate() {
        getNumbers();
        exchangeResult = kurs * number;
        textViewResultOfExchange.setText(exchangeResult.toString());
    }
}
