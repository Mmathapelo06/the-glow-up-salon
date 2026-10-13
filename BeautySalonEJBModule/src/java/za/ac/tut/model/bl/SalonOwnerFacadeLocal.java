
package za.ac.tut.model.bl;

import java.util.List;
import javax.ejb.Local;
import za.ac.tut.entity.SalonOwner;

@Local
public interface SalonOwnerFacadeLocal {

    void create(SalonOwner salonOwner);

    void edit(SalonOwner salonOwner);

    void remove(SalonOwner salonOwner);

    SalonOwner find(Object id);

    List<SalonOwner> findAll();

    List<SalonOwner> findRange(int[] range);

    int count();
    
    SalonOwner findByUsernameAndPassword(String userName, String password);
    
}
