package com.example.zpo_lista11;

import java.util.ArrayList;
public class Polynomial {
        private String wspolczynniki;
        private String result;


        public Polynomial(String wspolczynniki,String result) {
                this.wspolczynniki = wspolczynniki;
                this.result=result;

        }

        @Override
        public String toString() {
                return result;
        }

        public String wyrazenieAPI() {
                String[] listaWsp = wspolczynniki.split(",");
                String row;
                ArrayList lista = new ArrayList();
                for (int i = 0; i < listaWsp.length; i++) {
                        row = listaWsp[i] + "x^" + (listaWsp.length - i - 1);
                        lista.add(row);
                }
                String s1 = lista.toString();
                String wynik = s1.replace(", ", "+");
                wynik = wynik.substring(1, wynik.length() - 1);
                return wynik;
        }

        public String podstaw(int x) {
                String[] listaWsp = wspolczynniki.split(",");
                String row;
                ArrayList lista = new ArrayList();
                for (int i = 0; i < listaWsp.length; i++) {
                        row = listaWsp[i] + "(" + x + "^" + (listaWsp.length - i - 1) + ")";
                        lista.add(row);
                }
                String s1 = lista.toString();
                String wynik = s1.replace(", ", "+");
                wynik = wynik.substring(1, wynik.length() - 1);
                return wynik;
        }

}