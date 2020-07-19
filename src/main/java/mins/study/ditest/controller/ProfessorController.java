package mins.study.ditest.controller;

import lombok.RequiredArgsConstructor;
import mins.study.ditest.entity.Professor;
import mins.study.ditest.repository.ProfessorRepository;
import mins.study.ditest.sevice.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/professor")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorRepository professorRepository;

    @Autowired
    private ProfessorService professorService;

    @PostMapping
    public ResponseEntity<Object> add(String name, Integer age) {
        return ResponseEntity.ok(professorRepository.save(new Professor(name, age)));
    }

    @GetMapping
    public ResponseEntity<Object> get(Long professorId) {
        return ResponseEntity.ok(professorRepository.findById(professorId).orElseThrow());
    }
}
