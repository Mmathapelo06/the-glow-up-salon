package za.ac.tut.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2026-09-04T14:29:25")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, String> password;
    public static volatile SingularAttribute<Client, String> phoneNumber;
    public static volatile SingularAttribute<Client, String> surname;
    public static volatile SingularAttribute<Client, String> name;
    public static volatile SingularAttribute<Client, Long> id;
    public static volatile SingularAttribute<Client, String> userName;
    public static volatile SingularAttribute<Client, Date> creationDate;
    public static volatile SingularAttribute<Client, String> email;

}