package com.example.zadanierekru;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;

import static javafx.scene.input.KeyCode.T;

public class ByteChanges {
    private int count;
    public LinkedList<Byte> byteLinkedList = new LinkedList<>();
    private String sciezka;
    private String rozszerzenie;
    private byte bajt_wejsciowy;
    private byte bajt_wyjsciowy;
    private byte[] zapis;
private byte dupa;

    public ByteChanges() {
    }

    public ByteChanges(String sciezka, String rozszerzenie) {
        this.sciezka = sciezka;
        this.rozszerzenie = rozszerzenie;
    }

    public ByteChanges(String sciezka, String rozszerzenie, byte bajt_wejsciowy, byte bajt_wyjsciowy) {
        this.sciezka = sciezka;
        this.rozszerzenie = rozszerzenie;
        this.bajt_wejsciowy = bajt_wejsciowy;
        this.bajt_wyjsciowy = bajt_wyjsciowy;
    }

    public String getSciezka() {
        return sciezka;
    }

    public void setSciezka(String sciezka) {
        this.sciezka = sciezka;
    }

    public String getRozszerzenie() {
        return rozszerzenie;
    }

    public void setRozszerzenie(String rozszerzenie) {
        this.rozszerzenie = rozszerzenie;
    }

    public byte getBajt_wejsciowy() {
        return bajt_wejsciowy;
    }

    public void setBajt_wejsciowy(byte bajt_wejsciowy) {
        this.bajt_wejsciowy = bajt_wejsciowy;
    }

    public byte getBajt_wyjsciowy() {
        return bajt_wyjsciowy;
    }

    public void setBajt_wyjsciowy(byte bajt_wyjsciowy) {
        this.bajt_wyjsciowy = bajt_wyjsciowy;
    }


    public String getChange(String sciezka, String rozszerzenie, byte bajt_wejsciowy, byte bajt_wyjsciowy) throws IOException {
        if (sciezka == null || rozszerzenie == null) {
            return "Wrong input";
        }
        String adres = sciezka + "\\" + rozszerzenie;
        File plik = new File(adres);
        Path path = Paths.get(adres);
        byte[] table = Files.readAllBytes(path);

count=0;
        for (
                Byte b : table) {
            {


                zapis = new byte[table.length];

            }
            for (int i = 0; i < table.length; i++) {
                if (b == bajt_wejsciowy) {

                    b = bajt_wyjsciowy;

                }
                else{


                }


            }
            byteLinkedList.add(b);



        }
        for (int i = 0; i <table.length ; i++) {

            dupa = byteLinkedList.get(i);
            Array.setByte(zapis, count, dupa);
            count++;
        }
        FileOutputStream outputStream = new FileOutputStream(adres);
        outputStream.write(zapis);
        return byteLinkedList.toString();
    }

    public String getFirstByte(String sciezka, String rozszerzenie) throws IOException {
        if (sciezka == null || rozszerzenie == null) {
            return "Wrong input";
        }
        String adres = sciezka + "\\" + rozszerzenie;
        File plik = new File(adres);
        Path path = Paths.get(adres);
        byte[] table = Files.readAllBytes(path);


        for (
                Byte b : table) {


        }
        return Arrays.toString(table);
    }
}