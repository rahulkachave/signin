package com.sign.SIgnUp.Repository;

import com.sign.SIgnUp.DTO.SignUpDTO;
import com.sign.SIgnUp.Entity.SIgnUp;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SignUpRepository extends MongoRepository<SIgnUp,String> {

    Optional<SIgnUp> findOneByEmailAndPassword(String email, String password);
    SIgnUp findByEmail(String email);

}
