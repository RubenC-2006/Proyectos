package com.fantasydc;

import java.util.ArrayList;

public class Equipo {
    private ArrayList<Personaje> integrantes;
    private int presupuestoMaximo;

    public Equipo(int presupuestoMaximo) {
        this.presupuestoMaximo = presupuestoMaximo;
        this.integrantes = new ArrayList<>();
    }

    public boolean agregarPersonaje(Personaje p) {
        if (integrantes.size() >= 6) return false;
        if (costoActual() + p.getCosto() > presupuestoMaximo) return false;
        integrantes.add(p);
        return true;
    }

    public int costoActual() {
        int total = 0;
        for (Personaje p : integrantes) total += p.getCosto();
        return total;
    }

    public ArrayList<Personaje> getIntegrantes() { return integrantes; }
    public int getPresupuestoMaximo() { return presupuestoMaximo; }
}
