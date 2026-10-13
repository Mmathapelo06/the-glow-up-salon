
package za.ac.tut.model.bl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import za.ac.tut.entity.SalonOwner;
import javax.persistence.Query;

@Stateless
public class SalonOwnerFacade extends AbstractFacade<SalonOwner> implements SalonOwnerFacadeLocal {

    @PersistenceContext(unitName = "BeautySalonEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SalonOwnerFacade() {
        super(SalonOwner.class);
    }

    @Override
    public SalonOwner findByUsernameAndPassword(String userName, String password) {
        try {
            String queryStr = "SELECT s FROM SalonOwner s "
                    + "WHERE s.userName = ?1 "
                    + "AND s.password = ?2";

            Query query = em.createQuery(queryStr);

            query.setParameter(1, userName);
            query.setParameter(2, password);

            SalonOwner sn = (SalonOwner) query.getSingleResult();

            return sn;

        } catch (NoResultException ex) {
            return null;
        }
    }
    }
    
