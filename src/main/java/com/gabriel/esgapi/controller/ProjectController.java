package com.gabriel.esgapi.controller;

import com.gabriel.esgapi.model.Project;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:4173","https://portfolio-gabriel-three.vercel.app"})
@Tag(name = "Projects", description = "Endpoints em memória para projetos ESG (MVP)")
public class ProjectController {

    private final Map<Long, Project> store = new LinkedHashMap<>();
    private final AtomicLong seq = new AtomicLong(0);

    public ProjectController() {
        // Seed inicial
        save(new Project(null, "Energia Solar à Fase 1", "E", 82.5));
        save(new Project(null, "Programa de Voluntariado", "S", 74.0));
        save(new Project(null, "Compliance Fornecedores", "G", 90.0));
    }

    private Project save(Project p) {
        long id = seq.incrementAndGet();
        p.setId(id);
        store.put(id, p);
        return p;
    }

    @GetMapping
    @Operation(summary = "Lista todos os projetos (em memória)")
    public List<Project> list() {
        return new ArrayList<>(store.values());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca um projeto pelo ID")
    public ResponseEntity<Project> get(@PathVariable Long id) {
        Project p = store.get(id);
        return (p == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(p);
    }

    @PostMapping
    @Operation(summary = "Cria um novo projeto")
    public ResponseEntity<Project> create(@RequestBody Project p) {
        Project saved = save(p);
        return ResponseEntity.created(URI.create("/api/projects/" + saved.getId())).body(saved);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove um projeto pelo ID")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return (store.remove(id) != null) ? ResponseEntity.noContent().build()
                                          : ResponseEntity.notFound().build();
    }
}
