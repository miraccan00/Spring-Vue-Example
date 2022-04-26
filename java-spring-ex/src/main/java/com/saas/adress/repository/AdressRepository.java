package com.saas.adress.repository;
/*Created by Mirac Can Yılmaz ©
    Date : 18.04.2022
    Time : 23:01
*/
import com.saas.adress.domain.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
// JpaRepository is a JPA (Java Persistence API) specific extension of Repository.
// It contains the full API of CrudRepository and PagingAndSortingRepository.
public interface AdressRepository extends JpaRepository<Adress,Long> {


}
