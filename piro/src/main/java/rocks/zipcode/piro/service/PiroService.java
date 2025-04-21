package rocks.zipcode.piro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rocks.zipcode.piro.domain.Piro;
import rocks.zipcode.piro.repository.PiroRepository;

@Service
public class PiroService {
    @Autowired
    private PiroRepository piroRepository;

    public List<Piro> findAll() {
        return piroRepository.findAll();
    }

    public Piro save(Piro piro) {
        return piroRepository.save(piro);
    }

    public void deleteById(Long id) {
        piroRepository.deleteById(id);
    }
}
