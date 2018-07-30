package com.example.joaquinmartinez.miga_vistas;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;


import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetWebCatalogos {

    private static final String TAG = GetWebCatalogos.class.getName();

    private Activity act;
    private Context context;
    private APIInterface apiInterface;
    private EditText etMunicipio;
    private EditText etEstado;
    private EditText etColonia;
    private Spinner spnCol;
    private TextInputLayout textInputLayout;

    private EditText etMunicipioIL;//editTextMUNICIPIOIL;
    private EditText etEstadoIL;
    private EditText etColoniaIL;
    private Spinner spnColIL;
    private TextInputLayout textInputLayoutIL;

    ArrayAdapter<String> comboAdapter;




    public GetWebCatalogos(Activity act, Context context, String endpoint) throws NoSuchAlgorithmException, KeyManagementException {
        apiInterface = APIUtils.getUtils(context, endpoint).create(APIInterface.class);

        this.context = context;
        this.act = act;
        etMunicipio = act.findViewById(R.id.editTextMUNICIPIO);
        etEstado = act.findViewById(R.id.editTextEstado);
        etColonia = act.findViewById(R.id.editTextCOLONIA);
        spnCol = act.findViewById(R.id.SpColonia);
        textInputLayout =  act.findViewById(R.id.TIL);

        etMunicipioIL = act.findViewById(R.id.editTextMUNICIPIOIL);
        etEstadoIL = act.findViewById(R.id.editTextEstadoIL);
        etColoniaIL = act.findViewById(R.id.editTextCOLONIAIL);
        spnColIL = act.findViewById(R.id.SpColoniaIL);
        textInputLayoutIL =  act.findViewById(R.id.TIIL);
    }



    public void getWebSepomex(final String cp) {

        System.out.println("salida: "+"getWebSepomex");
        Call<GetSepomex> call = apiInterface.getSepomex(cp);
        call.enqueue(new Callback<GetSepomex>() {
            @Override
            public void onResponse(Call<GetSepomex> call, Response<GetSepomex> response) {
                Log.d(TAG, String.valueOf(response.code()));

                if (response.isSuccessful()) {

                    GetSepomex sepomex = response.body();

                    Log.i(TAG, "Resultados: " + sepomex.Resultados);

                    String estado = "";
                    String ciudad = "";
                    String municipio = "";
                    ArrayList<String> arrayColonias = new ArrayList<>();

                    if (!sepomex.Resultados.equals("0")) {
                        List<GetSepomex.Sepomex> listSepomex = sepomex.Sepomex;
                        for (GetSepomex.Sepomex Informacion : listSepomex) {

                            Log.i(TAG, "\tCP:        " + Informacion.CP);
                            Log.i(TAG, "\tESTADO:    " + Informacion.ESTADO);
                            Log.i(TAG, "\tCIUDAD:    " + Informacion.CIUDAD);
                            Log.i(TAG, "\tMUNICIPIO: " + Informacion.MUNICIPIO);
                            Log.i(TAG, "\tCOLONIA:   " + Informacion.COLONIA);
                            Log.i(TAG, "\t--------------------------------------------------------");

                            estado = Informacion.ESTADO;
                            ciudad = Informacion.CIUDAD;
                            municipio = Informacion.MUNICIPIO;
                            arrayColonias.add(Informacion.COLONIA);
                        }
                        etMunicipio.setText(municipio);
                        etEstado.setText(estado);
                        etMunicipio.setEnabled(true);
                        etEstado.setEnabled(true);
                        etColonia.setEnabled(true);
                        if (arrayColonias.size() > 1){
                            spnCol.setVisibility(View.VISIBLE);
                            textInputLayout.setVisibility(View.GONE);
                            ArrayAdapter<String> adapterColonia = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, arrayColonias);
                            spnCol.setAdapter(adapterColonia);
                        }
                        if (arrayColonias.size() == 1){
                            etColonia.setText(arrayColonias.get(0));
                            spnCol.setVisibility(View.GONE);
                        }
                    } else {
                        textInputLayout.setVisibility(View.VISIBLE);
                        etColonia.setVisibility(View.VISIBLE);
                        spnCol.setVisibility(View.GONE);
                        etMunicipio.setEnabled(true);
                        etEstado.setEnabled(true);
                        etColonia.setEnabled(true);
                    }
                }
            }

            @Override
            public void onFailure(Call<GetSepomex> call, Throwable t) {
                call.cancel();
            }
        });
    }


    public void getWebSepomexIL(final String cp) {

        System.out.println("salida: "+"getWebSepomex");
        Call<GetSepomex> call = apiInterface.getSepomex(cp);
        call.enqueue(new Callback<GetSepomex>() {
            @Override
            public void onResponse(Call<GetSepomex> call, Response<GetSepomex> response) {
                Log.d(TAG, String.valueOf(response.code()));

                if (response.isSuccessful()) {

                    GetSepomex sepomex = response.body();

                    Log.i(TAG, "Resultados: " + sepomex.Resultados);

                    String estado = "";
                    String municipio = "";
                    ArrayList<String> arrayColonias = new ArrayList<>();

                    if (!sepomex.Resultados.equals("0")) {
                        List<GetSepomex.Sepomex> listSepomex = sepomex.Sepomex;
                        for (GetSepomex.Sepomex Informacion : listSepomex) {

                            Log.i(TAG, "\tCP:        " + Informacion.CP);
                            Log.i(TAG, "\tESTADO:    " + Informacion.ESTADO);
                            Log.i(TAG, "\tCIUDAD:    " + Informacion.CIUDAD);
                            Log.i(TAG, "\tMUNICIPIO: " + Informacion.MUNICIPIO);
                            Log.i(TAG, "\tCOLONIA:   " + Informacion.COLONIA);
                            Log.i(TAG, "\t--------------------------------------------------------");

                            estado = Informacion.ESTADO;
                            municipio = Informacion.MUNICIPIO;
                            arrayColonias.add(Informacion.COLONIA);
                        }
                        etMunicipioIL.setText(municipio);
                        etEstadoIL.setText(estado);
                        etMunicipioIL.setEnabled(true);
                        etEstadoIL.setEnabled(true);
                        etColoniaIL.setEnabled(true);
                        if (arrayColonias.size() > 1){
                            spnColIL.setVisibility(View.VISIBLE);
                            textInputLayoutIL.setVisibility(View.GONE);
                            ArrayAdapter<String> adapterColonia = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, arrayColonias);
                            spnColIL.setAdapter(adapterColonia);
                        }
                        if (arrayColonias.size() == 1){
                            etColoniaIL.setText(arrayColonias.get(0));
                            spnColIL.setVisibility(View.GONE);
                        }
                    } else {
                        textInputLayoutIL.setVisibility(View.VISIBLE);
                        etColoniaIL.setVisibility(View.VISIBLE);
                        spnColIL.setVisibility(View.GONE);
                        etMunicipioIL.setEnabled(true);
                        etEstadoIL.setEnabled(true);
                        etColoniaIL.setEnabled(true);
                    }
                }
            }

            @Override
            public void onFailure(Call<GetSepomex> call, Throwable t) {
                call.cancel();
            }
        });
    }



}
