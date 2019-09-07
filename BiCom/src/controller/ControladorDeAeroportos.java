package controller;

import java.util.HashMap;
import java.util.Map;
import model.Aeroporto;
import util.Settings;

public final class ControladorDeAeroportos {
    private final Map<String, Aeroporto> aeroportos;

    public ControladorDeAeroportos() {
        aeroportos = new HashMap<>();
        initializeAeroportos();
    }

    public void initializeAeroportos(){
        for (Settings.EnumAeroportos a : Settings.EnumAeroportos.values()) {
            aeroportos.put(a.getEstado(), new Aeroporto(a.getNome(), a.getEstado()));
        }          
    }
    

}
