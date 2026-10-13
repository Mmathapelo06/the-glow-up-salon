
package za.ac.tut.appointment;

import java.util.List;
import javax.ejb.Local;
import za.ac.tut.entity.Appointment;

@Local
public interface AppointmentFacadeLocal {

    void create(Appointment appointment);

    void edit(Appointment appointment);

    void remove(Appointment appointment);

    Appointment find(Object id);

    List<Appointment> findAll();

    List<Appointment> findRange(int[] range);

    int count();
    
    List<Appointment> findAllAppointments();
    
}
