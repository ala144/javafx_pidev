/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author Ala
 */
public class Aliments {
    private int id;
    private String nom;
    private float glucides,proteins,calories;
    private String imagepath;

    public Aliments() {
    }

    public Aliments(int id) {
        this.id = id;
    }
    

    public Aliments( String nom, float glucides, float proteins, float calories) {
        
        this.nom = nom;
        this.glucides = glucides;
        this.proteins = proteins;
        this.calories = calories;
        
    }

    public Aliments(String nom, float glucides, float proteins, float calories, String imagepath) {
        this.nom = nom;
        this.glucides = glucides;
        this.proteins = proteins;
        this.calories = calories;
        this.imagepath = imagepath;
    }

    public Aliments(int id, String nom, float glucides, float proteins, float calories, String imagepath) {
        this.id = id;
        this.nom = nom;
        this.glucides = glucides;
        this.proteins = proteins;
        this.calories = calories;
        this.imagepath = imagepath;
    }
    

    public Aliments(String toString, String toString0, String toString1, String toString2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getGlucides() {
        return glucides;
    }

    public void setGlucides(float glucides) {
        this.glucides = glucides;
    }

    public float getProteins() {
        return proteins;
    }

    public void setProteins(float proteins) {
        this.proteins = proteins;
    }

    public float getCalories() {
        return calories;
    }

    public void setCalories(float calories) {
        this.calories = calories;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    @Override
    public String toString() {
        return "Aliments{" + "id=" + id + ", nom=" + nom + ", glucides=" + glucides + ", proteins=" + proteins + ", calories=" + calories + ", imagepath=" + imagepath + '}';
    }
    
    
}
