package com.inetum.mbean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;

@ManagedBean
@RequestScoped
//@SessionScoped
public class CalculTva implements Serializable {
	
	private Double ht ; // a saisir 
	private Double tauxTva ; // a saisir 	
	private Double tva; // resultat calcul de la tva
	private Double ttc;

	
    // ... (les autres attributs et méthodes existants)

    private List<Double> tauxTvaList = Arrays.asList(5.0, 10.0, 20.0);
    private Double selectedTauxTva = 20.0;

    // Getter et Setter pour selectedTauxTva

    public List<Double> getTauxTvaList() {
        return tauxTvaList;
    }

    public void setTauxTvaList(List<Double> tauxTvaList) {
        this.tauxTvaList = tauxTvaList;
    }

    public Double getSelectedTauxTva() {
        return selectedTauxTva;
    }

    public void setSelectedTauxTva(Double selectedTauxTva) {
        this.selectedTauxTva = selectedTauxTva;
    }
	
	
	
	
	public void calculerTvattc() {
		this.tva=this.ht*this.selectedTauxTva/100;
		this.ttc=this.ht*this.selectedTauxTva /100 + this.ht;
	}



	public Double getHt() {
		return ht;
	}

	public void setHt(Double ht) {
		this.ht = ht;
	}

	public Double getTauxTva() {
		return tauxTva;
	}

	public void setTauxTva(Double tauxTva) {
		this.tauxTva = tauxTva;
	}

	public Double getTva() {
		return tva;
	}

	public void setTva(Double tva) {
		this.tva = tva;
	}

	public Double getTtc() {
		return ttc;
	}

	public void setTtc(Double ttc) {
		this.ttc = ttc;
	}

	
	
}
