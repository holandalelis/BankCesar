package school.cesar.nibank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.cesar.nibank.entities.Cliente;

@Repository
public interface ClienteDAO extends JpaRepository<Cliente, Long> {

    Cliente findByCpf(String cpf);

}
