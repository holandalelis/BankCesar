package school.cesar.nibank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import school.cesar.nibank.entities.Cliente;
import school.cesar.nibank.services.ClienteService;

@SpringBootApplication
public class NIBankMain implements CommandLineRunner {

    @Autowired
    private ClienteService clienteService;

    public static void main(String[] args) {
        SpringApplication.run(NIBankMain.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("comecei a executar daqui");

        Cliente cliente1 = new Cliente();
        cliente1.setNome("Jair da Silva Jose");
        cliente1.setCpf("382.008.180-12");

//        Cliente cliente2 = new Cliente();
//        cliente1.setNome("Claudio");
//        cliente1.setCpf("382.008.180-12");

        System.out.println("Vou sair o cliente: " + cliente1);
        clienteService.salvar(cliente1);
//        clienteService.salvar(cliente2);
    }
}
