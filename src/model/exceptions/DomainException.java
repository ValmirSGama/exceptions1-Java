package model.exceptions;

// Definição da classe DomainException, que estende RuntimeException
// Isso significa que DomainException é uma exceção não verificada, ou seja, não é necessário declarar em métodos ou tratá-la explicitamente.
public class DomainException extends RuntimeException {

    // Número de série para garantir a consistência durante a desserialização.
    private static final long serialVersionUID = 1L;

    // Construtor da classe DomainException, que recebe uma mensagem de erro como parâmetro.
    public DomainException(String msg) {
        // Chama o construtor da superclasse (RuntimeException) com a mensagem recebida.
        super(msg);
    }
}
