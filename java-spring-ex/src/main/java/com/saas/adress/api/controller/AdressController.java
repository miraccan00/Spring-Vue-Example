package com.saas.adress.api.controller;
/*Created by Mirac Can Yılmaz ©
    Date : 18.04.2022
    Time : 23:01
*/
import com.saas.adress.domain.Adress;
import com.saas.adress.dto.AdressDTO;
import com.saas.adress.repository.service.AdressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/adresses/v1")
public class AdressController {
    //address part fix
    private AdressService adressService;
    public AdressController(AdressService adressService) {
        this.adressService = adressService;
    }
    @GetMapping("/get-adresses")
    public List<AdressDTO> getAllPost() {
        return adressService.getAllAdress();
    }
    @PostMapping("/add-adress")
    public ResponseEntity<AdressDTO> addPost(@RequestBody AdressDTO adressDTO) {
        return new ResponseEntity<>(adressService.addAdress(adressDTO), HttpStatus.CREATED);
    }
    @PostMapping("/update-adress/{adressId}")
    public ResponseEntity<AdressDTO> updatePost(@RequestBody AdressDTO adressDTO,@PathVariable(name = "adressId") Long id) {
        return new ResponseEntity<>(adressService.updateAdress(adressDTO,id),HttpStatus.OK);
    }
    @PostMapping("/delete-adress/{adressId}")
    public ResponseEntity<AdressDTO> deletePost(@PathVariable(name = "adressId") Long id) {
        return new ResponseEntity<>(adressService.deleteAdress(id),HttpStatus.OK);
    }
    @GetMapping("/get-adress-by-id/{adressId}")
    public Optional<Adress> getAdressById(@PathVariable(name = "adressId") Long id) {
        return adressService.findById(id);
    }
}
