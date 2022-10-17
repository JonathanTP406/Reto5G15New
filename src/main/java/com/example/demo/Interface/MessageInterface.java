package com.example.demo.Interface;

import com.example.demo.Modelo.Message;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Jonathan
 */
public interface MessageInterface extends CrudRepository<Message, Integer> {
    
}
