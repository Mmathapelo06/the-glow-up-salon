
package za.ac.tut.client;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import za.ac.tut.entity.Client;

@Stateless
public class ClientFacade extends AbstractFacade<Client> implements ClientFacadeLocal {

    @PersistenceContext(unitName = "BeautySalonEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientFacade() {
        super(Client.class);
    }

    @Override
    public Client findByUsernameAndPassword(String userName, String password) {
      try{
        String queryStr = "SELECT c FROM Client c WHERE c.userName = ?1 AND c.password = ?2";
        Query query = em.createQuery(queryStr);
        query.setParameter(1, userName);
        query.setParameter(2, password);
        Client client = (Client)query.getSingleResult();
        return client;
        
         } catch (NoResultException ex) {
            return null;
        }
    }  
}
