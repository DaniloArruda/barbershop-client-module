package barbershop.clientmodule.adapter.repository.model;

import java.util.ArrayList;
import java.util.List;

public class ClientRecord {
    public String id;
    public List<AppointmentRecord> appointments = new ArrayList<>();
}
