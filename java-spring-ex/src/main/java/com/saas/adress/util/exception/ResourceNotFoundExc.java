package com.saas.adress.util.exception;
/*Created by Mirac Can Yılmaz ©
    Date : 18.04.2022
    Time : 23:01
*/
public class ResourceNotFoundExc extends RuntimeException {
    private String resourceName;
    private String fieldName;
    private Long fieldValue;
    public ResourceNotFoundExc(String resourceName, String fieldName, Long fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue)); // Address not found with id : 1
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
