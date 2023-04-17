/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author Ala
 */
public class Repas {
    private int id;
    private String nom,description;
    private float totalglucides,totalproteines,total_calories;

    public Repas() {
    }

    public Repas(String nom, String description, float totalglucides, float totalproteines, float total_calories) {
        this.nom = nom;
        this.description = description;
        this.totalglucides = totalglucides;
        this.totalproteines = totalproteines;
        this.total_calories = total_calories;
    }

    public Repas(int id, String nom, String description, float totalglucides, float totalproteines, float total_calories) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.totalglucides = totalglucides;
        this.totalproteines = totalproteines;
        this.total_calories = total_calories;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public float getTotalglucides() {
        return totalglucides;
    }

    public float getTotalproteines() {
        return totalproteines;
    }

    public float getTotal_calories() {
        return total_calories;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTotalglucides(float totalglucides) {
        this.totalglucides = totalglucides;
    }

    public void setTotalproteines(float totalproteines) {
        this.totalproteines = totalproteines;
    }

    public void setTotal_calories(float total_calories) {
        this.total_calories = total_calories;
    }

    @Override
    public String toString() {
        return "Repas{" + "id=" + id + ", nom=" + nom + ", description=" + description + ", totalglucides=" + totalglucides + ", totalproteines=" + totalproteines + ", total_calories=" + total_calories + '}';
    }

    
    
    
}
