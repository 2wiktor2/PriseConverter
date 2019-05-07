package com.wiktor.mysuperpriceconverter.activity.fragments.converterFragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wiktor.mysuperpriceconverter.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ConverterFragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.et_exchange_kurs)
    EditText editTextKurs;
    @BindView(R.id.et_convertible_number)
    EditText editTextConvertibleNumber;
    @BindView(R.id.tv_result_of_exchange)
    TextView textViewResultOfExchange;
    @BindView(R.id.b_calculate)
    Button buttonCalculate;

    Double kurs = 1.0;
    Double number = 1.0;
    Double exchangeResult = 1.0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_for_converting, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        buttonCalculate.setOnClickListener(this);

        editTextConvertibleNumber.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            // настроить setOnFocusChangeListener или  addTextChangedListener
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    Toast.makeText(getActivity(), "ввод значения", Toast.LENGTH_SHORT).show();

                } else {
                    if (!editTextKurs.getText().toString().equals("") && !editTextKurs.getText().toString().equals("")) {
                        kurs = Double.parseDouble(editTextKurs.getText().toString());
                        number = Double.parseDouble(editTextConvertibleNumber.getText().toString());
                    } else {
                        Toast.makeText(getActivity(), "Введите числа", Toast.LENGTH_SHORT).show();
                    }
                    exchangeResult = kurs * number;
                    textViewResultOfExchange.setText(exchangeResult.toString());
                }
            }
        });


       /* // не показывать клавиатуру
        final InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);*/
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


    @Override
    public void onClick(View v) {
        //calculate();
    }

/*    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            // do something when check is selected
        } else {
            //do something when unchecked
        }
    }*/
}