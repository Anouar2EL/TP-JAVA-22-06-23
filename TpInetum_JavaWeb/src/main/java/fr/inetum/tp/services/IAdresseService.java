package fr.inetum.tp.services;

import java.util.Set;

import fr.inetum.tp.entites.Adresse;

public interface IAdresseService {

	
	Set<Adresse> allAdresse();
	Adresse readAdresse(int adresseId);
	Adresse addAdresse(Adresse adresse);
}
