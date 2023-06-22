package tp.dao;

import java.util.List;
import tp.entity.Personne;

//en cas de probleme, les méthodes de ce DAO vont remonter des exceptions qui héritent de RuntimeExcption

public interface PersonneDAO {
	
	public Personne createPersonne(Personne p); // en retour, la pêrsonne avec id auto_incrémentée par la base de données 
	public Personne rechercherPersonneParId(Integer idPers);
	public List<Personne> rechercherToutesPersonnes();
	public void updatePersonne(Personne p);
	public void deletePersonne(Integer idPers);
}
