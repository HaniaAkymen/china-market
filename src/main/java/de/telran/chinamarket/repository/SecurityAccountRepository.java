package de.telran.chinamarket.repository;

import de.telran.chinamarket.entity.SecurityAccount;
import org.springframework.data.repository.CrudRepository;

public interface SecurityAccountRepository extends CrudRepository<SecurityAccount, Integer> {
    SecurityAccount findByLogin(String Login);

}
