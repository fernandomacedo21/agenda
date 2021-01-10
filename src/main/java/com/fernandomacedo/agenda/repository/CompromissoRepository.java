package com.fernandomacedo.agenda.repository;

import com.fernandomacedo.agenda.model.Compromisso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompromissoRepository  extends JpaRepository<Compromisso, Long> {
}
