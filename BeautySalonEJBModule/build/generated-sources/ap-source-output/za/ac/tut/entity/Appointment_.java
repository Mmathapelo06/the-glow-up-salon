package za.ac.tut.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import za.ac.tut.entity.Client;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2026-09-04T14:29:25")
@StaticMetamodel(Appointment.class)
public class Appointment_ { 

    public static volatile SingularAttribute<Appointment, String> appointmentTime;
    public static volatile SingularAttribute<Appointment, Client> client;
    public static volatile SingularAttribute<Appointment, Long> id;
    public static volatile SingularAttribute<Appointment, Date> appointmentDate;
    public static volatile SingularAttribute<Appointment, String> hairstyle;
    public static volatile SingularAttribute<Appointment, String> status;

}