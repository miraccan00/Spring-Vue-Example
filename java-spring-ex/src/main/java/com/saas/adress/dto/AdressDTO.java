package com.saas.adress.dto;
/*Created by Mirac Can Yılmaz ©
    Date : 18.04.2022
    Time : 23:01
*/
import lombok.Data;
import java.io.Serializable;
@Data
public class AdressDTO implements Serializable {
    private Long id;
    private Integer cityCode;
    private String cityName;
    private String districtName;
    private String areaName;
}
