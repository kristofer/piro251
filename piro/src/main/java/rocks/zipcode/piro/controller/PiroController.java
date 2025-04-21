package rocks.zipcode.piro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rocks.zipcode.piro.domain.Piro;
import rocks.zipcode.piro.service.PiroService;

@RestController
@RequestMapping("/api/piros/")
public class PiroController {

    @Autowired
    private PiroService piroService;

    @GetMapping
    public List<Piro> getAllPiros() {
        return piroService.findAll();
    }

    @PostMapping
    public Piro createPiro(@RequestBody Piro piro) {
        return piroService.save(piro);
    }

    @DeleteMapping("/{id}")
    public void deletePiro(@PathVariable Long id) {
        piroService.deleteById(id);
    }
}
