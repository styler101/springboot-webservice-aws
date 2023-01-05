package com.webservices_with_aws.webservicewithaws;


import com.webservices_with_aws.webservicewithaws.entities.Person;
import com.webservices_with_aws.webservicewithaws.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;


@RestController
@RequestMapping(value = "/persons")
public class PersonController {

   @Autowired
   private PersonService service;
   private final AtomicLong counter = new AtomicLong();

   @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
   public List<Person> findAll(){
     return service.findAll();
   }
   @RequestMapping(value="/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
   public Person findById(@PathVariable(value="id") String id){
      return service.findById(id);
   }




}