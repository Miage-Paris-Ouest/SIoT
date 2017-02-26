package siot.awssiot;

import android.graphics.Bitmap;

import com.orm.SugarRecord;

/**
 * Created by Leys on 25/02/2017.
 */


public class Capteurs extends SugarRecord {

    Boolean etat;
    Integer valeur;
    String nomCapteur;
    String seuil;
    String description;
    Bitmap logoCapteur;

    public Capteurs() {}

    public Capteurs(String seuil) {
        this.seuil=seuil;
    }


    public Capteurs( Boolean etat, Integer valeur, String nomCapteur, String seuil, Bitmap logoCapteur, String description ) {
        this.etat = true;
        this.valeur = valeur;
        this.nomCapteur = nomCapteur;
        this.seuil = seuil;
        this.logoCapteur= logoCapteur;
        this.description = description;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




    public Bitmap getLogoCapteur() {
        return logoCapteur;
    }

    public void setLogoCapteur(Bitmap logoCapteur) {
        this.logoCapteur = logoCapteur;
    }

    public Boolean getEtat() {
        return etat;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "seuil=" + seuil ;
    }

    public Integer getValeur() {
        return valeur;
    }

    public void setValeur(Integer valeur) {
        this.valeur = valeur;
    }

    public String getNomCapteur() {
        return nomCapteur;
    }

    public void setNomCapteur(String nomCapteur) {
        this.nomCapteur = nomCapteur;
    }

    public String getSeuil() {
        return seuil;
    }

    public void setSeuil(String seuil) {
        this.seuil = seuil;
    }



}
