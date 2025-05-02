package dio_springboot_desafio_railway.repository;

import dio_springboot_desafio_railway.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Client, Long> {
    boolean existsByAccountNumberAccount(String accountNumber);  // Verifica se o número da conta já existe
}