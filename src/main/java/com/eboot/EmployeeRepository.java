package com.eboot;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by iagu on 2/17/17.
 */
public interface EmployeeRepository extends MongoRepository<Employee, String>
{

}