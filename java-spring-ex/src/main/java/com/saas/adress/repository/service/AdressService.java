package com.saas.adress.repository.service;
/*Created by Mirac Can Yılmaz ©
    Date : 18.04.2022
    Time : 23:01
*/
import com.saas.adress.domain.Adress;
import com.saas.adress.dto.AdressDTO;

import java.util.List;
import java.util.Optional;
public interface AdressService {
    AdressDTO addAdress(AdressDTO adressDTO);
    List<AdressDTO> getAllAdress();
    AdressDTO deleteAdress(Long id);
    AdressDTO updateAdress(AdressDTO adressDTO,Long id);
    Optional<Adress> findById(Long id);
}
