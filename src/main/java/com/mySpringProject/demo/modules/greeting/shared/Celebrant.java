package com.mySpringProject.demo.modules.greeting.shared;

import java.util.UUID;

public record Celebrant(
    UUID id, String firstName, String lastName, String emailAddress, String phoneNumber, String alias) {
 public Celebrant(){
   this(null,"Auto-generated", "Auto-generated", "Auto-generated", "Auto-generated","Auto-generated");
 }
}
