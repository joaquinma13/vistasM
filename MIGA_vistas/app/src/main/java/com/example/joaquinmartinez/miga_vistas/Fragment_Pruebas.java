package com.example.joaquinmartinez.miga_vistas;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Pruebas extends Fragment {







    public static Switch swCob;
    private Switch swIL;
    private EditText etCP;
    private EditText etCURP;
    private EditText etNombre;
    private EditText etAP;
    private EditText etAM;
    private EditText etMunicipio;
    private EditText etEstado;
    private EditText etColonia;
    private EditText etFechaNac;
    private EditText etEdad;
    private EditText etCPIL;
    private EditText etColIL;
    private EditText etMunicipioIL;//editTextMUNICIPIOIL;
    private EditText etEstadoIL;
    private EditText etrc;
    private Connection connection;
    private Spinner spnCol;
    private Spinner spnLN;
    private Spinner spnSX;
    private Spinner spHijos;
    private Spinner spResidencia;
    private Spinner spColIL;
    private Spinner spCred;
    private String Estado;
    private String Sexo;
    private String Curp;
    private TextInputLayout textInputLayout;
    private TextInputLayout textInputLayoutH;
    private TextInputLayout textInputLayoutA;
    private TextInputLayout textInputLayoutM;
    private TextInputLayout textInputLayoutIL;
    private TextInputLayout etCual;




    public Fragment_Pruebas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__pruebas, container, false);
    }


    //instancias de controles

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        connection = new Connection(getActivity());
        spnLN = getActivity().findViewById(R.id.spLN);
        spnSX = getActivity().findViewById(R.id.spSexo);
        swCob = getActivity().findViewById(R.id.swDG);
        etFechaNac = getActivity().findViewById(R.id.ediFECHA);
        etEdad = getActivity().findViewById(R.id.editTextEDAD);
        etCP = getActivity().findViewById(R.id.editTextCP);
        etNombre = getActivity().findViewById(R.id.editNombre);
        etAP = getActivity().findViewById(R.id.editAP);
        etAM = getActivity().findViewById(R.id.editAM);
        etCURP = getActivity().findViewById(R.id.editTextCURP);
        etMunicipio = getActivity().findViewById(R.id.editTextMUNICIPIO);
        etEstado = getActivity().findViewById(R.id.editTextEstado);
        etColonia = getActivity().findViewById(R.id.editTextCOLONIA);
        spnCol = getActivity().findViewById(R.id.SpColonia);
        textInputLayout =  getActivity().findViewById(R.id.TIL);
        spHijos =  getActivity().findViewById(R.id.SpHijos);
        textInputLayoutH = getActivity().findViewById(R.id.etHijos);
        spResidencia = getActivity().findViewById(R.id.SpResidencia);
        textInputLayoutA = getActivity().findViewById(R.id.ano);
        textInputLayoutM = getActivity().findViewById(R.id.mes);
        swIL = getActivity().findViewById(R.id.swIL);
        etCPIL = getActivity().findViewById(R.id.editTextCPIL);
        textInputLayoutIL = getActivity().findViewById(R.id.TIIL);
        spColIL = getActivity().findViewById(R.id.SpColoniaIL);
        etColIL = getActivity().findViewById(R.id.editTextCOLONIAIL);
        etMunicipioIL = getActivity().findViewById(R.id.editTextMUNICIPIOIL);
        etEstadoIL = getActivity().findViewById(R.id.editTextEstadoIL);
        etCual = getActivity().findViewById(R.id.etCual);
        spCred = getActivity().findViewById(R.id.spPC);
        etrc = getActivity().findViewById(R.id.rc);

        etCP.setEnabled(true);
        etMunicipio.setEnabled(false);
        etEstado.setEnabled(false);
        etColonia.setEnabled(false);

        etCPIL.setEnabled(true);
        etMunicipioIL.setEnabled(false);
        etEstadoIL.setEnabled(false);
        etColIL.setEnabled(false);






        //declaracion de eventos en spinners

        spnSX.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if (parentView.getItemAtPosition(position).toString().equals("F")) {
                    Sexo = "F";
                }
                if (parentView.getItemAtPosition(position).toString().equals("M")) {
                    Sexo = "M";
                }
                generateCurp();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });


        spnLN.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if (parentView.getItemAtPosition(position).toString().equals("Baja California Sur"))
                    Estado = "BS";
                if (parentView.getItemAtPosition(position).toString().equals("Campeche"))
                    Estado = "CC";
                if (parentView.getItemAtPosition(position).toString().equals("CDMX"))
                    Estado = "DF";
                if (parentView.getItemAtPosition(position).toString().equals("Chihuahua"))
                    Estado = "CH";
                if (parentView.getItemAtPosition(position).toString().equals("Chiapas"))
                    Estado = "CS";
                if (parentView.getItemAtPosition(position).toString().equals("Coahuila"))
                    Estado = "CL";
                if (parentView.getItemAtPosition(position).toString().equals("Colima"))
                    Estado = "CM";
                if (parentView.getItemAtPosition(position).toString().equals("Durango"))
                    Estado = "DG";
                if (parentView.getItemAtPosition(position).toString().equals("Guanajuato"))
                    Estado = "GT";
                if (parentView.getItemAtPosition(position).toString().equals("Guerrero"))
                    Estado = "GR";
                if (parentView.getItemAtPosition(position).toString().equals("Hidalgo"))
                    Estado = "HG";
                if (parentView.getItemAtPosition(position).toString().equals("Jalisco"))
                    Estado = "JC";
                if (parentView.getItemAtPosition(position).toString().equals("Estado de Mexico"))
                    Estado = "MC";
                if (parentView.getItemAtPosition(position).toString().equals("Michoacan"))
                    Estado = "MN";
                if (parentView.getItemAtPosition(position).toString().equals("Morelos"))
                    Estado = "MS";
                if (parentView.getItemAtPosition(position).toString().equals("Nayarit"))
                    Estado = "NT";
                if (parentView.getItemAtPosition(position).toString().equals("Nuevo Leon"))
                    Estado = "NL";
                if (parentView.getItemAtPosition(position).toString().equals("Oaxaca"))
                    Estado = "OC";
                if (parentView.getItemAtPosition(position).toString().equals("Puebla"))
                    Estado = "PL";
                if (parentView.getItemAtPosition(position).toString().equals("Queretaro"))
                    Estado = "QT";
                if (parentView.getItemAtPosition(position).toString().equals("Quintana Roo"))
                    Estado = "QR";
                if (parentView.getItemAtPosition(position).toString().equals("San Luis Potosí"))
                    Estado = "SP";
                if (parentView.getItemAtPosition(position).toString().equals("Sinaloa"))
                    Estado = "SL";
                if (parentView.getItemAtPosition(position).toString().equals("Sonora"))
                    Estado = "SR";
                if (parentView.getItemAtPosition(position).toString().equals("Tabasco"))
                    Estado = "TC";
                if (parentView.getItemAtPosition(position).toString().equals("Tamaulipas"))
                    Estado = "TL";
                if (parentView.getItemAtPosition(position).toString().equals("Tlaxcala"))
                    Estado = "TS";
                if (parentView.getItemAtPosition(position).toString().equals("Veracruz"))
                    Estado = "VZ";
                if (parentView.getItemAtPosition(position).toString().equals("Yucatan"))
                    Estado = "YN";
                if (parentView.getItemAtPosition(position).toString().equals("Zacatecas"))
                    Estado = "ZS";
                if (parentView.getItemAtPosition(position).toString().equals("NACIO EN EL EXTRANJERO"))
                    Estado = "NE";
                generateCurp();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });


        spHijos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if (parentView.getItemAtPosition(position).toString().equals("Si"))
                    textInputLayoutH.setVisibility(View.VISIBLE);
                if (parentView.getItemAtPosition(position).toString().equals("No"))
                    textInputLayoutH.setVisibility(View.GONE);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

        spResidencia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if (parentView.getItemAtPosition(position).toString().equals("Rentada")){
                    textInputLayoutA.setVisibility(View.VISIBLE);
                    textInputLayoutM.setVisibility(View.VISIBLE);
                }
                else{
                    textInputLayoutA.setVisibility(View.GONE);
                    textInputLayoutM.setVisibility(View.GONE);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });





        swCob.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    expand(getActivity().findViewById(R.id.relativDATOSGENERALES));
                } else {
                    collapse(getActivity().findViewById(R.id.relativDATOSGENERALES));
                }


            }
        });



        etCP.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (charSequence.length() < 5){
                    textInputLayout.setVisibility(View.VISIBLE);
                    spnCol.setVisibility(View.GONE);
                    etColonia.setVisibility(View.VISIBLE);
                    etColonia.setText("");
                }

                if (connection.getConnection() && charSequence.length() == 5) {
                    System.out.println(charSequence);
                    try {
                        new GetWebCatalogos(getActivity(),getActivity(), "master").getWebSepomex(charSequence.toString());
                    } catch (NoSuchAlgorithmException e) {
                        e.printStackTrace();
                    } catch (KeyManagementException e) {
                        e.printStackTrace();
                    }
                } else {
                    etEstado.setText("");
                    etMunicipio.setText("");
                    etColonia.setText("");
                    etEstado.setEnabled(true);
                    etMunicipio.setEnabled(true);
                    etColonia.setEnabled(true);
                    etColonia.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });


        etFechaNac.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() < 10) {
                    etEdad.setText("");
                }

                if (charSequence.length() == 10) {
                    if (  charSequence.toString().charAt(2) == '/' && charSequence.toString().charAt(5) == '/') {
                        int year = Integer.parseInt(etFechaNac.getText().toString().substring(6,10));
                        int month = Integer.parseInt(etFechaNac.getText().toString().substring(3,5))-1;
                        int day = Integer.parseInt(etFechaNac.getText().toString().substring(0,2));
                        if (year > 1900 && year < 2018 && month > 0 && month < 13 && day > 0 && day < 32){
                            Calendar newDate = Calendar.getInstance();
                            int age = newDate.get(Calendar.YEAR) - year;
                            if (newDate.get(Calendar.MONTH) < month) {
                                age--;
                            }
                            if (newDate.get(Calendar.MONTH) == month) {
                                if (newDate.get(Calendar.DAY_OF_MONTH) < day)
                                    age--;
                            }
                            etEdad.setText(String.valueOf(age));
                        }
                        System.out.println(year);
                        System.out.println(month);
                        System.out.println(day);

                    }
                }
            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });




        etFechaNac.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                generateCurp();
            }
        });

        etNombre.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                generateCurp();
            }
        });

        etAP.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                generateCurp();
            }
        });

        etAM.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                generateCurp();

            }
        });


        ////////////////////// eventos de info_laboral

        swIL.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    expand(getActivity().findViewById(R.id.relativINFOLABORAL));
                } else {
                    collapse(getActivity().findViewById(R.id.relativINFOLABORAL));
                }


            }
        });

        etCPIL.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (charSequence.length() < 5){
                    textInputLayoutIL.setVisibility(View.VISIBLE);
                    spColIL.setVisibility(View.GONE);
                    etColIL.setText("");
                }

                if (connection.getConnection() && charSequence.length() == 5) {
                    try {
                        new GetWebCatalogos(getActivity(),getActivity(), "master").getWebSepomexIL(charSequence.toString());
                    } catch (NoSuchAlgorithmException e) {
                        e.printStackTrace();
                    } catch (KeyManagementException e) {
                        e.printStackTrace();
                    }
                } else {
                    etEstadoIL.setText("");
                    etMunicipioIL.setText("");
                    etColIL.setText("");
                    etEstadoIL.setEnabled(true);
                    etMunicipioIL.setEnabled(true);
                    etColIL.setEnabled(true);
                    etColIL.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        //spCred

        spCred.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if (parentView.getItemAtPosition(position).toString().equals("Si")) {
                    etCual.setVisibility(View.VISIBLE);
                    etrc.setText("");
                }
                if (parentView.getItemAtPosition(position).toString().equals("No"))
                    etCual.setVisibility(View.GONE);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });








    }










    private static void expand(final View v) {

        v.measure(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        final int targetHeight = v.getMeasuredHeight();

        // Older versions of android (pre API 21) cancel animations for views with a height of 0.
        v.getLayoutParams().height = 1;
        v.setVisibility(View.VISIBLE);
        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                v.getLayoutParams().height = interpolatedTime == 1
                        ? WindowManager.LayoutParams.WRAP_CONTENT
                        : (int) (targetHeight * interpolatedTime);
                v.requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        a.setDuration((int) (targetHeight / v.getContext().getResources().getDisplayMetrics().density) + 5);
        v.startAnimation(a);
    }


    private static void collapse(final View v) {
        final int initialHeight = v.getMeasuredHeight();

        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1) {
                    v.setVisibility(View.GONE);
                } else {
                    v.getLayoutParams().height = initialHeight - (int) (initialHeight * interpolatedTime);
                    v.requestLayout();
                }
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        a.setDuration((int) (initialHeight / v.getContext().getResources().getDisplayMetrics().density) + 5);
        v.startAnimation(a);
    }

    private void generateCurp() {
        Curp = "";
        String consonanteP = "";
        String consonanteM = "";
        String consonanteN = "";
        int k = 0;

        if (etAP.getText().toString().length() > 2) {
            Curp += etAP.getText().toString().substring(0, 2).toUpperCase();
            consonanteP = secondConsonantP(etAP.getText().toString());
            k++;
        }
        if (etAM.getText().toString().length() > 1) {
            Curp += etAM.getText().toString().substring(0, 1).toUpperCase();
            consonanteM = secondConsonantP(etAM.getText().toString());
            k++;
        }
        if (etNombre.getText().toString().length() > 1) {
            Curp += etNombre.getText().toString().substring(0, 1).toUpperCase();
            consonanteN = secondConsonantP(etNombre.getText().toString());
            k++;
        }
        if (etFechaNac.getText().toString().length() == 10) {
            Curp += (etFechaNac.getText().toString().substring(8));
            Curp += (etFechaNac.getText().toString().substring(3, 5));
            Curp += (etFechaNac.getText().toString().substring(0, 2));
            k++;
        }
        System.out.println(k);
        Curp += Sexo;
        Curp += Estado;
        Curp += consonanteP;
        Curp += consonanteM;
        Curp += consonanteN;
        if (k == 4) {
            System.out.println("Este es el Curp " + Curp);
            etCURP.setText(Curp);
        }
    }

    private static String secondConsonantP(String string) {
        if (string.length() < 4)
            return "";
        if ("aeiouAEIOU".contains(string.substring(0, 1))) {
            return string.substring(1, 2).toUpperCase();
        }
        //String consonants = string.replaceAll("[aeiouAEIOU]", "");
        return string.substring(2, 3).toUpperCase();
    }








}
