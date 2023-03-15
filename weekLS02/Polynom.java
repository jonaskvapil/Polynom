/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package weekLS02;

/**
 *
 * @author jony1
 */
public class Polynom {

    private final double[] koeficienty;

    // Konstruktor pro vytvoření polynomu z pole koeficientů
    public Polynom(double[] koeficienty) {
        this.koeficienty = new double[koeficienty.length];
        System.arraycopy(koeficienty, 0, this.koeficienty, 0, koeficienty.length);
    }

    // Konstruktor pro vytvoření polynomu nultého stupně (konstanty)
    public Polynom(double constant) {
        this.koeficienty = new double[] { constant };
    }

    // Konstruktor pro vytvoření polynomu prvního stupně (přímky)
    public Polynom(double a, double b) {
        this.koeficienty = new double[] { b, a };
    }

    // Konstruktor pro vytvoření polynomu druhého stupně
    public Polynom(double a, double b, double c) {
        this.koeficienty = new double[] { c, b, a };
    }

    // Metoda pro získání stupně polynomu
    public int getDegree() {
        return this.koeficienty.length - 1;
    }

    // Metoda pro získání koeficientu na dané pozici
    public double getKoeficient(int position) {
        return this.koeficienty[position];
    }

    // Metoda pro výpočet hodnoty polynomu pomocí Hornerova schématu
    public double evaluate(double x) {
        double result = 0;
        for (int i = this.koeficienty.length - 1; i >= 0; i--) {
            result = this.koeficienty[i] + x * result;
        }
        return result;
    }

    // Metoda pro výpočet derivace polynomu
    public Polynom derivace() {
        if (this.koeficienty.length == 1) {
            return new Polynom(0);
        }
        double[] newkoeficienty = new double[this.koeficienty.length - 1];
        for (int i = 0; i < newkoeficienty.length; i++) {
            newkoeficienty[i] = (i + 1) * this.koeficienty[i + 1];
        }
        return new Polynom(newkoeficienty);
    }

    // Metoda pro získání textového zápisu polynomu
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = this.koeficienty.length - 1; i >= 0; i--) {
            if (i == 0) {
                sb.append(this.koeficienty[i]);
            } else if (i == 1) {
                sb.append(this.koeficienty[i]).append("x + ");
            } else {
                sb.append(this.koeficienty[i]).append("x^").append(i).append(" + ");
            }
        }
        return sb.toString();

    }
}
