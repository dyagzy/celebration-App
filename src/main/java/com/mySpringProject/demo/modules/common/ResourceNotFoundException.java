package com.mySpringProject.demo.modules.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value =HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

  private String resourceName;
  private String resourceValue;
  private String resourceField;

  public ResourceNotFoundException(
      String resourceName, String resourceValue, String resourceField) {
    super(String.format("%s not found with %s : %s", resourceName, resourceField, resourceValue));
    this.resourceName = resourceName;
    this.resourceValue = resourceValue;
    this.resourceField = resourceField;
  }

  public String getResourceValue() {
    return resourceValue;
  }

  public String getResourceField() {
    return resourceField;
  }

  public String getResourceName() {
    return resourceName;
  }
}
