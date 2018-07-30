package com.example.joaquinmartinez.miga_vistas;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GetSepomex {

    @SerializedName("Sepomex")
    public List<GetSepomex.Sepomex> Sepomex = new ArrayList<>();

    @SerializedName("Resultados")
    public String Resultados;

    public class Sepomex{

        @SerializedName("CP")           public String CP;
        @SerializedName("ESTADO")       public String ESTADO;
        @SerializedName("CIUDAD")       public String CIUDAD;
        @SerializedName("MUNICIPIO")    public String MUNICIPIO;
        @SerializedName("COLONIA")      public String COLONIA;
    }
}
