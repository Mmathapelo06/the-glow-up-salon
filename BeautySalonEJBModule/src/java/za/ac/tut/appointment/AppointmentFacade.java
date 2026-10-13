
package za.ac.tut.appointment;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import za.ac.tut.entity.Appointment;

@Stateless
public class AppointmentFacade extends AbstractFacade<Appointment> implements AppointmentFacadeLocal {

    @PersistenceContext(unitName = "BeautySalonEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AppointmentFacade() {
        super(Appointment.class);
    }

    @Override
    public List<Appointment> findAllAppointments() {
        String queryStr = "SELECT a FROM Appointment a";
        Query query = em.createQuery(queryStr);
        List<Appointment> appointment = query.getResultList();
        return appointment;
    }  
}
