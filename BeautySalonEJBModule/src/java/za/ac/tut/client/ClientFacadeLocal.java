
package za.ac.tut.client;

import java.util.List;
import javax.ejb.Local;
import za.ac.tut.entity.Client;

@Local
public interface ClientFacadeLocal {

    void create(Client client);

    void edit(Client client);

    void remove(Client client);

    Client find(Object id);

    List<Client> findAll();

    List<Client> findRange(int[] range);

    int count();
    
    Client findByUsernameAndPassword(String userName, String password);
    
}
