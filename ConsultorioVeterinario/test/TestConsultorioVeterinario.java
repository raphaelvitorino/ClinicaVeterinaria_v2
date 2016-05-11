
import consultorioveterinario.Animal;
import consultorioveterinario.Cliente;
import consultorioveterinario.Fatura;
import consultorioveterinario.Item;
import consultorioveterinario.OrdemServico;
import consultorioveterinario.Servico;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestConsultorioVeterinario {

    public TestConsultorioVeterinario() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testServico() {
        Servico servico = new Servico("Exame Rotina", 120);
        Cliente cliente = new Cliente("Dave Atkins");
        assertEquals("Dave Atkins", cliente.getNomeCliente());
        assertEquals("Exame Rotina", servico.getNomeServico());
        assertEquals(120, servico.getValor(), 0);
    }

    @Test
    public void testPagar() {
        Fatura f = new Fatura();
        double dinheiroRecebido = 100;
        OrdemServico ordemServico = new OrdemServico();
        ordemServico.setValorTotal(100);
        f.pagar(dinheiroRecebido, ordemServico);
        assertEquals("Pago", f.getStatus());
    }

    @Test
    public void testExecutarOrdemServico() {

        List<Item> itens = new ArrayList<>();
        Fatura f;
        Cliente cliente = new Cliente("Dave Atkins");
        Animal animal = new Animal("Fofo", "Doberman", cliente);
        Servico servico = new Servico("Exame Rotina", 150);
        Servico servico2 = new Servico("Vacina Raiva", 50);
        Item item = new Item(1, 150, servico, animal);
        Item item2 = new Item(1, 50, servico2, animal);
        itens.add(item);
        itens.add(item2);
        OrdemServico os = new OrdemServico(itens, cliente);
        f = os.executar(os);
        assertEquals(200, f.getOs().get(0).getValorTotal(), 0);
    }
    @Test
    public void testEmitirFaturaFimDoMes() {
        List<Item> itens = new ArrayList<>();
        Fatura f;
        Cliente cliente = new Cliente("Traci Heinrich");
        Animal animal1 = new Animal("Tweedle Dee", "Gato", cliente);
        Animal animal2 = new Animal("Tweedle Dum", "Gato", cliente);
        Servico servico = new Servico("Esterilização", 300);
        Item item = new Item(1, 300, servico, animal1);
        Item item2 = new Item(1, 300, servico, animal2);
        itens.add(item);
        itens.add(item2);
        OrdemServico os = new OrdemServico(itens, cliente);
        f = os.executar(os);
        f.pagarFimDoMes(f);
        assertEquals(false, f.isAvista());
        
    }
}
