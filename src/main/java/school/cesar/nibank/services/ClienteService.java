package school.cesar.nibank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import school.cesar.nibank.dao.ClienteDAO;
import school.cesar.nibank.entities.Cliente;
import school.cesar.nibank.exceptions.ClienteInvalidoException;
import school.cesar.nibank.util.CpfUtil;

@Service
public class ClienteService {

    @Autowired
    private ClienteDAO clienteDAO;

    public void salvar(Cliente cliente) {

        if (!CpfUtil.isCPF(cliente.getCpf())) {
            throw new ClienteInvalidoException("Erro ao cadastrar cliente " + cliente + " . CPF invalido");
        }

        try {
            clienteDAO.save(cliente);
        } catch (DataIntegrityViolationException e) {
            cliente.setId(clienteDAO.findByCpf(cliente.getCpf()).getId());
            clienteDAO.save(cliente);
        }
    }
}
