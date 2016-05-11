package consultorioveterinario;

public class Animal {

    private String nomeAnimal;
    private String raca;
    Cliente cliente;

    public Animal(String nomeAnimal, String raca, Cliente cliente) {
        this.nomeAnimal = nomeAnimal;
        this.raca = raca;
        this.cliente = cliente;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
