package de.jan.banking.sparen.repository;

import de.jan.banking.sparen.entity.AccountQueryEntity;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<AccountQueryEntity, String> {

}
