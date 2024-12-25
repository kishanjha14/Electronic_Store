package com.kishan.Electroinc.store.ElectronicStore.Repositorys;

import com.kishan.Electroinc.store.ElectronicStore.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.event.ListDataEvent;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String>
{
    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndPassword(String email,String password);

    List<User> findByNameContaining(String keyword);
}
