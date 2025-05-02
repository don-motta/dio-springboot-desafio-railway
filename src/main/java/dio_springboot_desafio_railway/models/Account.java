package dio_springboot_desafio_railway.models;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "tab_account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)  //unique = true define que o número da conta deve ser único no banco de dados.
    private String numberAccount;
    private String agency;

    @Column(scale= 13, precision= 2) //scale= 13 define o número máximo de dígitos à direita do ponto decimal e precision= 2 define o número máximo de dígitos à esquerda do ponto decimal.
    private BigDecimal balance;
    @Column(name = "account_limit",scale= 13, precision= 2)
    private BigDecimal limit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }
}
